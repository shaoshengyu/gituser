<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cha5.pojo.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>

<script type="text/javascript">

/*
//定义一个全局的XMLHttpRequest对象
var xhr=false;
//创建XMLHttpRequest对象
function createXHR(){
	try{
		//适用于IE7+,Firefox,Chrome,Opera,Safar1
		xhr=new XMLHttpRequest();
	}catch(e){
		try{
			//适用于IE6,IE5
			xhr=new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e1){
			xhr=false;
		}
	}
	if(!xhr)
		alert("初始化XMLHttpRequest对象失败!");
}
//进行Ajax请求和响应结果处理
function ajaxProcess(obj) {
	//创建XMLHttpRequest对象
	createXHR();
	//获取请求数据
	var zhanghao=obj.value;
	//设定请求地址
	//var url="AjaxServlet?zhanghao="+zhanghao;
	var url="AjaxJSONServlet?zhanghao="+zhanghao;
	//建立对服务器的调用
	xhr.open("GET",url,true);
	//制定响应事件处理函数
	xhr.onreadystatechange=function(){
		//当readyState等于4且状态为200时，表示响应已就绪
		if(xhr.readyState==4&&xhr.status==200){
			//对相应结果进行处理
			//var responseData=xhr.responseText.split(",");
			//将响应的JSON格式数据转为JavaScript对象
			var responseObj = eval("("+xhr.responseText+")");
			//将响应数据更新到页面空间中显示
			//document.getElementById("system").value=responseData[0];
			//document.getElementById("qvfu").value=responseData[1];
			//document.getElementById("job").value=responseData[2];*
			document.getElementById("system").value=responseObj.system;
			document.getElementById("qvfu").value=responseObj.qvfu;
			document.getElementById("job").value=responseObj.job;
		}
	};
	//向服务器发出请求
	xhr.send(null);
}*/

function ajaxProcess(obj){
	//获取 请求数据
	var zhanghao = obj.value;
	/*
	$.get("AjaxJSONServlet",{"zhanghao":zhanghao},function(data){
		//将响应的JSON格式数据转为JavaScript对象
		var responseObj = eval("("+data+")");
		//将响应数据更新到页面空间中显示
		document.getElementById("system").value=responseObj.system;
	    document.getElementById("qvfu").value=responseObj.qvfu;
	    document.getElementById("job").value=responseObj.job;
	})
	*/
	
	$.getJSON("AjaxJSONServlet",{"zhanghao":zhanghao},function(json){
		//将响应数据更新到页面空间中显示
		document.getElementById("system").value=json.system;
	    document.getElementById("qvfu").value=json.qvfu;
	    document.getElementById("job").value=json.job;
	})
}
</script>


</head>
<body>

<%session.removeAttribute("xinxi");
User user = new User();
String name = (String) request.getSession().getAttribute("name");
StringBuffer url=request.getRequestURL();
user.setName(name);
user.setUrl(url);
session.setAttribute("xinxi", user);
%>

<h2>已登录区服</h2>

<form action="TestServlet" method="post">
<p>账号:<input name="zhanghao" id="zhanghao" type="text" onblur="ajaxProcess(this)"></p>
<p>系统:<input name="system" id="system" type="text"></p>
<p>区服:<input name="qvfu" id="qvfu" type="text"></p>
<p>职业:<input name="job" id="job" type="text"></p>

兴趣:<input name="xq" type="text">
<input type="submit" value="提交"/>
</form>
</body>
</html>