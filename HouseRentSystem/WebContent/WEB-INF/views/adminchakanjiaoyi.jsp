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
String tranmsg=(String)request.getSession().getAttribute("tranmsg");	
%>
<body >
	<jsp:include page="./adminhead.jsp"  flush="true"></jsp:include>
	<div class="admin_search">
		<font class="message_liuyanmsg">查看交易信息</font><br><br>
		<form method="post" action="${pageContext.request.contextPath}/admin/seltrans">
		中介号：<input type="text" name="mediaid">&nbsp;
		顾客账号：<input type="text" name="customid">&nbsp;
		房主账号：<input type="text" name="ownerid">&nbsp;
		<input type="submit" value="查询">&nbsp;
	</form>
	</div>
	<c:forEach var="trans"   items="${requestScope.transList}">
		<div class="admin_body"> 
			<div class="message_info">
			<font class="message_id">交易信息编号：${trans.transid}</font><br><br>
			中介号:${trans.mediaid}&nbsp;&nbsp;
			顾客账号:${trans.customid}<br><br>
			房主账号:${trans.ownerid}&nbsp;&nbsp;
			交易状态：${trans.transtatus}&nbsp;&nbsp;
			交易时间:${trans.createtime}<br><br>
			</div>
		</div>
		</c:forEach>
	
</body>
</html>