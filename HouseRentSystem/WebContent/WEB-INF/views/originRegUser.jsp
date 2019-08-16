<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<%
String addusermsg=(String)request.getSession().getAttribute("addusermsg");	
%>
<script src="${pageContext.request.contextPath}/js/check.js"></script>

<body>
	<h3>用户注册</h3>    <br>
    <form method="post" action="${pageContext.request.contextPath}/origin/addUser" enctype="multipart/form-data">
    <font size="3" color="red">${addusermsg}</font><br>
    	&nbsp;&nbsp;&nbsp;用户名:<input type="text" name="username" id="username1"><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 密码:<input type="password" name="userpassword" id="userpassword1"><br>
                     确认密码:<input type="password" name="repassword" id="repassword1"><br>
                     电话号码:<input type="text" name="userphone" id="userphone1"><br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱:<input type="text" name="useremail" id="useremail1"><br>
                     身份证号:<input type="text" name="useridentity" id="useridentity1"><br><br>
                     用户身份:<input type="radio" name="userrole" id="userrole11" value="普通用户">普通用户&nbsp;
             <input type="radio" name="userrole" id="userrole21" value="中介">中介<br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上传照片:<input type="file" name="myfile" ><br><br>
      <input type="reset" value="重置">
      <input type="submit" value="提交"  onclick="return registcheck(); ">
    </form>
</body>
</html>