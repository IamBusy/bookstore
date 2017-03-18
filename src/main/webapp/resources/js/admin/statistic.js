$(document).ready(function(){
	getOrders();
	$("#search").on('click',function(){
		getOrders();
	});
	
	$("#search2").on('click',function(){
		getSoldBooks($("#cateId").val());
	});
});



var getOrders=function()
{
	$("#ordersArea").html("");
	$.ajax({
		 url:URL_REQUEST+'getOrders',
		 dataType:'json',
		 data:
		{
			 uid:$("#uid").val(),
			 start_time:$("#start_time").val(),
			 end_time:$("#end_time").val(),
		},
		 success:function(data)
		 {
			 console.log(data);
			 if(!data.success)
			{
				 C_prompt("查询失败！");
				 return ;
			}
			 else
			{
				 
				 dealData((data.list));
			}
		 }
	 });
}

var getSoldBooks=function(cateId)
{
	$("#ordersArea2").html("");
	$.ajax({
		 url:URL_REQUEST+'getSoldBooks',
		 dataType:'json',
		 data:
		{
			 cateId:cateId
		},
		 success:function(data)
		 {
			 console.log(data);
			 if(!data.success)
			{
				 C_prompt("查询失败！");
				 return ;
			}
			 else
			{
				var books=(data.list);
				for(var i=0;i<books.length;i++)
				{
					var tmp=$("<tr/>");
					tmp.html("<td>"+books[i].bid+"</td>"+
							"<td>"+books[i].title+"</td>"+
							"<td>"+books[i].price+"</td>"+
							"<td>"+books[i].num+"</td>"
							);
					tmp.appendTo("#ordersArea2");
				}

			}
		 }
	 });
}

var dealData=function(data)
{
	var len=data.length;
	var lastOrderId=-1;
	var bigData=new Array();
	var idx=-1;
	if(len==0) return;
	var lastOid=data[0].oid;
	for(var i=0;i<len;i++)
	{
		geneOneOrder(data[i]);
		/*if(data[i].oid==lastOid)
		{
			bigData.push(data[i]);
		}
		else
		{
			geneTable(bigData);
			bigData=new Array();
			bigData.push(data[i]);
			lastOid=data[i].oid;
		}*/
	}
	if(bigData.length>0) geneTable(bigData);
}

var geneTable=function(data){
	var tr=$("<tr/>");
	var oid="<td>"+data[0].oid+"</td>";
	var time="<td>"+data[0].time+"</td>";
	var uid="<td>"+data[0].uid+"</td>";
	var books="";
	var nums="";
	var price=0;
	var sprice="";
	for(var i=0;i<data.length;i++)
	{
		books+="<tr><td>"+data[i].title+"</td></tr>";
		nums+="<tr><td>"+data[i].num+"</td></tr>";
		sprice+="<tr><td>"+data[i].price+"</td></tr>";
		price+=(data[i].num*data[i].price);
	}
	price="<td>￥"+price+"</td>";
	sprice="<td><table>"+sprice+"</table></td>";
	books="<td><table>"+books+"</table></td>";
	nums="<td><table>"+nums+"</table></td>";
	$("<tr>"+uid+oid+price+books+nums+sprice+time+"</tr>").appendTo("#ordersArea");	
}


var geneOneOrder=function(data)
{
	var tr=$("<tr/>");
	var oid="<td>"+data.oid+"</td>";
	var time="<td>"+data.time+"</td>";
	var books="";
	var nums="";
	var price=0;
	var sprice="";
	var uid="<td>"+data.uid+"</td>";
	for(var i=0;i<data.books.length;i++)
	{
		books+="<tr><td>"+data.books[i].title+"</td></tr>";
		nums+="<tr><td>"+data.books[i].num+"</td></tr>";
		sprice+="<tr><td>"+data.books[i].price+"</td></tr>";
		price+=(data.books[i].num*data.books[i].price);
	}
	price="<td>￥"+price+"</td>";
	sprice="<td><table>"+sprice+"</table></td>";
	books="<td><table>"+books+"</table></td>";
	nums="<td><table>"+nums+"</table></td>";
	$("<tr>"+uid+oid+price+books+nums+sprice+time+"</tr>").appendTo("#ordersArea");
}
