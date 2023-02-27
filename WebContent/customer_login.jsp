<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	
	<h1>Customer login Page</h1>

	<form action="logCustomer" method="post">
	<label for="tbEmail">Email:</label>
	<input type="email" name="tbEmailLog" id="tbEmailLog" value="<%= request.getParameter("tbEmail") %>" />
	
	<br>
	
	<label for="tbPass">Password:</label>
	<input type="password" name="tbPassLog" id="tbPassLog" value="<%= request.getParameter("tbPass") %>>" />
	<br>
	
	<input type="submit" value="Log In" />
	
	</form>


</body>
</html>