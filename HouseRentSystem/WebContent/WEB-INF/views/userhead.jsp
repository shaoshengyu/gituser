<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user头</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css" type="text/css">
</head>
<body>
	<div class="user_head">
		<div class="user_head_left">
			<img alt="图片加载失败" src="${pageContext.request.contextPath}/picture/anxinju.png" height="280px" width="600px"/>
		</div>
		<div class="user_head_right">
			<div class="user_head_right_top">
				<label>欢迎登陆用户使用中心</label>
			</div>
			<div class="user_head_right_bottom">
				<a class="title01" href="${pageContext.request.contextPath}/user/showhouseinfo">
				<span>找房源&nbsp;&nbsp;&nbsp;</span>
				</a>
				<a class="title01" href="${pageContext.request.contextPath}/user/medialist">
				<span>寻找中介&nbsp;&nbsp;&nbsp;</span>
				</a>
				<a class="title01" href="${pageContext.request.contextPath}/user/useraddhouse">
				<span>我要出租房子&nbsp;&nbsp;&nbsp;</span>
				</a>
				<a class="title01" href="${pageContext.request.contextPath}/user/ownhouse">
				<span>已上传房源信息&nbsp;&nbsp;&nbsp;</span>
				</a>
				<a class="title01" href="${pageContext.request.contextPath}/user/usertransaction">
				<span>查看交易信息</span>
				</a>
			</div>
		</div>
	</div>	
</body>
</html>