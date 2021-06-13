<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col">
      
    </div>
    <div class="col">
<form method="get" action="AuthServlet">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">numéro</label>
    <input type="number" class="form-control" name="numero" id="exampleInputEmail1" >
  </div>
  <div class="mb-3">
    <label for="nom" class="form-label">Nom</label>
    <input type="text" class="form-control" name="nom">
  </div>
   <div class="mb-3">
    <label for="pr" class="form-label">Prenom</label>
    <input type="text" class="form-control" name="prenom">
  </div>
    <div class="mb-3">
    <label for="adr" class="form-label">Adresse</label>
    <input type="text" class="form-control" name="adresse">
  </div>
  <button type="submit" class="btn btn-primary">S'inscrire</button>
</form>

</form>
    </div>
    <div class="col">
      
    </div>
  </div>
</div>

</body>
</html>