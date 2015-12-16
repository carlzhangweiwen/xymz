<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Home</title>
</head>
<body>
	<form action="./test.do?method=login" method="post">
		用户名<input type="text" name="name">
		密码<input type="password" name="password">
		<input type="submit" value="提交">
	</form>
</body>
</html>
