<?xml version="1.0" encoding="utf8" ?>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<script type="text/javascript" src="./resources/js/main.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">BookStore</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li class="active"><a href="#">首页</a></li>
         <li ><a href="cart.jsp">购物车<span id="cart_num" class="label label-success">5</span></a></li>
         <li ><a href="order.jsp">订单</a></li>
         <li ><input style="margin-top:8px" type="text" class="form-control" placeholder="输入关键字" id="key"/></li>
         <li><input style="margin-top:8px"  type="button" class="btn btn-info" id="search" value="Search!" /></li>
      </ul>
      
      <ul class="nav navbar-nav pull-right">
      <%if(session.getAttribute("uid")!=null){ %>
         <li class="pull-right" ><a href="account.jsp"><%=session.getAttribute("name")%></a></li>
         <%} %>
      </ul>
   </div>
</nav>

<div class="container">
	<div class="col-md-3" id="categoryArea">
		<a href="#" class="list-group-item cate" cateid="-1">ALL</a>

	</div>
	<div class="col-md-9" id="booksArea">
		
	</div>
	<div class="col-md-9 col-md-offset-3" style="text-align:center">
		<ul class="pagination" style="left:45%">
 		 	<li><a href="#">&laquo;</a></li>
  			<li><a href="#">1</a></li>
  			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
</div>
<div class="col-md-3 col-md-4" id="template" style="display:none;margin:0px 10px 10px 10px">
			<div><IMG class="cover" alt="" src="" style=" cursor:pointer" /></div>
			<div class="row">
				<label class="title" style="padding-left:25px"></label>
				<label class="price pull-right"><font color="red"></font></label>
			</div>
</div>
</body>
<footer class="footer navbar-fixed-bottom ">
    <div class="container" style="text-align:center;">
    <p>版权所有@2016 魏晓乐</p>
    </div>
</footer>
</html>