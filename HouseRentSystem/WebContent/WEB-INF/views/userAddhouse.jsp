<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传房源信息</title>
</head>
<%
String addhousemsg=(String)request.getSession().getAttribute("addhousemsg");
%>

<script src="${pageContext.request.contextPath}/js/check.js"></script>
<body>
	<jsp:include page="./userhead.jsp"  flush="true"></jsp:include>
	<div class="addhouse">
		<h3>上传房源信息</h3>    <br>
		<form  name="theform" method="post" action="${pageContext.request.contextPath}/user/addHouse" enctype="multipart/form-data">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中介号:<input type="text" name="mediaid" id="mediaid"><br><br>
			房屋面积:<select id="space" name="space" id="space">
              		<option value="">--请选择--</option>
              		<option value="50">50平米的屋子</option>
              		<option value="100">100平米的屋子</option> 
              		<option value="150">150平米的屋子</option> 
              		<option value="200">200平米的屋子</option>
              	   </select><br><br>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上传房屋图片:<input type="file" name="myfile"><br><br>
              &nbsp;&nbsp;&nbsp;所在省份:<select name="locationprovince" onchange="getCity()">
                    	<option value = "0">请选择所在的省份</option>
                   		<option value="1">浙江省</option>
                    	<option value="2">山东省</option>
                    	<option value="3">广东省</option> 
                    	<option value="4">甘肃省</option> 
                	</select><br><br>   
           &nbsp;&nbsp;&nbsp;所在城市:<select id="locationcity" name="locationcity" onchange="getQu()">
                    	<option value = "0">请选择所在的城市</option>
                	</select><br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所在区:<select name = "locationqu">
                    	<option value = "0">请选择所在的县区</option>
                	</select><br><br> 
              <input type="reset" value="重置">
              <input type="submit" value="提交" onclick="return checkaddhouse();">     
              <script src="${pageContext.request.contextPath}/js/sanjiliandong.js"></script>          
		</form>
	</div>
</body>
</html>