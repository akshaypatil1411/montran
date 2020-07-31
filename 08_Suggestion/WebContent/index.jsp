<%@page import="java.util.LinkedHashSet"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	<%!Set<String> set = new LinkedHashSet<String>();%>
	

	<form action="" method="post">
		Product Name <input type="text" name="txtName"><br> 
		<input	type="submit" value="print">
	</form><br><br>

	<%
		if (request.getParameter("txtName") != null) {
		set.add(request.getParameter("txtName"));
	}
		
			
	if (application.getAttribute("name") == null) {
		application.setAttribute("name", set);
	}
	%>
	
	Suggestion : [
	<% for(String str:set){%>
	<%= str+"," %>	
		<%} %>
	]

	<%
		application.setAttribute("name", set);
	%>
</body>
</html>