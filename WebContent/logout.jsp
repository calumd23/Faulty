<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logging Out</title>
</head>
<body>
	<%
	session.removeAttribute("username");
	session.removeAttribute("id");
	session.removeAttribute("permissions");
	session.setAttribute("loggedIn","false");
	
	session.invalidate();
	
	%>
	<h1>You are now logged out.</h1>
	<a href = "login.jsp"> Click Here to Log in.</a>
</body>
</html>