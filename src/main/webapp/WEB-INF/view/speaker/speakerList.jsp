<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="zyc" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html lang="zh-CN">
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
	 	<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
   	 	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    
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
			            <li><a class="navbar-brand" href="<c:url value="/admin/video/videoList.action"/>">视频管理</a></li>
			            <li class="active"><a href="<c:url value="/admin/speaker/speakerList.action"/>">主讲人管理</a></li>
			            <li><a href="<c:url value="/admin/course/courseList.action"/>">课程管理</a></li>
			            <li><a href="<c:url value="/admin/video/view.action" />">统计分析</a></li>
		          	</ul>

		        </div><!-- /.navbar-collapse -->
		      </div>  
		     <div class="small">
		        	<a style="color: #C0C0C0;text-decoration:none;" href="#">${loginList[0].loginName }</a>
		        	<a class="glyphicon glyphicon-log-out" style="color: #C0C0C0;text-decoration: none;" href="<c:url value="/admin/index.jsp"/>"></a>
		     </div> 
		</div> 
		
      </div><!-- /.container-fluid -->
      	
    </nav>
    
    <div class="body">
		       	<div class="jumbotron" style="width: 60%;height: 20px;position: relative;top: -18px; border-radius: 10px;">
		      		<div style="position: relative; top: -50px;left: 40px;"><h2>主讲人列表-主讲人管理</h2></div>
		    	</div>
  	</div>
  
  	<div class="body" >
		<div style="width: 60%;">
			<a href="<c:url value="/admin/speaker/addSpeaker.action"/>" class="btn btn-primary" >添加主讲人</a>&nbsp;&nbsp;
			 
			 <form>	
			 	<div style="float: right;">
			 		<input type="submit" class="btn btn-primary" style="float: right; " value="查询"/>
			 	</div>
			 	
			 	<div class="form-group" style="float: right;">
						  <input type="text" name="speakerJob" class="form-control" id="exampleInputName2" placeholder="主讲人职位" value="${speakerJob}">
			    </div>
			    
			 	<div class="form-group" style="float: right;">
						 <input type="text" name="speakerName" class="form-control" id="exampleInputName2" placeholder="主讲人名称" value="${speakerName}">
			   </div>
			 
		 	</form>
		 </div>
  	</div>
  	
  	<div class="body">
  		<div style="width: 60%;">
  			<table class="table table-hover">
  				<thead>
  					<td width="40px">序号</td>
  					<td width="100px">名称</td>
  					<td width="100px">职位</td>
  					<td>简介</td>
  					<td width="40px">编辑</td>
  					<td width="40px">删除</td>
  				</thead>
  				<tbody>
	  				<c:forEach var="list" items="${page.rows}" varStatus="status">
  						<tr class="success">
		  					<td>${(page.page-1)*7+status.count}</td>
		  					<td>${list.speakerName}</td>
		  					<td>${list.speakerJob }</td>
		  					<td>${list.speakerDescr }</td>
		  					<td><a href="<c:url value="/admin/speaker/editSpeaker.action"/>?id=${list.id}" class="glyphicon glyphicon-edit" style="text-decoration: none"></a></td>
		  					<td>
		  					
			  			<a class="glyphicon glyphicon-trash" data-toggle="modal" data-target="#myModal${list.id }" > </a>
						<!-- Modal -->
						<div class="modal fade" id="myModal${list.id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog" role="document">
							 <div class="modal-content">
								 <div class="modal-header">
							      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="myModalLabel">确认框</h4>
							      </div>
							      <div class="modal-body">
							                确认删除么
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
							        <a class="btn btn-primary" href="<c:url value="/admin/speaker/deleteSpeaker.action?id=${list.id }" />">确定</a>
							      </div>
							    </div>
							  </div>
							</div>
						  					
	  				    </td>
 						</tr>
 					</c:forEach>
 				</tbody>
  			</table>
  			
  		</div>
  		
  	</div>
  	
  	<div class="body">
  		<div style="width: 60%;">
  			<zyc:page url="${pageContext.request.contextPath}/admin/video/videoList.action"/>
  		</div>
  	
  	</div>
  	
	</body>
</html>

