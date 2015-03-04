<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
<h1>登陆</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
用户名：<input name="username" type="text"/>
密码：<input name="password" type="password"/>
<input type="submit" value="提交"/>
</form>
</body>
</html>