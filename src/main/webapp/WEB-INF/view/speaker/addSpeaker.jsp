<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link href="../css/bootstrap.min.css" rel="stylesheet">
	 	<script src="../js/jquery-1.12.4.min.js"></script>
   	 	<script src="../js/bootstrap.min.js"></script>
    
    <style type="text/css">
    		
    		.body {
				    background-color: #fff;
				    display: flex;
				    justify-content: center;
				    align-items: center;
				}
				
			.title{
    				display: flex;
				    justify-content: center;
				    align-items: center;
				   
    		}
    		
    		.small{
					
					font-size: 16px;
					position: relative;
					right: 2px;
					top:5px;
				
			}		
    		
    	
    </style>
	</head>
	<body>
	<nav class="navbar navbar-inverse">
      <div class="container-fluid" >
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="title">
        	<div style="width: 60%;">
		        <div class="navbar-header">
		          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		          
		          <a class="navbar-brand" href="#">视频管理系统</a>
		        </div>
		
		        <!-- Collect the nav links, forms, and other content for toggling -->
		        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9" style="width: 100%;">
		          	<ul class="nav navbar-nav">
			            <li><a class="navbar-brand" href="<c:url value="/video/videoList.action"/>">视频管理</a></li>
			            <li class="active"><a href="<c:url value="/speaker/speakerList.action"/>">主讲人管理</a></li>
			            <li><a href="<c:url value="/course/courseList.action"/>">课程管理</a></li>
			            <li><a href="<c:url value="/video/view.action" />">统计分析</a></li>
		          	</ul>

		        </div><!-- /.navbar-collapse -->
		      </div>  
		     <div class="small">
		        	<a style="color: #C0C0C0;text-decoration:none;" href="#">${loginList[0].loginName }</a>
		        	<a class="glyphicon glyphicon-log-out" style="color: #C0C0C0;text-decoration: none;" href="<c:url value="/index.jsp"/>"></a>
		     </div> 
		</div> 
		
      </div><!-- /.container-fluid -->
    </nav>
  
  	<div class="body">
		       	<div class="jumbotron" style="width: 60%;height: 20px;position: relative;top: -18px; border-radius: 10px;">
		      		<div style="position: relative; top: -50px;left: 40px;"><h2>编辑主讲人-主讲人管理</h2></div>
		    	</div>
  	</div>

  	<div class="body" >
		<div style="width: 60%;">
			<form class="form-horizontal" action="<c:url value="/speaker/addSpeaker.action"/>" method="post">
				<div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">名字</label>
				    <div class="col-sm-10">
				    <input type="text" class="form-control" id="inputPassword3" placeholder="请输入主讲人名字" name="speakerName">
				    </div>
			  	</div>
				
				<div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">职业</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputPassword3" placeholder="请输入主讲人职业" name="speakerJob">
				    </div>
			  	</div>
			 	
			 	<div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">头像图片</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputPassword3" placeholder="请输入主讲人头像图片地址" name="speakerHeadUrl">
				    </div>
			  	</div>
			  	
			  	<div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">简介</label>
				    <div class="col-sm-10">
				      <textarea class="form-control" rows="3" name="speakerDescr"></textarea>
				    </div>
			  	</div>
			 	
			 	<input type="submit" class="btn btn-primary" value="保存"/>
			 	<a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>	
		 	
		 </div>
  	</div>
  	</form>
  	
  	
	</body>
</html>
