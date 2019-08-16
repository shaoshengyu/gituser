<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<td>部门</td>
			<td>部门权限</td>
			<td>部门员工</td>
			<td>员工状态</td>
		</tr>

		<c:forEach items="${requestScope.department}" var="department">
			<tr>
				<td>${department.departmentName}</td>
				<td>${department.departmentQx}</td>
				<c:forEach items="${department.userList}" var="user" >
					<td>${user.userName}</td>
					<td>${user.userState}</td>
				</c:forEach>				
			</tr>
		</c:forEach>

	</table>
<a href="${pageContext.request.contextPath}/user/todepartment">返回</a><br/>
<a href="${pageContext.request.contextPath}/user/tologin">退出登录</a><br/>
<a href="${pageContext.request.contextPath}/user/tomain">返回主页</a>
</body>
</html>