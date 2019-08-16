<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
	//表单提交请求验证
	function validate() {
		if (document.getElementById("userName").value == "") {
			alert("用户登录名不能为空！");
			return false;
		}
		if (document.getElementById("userPassword").value == "") {
			alert("登录密码不能为空！");
			return false;
		}
		if (document.getElementById("validateCode").value == "") {
			alert("验证码不能为空！");
			return false;
		}
		var userName = document.getElementById("userName").value;
		var userPassword = document.getElementById("userPassword").value;
		var validateCode = document.getElementById("validateCode").value;	
	
		$.getJSON("${pageContext.request.contextPath}/user/login",{"userName":userName,"userPassword":userPassword,"validateCode":validateCode},function(json){
			if(json.r==1){
				alert("用户名不存在！");
				return false ;
			}else if(json.re==1){
				alert("密码错误！");
				return false ;
			}else if(json.res==1){
				alert("验证码错误！");
				return false ;		
			}else{
				$.getJSON("${pageContext.request.contextPath}/user/us",{"userN":json.userN},function(json){})
				window.location.href = "${pageContext.request.contextPath}/user/tofunction";
			}
		});
			
}
	
	//验证码的更换
	function changeValidateCode() {
		document.getElementById("validateCodeImg").src = "${pageContext.request.contextPath}/user/validateCode?j="+Math.random();
	}

    
</script>
</head>
<body>
<p><font color='red'>${requestScope.error}</font></p>
	<h3>用户登录</h3>
	<br>
	<div class="rightinfo">
			<div>
				<td><label>用户名：</label></td>
				<td><input type="text" name="userName" id="userName"></td>
		    </div>
			<br>
			<div>
				<td><label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label></td>
				<td><input type="password" name="userPassword" id="userPassword"></td>
			</div>
			<br>
				<div>
					验证码：<input name="validateCode" id="validateCode" type="text"class="yzm_input" /> 
					<img src="${pageContext.request.contextPath}/user/validateCode" id="validateCodeImg" title="点击换一换" onclick="changeValidateCode()" />
					<a href="javascript:changeValidateCode();" style="color: blue;">看不清？</a>
				</div>
				<br> 
			<div align="center">
				<td><input id="submit" type="submit" value="登录" onclick="validate()"></td>
				<td><a href="${pageContext.request.contextPath}">退出</a></td>
			</div>
	</div>
</body>
</html>