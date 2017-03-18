<?xml version="1.0" encoding="utf8" ?>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% if(session.getAttribute("adminUid")==null) { ; %>
尚未登录!<a href="login.jsp">点击登录</a>
<% return;} %>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="../resources/dependence/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="../resources/dependence/jquery.backstretch.min.js"></script>

<script type="text/javascript" src="../resources/dependence/bootstrap.min.js"></script>
<script type="text/javascript" src="../resources/js/core.js"></script>
<script type="text/javascript" src="../resources/js/admin/statistic.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">BookStore</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li><a href="main.jsp">首页</a></li>
		<li  ><a href="user.jsp">用户</a></li>
         <li class="active"><a href="#">数据</a></li>
         <li ><a href="order.jsp">订单</a></li>
      </ul>
      <ul class="nav navbar-nav pull-right">
         <li class="pull-right" ><a href="order.jsp"><%=session.getAttribute("adminName")%></a></li>
      </ul>
   </div>
</nav>

<div class="container">




<ul id="myTab" class="nav nav-tabs">
   <li class="active">
      <a href="#home" data-toggle="tab">
      时间
      </a>
   </li>
   <li><a href="#ios" data-toggle="tab">类别</a></li>
</ul>

<div id="myTabContent" class="tab-content">

   <div class="tab-pane fade in active" id="home">
   
   	<div class="row">
			<form class="form-inline" role="form">
				<div class="form-group">
					<label class="sr-only" for="uid">UID</label> <input type="text"
						class="form-control" id="uid" placeholder="">
				</div>
				
				<div class="form-group">
					<label class="sr-only" for="start_time">StartTime</label> 
					<input type="date" class="form-control" id="start_time">
				</div>
				
				<div class="form-group">
					<label class="sr-only" for="end_time">EndTime</label> 
					<input type="date" class="form-control" id="end_time">
				</div>
				
				<input type="button" class="btn btn-success pull-right" id="search" value="Search!"/>
			</form>

		</div>
	<div class="row" id="statisticArea">
		<table class="table">
			<thead>
      			<tr>
         			<th>UID</th>
         			<th>订单号</th>
         			<th>总价</th>
         			<th>书籍</th>
         			<th>数量</th>
         			<th>价格</th>
         			<th>时间</th>
      			</tr>
  			 </thead>
  			 <tbody id="ordersArea">
  			 	
  			 </tbody>
		</table>
	</div>
   
   </div>
   <div class="tab-pane fade" id="ios">
   <div class="row">
   <form class="form-inline" role="form">

   				<input type="button" class="btn btn-success pull-right" id="search2" value="Search!"/>
				<div class="form-group pull-right">
					<label class="sr-only" for="uid">UID</label> <input type="text"
						class="form-control" id="cateId"  placeholder="">
				</div>
				

				
				
			</form>
			
   </div>
   
   		<table class="table">
			<thead>
      			<tr>
      			<th>BOOKID</th>
         			<th>书名</th>
         			<th>价格</th>
         			<th>总销量</th>
      			</tr>
  			 </thead>
  			 <tbody id="ordersArea2">
  			 	
  			 </tbody>
		</table>
   
   
   
   
      
   </div>

   
</div>


</div>
</body>

</html>