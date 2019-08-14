<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cha5.pojo.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%session.removeAttribute("xinxi");
User user = new User();
StringBuffer url=request.getRequestURL();
user.setName("游客");
user.setUrl(url);
session.setAttribute("xinxi", user);
%>

<p><font color='red'>${requestScope.tip}</font></p>
<%
String error=(String)request.getAttribute("errorMsg");
if(error != null){
	response.getWriter().print("<font color='red'>"+error+"</font>");
}
%>
<p><font color='red'>请求登陆访问总次数:${count}</font></p>
<form action="loginServlet" method="post">
<p>用户名:<input name="name" type="text"></p>
<p>密&nbsp;码:<input name="password" type="password"></p>
<p><input type="submit" value="登录">
<%//清除session %>
<%session.invalidate(); %>
</form>
<a href="test.jsp">测试</a>
</body>
</html>