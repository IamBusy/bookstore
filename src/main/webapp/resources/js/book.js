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
		url:URL_REQUEST+'getBook',
		dataType:'json',
		data:{
			bid:bid
		},
		success:function(data)
		{
			if(!data.success)
			{
				C_err();
				return ;
			}
			var books=(data.list);
			console.log(books);
			
			if(books!=null)	
			{
				
				var book=books;
				curBook=book;
				$("#cover").attr('src',book.cover);
				$("#title").html(book.title);
				$("#price").html(book.price);
				$("#author").html(book.author);
				$("#intro").html(book.intro);
			}
		}
	});
}