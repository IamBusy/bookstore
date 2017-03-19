$(document).ready(
		function() {

            $.ajax({
                url:URL_REQUEST+'cart',
                dataType:'json',
                success:function(data)
                {
                	C_cart=[];
                	for(var i=0;i<data.length;i++)
					{
						data[i].bid = data[i].id;
						C_cart.push({
							info:data[i],
							num:data[i].quantity
						});

					}

                    var len = C_cart.length;
                    var totPrice=0;
                    for (var i = 0; i < len; i++) {
                        var template = $("#template").clone();
                        template.find('img').attr('src', C_cart[i].info.photo);
                        template.find('.num').val(C_cart[i].num);
                        template.find('.price').html('￥'+C_cart[i].info.price);
                        template.find('.modifyNum').attr('bookid', C_cart[i].info.bid);
                        template.find('.delete').attr('bookid', C_cart[i].info.bid);
                        template.find('.title').html(C_cart[i].info.name);
                        template.css('display', 'block').attr('id', '').appendTo(
                            "#ordersArea");
                        totPrice+=C_cart[i].info.price*C_cart[i].num;
                    }

                    $("#submitOrder").val('￥'+totPrice.toFixed(2));

                }
            });


			


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
				$(this).closest(".row").hide();
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

				var key = $(this).attr("key");
				
				$.ajax({
					 url:URL_REQUEST+'orders',
					 type:'POST',
					 dataType:'json',
					 data:{
					 	pwd:strEnc($("#password").val(),key),
					 	books:JSON.stringify(books)
					 },
					 success:function(data)
					 {
                         sessionStorage.clear();
                         C_prompt("订单提交成功！");
                         C_redirect('main.jsp');
					 },
					error:function (data) {
					 	if(data.status!=200)
						{
                            alert("提交失败，请核对密码");
                            return;
						}
                        sessionStorage.clear();
                        C_prompt("订单提交成功！");
                        C_redirect('main.jsp');

                    }
				 });
			});
		});