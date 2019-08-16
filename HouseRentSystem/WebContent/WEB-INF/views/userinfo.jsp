<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表 here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/clickinfo.css" type="text/css">
</head>
<style>
.img{
	margin-left:120px ;
	}
</style>
<body>
<div class="context">
	<div class="img">
		<img alt="图片加载失败" src="/img/${requestScope.us.userimage}" height="150px" width="150px"/>
	</div>
	<div class="word">
		姓名:${requestScope.us.username}<br><br>
 		&nbsp;&nbsp;&nbsp;身份:${requestScope.us.userrole}<br><br>
		电话:${requestScope.us.userphone}<br><br>
		邮箱:${requestScope.us.useremail}<br><br>
 		<input type="button" value="关闭" onclick="window.close();">
	</div>
</div>


</body>
</html>