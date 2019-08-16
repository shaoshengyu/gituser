<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<div style="position:absolute;left:200px;top:100px">
	   <a href="${pageContext.request.contextPath}/user/toregUser">用户注册</a><br/><br/>
	   <a href="${pageContext.request.contextPath}/user/tologin">用户登录</a> <br><br>
	</div>
<%session.invalidate();%>
</body>
</body>
</html>