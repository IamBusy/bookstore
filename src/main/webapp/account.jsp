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
<script type="text/javascript" src="./resources/js/account.js"></script>

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
      </ul>
      <ul class="nav navbar-nav pull-right">
      <%if(session.getAttribute("uid")!=null){ %>
         <li class="pull-right" ><a href="#"><%=session.getAttribute("name")%></a></li>
         <%} %>
      </ul>
   </div>
</nav>

<div class="container">
	<div class="col-md-3">
		<div class="row">
			<img id="photo" class="img-thumbnail" data-toggle="modal" data-target="#myModal"/>
		</div>
		<div class="row">
			<ul class="list-group">
   				<li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp个人主页</a></li>
   				<li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-envelope"></span>&nbsp我的消息</a></li>
   				<li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-heart"></span>&nbsp我的好友</a></li>
   				<li class="list-group-item"><a href="#" id="quit"><span class="glyphicon glyphicon-off"></span>&nbsp退出登录</a></li>
			</ul>
		</div>
			
	</div>
	<div class="col-md-8">
	
<form role="form">
   <!-- <div class="form-group">
      <label for="name">Nickname</label>
      <input type="text" class="form-control" id="name" 
         placeholder="请输入昵称">
   </div> -->
   
   <div class="form-group">
      <label for="name">Hobby</label>

      <textarea  class="form-control" id="hobby"  rows="2" placeholder="请输入兴趣爱好" disabled >
      </textarea>
   </div>
   
   
   <div class="form-group">
      <label for="name">Introduction</label>

      <textarea  class="form-control" id="introduction"  rows="3" placeholder="请输入个人简介" disabled >
      </textarea>
   </div>
   
   <button type="button" id="change" class="btn btn-danger" style="display:none" >保存</button>
   <button type="button" id="modify" class="btn btn-info">修改</button>
</form>
	
	</div>
</div>
<SCRIPT type="text/javascript">
$(document).ready(function(){
	
	$("#modify").on("click",function(){
		$("textarea").attr("disabled",false);
		$("#change").css("display",'block');
		$("#modify").css("display",'none');
	})
	$.ajax({
		 url:URL_REQUEST+'getInfo',
		 dataType:'json',
		 data:{
			 account:$("#account").val(),
			 pwd    :$("#pwd").val()
		 },
		 success:function(data)
		 {
			 
			 
			 console.log(data);
			 if(!data.success)
			 {
				 alert("获取信息失败！");
				 return ;
				 }
			 else
				 {
				 $("#introduction").val(data.info.introduction);
				 $("#hobby").val(data.info.hobby);
				 if(data.info.photo=="" || data.info.photo==null)
					 $("#photo").attr('src','http://7xikcz.com1.z0.glb.clouddn.com/bookstore/test/1.jpg');
				 }
		 }
	 });
	
	$("#change").on("click",function(){
		$.ajax({
			 url:URL_REQUEST+'updateInfo',
			 dataType:'json',
			 data:{
				 intro:$("#introduction").val(),
				 hobby:$("#hobby").val()
			 },
			 success:function(data)
			 {
				 
				 
				 console.log(data);
				 if(!data.success)
				 {
					 alert("更新失败，请重试！");
					 return ;
					 }
				 else
					 {
					 $("textarea").attr("disabled",true);
						$("#change").css("display",'none');
						$("#modify").css("display",'block');
					 alert("更新成功！");
					 //$("#introduction").val(data.intro);
					 }
			 }
		 });
	});
	
	$("#quit").on("click",function(){
		$.ajax({
			 url:URL_REQUEST+'logout',
			 dataType:'json',
			 success:function(data)
			 {		 
				 console.log(data);
				 if(!data.success)
				 {
					 alert("更新失败，请重试！");
					 return ;
					 }
				 else
					 {
					 window.location.href="login.jsp";
					 //$("#introduction").val(data.intro);
					 }
			 }
		 });
		
	});
});
</SCRIPT>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               模态框（Modal）标题
            </h4>
         </div>
         <div class="modal-body">
            在这里添加一些文本
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</body>
</html>