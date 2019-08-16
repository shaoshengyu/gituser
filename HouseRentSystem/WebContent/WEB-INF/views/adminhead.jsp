<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中介头</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css" type="text/css">
</head>
<body>
	<div class="admin_head">
		<div class="admin_head_left">
			<img alt="图片加载失败" src="${pageContext.request.contextPath}/picture/anxinju.png" height="280px" width="600px"/>
		</div>
		<div class="admin_head_right">
			<div class="admin_head_right_top">
				<label>欢迎登陆管理员使用中心</label>
			</div>
			<div class="admin_head_right_bottom">
			    <a class="title01" href="${pageContext.request.contextPath}/admin/selrep">
				<span>查看评价&nbsp;&nbsp;&nbsp;</span>
				</a>
				<a class="title01" href="${pageContext.request.contextPath}/admin/seltrans">
				<span>查看交易信息&nbsp;&nbsp;&nbsp;</span>
				</a>
				<a class="title01" href="${pageContext.request.contextPath}/admin/chulijuBao">
				<span>处理举报信息&nbsp;&nbsp;&nbsp;</span>
				</a>
			</div>
		</div>
	</div>	
</body>
</html>