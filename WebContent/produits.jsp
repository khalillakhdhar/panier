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
</head>
<body>
<h2>Liste des produits</h2>
</body>
</html>