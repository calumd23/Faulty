<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>
	<%
	
try{
	if(session.getAttribute("permissions").equals("admin")) {
		
		List<String> unames = (List<String>)request.getAttribute("usernames");
		List<String> permissions = (List<String>)request.getAttribute("permissions");
		
		if (unames == null){
			%> <p>No other usernames were found</p> <%
		}else{
			Iterator<String> iterator;
			Iterator<String> iterator2;
			
			iterator = unames.iterator();
			iterator2 = permissions.iterator();
			
			%>
			
			<form action="editUser" method="get">
				<select name="uname">
					<option value="" disabled="disabled" selected="selected">Please Select a User</option>
					
					<%
					
					while(iterator.hasNext()){
						
						String name = (String)iterator.next();
						String perm = (String)iterator2.next();
						
						%>
						
						<option value=<%=name + ";" + perm%>> <%=name + " - " + perm %> </option>
						<%
					}
				
				%>
				
				
				</select> <%
				
				}%>
				
				<input type="submit" name="submit" value="Change Permissions">
				<input type="submit" name="submit" value="Delete User">
			
			
			</form>
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