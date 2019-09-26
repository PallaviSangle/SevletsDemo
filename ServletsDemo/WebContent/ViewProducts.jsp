<%@page import="com.bv.model.Products"%>
<%@page import="java.util.List" %>
<%@page import="com.bv.handler.ProductDBHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Products</title>
</head>
<body>
<h1>List All Products</h1>
<a href='products.html'>Add Products</a>
<%List<Products> list=ProductDBHandler.getAllProducts();%>

<table border='1'>
<tr><th>Id</th>
<th>Product Named</th>
<th>Manufacturer Name</th>
<th>price</th>
<th>Manufacturer Date</th>
<th>Update</th>
<th>Delete</th>
</tr>
<% for(Products prd:list)
{
%>
<tr>
<td><%=prd.getId()%></td>
<td><%=prd.getProductname() %></td>
<td><%=prd.getManufacturername() %></td>
<td><%=prd.getPrice() %></td>
<td><%=prd.getManufacturerDate() %></td>
<td><a href='updateProducts.jsp?id=<%=prd.getId()%>'>update</a>
<td><a href='DeleteServlet?id=<%=prd.getId() %>'>delete</a></td>

</tr>

<%} %>
</table>
<a href='LogoutServlet'>Log out</a>
</body>
</html>