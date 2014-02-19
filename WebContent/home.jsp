<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<%
try{
		if(session.getAttribute("permissions").equals("admin")) {
			%> <h1> Admin Homepage</h1> <br>
			<a href="Faults">View Faults</a> <br>
			More links coming soon <br>
			<br>
			<a href= "logout.jsp">Log Out</a> <%
		}
		else if(session.getAttribute("permissions").equals("dev")) {
			%> <h1> Developer Homepage</h1> <br>
			<a href= "logFault.jsp">Log Fault</a> <br>
			<br>
			<a href="logout.jsp">Log Out</a>
			<%
		}
			
	} catch (Exception e){
		response.sendRedirect("login.jsp");
		
	}

	
	
%>
</body>

</html>