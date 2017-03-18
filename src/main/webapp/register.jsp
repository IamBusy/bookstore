<?xml version="1.0" encoding="utf8" ?>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">

<title>Insert title here</title>

<link href="./resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="./resources/dependence/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="./resources/dependence/jquery.validate.min.js"></script>
<script type="text/javascript" src="./resources/dependence/jquery.backstretch.min.js"></script>

<script type="text/javascript" src="./resources/dependence/bootstrap.min.js"></script>
<script type="text/javascript" src="./resources/js/core.js"></script>
<STYLE type="text/css">
.errorPlacement{
	color:red;
}
</STYLE>
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
                        			<h3>欢迎注册</h3>
                            		<p>Enter your username and password to register:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
         
			                    <form  class="login-form" id="register_form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" id="account" name="account" placeholder="Username..." class="form-username form-control block" id="form-username"/>
			                        </div>
			                        <div class="errorPlacement"></div>
			                        
			                        <div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" id="name" name="name" placeholder="Nickname..." class="form-username form-control block" id="form-username"/>
			                        </div>
			                        <div class="errorPlacement"></div>
			                        
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" id="pwd" name="pwd" placeholder="Password..." class="form-password form-control" id="form-password"/>
			                        </div>
			                        <div class="errorPlacement"></div>
			                        
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" id="sure_pwd" name="sure_pwd" placeholder="Confirm Password..." class="form-password form-control" id="form-password"/>
			                        </div>
			                        <div class="errorPlacement"></div>
			                        
			                        
			                        <input type="button" class="btn btn-info btn-block "  id="register" value="Register!"/>
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
	 
	 var registerForm=$("#register_form").validate({
		    rules: {
		      account: "required",
		      name: "required",
		      pwd: "required",
		      sure_pwd: {
		    	  required:true,
		    	  equalTo:pwd
		      }
		    },
		    errorPlacement:function(error,element)
	        {
	            error.appendTo(element.parent('div').next('.errorPlacement'));
	        }
		});
	 
	 $("#register").on('click',function(){
		 if(!registerForm.form())
		{
			 return ;
		}
		 else
		{
			 $.ajax({
				 url:URL_REQUEST+'register',
				 type:'POST',
				 dataType:'json',
				 data:{
					 account:$("#account").val(),
					 pwd    :$("#pwd").val(),
					 name   :$("#name").val()
				 },
				 success:function(data)
				 {
					 console.log(data);
					 if(!data.success)
						 {
						 alert(data.list.hit);
						 return ;
						 }
					 else
						 {
						 C_redirect('main.jsp');
						 }
				 }
			 });
		}
	 });
	
	 
});
</script>
</html>