<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>举报用户</title>
</head>

<body >
	<jsp:include page="./userhead.jsp"  flush="true"></jsp:include>
	<div class="jubao_body">
		<form method="post" action="${pageContext.request.contextPath}/user/jubao" >
			<font class="jubao_font">请正确填写举报信息</font><br>
   			举报账号：<input type="text" name="userid" value="${requestScope.userid}"><br><br>
         	举报信息：<input type="text" name="description"  id="description" style="height:60px;width:200px"><br><br>
         	<input type="reset" value="重置">
		    <input type="submit" value="提交">
   </form>
	</div>
	
</body>
</html>