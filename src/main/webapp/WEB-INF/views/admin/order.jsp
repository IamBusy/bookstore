
<?xml version="1.0" encoding="utf8" ?>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="../resources/dependence/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="../resources/dependence/jquery.backstretch.min.js"></script>

<script type="text/javascript" src="../resources/dependence/bootstrap.min.js"></script>
<script type="text/javascript" src="../resources/js/core.js"></script>
<script type="text/javascript" src="../resources/js/order.js"></script>

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
         <li ><a href="statistic.jsp">数据</a></li>
         <li class="active"><a href="#">订单</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
         <li class="pull-right" ><a href="order.jsp"><%=session.getAttribute("adminName")%></a></li>
      </ul>
	</div>
	</nav>

<div class="container" >
	<div class="row" id="">
<table class="table">
   <thead>
      <tr>
         <th>订单号</th>
         <th>总价</th>
         <th>书籍</th>
         <th>数量</th>
         <th>价格</th>
         <th>时间</th>
      </tr>
   </thead>
   <tbody id="ordersArea">
      <!-- <tr>
         <td>Tanmay</td>
         <td>Bangalore</td>
         <td>
         <table>
      <tr>
        <td>这里仍然可以继续嵌套表格</td>
      </tr>
      <tr>
         		<td>1</td>
         	</tr>
         	<tr>
         		<td>1</td>
         	</tr>
    </table>`
         	<tr>
         		<td>1</td>
         		<td>1</td>
         		<td>1</td>
         	</tr>
         </td>
      </tr> -->
   </tbody>
</table>
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