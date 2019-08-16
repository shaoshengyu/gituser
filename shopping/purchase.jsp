<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="PurchaseServlet" method="Get">
<p>商品:</p>
<input name="equipment" type="checkbox" value="空调">空调</p>
<p><input name="equipment" type="checkbox" value="冰箱">冰箱</p>
<p><input name="equipment" type="checkbox" value="洗衣机">洗衣机</p>
<p><input type="submit" value="提交"/><input type="reset" value="重置"/></p>
</form>
</body>
</html>