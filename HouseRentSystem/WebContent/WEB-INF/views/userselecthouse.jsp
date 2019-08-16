<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找房源</title>
</head>
<%
String housemsg=(String)request.getSession().getAttribute("housemsg");	
%>

<body>
		<jsp:include page="./userhead.jsp"  flush="true"></jsp:include>
		<div class="housesearch">
			<font size="3" color="red">${housemsg}</font>
			<form action="${pageContext.request.contextPath}/user/selhouse" name="theform" method="post">
                <select name="locationprovince" onchange="getCity()">
           6          <option value = "0">请选择所在的省份</option>
                    <option value="1">浙江省</option>
                    <option value="2">山东省</option>
                    <option value="3">广东省</option> 
                    <option value="4">甘肃省</option> 
                </select>
                <select id="locationcity" name="locationcity" onchange="getQu()">
                    <option value = "0">请选择所在的城市</option>
                </select>
        
                <select name = "locationqu">
                    <option value = "0">请选择所在的县区</option>
                </select>
                <select name = "space">
                    <option value = "0">请选择房屋面积</option>
                    <option value = "50">50m²左右</option>
                    <option value = "100">100m²左右</option>
                    <option value = "150">150m²左右</option>
                    <option value="200">200平米的屋子</option>
                </select>
                <input type="submit" value="查找"  >
                <script src="${pageContext.request.contextPath}/js/sanjiliandong.js"></script>
        	</form>
        			
		</div>
		<c:forEach var="house"   items="${requestScope.sellinfo}">
		<div class="housesearch_showhouse">
			<font class="font_house2">编号${house.houseid}的房子信息<br></font>
			<div class="housesearch_houseimg">
			<img alt="图片加载失败" src="/img/${house.houseimage}" height="150px" width="150px"/>
			</div>
			<div class="housesearch_houseinfo">
				房子面积:${house.space}<br>
				出租时长:${house.rentlength}<br>
				房屋状态:${house.housestatus}<br>
				上传时间:${house.createtime}
			</div>	
		</div>
		</c:forEach>
	
</body>
</html>