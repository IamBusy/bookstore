<% if(session.getAttribute("adminUid")==null) { ; %>
尚未登录!<a href="login.jsp">点击登录</a>
<% return;} %>
<?xml version="1.0" encoding="utf8" ?>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<script type="text/javascript" src="../resources/js/admin/user.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">BookStore</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li><a href="main.jsp">首页</a></li>
		<li  class="active"><a href="#">用户</a></li>
         <li ><a href="statistic.jsp">数据</a></li>
         <li ><a href="order.jsp">订单</a></li>
      </ul>
      <ul class="nav navbar-nav pull-right">
         <li class="pull-right" ><a href="order.jsp"><%=session.getAttribute("adminName")%></a></li>
      </ul>
   </div>
</nav>

<div class="container">
	<button  class="btn btn-success pull-right" id="add" data-toggle="modal" data-target="#addUser"> Add!</button>
	<div id="userArea">
		<table class="table">
			<thead>
      			<tr>
         			<th>UID</th>
         			<th>Account</th>
         			<th>Name</th>
         			<th>Operation</th>
      			</tr>
  			 </thead>
  			 <tbody id="usersArea">
      			
   			</tbody>
		</table>
	</div>
</div>
</body>

<!-- 模态框（Modal） -->
<div class="modal fade" id="addUser" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
             修改用户信息
            </h4>
         </div>
         <div class="modal-body">
         
         
 <form role="form">
   <!-- <div class="form-group">
      <label for="name">Nickname</label>
      <input type="text" class="form-control" id="name" 
         placeholder="请输入昵称">
   </div> -->
   
   <div class="form-group">
      <label for="name">账号</label>

      <input type="text"  class="form-control" id="account"  placeholder="请输入账号"  >
      </input>
   </div>
   
   <div class="form-group">
      <label for="name">密码</label>

      <input type="text"  class="form-control" id="pwd"  placeholder="密码"  >
      </input>
   </div>
   
   <div class="form-group">
      <label for="name">昵称</label>

      <input type="text"  class="form-control" id="name"  placeholder="昵称"  >
      </input>
   </div>
   


</form>


         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" id="addUserButton" class="btn btn-primary">
               提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
<!-- <tr id="template">
	<td class="uid"></td>
	<td class="account"></td>
	<td class="name"></td>
	<td ><input class="operation" type="button" value="Delete!"></td>
</tr> -->
</html>