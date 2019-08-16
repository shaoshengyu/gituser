<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言信息列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/media.css" type="text/css">
</head>
<%
String liuyanmsg=(String)request.getSession().getAttribute("liuyanmsg");	
%>
<body >	
<jsp:include page="./mediahead.jsp"  flush="true"></jsp:include>
<div class="media_body">
	<font class="message_liuyanmsg">${liuyanmsg}</font>
	<c:forEach var="message" items="${requestScope.messageList}">
	<div class="message_info">
		<font class="message_id">信息编号：${message.messageid}</font><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;留言时间：${message.createtime}<br>
		留言人账号:${message.userid}<br>
		信息内容：${message.description}<br>
		信息状态:${message.status}<br>
		<a class="message" href="${pageContext.request.contextPath}/media/updatemessage?messageid=${message.messageid}">已读</a>
	</div>
	</c:forEach>
</div>
</body>
</html>