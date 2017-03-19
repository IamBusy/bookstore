var URL_REQUEST='/api/';
var C_cart;
var C_cart_num;
var sS;
var C_user;

$(function(){
	C_cart= JSON.parse(localStorage.getItem("bookstore.cart"));
	C_cart_num=localStorage.getItem("bookstore.cart.num");
	if(C_cart==null)
	{
		C_cart=new Array();
	}
	if(C_cart_num==null)
	{
		C_cart_num=0;
	}

});

//修改购物车中某一物品
var modifyCart=function(book,num)
{
    $.ajax({
        type:"PUT",
        url:URL_REQUEST+'cart/products/'+book.id+'?quantity='+num,
        dataType:'json',
        data:{
            quantity:num
        },
        success:function(data)
        {
        }
    });
	
	var len=C_cart.length;
	
	for(var i=0;i<len;i++)
	{
		if(book.bid==C_cart[i].info.bid)
		{
			C_cart[i].num=num;
			saveCart();
			return  ;
		}
	}
	
	//未找到则添加
	var obj={'info':book,'num':num};
	C_cart_num+=num;
	
	C_cart.push(obj);
	
	//save
	saveCart();
}

function encryptByDES(message, key) {
    var keyHex = CryptoJS.enc.Utf8.parse(key);
    var encrypted = CryptoJS.DES.encrypt(message, keyHex, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
    });
    return encrypted.toString();
}

//删除购物车中某一物品
var delCart=function(bookid)
{
	if(C_cart==null)
	{
		C_cart=new Array();
		return ;
	}
	
	var len=C_cart.length;
	
	for(var i=0;i<len;i++)
	{
		if(bookid==C_cart[i].info.bid)
		{
			C_cart_num-=C_cart[i].num;
			C_cart.splice(i,1);
			saveCart();
			break;
		}
	}

    $.ajax({
        type:"DELETE",
        url:URL_REQUEST+'cart/products/'+bookid,
        dataType:'json',
        success:function(data)
        {
        }
    });
	
}

var saveCart=function()
{

	sessionStorage.setItem("bookstore.cart", JSON.stringify(C_cart));
    sessionStorage.setItem("bookstore.cart.num", JSON.stringify(C_cart_num));
	$("#cart_num").html("");
}

var getBookFromCart=function(bid)
{
	var len=C_cart.length;
	for(var i=0;i<len;i++)
	{
		if(C_cart[i].info.bid==bid)
		{
			return C_cart[i].info;
		}
	}
	return null;	
}

var getCartNum=function()
{
	var len=C_cart.length;
	var num=0;
	for(var i=0;i<len;i++)
	{
		num+=(parseInt(C_cart[i].num));
	}
	return num;	
}

function C_redirect(url)
{
	window.location.href=url;
}


function C_err()
{
	alert("Error,Please try again!");
}



function C_getQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

function C_prompt(msg)
{
	alert(msg);
}


$(document).ready(function(){
	$("#cart_num").html(getCartNum());
	var accountTarget = $("#accountTarget");
	if(accountTarget)
	{
        $.ajax({
            type:"GET",
            url:URL_REQUEST+'users/info',
            dataType:'json',
            success:function(data)
            {
            	C_user = data;
            	accountTarget.text(data.phone);
            }
        });
	}
	
});



