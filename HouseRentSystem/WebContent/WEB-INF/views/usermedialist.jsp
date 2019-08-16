<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有中介</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css" type="text/css">
</head>
<body>
	<jsp:include page="./userhead.jsp"  flush="true"></jsp:include>
	<div class="user_media_body">
		<c:forEach var="media"   items="${requestScope.userinf}">
		<div class="showmedia">
			<font class="font_media">中介编号${media.userid}<br></font>
			<div class="mediaimg">
			<img alt="图片加载失败" src="/img/${media.userimage}" height="150px" width="150px"/>
			</div>
			<div class="mediainfo">
				五星评价次数:&nbsp;&nbsp;${media.usercredit}<br>
				手&nbsp;机&nbsp;号&nbsp;:&nbsp;&nbsp;${media.userphone}<br>
				邮&nbsp;&nbsp;&nbsp;箱&nbsp;:&nbsp;&nbsp;${media.useremail}<br>
				<a class="message" href="${pageContext.request.contextPath}/user/getmessageinfo?mediaid=${media.userid}">私信他</a>
			</div>	
		</div>
		</c:forEach>
	</div>
</body>
</html>