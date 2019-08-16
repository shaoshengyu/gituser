<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已上传房源信息</title>
</head>
<%
String ownhousemsg=(String)request.getSession().getAttribute("ownhousemsg");	
%>
<body >
	<jsp:include page="./mediahead.jsp"  flush="true"></jsp:include>
	<div class="housesearch">
		<font class="font_search">${ownhousemsg}</font><br>
    	<form action="${pageContext.request.contextPath}/media/ownhouse" name="theform" method="post">
                <select name = "housestatus">
                    <option value = "">请选择房屋状态</option>
                    <option value = "已出租">已出租</option>
                    <option value = "出租中">出租中</option>
                </select>
                <input type="submit" value="查找">
    	</form>
	</div>
	<c:forEach var="house" items="${requestScope.ownhouse}">
	<div class="housesearch_showhouse">
		<font class="font_house3">编号${house.houseid}的房子信息<br></font>
		<div class="housesearch_houseimg">
		<img alt="图片加载失败" src="/img/${house.houseimage}" height="150px" width="150px"/>
		</div>
		<div class="housesearch_houseinfo">
			房源编号:${house.houseid}<br>
			房源状态:${house.housestatus}<br>
			上传日期:${house.createtime}<br>
			<a class="uptran"  href="${pageContext.request.contextPath}/media/transaction?houseid=${house.houseid}">上传交易信息</a>
		</div>	
	</div>
	</c:forEach>
</body>
</html>