<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.abc.calum.stores.*" %>
<%@ page import="java.util.*" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Faults List</title>
</head>
<body>
<%
try{
	if (session.getAttribute("permissions").equals("admin"))
	{
		
		%>
		<h1>Faults</h1>
		<%
		System.out.println("Faults in render");
		List<FaultsStore> lFaults = (List<FaultsStore>)request.getAttribute("Faults");
		
		if (lFaults==null){
		 %>
			<p>No faults found</p>
		<%
		} 
		else {
			%>
			<a href="viewSection?id=1">All Cassandra Faults</a>
			<br>
			<a href="viewSection?id=2">All Hadoop Faults</a>
			<br>
			<a href="viewSection?id=3">All Debian Faults</a>
			<br>
			<br>
			<%
		
		Iterator<FaultsStore> iterator;
		
		
		iterator = lFaults.iterator();     
		while (iterator.hasNext()){
			FaultsStore md = (FaultsStore)iterator.next();
		
			%>
			<a href="viewFault?id=<%=md.getFaultid() %>" ><%=md.getFaultSummary() %></a><br><%
		
		}
		}
		%>
		<br>
		<br>
		<a href="home.jsp">Home</a>
		<a href="logout.jsp">Log Out</a>
		
		<%
	} else {
		response.sendRedirect("home.jsp");
	}
} catch (Exception e) {
	response.sendRedirect("login.jsp");
}
%>
	
</body>
</html>