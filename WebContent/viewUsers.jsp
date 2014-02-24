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
		List<String> enableds = (List<String>)request.getAttribute("enableds");
		
		if (unames == null){
			%> <p>No other usernames were found</p> <%
		}else{
			Iterator<String> iterator;
			Iterator<String> iterator2;
			Iterator<String> iterator3;
			
			iterator = unames.iterator();
			iterator2 = permissions.iterator();
			iterator3 = enableds.iterator();
			
			%>
			
			<form action="editUser" method="get">
				<select name="uname">
					<option value="" disabled="disabled" selected="selected">Please Select a User</option>
					
					<%
					
					while(iterator.hasNext()){
						
						String name = (String)iterator.next();
						String perm = (String)iterator2.next();
						String enab = (String)iterator3.next();
						String enabInfo = null;
						
						if(enab.equals("true")){
							enabInfo = "Account Enabled";
						} else if (enab.equals("false")){
							enabInfo = "Account Disabled";
						}
						
						%>
						
						<option value=<%=name + ";" + perm + ";" + enab%>> <%=name + " - " + perm + " - " + enabInfo%> </option>
						<%
					}
				
				%>
				
				
				</select> <%
				
				}%>
				
				<input type="submit" name="submit" value="Change Permissions">
				<input type="submit" name="submit" value="Enable/Disable Account">
			
			
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