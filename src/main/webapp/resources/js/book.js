curBook=null;


$(document).ready(function(){
	//localStorage.clear();
	getBookInfo(C_getQueryString('bookid'));
	
	$("#addCart").on('click',function(){
		if($("#num").val()>0)
		{
            modifyCart(curBook,$("#num").val());
            C_prompt("添加成功");

			return ;
		}
		else
		{
			alert('Please input the number(1-999)');
		}
	});
});


var getBookInfo=function(bid)
{
	if(bid==null) return;
	$.ajax({
		url:URL_REQUEST+'products/'+bid,
		dataType:'json',
		data:{
			bid:bid
		},
		success:function(data)
		{
			var books=(data);
			console.log(books);
			
			if(books!=null)	
			{
				var book=books;
				curBook=book;
				curBook.bid = book.id;
				$("#cover").attr('src',book.photo);
				$("#title").html(book.name);
				$("#price").html(book.price);
				$("#author").html(book.author);
				$("#intro").html(book.intro);
			}
		}
	});
}