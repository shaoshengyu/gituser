<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cha4.Book"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="hello" value="Hello JSTL!<br/>" scope="session"/>
<c:out value="${hello }" escapeXml="false" default="Goodby!<br/>"></c:out>
<c:out value="${hello }" escapeXml="true"></c:out>
<c:out value="${hello2 }" escapeXml="false" default="Goodby!<br/>"></c:out>
${fn:substring(hello,0,5)}<br>

<c:if test="${not empty sessionScope.hello}">
     欢迎您：${sessionScope.hello}
</c:if>

<c:set var="score" value="85"></c:set>
<c:choose>
<c:when test="${score>=90}">
优秀<br/>
</c:when>
<c:when test="${score<90&&score>=60}">
良好<br/>
</c:when>
<c:otherwise>
不及格<br/>
</c:otherwise>
</c:choose>

<%
ArrayList list=new ArrayList();
list.add("一");
list.add(2);
list.add(3.6);
list.add("si");
session.setAttribute("list", list);
%>
<c:forEach items="${sessionScope.list}" var="item" varStatus="vst">
序号${vst.index+1}:${item}<br>
<%//判断一个数是否在集合内 %>
<c:if test="${item eq '2'}">
存在<br/>
</c:if>
</c:forEach>
<%=list.get(2)%><br>

<c:forEach begin="3" end="10" step="2" var="num">
${num}<br>
</c:forEach>


<%
//无序
Map<String,Book> map=new HashMap<String,Book>();
map.put("Java基础",new Book("Java基础开发",50));
map.put("Java高级",new Book("Java高级开发",60));
map.put("JavaWeb",new Book("JavaWeb开发",70));
map.put("Java框架",new Book("Java框架开发",80));
request.setAttribute("bookMap",map);
%>
<c:forEach items="${requestScope.bookMap}" var="book">
${book.key}:${book.value.name}--${book.value}<br><br>
</c:forEach>
<%=map.get("Java基础").getName() %>


<c:set var="number" value="a,b,c,d,e"></c:set>
<c:forTokens items="${number}" var="num" delims="," varStatus="no">
<c:out value="${no.count}"/>.<c:out value="${num}"/>
</c:forTokens>
<br>

<c:catch var="myException">
<%=5/0 %>
</c:catch>
<c:out value="${myException}<br/>" escapeXml="false"></c:out>
<c:out value="${myException.message}<br/>"></c:out>
</body>
</html>