<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login JSP</title>
</head>
<body>
<form action="AuthController" method="post">
	<input type="text" name="username" placeholder="User name">
	<input type="password" name="password" placeholder="Password">
 	<input type="checkbox" name="setup" value="true">
 	<input type="submit" value="Sign In">
</form>
</body>
</html>