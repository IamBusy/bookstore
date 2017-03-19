$(document).ready(function(){
	getOrders();
});

var getOrders=function()
{
	$.ajax({
		 url:URL_REQUEST+'users/2/orders',
		 dataType:'json',
		 success:function(data)
		 {
			 console.log(data);
             dealData((data));
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
	var lastOid=data[0].id;
	for(var i=0;i<len;i++)
	{
		data[i].books = data[i].products;
		geneOneOrder(data[i]);

	}
	//if(bigData.length>0) geneTable(bigData);
}

var geneTable=function(data){
	var tr=$("<tr/>");
	var oid="<td>"+data[0].id+"</td>";
	var time="<td>"+data[0].createdAt+"</td>";
	var books="";
	var nums="";
	var price=0;
	var sprice="";
	for(var i=0;i<data.length;i++)
	{
		books+="<tr><td>"+data[i].name+"</td></tr>";
		nums+="<tr><td>"+data[i].quantity+"</td></tr>";
		sprice+="<tr><td>"+data[i].price+"</td></tr>";
		price+=(data[i].quantity*data[i].price);
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
	var oid="<td>"+data.id+"</td>";
	var time="<td>"+data.createdAt+"</td>";
	var books="";
	var nums="";
	var price=0;
	var sprice="";
	for(var i=0;i<data.books.length;i++)
	{
		books+="<tr><td>"+data.books[i].name+"</td></tr>";
		nums+="<tr><td>"+data.books[i].quantity+"</td></tr>";
		sprice+="<tr><td>"+data.books[i].price+"</td></tr>";
		price+=(data.books[i].quantity*data.books[i].price);
	}
	price="<td>￥"+price+"</td>";
	sprice="<td><table>"+sprice+"</table></td>";
	books="<td><table>"+books+"</table></td>";
	nums="<td><table>"+nums+"</table></td>";
	$("<tr>"+oid+price+books+nums+sprice+time+"</tr>").appendTo("#ordersArea");
}