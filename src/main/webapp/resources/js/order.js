$(document).ready(function(){
	getOrders();
});

var getOrders=function()
{
	$.ajax({
		 url:URL_REQUEST+'getOrders',
		 dataType:'json',
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

var dealData=function(data)
{
	console.log(data);
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
	//if(bigData.length>0) geneTable(bigData);
}

var geneTable=function(data){
	var tr=$("<tr/>");
	var oid="<td>"+data[0].oid+"</td>";
	var time="<td>"+data[0].time+"</td>";
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
	$("<tr>"+oid+price+books+nums+sprice+time+"</tr>").appendTo("#ordersArea");	
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
	$("<tr>"+oid+price+books+nums+sprice+time+"</tr>").appendTo("#ordersArea");
}