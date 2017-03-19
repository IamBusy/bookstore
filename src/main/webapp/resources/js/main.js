function dealBook(books)
{
	$("#booksArea").html('');
	for(var i=0;i<books.length;i++)
	{
		var book=books[i];
		var template=$("#template");
		template.find("img").attr('src',book.photo).attr('bid',book.id);
		template.find("font").html('￥'+book.price);
		template.find(".title").html(book.name);
		//template.find(".cate").html(book.title);
		
		var tmp=template.clone(true);
		tmp.css('display','block');
		tmp.attr('id','');
		tmp.appendTo("#booksArea");
		
		/*var b=$("<div class=\"col-md-9\"><div class=\"col-md-3 col-md-4\"><div><IMG bid=\"\" /></div><div class=\"row\"><label class=\"title\"></label><label class=\"price\">￥<font color=\"red\"></font></label></div></div></div>");
		var img=b.children("img");
		img.attr('src',book.cover).attr('bid',book.bid);
		b.children("font").html(book.price);
		b.children(".title").html(book.title);
		b.appendTo($("#booksArea"));*/
	}
}

$(document).ready(function(){
	
	$("#search").on("click",function(){
		var key=$("#key").val();
		if(key=='')
			{
			alert("请输入关键字！");
			return ;
			}
			
		$.ajax({
			url:URL_REQUEST+'search',
			dataType:'json',
			data:{
				key:key
			},
			success:function(data)
			{
				if(!data.success)
				{
					C_err();
					return ;
				}
				console.log(data.list);
				dealBook(data.list);
				return ;
				
			}
		});
		
	});



	$.ajax({
		url:URL_REQUEST+'categories',
		dataType:'json',
		success:function(data)
		{
			console.log(data.list);
			var categories=(data);
			console.log(categories);
			for(var i=0;i<categories.length;i++)
			{
				var cate=categories[i];
				var ele=$("<a/>").addClass("list-group-item cate")
					.attr('href','#')
					.attr('cateId',cate.id)
					.html(cate.name)
					.appendTo($("#categoryArea"));
			}

		}
	});

	var getBooks=function(cateid)
	{
		$("#booksArea").html("");

		$.ajax({
			url:URL_REQUEST+'categories/'+cateid+"/products",
			dataType:'json',
			data:{
				cateid:cateid
			},
			success:function(data)
			{
				dealBook(data);
				return ;
				var books=(data);
				for(var i=0;i<books.length;i++)
				{
					var book=books[i];
					var template=$("#template");
					template.find("img").attr('src',book.cover).attr('bid',book.id);
					template.find("font").html('￥'+book.price);
					template.find(".title").html(book.name);
					//template.find(".cate").html(book.title);
					
					var tmp=template.clone(true);
					tmp.css('display','block');
					tmp.attr('id','');
					tmp.appendTo("#booksArea");
					
					/*var b=$("<div class=\"col-md-9\"><div class=\"col-md-3 col-md-4\"><div><IMG bid=\"\" /></div><div class=\"row\"><label class=\"title\"></label><label class=\"price\">￥<font color=\"red\"></font></label></div></div></div>");
					var img=b.children("img");
					img.attr('src',book.cover).attr('bid',book.bid);
					b.children("font").html(book.price);
					b.children(".title").html(book.title);
					b.appendTo($("#booksArea"));*/
				}
	
			}
		});
	}

	$("#categoryArea").on('click','.cate',function(){
		getBooks($(this).attr('cateId'));
	});


	$("#booksArea").on('click','.cover',function(){
		C_redirect('book.jsp?bookid='+$(this).attr('bid'));
	});



	getBooks(-1);
	
})