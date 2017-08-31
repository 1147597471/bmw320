<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
	 	<script src="js/jquery-1.12.4.min.js"></script>
   	 	<script src="js/bootstrap.min.js"></script>
   	 	<script type="text/javascript" src="static/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="static/jquery.validate.min.js"></script>
		<script type="text/javascript" src="static/messages_zh.min.js"></script>
		<script type="text/javascript">
	
		
		$(function(){
		$("#checkForm").validate({
			rules:{
				name:{
					required:true,
				},
				pwd:{
					required:true
				}
				
			},
			messages:{
				name:{
					required:"用户名不能为空",
				},
				pwd:{
					required:"密码不能为空"
				}
			}
		});
		
	});	

</script>
   	 	
		<style>
				* {
				box-sizing: border-box;
				font-family: 微软雅黑;
				}
				html,body {
				    height: 100%;
				}
				body {
					margin: 0;
				    background-color: #fff;
				    display: flex;
				    justify-content: center;
				    align-items: center;
				}
				.login {
				    background-color: #fff;
				    width: 340px;
				    padding-top: 30px;
				    border-radius: 5px;
				}
				.login img {
				    display: block;
				    width: 300px;
				    margin: 0 auto;
				}
				p {
				    text-align: center;
				    margin: 10px 0;
				    color: #888;
				    padding-bottom: 5px;
				}
				form {
				    padding: 0 30px 20px 30px;
				}
				input {
					border-radius: 5px;
				    height: 40px;
				    width: 100%;
				    margin: 5px 0;
				    outline: none;
				    border: 1px solid green;
				    padding-left: 10px;
				    font-size: 14px;
				}
				input:focus {
				    border: 1px solid #d70f18;
				}
				input[type=submit] {
				    width: 100%;
				    height: 40px;
				    line-height: 40px;
				    font-size: 16px;
				    
				    border: none;
				    color: #fff;
				    padding: 0;
				    margin: 5px 0;
				    cursor: pointer;
				}
				.error-message {
					color: #d70f18;
					margin: 3px 0;
				}
		</style>
	</head>
	<body>
		<div class="login">
        <img src="img/logo.png" alt="智游">
        <form id="checkForm" action="<c:url value="/admin/login.action"/>" method="post">
            <div>
                <input type="text"id="username" name="name"  placeholder="请输入用户名" value="admin">
            </div>
            <div>
                <input type="password" id="password" name="pwd" placeholder="请输入密码" value="admin">
            </div>
            <div><input type="submit" value="登录" class="btn btn-success"> 
            </div>
        </form>
    </div>
		
		
	</body>
</html>
