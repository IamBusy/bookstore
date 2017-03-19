<?xml version="1.0" encoding="utf8" ?>
<%=session.getAttribute("uid")%>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">

<title>Insert title here</title>

<link href="./resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="./resources/dependence/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="./resources/dependence/jquery.backstretch.min.js"></script>

<script type="text/javascript" src="./resources/dependence/bootstrap.min.js"></script>
<script type="text/javascript" src="./resources/js/core.js"></script>

</head>
<body>
<div class="container">
<!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row" style="padding-top:180px">
                        <div class="col-sm-4 col-sm-offset-4 form-box well">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>欢迎登陆</h3>
                            		<p>Enter your username and password to log on:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
         
			                    <form action="login" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" id="account" name="account" placeholder="Username..." class="form-username form-control block" id="form-username"/>
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" id="pwd" name="pwd" placeholder="Password..." class="form-password form-control" id="form-password"/>
			                        </div>
			                        <input type="button" class="btn btn-info btn-block "  id="login" value="Sign in!"/>
			                        <a href="register.jsp" class="pull-right" style="padding-top:10px" value="">Register Now!<span class="glyphicon glyphicon-chevron-right"></span></a>
			                    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>

</div>

</body>
<script type="text/javascript">
$(document).ready(function(){
	 $.backstretch("./resources/img/backgrounds/1.jpg");
	 
	 $("#login").on('click',function(){
		 if($("#account").val().length==0)
			{
			 alert("account is required");
			 return ;
			 
			 }
		 if($("#pwd").val().length==0)
		{
			 alert("password is required!");
			 return ;
		}
		 
		 $.ajax({
			 url:URL_REQUEST+'login',
			 type:'POST',
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
					 alert(data.hit);
					 return ;
					 }
				 else
					 {
					 C_redirect('main.jsp');
					 }
			 }
		 });
	 })
	 
});
</script>
</html>