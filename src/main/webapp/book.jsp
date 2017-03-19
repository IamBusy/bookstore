<?xml version="1.0" encoding="utf8" ?>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="./resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">


<script type="text/javascript"
	src="./resources/dependence/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="./resources/dependence/jquery.backstretch.min.js"></script>

<script type="text/javascript"
	src="./resources/dependence/bootstrap.min.js"></script>
<script type="text/javascript" src="./resources/js/core.js"></script>
<script type="text/javascript" src="./resources/js/book.js"></script>

</head>
<body>
	<nav class="navbar navbar-inverse" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">BookStore</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="main.jsp">首页</a></li>
			<li><a href="cart.jsp">购物车<span id="cart_num" style="visibility: hidden"></span></a></li>
			<li><a href="#">订单</a></li>
		</ul>
	</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-sm-6">
			<img id="cover" />
		</div>
		<div class="col-md-8 col-sm-6">
			<h2 id="title">Title</h2>
			<hr>
			
			
			<form role="form">
				<div class="form-group">
					<label for="name">作者：</label>
					<span id="author"></span>
				</div>
				
				<%-- <div class="form-group">
					<label for="name">分类：</label> 
					<span id="category"></span>
				</div> --%>
				
				<div class="form-group">
					<label for="name">价格：</label> 
					<span id="price"></span>
				</div>
			</form>
			
			<form role="form" class="form-inline">
				<div class="form-group">
					<label for="name">数量：</label> 
				</div>
				<div class="form-group">
					<input id="num" class="form-control" type="text">
				</div>
				
				<div class="form-group">
					<input type="button" class="btn btn-success"  id="addCart" value="加入购物车"/>
				</div>

			</form>
			
		</div>
		</div>
		<div>
		<p id="intro" style="font-size:20px;padding-top:35px">this is introduction</p>
		</div>
		


	</div>
</body>
</html>