<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register as Developer</title>
</head>
<body>
<h2>Register as Developer</h2>
<h3>To register, please fill in the following details:</h3>

	<form action="registerServlet" method="get">
	<p>First Name:</p>
	<input type="text" name="firstName" align="top">
	<br>
	<p>Last Name:</p>
	<input type="text" name="lastName" align="top">
	<p>Username:</p>
	<input type="text" name="uname" align="top">
	<p>Password:</p>
	<input type="password" name="pass" align="top">
	<br><br>
	<input type="submit" name="register" value="Register">
	</form>

</body>
</html>