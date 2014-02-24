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
			%> 
			<h2> Admin Homepage</h2>
			<h3> Welcome <%=session.getAttribute("username") %></h3> <br>
			<a href="Faults">View Faults</a> <br>
			<a href="logFault.jsp">Log a Fault</a> <br>
			<a href="viewUsers">View Users</a> <br>
			More links coming soon <br>
			<br>
			<a href= "logout.jsp">Log Out</a> <%
		}
		else if(session.getAttribute("permissions").equals("dev")) {
			%> 
			<h2> Developer Homepage</h2>
			<h3> Welcome <%=session.getAttribute("username") %></h3> <br>
			<a href= "logFault.jsp">Log a Fault</a> <br>
			<a href= "viewAuthor?id=<%=session.getAttribute("id") %>">View Your Faults</a>
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