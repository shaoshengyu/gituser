<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/origin.css" type="text/css">
<title>用户基本信息</title>
</head>
<%
String forgetpasswordmsg=(String)request.getSession().getAttribute("forgetpasswordmsg");	
%>
<script src="${pageContext.request.contextPath}/js/check.js"></script>
<body>
	<div class="origin_head_content">
		<div class="head_left">
			<img alt="图片加载失败" src="${pageContext.request.contextPath}/picture/anxinju.png" height="280px" width="600px"/>
		</div>
		<div class="head_right">
			<label>欢迎使用安心居</label>
		</div>
	</div>
	<div class="forgetpassword">
		<form name="userInfo" action="${pageContext.request.contextPath}/origin/forget" method="post">
			<h3>请输入用户名、邮箱重要验证信息来修改密码</h3>
  			<font class="font_forgetpassword">${forgetpasswordmsg}</font><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名:<input type="text" name="username" id="username"/><br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱:<input type="text" name="useremail" id="useremail"/><br><br>
			请输入新密码:<input type="password" name="userpassword" id="userpassword"><br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确认密码:<input type="password" name="newpassword" id="newpassword"/><br><br>
			<input type="submit" value="修改"  onclick="return forgetpasswordcheck();">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/">返回首页</a>
  		</form>
	</div>
</body>
</html>
