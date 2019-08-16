<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理举报页面</title>
</head>

<%
String tranmsg=(String)request.getSession().getAttribute("repmsg");	
%>
<body >
	<jsp:include page="./adminhead.jsp"  flush="true"></jsp:include>
	<div class="admin_search">
		<font class="message_liuyanmsg">查看评价</font><br><br>
		<form method="post" action="${pageContext.request.contextPath}/admin/selrep">
		顾客账号：<input type="text" name="customid">&nbsp;
		被评价人账号：<input type="text" name="ownerid">&nbsp;
		中介号：<input type="text" name="mediaid">&nbsp;
		<input type="submit" value="查询">&nbsp;
	</form>
	</div>
	<c:forEach var="rep"   items="${requestScope.repList}">
		<div class="admin_body"> 
			<div class="message_info">
			<font class="message_id">交易信息编号：${rep.reportid}</font><br><br>
			顾客账号:${rep.customid}&nbsp;&nbsp;
			房主账号:${rep.ownerid}&nbsp;&nbsp;
			中介号:${rep.mediaid}&nbsp;&nbsp;<br><br>		
			评价信息:${rep.description}&nbsp;<br><br>
			</div>
		</div>
		</c:forEach>
	
</body>
</html>