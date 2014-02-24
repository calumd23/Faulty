<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Faults by Author</title>
</head>
<body>
	<%
	
try{
	String authorID = request.getAttribute("authorID").toString();
	String myID = session.getAttribute("id").toString();
	
	if(session.getAttribute("permissions").equals("admin") || myID.equals(authorID)) {
		%><h2>Viewing Faults by Author: <%=request.getAttribute("authorID") %></h2><%
		List<String> faultIds = (List<String>)request.getAttribute("faultIds");
		List<String> summaries = (List<String>)request.getAttribute("summaries");
		
		if (faultIds == null){
			%> <p>No faults were found by this author</p> <%
		}else{
			Iterator<String> iterator;
			Iterator<String> iterator2;
			
			iterator = faultIds.iterator();
			iterator2 = summaries.iterator();
			
					
			while(iterator.hasNext()){
						
				String id = (String)iterator.next();
				String summary = (String)iterator2.next();
						
				%>
				<a href="viewFault?id=<%=id%>" ><%=summary%></a><br>
				<%
			}
				
		}%>

	<br>
	<p><a href="Faults">Back to Faults</a></p>
	<a href="home.jsp">Home</a>
	<a href="logout.jsp">Log Out</a>
			
	<%
	} else {
		response.sendRedirect("login.jsp");
	}
} catch (Exception e) {
	response.sendRedirect("login.jsp");
}
	
	%>

</body>
</html>