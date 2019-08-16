<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中介头</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/media.css" type="text/css">
</head>
<body>
	<div class="media_head">
		<div class="media_head_left">
			<img alt="图片加载失败" src="${pageContext.request.contextPath}/picture/anxinju.png" height="280px" width="600px"/>
		</div>
		<div class="media_head_right">
			<div class="media_head_right_top">
				<label>欢迎登陆中介使用中心</label>
			</div>
			<div class="media_head_right_bottom">
				<a class="title01" href="${pageContext.request.contextPath}/media/seemessage">
				<span>查看留言信息&nbsp;&nbsp;&nbsp;</span>
				</a>
				<a class="title01" href="${pageContext.request.contextPath}/media/mediaaddhouse">
				<span>添加已有房源&nbsp;&nbsp;&nbsp;</span>
				</a>
				<a class="title01" href="${pageContext.request.contextPath}/media/ownhouse">
				<span>已上传房源信息&nbsp;&nbsp;&nbsp;</span>
				</a>
			</div>
		</div>
	</div>	
</body>
</html>