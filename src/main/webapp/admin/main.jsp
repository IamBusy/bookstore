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
<script type="text/javascript" src="../resources/js/admin/main.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">BookStore</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li class="active"><a href="#">首页</a></li>
		<li ><a href="user.jsp">用户</a></li>
         <li ><a href="statistic.jsp">数据</a></li>
         <li ><a href="order.jsp">订单</a></li>
      </ul>
      <ul class="nav navbar-nav pull-right">
         <li class="pull-right" ><a href="order.jsp"><%=session.getAttribute("adminName")%></a></li>
      </ul>
   </div>
</nav>

<div class="container">
	<div class="col-md-3" id="categoryArea">
		<a href="#" class="list-group-item active" cateid="-1" id="addBook">Add book!</a>
		<a href="#" class="list-group-item cate" cateid="-1">ALL</a>

	</div>
	<div class="col-md-9" id=booksArea>
		
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
<!-- 模态框（Modal） -->
<div class="modal fade" id="bookEdit" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
            </h4>
         </div>
         <div class="modal-body">
         
								<form  class="login-form" id="book_form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Title</label>
			                        	<input type="text" id="" name="title" placeholder="Title" class="form-username form-control block" id="form-username"/>
			                        </div>
			                        <div class="errorPlacement"></div>
			                        
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Author</label>
			                        	<input type="text" id="" name="author" placeholder="Author" class="form-password form-control" id="form-password"/>
			                        </div>
			                        
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Category</label>
			                        	<input type="text" id="" name="cate" placeholder="Category" class="form-password form-control" id="form-password"/>
			                        </div>
			                        
			                        <div class="form-group">
			                    		<label class="sr-only" for="form-username">Cover</label>
			                        	<input type="text" id="" name="cover" placeholder="Cover" class="form-username form-control block" id="form-username"/>
			                        </div>
			                        <div class="errorPlacement"></div>
			                        
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Price</label>
			                        	<input type="text" id="" name="price" placeholder="Price" class="form-password form-control" id="form-password"/>
			                        </div>
			                        <div class="errorPlacement"></div>
			                        
			                        
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Intorduction</label>
			                        	<textarea class="form-control" name="introduction" rows="3"></textarea>
			                        	
			                        </div>
			                        <div class="errorPlacement"></div>
			                        
			                        
							</form>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <input type="button" id="saveBook" class="btn btn-primary" value="">
             
            <input type="button" id="delBook" class="btn btn-danger" value="删除此书">
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->

</html>