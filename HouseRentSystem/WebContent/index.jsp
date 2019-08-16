<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<div style="position:absolute;left:200px;top:100px">
	  	<a href="${pageContext.request.contextPath}/user/getmessageinfo">发送私信</a> <br>
	   <a href="${pageContext.request.contextPath}/user/showhouseinfo">找房</a> <br>
	   <a href="${pageContext.request.contextPath}/user/medialist">找中介</a> <br>
	   <a href="${pageContext.request.contextPath}/user/useraddhouse">用户加房</a> <br>
	   <a href="${pageContext.request.contextPath}/user/usertransaction">用户交易信息查询</a> <br>
	   <a href="${pageContext.request.contextPath}/user/transaction">房源信息查询</a> <br>
	   <a href="${pageContext.request.contextPath}/user/juBao?userid=102">举报用户</a> <br>
	   <a href="${pageContext.request.contextPath}/user/transaction?houseid=401">用户添加交易信息</a> <br>
	   <a href="${pageContext.request.contextPath}/user/usercredit?userid=101">点赞</a> <br>
	   <a href="${pageContext.request.contextPath}/user/comment?customid=101&ownerid=102&mediaid=103">评价</a> <br><br> 
	   <a href="${pageContext.request.contextPath}/user/mediainfo?userid=104">点击获取中介信息</a> <br>
	   <a href="${pageContext.request.contextPath}/user/showuserinfo?userid=103">点击获取用户信息</a> <br>
   
	   <a href="${pageContext.request.contextPath}/media/mediaaddHouse">中介加房</a> <br>
	   <a href="${pageContext.request.contextPath}/media/mediaaddhouse">中介添加房源信息</a> <br>
	   <a href="${pageContext.request.contextPath}/media/transaction?houseid=401">中介添加交易信息</a> <br>
	   <a href="${pageContext.request.contextPath}/media/updatemessage">中介处理信息</a> <br>  
	   <a href="${pageContext.request.contextPath}/media/seemessage">中介查看信息</a> <br>
	   <a href="${pageContext.request.contextPath}/media/ownhouse">中介查看上传房源信息</a> <br><br>
	   
	   
	   <a href="${pageContext.request.contextPath}/admin/chulijuBao">处理被举报用户</a> <br>
	   <a href="${pageContext.request.contextPath}/admin/seltrans">查看所有交易记录</a> <br><br>
	     
	   
	   <a href="${pageContext.request.contextPath}/origin/regUser">用户注册</a><br/>
	   <a href="${pageContext.request.contextPath}/origin/userlogin">用户登录</a> <br><br>
	   <a href="${pageContext.request.contextPath}/origin/userlogin">忘记密码</a> <br><br>
		
		拦截器
	</div>
</body>
</html>
