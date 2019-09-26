<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<%
String username=request.getParameter("username");
%>
<p><% out.print("Hello" +username);%></p>

<a href="index.html">Welcome</a>
</body>
</html>