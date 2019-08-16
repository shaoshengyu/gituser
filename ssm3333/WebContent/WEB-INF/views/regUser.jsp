<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	//表单提交请求验证
	function validate() {
		if (document.getElementById("userName").value == "") {
			alert("用户名不能为空！");
			document.getElementById("userName").focus();
			return false;
		}
		if (document.getElementById("userPassword").value == "") {
			alert("登录密码不能为空！");
			document.getElementById("userPassword").focus();
			return false;
		}
		if (document.getElementById("userEmail").value == "") {
			alert("邮箱不能为空！");
			document.getElementById("userEmail").focus();
			return false;
		}
		if (document.getElementById("userPicture").value == "") {
			alert("请上传照片！");
			document.getElementById("userPicture").focus();
			return false;
		}
		return true;
	}
	
	function ajaxOne(obj){
		//获取 请求数据
		var userName = obj.value;
		
		$.getJSON("${pageContext.request.contextPath}/user/ajaxOne",{"userName":userName},function(json){
			//将响应数据更新到页面空间中显示
			if(json.userPassword!=null){
				$("#userName").val("");
				alert("该用户名已存在！");
				return false;
			}
		});
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/regUser" method="post" enctype="multipart/form-data" onsubmit="return validate();" >
  <table>
           <tr>
               <td><label>登录名：</label></td>
               <td><input type="text" name="userName" id="userName" onblur="ajaxOne(this)"></td>
           </tr>
           <tr>
               <td><label>密码：</label></td>
               <td><input type="password" name="userPassword" id="userPassword"></td>
           </tr>
           <tr>
               <td><label>邮箱:</label></td>
               <td><input type="text" name="userEmail" id="userEmail"></td>
           </tr>
           <tr>
               <td><label>照片:</label></td>
               <td><input type="file" name="myfile" id="userPicture"></td>
           </tr>
           <tr>
               <td><input type="submit" value="注册"></td>
           </tr>
       </table>
</form>
<tbody id="viewData"></tbody>
</body>
</html>