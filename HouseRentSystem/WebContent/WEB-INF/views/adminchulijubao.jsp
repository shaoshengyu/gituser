<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理举报信息</title>
</head>
<%
String chulijuBaomsg=(String)request.getSession().getAttribute("chulijuBaomsg");	
%>

<body>
<jsp:include page="./adminhead.jsp"  flush="true"></jsp:include>
<div class="admin_body2">
 <font size="3" color="red">${chulijuBaomsg}</font>
		<table width="100%" border="1px"  cellpadding="1"cellspacing="1">
			<tr bgcolor="red">
   				 <td width="20%">黑名单用户账号：</td>
   				 <td width="10%">用户账号：</td>
   				 <td width="20%">创建时间：</td>
   				 <td width="20%">举报原因：</td>
   				 <td width="30%">操作</td>
			</tr>
			<c:forEach var="jb" items="${requestScope.jubaoList}">
			<tr>			    
				<td align="center">${jb.blackid}</td>		    
				<td align="center">${jb.userid}</td>		    
				<td align="center">${jb.createtime}</td>
		   		<td align="center">${jb.description}</td>
		   		<td align="center"><a href="${pageContext.request.contextPath}/admin/chulijubaoa?blackid=${jb.blackid}&userid=${jb.userid}">正确举报</a>
                <a href="${pageContext.request.contextPath}/admin/chulijubaob?blackid=${jb.blackid}">错误举报</a></td> 
		    </tr>		
			</c:forEach>    
	</table>
</div>
</body>
</html>