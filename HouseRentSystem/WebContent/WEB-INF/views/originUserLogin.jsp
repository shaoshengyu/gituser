<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登陆界面</title>
</head>
<%
String loginmsg=(String)request.getSession().getAttribute("loginmsg");	
%>
<script src="${pageContext.request.contextPath}/js/check.js"></script>
	
<body>
	<h3>用户登录</h3>  <br>
  <form  action="${pageContext.request.contextPath}/origin/validateUser"  method="post">
  		<font size="3" color="red">${loginmsg}</font><br><br>
       	    &nbsp;&nbsp;用户名:<input type="text" name="username" id="username" value="${userinfo.username}">
     		<br><br>
 		 &nbsp;&nbsp;&nbsp; 密码:<input type="password" name="userpassword" id="userpassword"><br><br>
        	<input type="radio" name="userrole" id="userrole1"  value="管理员"/>管理员&nbsp;
   			<input type="radio" name="userrole" id="userrole2"  value="普通用户"/>普通用户&nbsp;
   			<input type="radio" name="userrole" id="userrole3"  value="中介"/>中介<br><br>
            <input id="submit" type="submit" value="登录" onclick="return logincheck();"><br>
       		<a href="${pageContext.request.contextPath}/origin/showforgetpwd">忘记密码</a>
  </form>
</body>
</html>