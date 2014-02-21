<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Please Login</title>
</head>
<body>
<% 
try{
	if(session.getAttribute("userCreated").equals("true")){
		%> <p>Success! User Created. Please login below.<p> 
		<%
		session.removeAttribute("userCreated");
	}
} catch (Exception e){
}


try{
	if(session.getAttribute("loggedIn").equals("true")) {
		response.sendRedirect("home.jsp");
	}
	
	
} catch (Exception e){
	%>


	<form action="loginServlet" method="get">
	<p>Enter Username:</p>
	<input type="text" name="username" align="top">
	<br>
	<p>Enter Password:</p>
	<input type="password" name="password" align="top">
	<br><br>
	<input type="submit" name="login" value="Login">
	</form>
	<br>
	<a href="register.jsp">Register as Developer</a>
	
	<%
	}
	%>
	
</body>
</html>