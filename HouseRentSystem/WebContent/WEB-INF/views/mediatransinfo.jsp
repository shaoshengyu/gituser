<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询交易信息</title>
</head>
<%
String mediatranmsg=(String)request.getSession().getAttribute("mediatranmsg");	
%>
<script>
var num=0;
function countNum(){
	if(num==0){
		alert("点赞成功");
		
	}else{
		num++;
		alert("已经点过赞啦！！");
	}
}


</script> 

<body >

	<jsp:include page="./userhead.jsp"  flush="true"></jsp:include>
	<div class="transearch">
		<font class="font_search">${mediatranmsg}</font><br>
    	<form method="post" action="${pageContext.request.contextPath}/user/usertransaction2" enctype="multipart/form-data">
              	<select id="transtatus" name="transtatus">
              		<option value = "">请选择房屋状态</option>
              		<option value="已完成">已完成</option> 
              		<option value="交易中">交易中</option>
              	</select>
                <input type="submit" value="查询">
		</form>
	</div>
	 <c:forEach var="trans"   items="${requestScope.transList}">
	 <div class="transearch_showtran">
		<font class="font_house3">房屋交易编号:${trans.transid}</font><br><br>
		<div class="transearch_houseinfo">
			<a  href="#" onclick="javascript:openDialog(customid=${trans.customid});">用户编号:${trans.customid}<a><br>
			<a  href="#" onclick="javascript:openDialog2(customid=${trans.mediaid});">中介编号:${trans.mediaid}<a></a>&nbsp;(<a href="${pageContext.request.contextPath}/user/usercredit?userid=${trans.mediaid}" onclick="countNum();">为他点赞</a>)(<a  href="${pageContext.request.contextPath}/user/juBaovalue?userid=${trans.mediaid}">举报</a>)<br>
			屋主编号:${trans.ownerid}(<a  href="${pageContext.request.contextPath}/user/juBaovalue?userid=${trans.ownerid}">举报</a>)<br>
			交易状态:${trans.transtatus}<br><br>
			<a class="tran_link"  href="${pageContext.request.contextPath}/user/comment?customid=${trans.customid}&ownerid=${trans.ownerid}&mediaid=${trans.mediaid}">交易评价</a>
		</div>	
	</div>
	</c:forEach>
	<script type="text/javascript">
		function openDialog(customid){
			var iWidth=400; //弹出窗口的宽度;
			var iHeight=400; //弹出窗口的高度;
			var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
			var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		      var winObj = window.open ("${pageContext.request.contextPath}/origin/showuserinfo?userid="+customid, "newwindow", "height="+iHeight+",width="+iWidth+", top="+iTop+", left="+iLeft);  
		}
		function openDialog2(mediaid){
			var iWidth=400; //弹出窗口的宽度;
			var iHeight=400; //弹出窗口的高度;
			var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
			var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		      var winObj = window.open ("${pageContext.request.contextPath}/origin/mediainfo?userid="+mediaid, "newwindow", "height="+iHeight+",width="+iWidth+", top="+iTop+", left="+iLeft);  
		}
	</script>
	
</body>
</html>