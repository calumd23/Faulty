<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Failed Login</title>
</head>
<body>
<%
try{
	if(session.getAttribute("loggedIn").equals("true")) {
		response.sendRedirect("home.jsp");
	}
	
	
} catch (Exception e){
%>
	Login Details Not Recognised. Click
	<a href= "login.jsp"> Here</a>
	to try again.
	
<%

}

%>
</body>
</html>