<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script  type="text/javascript"  src="static/jquery-1.12.4.min.js"></script>

<script type="text/javascript">
   /*   alert("111");
     $(function(){
    	alert("222");
    	  $("#exit").click(function(){
    			
    	}); 
    });  */   
</script>
<header>
	<div class="container">
		<span>欢迎来到IT培训的黄埔军校——智游教育！</span>

		
		<c:if test="${not empty _front_user}">
			<div id="userBlock" style="float:right">
				<a href="front/user/logout.action" id="exit">退出</a> 
				<a href="front/user/index.action" id="account" >${sessionScope._front_user.email }</a>
			</div>
		</c:if>
		<c:if test="${empty _front_user}">
			<div id="regBlock" style="float:right">
				<a href="javascript:;" id="reg_open"><img src="static/img/we.png">注册</a>
				<a href="javascript:;" id="login_open"><img src="static/img/we.png">登录</a>
			</div>
		</c:if>

		<a onclick="JavaScript:addFavorite2()"><img src="static/img/sc.png" draggable="false">加入收藏</a>
		<a target="_self" href="admin/index.action"><img src="static/img/we.png" draggable="false">后台管理</a>
		<a class="color_e4"><img src="static/img/phone.png" draggable="false"> 0371-88888598&#x3000;&#x3000;4006-371-555</a>

	</div>
</header>
