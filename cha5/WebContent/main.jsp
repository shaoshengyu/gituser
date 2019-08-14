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
String name = (String) request.getSession().getAttribute("name");
StringBuffer url=request.getRequestURL();
user.setName(name);
user.setUrl(url);
session.setAttribute("xinxi", user);
%>

欢迎您! <%//=java.net.URLDecoder.decode(request.getParameter("name"),"ISO-8859-1")%>
<p><font color='red'>请求登陆访问总次数:${count}</font></p>
<p><font color='red'>当前在线登陆人数:${applicationScope.Num}</font></p>
<p>兴趣:${sessionScope.p}</p>
<%if(session.getAttribute("name")!=null){%>
<%=session.getAttribute("name") %>
<%} %>
<a href="login.jsp">返回</a>
<a href="test.jsp">测试</a>
</body>
</html>