<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易记录上传</title>
</head>

<body >
	<jsp:include page="./userhead.jsp"  flush="true"></jsp:include>
	<div class="adduptrans">
		<font class="font_adduptrans">上传交易信息</font>    <br>
		<form name="transinfo" action="${pageContext.request.contextPath}/user/transaction2"  method="post">
		顾客编号：<input type="text" name="customid"><br><br>
		房主编号：<input type="text" name="ownerid" value="${requestScope.trans.ownerid }"><br><br>
		中介编号：<input type="text" name="mediaid" value="${requestScope.trans.mediaid }"><br><br>
		房源编号：<input type="text" name="houseid" value="${requestScope.trans.houseid }"><br><br>
		交易状态：<select name="transtatus">
					<option value="">请选择交易状态</option>
					<option value="已完成">已完成</option>
					<option value="未完成">未完成</option>
				</select><br><br>
		<input type="submit" value="保存">
	</form>
	</div>
</body>
</html>