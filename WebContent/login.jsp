<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Please Login</title>
</head>
<body>
	<form action="loginServlet" method="get">
	<p>Enter Username:</p>
	<input type="text" name="username" align="top">
	<br>
	<p>Enter Password:</p>
	<input type="password" name="password" align="top">
	<input type="submit" name="login" value="Login">
	</form>
	
</body>
</html>