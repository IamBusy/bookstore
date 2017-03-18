$(document).ready(
		function() {
			var len = C_cart.length;
			var totPrice=0;
			for (var i = 0; i < len; i++) {
				var template = $("#template").clone();
				template.find('img').attr('src', C_cart[i].info.cover);
				template.find('.num').val(C_cart[i].num);
				template.find('.price').html('￥'+C_cart[i].info.price);
				template.find('.modifyNum').attr('bookid', C_cart[i].info.bid);
				template.find('.delete').attr('bookid', C_cart[i].info.bid);
				template.find('.title').html(C_cart[i].info.title);
				template.css('display', 'block').attr('id', '').appendTo(
						"#ordersArea");
				totPrice+=C_cart[i].info.price*C_cart[i].num;
			}
			
			$("#submitOrder").val('￥'+totPrice);

			$("#ordersArea").on('click', '.modifyNum', function() {
				var num = $(this).closest("form").find(".num").val();
				var bid = $(this).attr('bookid');
				if (num > 0) {
					var book = getBookFromCart(bid);
					if (book != null) {
						modifyCart(book, num);
						C_prompt("修改成功");
					} else {
						C_prompt("修改失败");
					}

					return;
				} else {
					alert('Please input the number(1-999)');
				}
			});

			$("#ordersArea").on('click', '.delete', function() {
				var bid = $(this).attr('bookid');
				delCart(bid);
				C_prompt("删除成功");
			});
			
			$("#submitOrder").on('click',function(){
				var len=C_cart.length;
				if(len==0)
				{
					C_prompt("您的购物车中没有物品!");
					return ;
				}
				var books=new Array();
				for(var i=0;i<len;i++)
				{
					books.push({bid:C_cart[i].info.bid,num:C_cart[i].num});
					//books.push(C_cart[i].info.bid+"_"+C_cart[i].num);
				}
				
				$.ajax({
					 url:URL_REQUEST+'order',
					 type:'POST',
					 dataType:'json',
					 data:{
						 books:JSON.stringify(books)
					 },
					 success:function(data)
					 {
						 console.log(data);
						 if(!data.success)
							 {
							 C_prompt((data.hit)?data.hit:"订单提交失败！");
							 return ;
							 }
						 else
							 {
							 localStorage.clear();
							 C_prompt("订单提交成功！");
							 C_redirect('main.jsp');
							 }
					 }
				 });
			});
		});