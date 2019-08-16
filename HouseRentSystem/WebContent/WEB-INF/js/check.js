
	function checkaddhouse(){
		var mediaid=document.getElementById("mediaid").value;
		if(mediaid.length==0){
			alert("中介号为空");
			return false;
		}
		else{
			return true;
		}
	}
	
	function registcheck(){
		var userpassword=document.getElementById("userpassword1").value;
		var repassword=document.getElementById("repassword1").value;
		var username=document.getElementById("username1").value;
		var userphone=document.getElementById("userphone1").value;
		var useremail=document.getElementById("useremail1").value;
		var useridentity=document.getElementById("useridentity1").value;
		if(userpassword==repassword){
		}else {
			alert("密码不一致");
		}
			
		if(userpassword.length==0 || repassword.length==0){
			alert("密码为空");
			return false;
		}else if(username.length==0){
			alert("用户名为空");
			return false;
		}else if(userphone.length==0){
			alert("电话号码为空");
			return false;
		}else if(useremail.length==0){
			alert("邮箱为空");
			return false;
		}else if(useridentity.length==0){
			alert("身份证号为空");
			return false;
		}else if(!document.getElementById("userrole11").checked&&!document.getElementById("userrole21").checked){
			alert("用户角色为空");
			return false;
		}
		else{
			return true;
		}
	}
	
	function logincheck(){
		var username=document.getElementById("username").value;
		var userpassword=document.getElementById("userpassword").value;
		if(username.length==0){
			alert("用户名为空");
			return false;
		}else if(userpassword.length==0){
			alert("密码为空");
			return false;
		}else if(!document.getElementById("userrole1").checked&&!document.getElementById("userrole2").checked&&
				!document.getElementById("userrole3").checked)
		{
			alert("请确认用户身份");
			return false;
		}
		else{
			return true;
		}
		}
	
	function forgetpasswordcheck(){
		var userpassword=document.getElementById("userpassword").value;
		var newpassword=document.getElementById("newpassword").value;
		var username=document.getElementById("username").value;
		var useremail=document.getElementById("useremail").value;
		if(username.length==0){
			alert("用户名不能为空!");
			return false;
		}else if(useremail.length==0){
			alert("邮箱不能为空!");
			return false;
		}
		else if(userpassword!=newpassword){
			alert("密码不一致!");
			return false;
		}else if(userpassword.length==0 || newpassword.length==0){
			alert("密码不能为空!");
			return false;
		}
		else{
			return true;
		}
	}