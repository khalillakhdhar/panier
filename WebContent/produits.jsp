<%@page import="java.sql.ResultSet"%>
<%@page import="panier.classes.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
Produit pr=new Produit();
ResultSet rs=pr.aff();

%>
<meta charset="ISO-8859-1">
<title>Produit</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<h2>Liste des produits</h2>
<br>
<table class="table">
<thead>
<tr>
<th>Numéro</th>
<th>Titre</th>
<th>Prix unitaire</th>
<th>Action</th>

</tr>
</thead>
<tbody>
<% while(rs.next())
{
%>
<tr>
<td><%= rs.getInt("numPro") %></td>
<td><%= rs.getString("nomPro") %></td>
<td><%= rs.getInt("puProd")	%></td>
<td><button class="btn btn-primary" onclick="alert('ajouté avec succés')">Ajouter au panier</button></td>

</tr>
<% } %>
</tbody>
</table>
</body>
</html>