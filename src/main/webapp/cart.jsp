<%@ page import="java.util.Random" %>
<?xml version="1.0" encoding="utf8" ?>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%
	Random random = new  Random(88344);
	Double key = random.nextDouble();
	session.setAttribute("orderKey", key);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="./resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="./resources/dependence/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="./resources/dependence/jquery.backstretch.min.js"></script>

<script type="text/javascript" src="./resources/dependence/bootstrap.min.js"></script>
<script type="text/javascript" src="./resources/js/core.js"></script>
<script type="text/javascript" src="./resources/js/cart.js"></script>

	<script src="./resources/js/des.js"></script>


</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">BookStore</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li><a href="main.jsp">首页</a></li>
			<li  class="active"><a href="#">购物车
				<span id="cart_num" style="visibility: hidden" ></span>
			</a></li>
			<li><a href="order.jsp">订单</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li class="pull-right" ><a href="account.jsp" id="accountTarget"></a></li>
      <%if(session.getAttribute("uid")!=null){ %>
         <li class="pull-right" ><a href="#"><%=session.getAttribute("name")%></a></li>
         <%} %>
      </ul>
	</div>
	</nav>

<div class="container" >
	<div class="row" id="ordersArea"></div>
	<div class="row">
		<div class="col-md-offset-5 col-md-2 col-sm-offset-4 col-sm-4">
			<input type="text"  class="form-control" id="password">
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-5 col-md-2 col-sm-offset-4 col-sm-4">
			<input type="button" text="提交订单" key="<%=key%>" class="form-control btn btn-success" id="submitOrder" value="Order!" >
		</div>
		
	</div>
	
</div>

<div class="row well" id="template"  style="display:none;padding-top:35px">
		<div class="col-md-4 col-sm-6">
			<img />
		</div>
		<div class="col-md-8 col-sm-6">
			<h2 class="title"></h2>
			
			<span class="price" style="color:red;font-size:15px"></span>
		
			<form role="form" class="form-inline">
				<div class="form-group">
					<label for="name">数量：</label> 
				</div>
				<div class="form-group">
					<input class="form-control num" type="text">
				</div>
				
				<div class="form-group">
					<input type="button" class="btn btn-success modifyNum" value="修改"/>
					<input type="button" class="btn btn-danger delete" value="删除"/>
				</div>
			</form>		
		</div>
		<hr>
	</div>
</body>
</html>