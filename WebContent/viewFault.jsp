<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Viewing Fault</title>
</head>
<body>
<%
int sectionNum = Integer.parseInt(request.getAttribute("section").toString());
int authorNum = Integer.parseInt(request.getAttribute("author").toString());
String section = "null";

if (sectionNum == 1){
	section = "Cassandra";
} else if (sectionNum == 2){
	section = "Hadoop";
} else if (sectionNum == 3){
	section = "Debian";
}


%> <br> 
<h3>Section: <a href= "viewSection?id=<%=sectionNum %>"><%=section%></a></h3>
<h3>Author Id: <a href= "viewAuthor?id=<%=authorNum %>"><%=authorNum%></a></h3>
<h3>Summary: </h3>
<p> <%=request.getAttribute("summary") %></p>
<h3>Details: </h3>
<p> <%=request.getAttribute("details") %>
<br>
<br>
<p><a href="Faults">Back to Faults</a></p>
<a href="home.jsp">Home</a>
<a href="logout.jsp">Log Out</a>


</body>
</html>