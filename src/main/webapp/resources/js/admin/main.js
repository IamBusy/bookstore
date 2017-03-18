var Category={};

$(document).ready(function(){
	$.ajax({
		url:URL_REQUEST+'../../api/getCategories',
		dataType:'json',
		success:function(data)
		{
			if(!data.success)
			{
				C_err();
				return ;
			}
			var categories=(data.list) ;
			Category=categories;
			for(var i=0;i<categories.length;i++)
			{
				var cate=categories[i];
				var ele=$("<a/>").addClass("list-group-item cate")
					.attr('href','#')
					.attr('cateId',cate.cateId)
					.html(cate.name)
					.appendTo($("#categoryArea"));
			}

		}
	});

	

	$("#categoryArea").on('click','.cate',function(){
		getBooks($(this).attr('cateId'));
	});


	$("#booksArea").on('click','.cover',function(){
		$("#bookEdit").attr('mode','edit');
		$("#bookEdit").attr('bookid',$(this).attr('bid'));
		$("#delBook").css('display','');
		$("#saveBook").val('修改并保存');
		$("#bookEdit").modal();
		//C_redirect('book.jsp?bookid='+$(this).attr('bid'));
	});



	getBooks(-1);
	
	
	$("#delBook").on('click',function(){
		if(!confirm("您确定要删除此书？")) return;
		var bookid=$("#bookEdit").attr('bookid');
		$.ajax({
			url:URL_REQUEST+'delBook',
			dataType:'json',
			data:{
				bid:bookid
			},
			success:function(data)
			{
				if(!data.success)
				{
					C_err();
					return ;
				}
				C_prompt("删除成功!");
				C_redirect("main.jsp");

			}
		});
	});
	var getForm=function()
	{
		var names=['title','author','price','cover','cate']
		var data=new Object();
		for(var i=0;i<names.length;i++)
		{
			data[names[i]]=$("input[name="+names[i]+"]").val();
		}
		data.intro=$("textarea[name=introduction]").val();
		if(isNaN(data['cate']))
		{
			for(var i=0;i<Category.length;i++)
			{
				if(Category[i].name==data['cate'])
				{
					data['cateId']=Category[i].cateId;
					return data;
				}
			}
			data['cateId']=1;
		}
		return data;
	}
	
	$("#saveBook").on('click',function(){
		var mode=$("#bookEdit").attr('mode');
		var newBook=getForm();
		//添加书籍
		if(mode=='add')
		{
			var isComp=true;
			$("#book_form").find("input").each(function(){
				if($(this).val()=='')
				{
					isComp=false;
					
				}
					
			})
			if(!isComp)
			{
				alert("请填写完整信息！");
				return ;
			}
			$.ajax({
				url:URL_REQUEST+'addBook',
				dataType:'json',
				data:newBook,
				success:function(data)
				{
					if(!data.success)
					{
						C_err();
						return ;
					}
					C_prompt("添加成功!");
					//C_redirect("main.jsp");

				}
			});
			
		}
		else if(mode=='edit')
		{
			
			var bookid=$("#bookEdit").attr('bookid');
			newBook.bid=bookid;
			$.ajax({
				url:URL_REQUEST+'updateBook',
				dataType:'json',
				data:newBook,
				success:function(data)
				{
					if(!data.success)
					{
						C_err();
						return ;
					}
					C_prompt("修改成功!");
					C_redirect("main.jsp");

				}
			});
		}
		
	});
	
	
	
	$("#bookEdit").on('show.bs.modal', function () {
		  var book=getBookInfo($(this).attr('bookid'));
		  if(book==undefined) return ;
		  $("input[name=title]").val(book.title);
		  $("input[name=author]").val(book.author);
		  $("input[name=price]").val(book.price);
		  $("input[name=cover]").val(book.cover);
		  $("input[name=cate]").val(getCateById(book.cateid));
		  $("textarea").val(book.intro);
		  
	});
	
	$("#addBook").on('click',function(){
		$("#bookEdit").attr('mode','add');
		$("#delBook").css('display','none');
		$("#saveBook").val('保存');
		$("#bookEdit").modal();
		$("input[name=title]").val("");
		$("input[name=author]").val("");
		$("input[name=price]").val("");
		$("input[name=cover]").val("");
		$("input[name=cate]").val("");
		$("textarea").val("");
	});
});


var getCateById=function(id)
{
	for(var i=0;i<Category.length;i++)
	{
		if(Category[i].cateid==id)
		{
			return Category[i].name;
		}
	}
	return "";
}

var getBooks=function(cateid)
{
	$("#booksArea").html("");

	$.ajax({
		url:URL_REQUEST+'getBooks',
		dataType:'json',
		data:{
			cateid:cateid
		},
		success:function(data)
		{
			if(!data.success)
			{
				C_err();
				return ;
			}
			var books=(data.list);
			for(var i=0;i<books.length;i++)
			{
				var book=books[i];
				var template=$("#template");
				template.find("img").attr('src',book.cover).attr('bid',book.bid);
				template.find("font").html('￥'+book.price);
				template.find(".title").html(book.title);
				
				var tmp=template.clone(true);
				tmp.css('display','block');
				tmp.attr('id','');
				tmp.appendTo("#booksArea");
			}

		}
	});
}


var getBookInfo=function(bid)
{
	var book
	$.ajax({
		url:URL_REQUEST+'../../api/getBook',
		dataType:'json',
		async:false,
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
			book=(data.list);
			
		}
	});
	return book;
}