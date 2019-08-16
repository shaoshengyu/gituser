<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int pageCount = 1;
		int sessionCount = 1;
		int applicationCount = 1;
		
		//页面域计数
		if (pageContext.getAttribute("pageCount") != null) {
			pageCount = Integer.parseInt(pageContext.getAttribute("pageCount").toString());
			pageCount++;
		}
		pageContext.setAttribute("pageCount", pageCount);
		
		//会话域计数(一个浏览器打开到关闭)
		if (session.getAttribute("sessionCount") != null) {
			sessionCount = Integer.parseInt(session.getAttribute("sessionCount").toString());
			sessionCount++;
		}
		session.setAttribute("sessionCount", sessionCount);
		
		//应用域计数(Web项目服务运行全程)
		if (application.getAttribute("applicationCount") != null) {
			applicationCount = Integer.parseInt(application.getAttribute("applicationCount").toString());
			applicationCount++;
		}
		application.setAttribute("applicationCount", applicationCount);
	%>
	
	<p>
		页面域计数：<%=pageCount%></p>
	<p>
		会话域计数：<%=sessionCount%></p>
	<p>
		应用域计数：<%=applicationCount%></p>
</body>
</html>