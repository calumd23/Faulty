<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log Fault</title>
</head>
<body>
<%
try{
	System.out.println(session.getAttribute("permissions"));	
	if(session.getAttribute("loggedIn").equals("true")) 
		{
			%>
			<form action="logFault" method="get" id="faultForm">
			
			<p>Enter Fault Section:</p>
			<select name="section" form="faultForm">
			<option value="1">Cassandra</option>
			<option value="2">Hadoop</option>
			<option value="3">Debian</option>
			</select>
			<br>
			<p>Enter Fault Summary:</p>
			<input type="text" name="summary" align="top">
			<br>
			<p>Enter Fault Details:</p>
			<textarea name="details" form="faultForm">Enter the fault details here...</textarea>
			<br>
			<input type="submit" name="logFault" value="Log Fault">
			</form>
			<br>
			<br>
			<a href="home.jsp">Home</a>
			<a href="logout.jsp">Log Out</a>
			
			
			
			<%
		} 
		
} catch (Exception e){
			response.sendRedirect("login.jsp");
}
		


			
			
%>
</body>
</html>