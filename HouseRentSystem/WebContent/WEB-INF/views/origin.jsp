<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>初始页面头部</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/origin.css" type="text/css">
</head>
<%
String housemsg=(String)request.getSession().getAttribute("housemsg");	
String interMsg=(String)request.getSession().getAttribute("interMsg");
%>
<script type="text/javascript">
function message()
{
<%if(interMsg==""){%>
<% }else{%>
	alert("${interMsg}");
	<%}%>
}
</script>
<body  >
	<div class="origin_head_content">
		<div class="head_left">
			<img alt="图片加载失败" src="${pageContext.request.contextPath}/picture/anxinju.png" height="280px" width="600px"/>
		</div>
		<div class="head_right">
			<label>欢迎使用安心居</label>
		</div>
	</div>
	<div class="origin_body">
		<div class="origin_bodyleft">
			<div class="origin_bodyleft_top">
				<jsp:include page="./originUserLogin.jsp"  flush="true"></jsp:include><br>
			</div>
			<div class="origin_bodyleft_bottom">
				<jsp:include page="./originRegUser.jsp"  flush="true"></jsp:include>
			</div>
		</div>
		
		<div class="origin_bodyright">
		<c:forEach var="house"   items="${requestScope.sellinfo}">
		<div class="showhouse">
			
			<font class="font_house">编号${house.houseid}的房子信息<br></font>
			<div class="houseimg">
			<img alt="图片加载失败" src="/img/${house.houseimage}" height="150px" width="150px"/>
			</div>
			<div class="houseinfo">
				<a href="${pageContext.request.contextPath}/test/mediaaddhouse" onclick="message()">
				房子面积:${house.space}<br>
				房屋状态:${house.housestatus}<br>
				上传时间:${house.createtime}
				</a>
			</div>	
		</div>
		</c:forEach>
		</div>
	</div>
	
</body>
</html>