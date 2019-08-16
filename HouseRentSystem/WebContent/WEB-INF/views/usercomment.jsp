<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评价交易</title>
</head>

<body  >
<jsp:include page="./userhead.jsp"  flush="true"></jsp:include>
	<div class="comment_body">
		 <form action="${pageContext.request.contextPath}/user/savecommentinfo"  method="post">
 		 	<font class="comment_font">请正确填写评价信息</font><br>
   			顾客账号：<input type="text" name="customid" value="${requestScope.trans.customid}"><br><br>
   			房主账号：<input type="text" name="ownerid" value="${requestScope.trans.ownerid}"><br><br>
   			中介账号：<input type="text" name="mediaid" value="${requestScope.trans.mediaid}"><br><br>
  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评价信息：<input type="text" name="description"  style="height:60px;width:200px"><br><br>
    		<input type="submit" value="提交">
  		</form>
	</div>
</body>
</html>