<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css" type="text/css">
</head>
<body>
	<jsp:include page="./userhead.jsp"  flush="true"></jsp:include>
	<div class="user_body">
		<c:forEach var="house"   items="${requestScope.sellinfo}">
		<div class="showhouse">
			<font class="font_house">编号${house.houseid}的房子信息<br></font>
			<div class="houseimg">
			<img alt="图片加载失败" src="/img/${house.houseimage}" height="150px" width="150px"/>
			</div>
			<div class="houseinfo">
				房子面积:${house.space}<br>
				房屋状态:${house.housestatus}<br>
				上传时间:${house.createtime}<br>
			</div>	
		</div>
		</c:forEach>
	</div>
</body>
</html>