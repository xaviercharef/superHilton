<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap.css">
<title>Catalogue produit</title>
</head>
<body>

<h1>Catalogue des produits</h1>

<div>
	<a class="btn btn-default" href="formAddPro">Ajouter un produit</a>
</div>

<div>
	<c:if test="${formPro}">
		<form action="addProduit" method="post">
			<label>Ajouter un produit</label>
			<input type="text" name="nomProduit" placeholder="Nom du produit">		
			<input type="text" name="prix" placeholder="Prix">
			<input type="text" name="descriptif" placeholder="Descriptif">	
			<input type="submit" value="Ajouter">
		</form>
	</c:if>
</div>
	
<div>
	<c:if test="${allPro != null}" >
		<h3> Liste des produit </h3>
		<table class="table">
	    	<tr class="success">
	      		<th>Identifiant</th>
	      		<th>Nom</th>
	      		<th>Prix</th>
	      		<th>Descriptif</th>
	     	</tr>
	  	
	  	<tbody>
	  		<c:forEach items="${allPro}" var="pro">
	    		<tr>
	    			<td>${pro.idProduit}</td>
	    			<td>${pro.nomProduit}</td>
	  	    		<td>${pro.prix}</td>
		    		<td>${pro.descriptif}</td>
	      			<td>
	      				<form action="delProduit" method="post">
							<input type="hidden" name="id" value="${pro.idProduit}">
							<input type="submit" value="Supprimer">
						</form>
						<form action="getToUpdateProduit" method="post">
							<input type="hidden" name="id" value="${pro.idProduit}">
							<input type="submit" value="MaJ">
						</form>
					</td>
	    		</tr>
	    	</c:forEach> 
	  	</tbody>
		</table>
	</c:if>
</div>

<div>
	<c:if test="${getUpdatePro != null}" >
		<h3> Mise a jour </h3>
		<table class="table">	
	  		<tr class="success">
				<th>Identifiant</th>
	      		<th>Nom</th>
	      		<th>Prix</th>
	      		<th>Descriptif</th>
	      		<th></th>
			</tr>
	  	<tbody>
	    	<tr>
	    		<td>${getUpdatePro.idProduit}</td>
	    		<td>${getUpdatePro.nomProduit}</td>
	  	    	<td>${getUpdatePro.prix}</td>
		    	<td>${getUpdatePro.descriptif}</td>
	      		<td></td>
	    	</tr>
	    	<tr>
	    		<form action="updateProduit" method="post" id="updateProduit">
	    			<input type="hidden" name="idProduit" value="${getUpdateCha.idChambre}">
	    		</form>
	    		<td>Elément à mettre à jour</td>
	    		<td><input type="text" name="nomProduit" placeholder="Nom du produit" form="updateProduit"></td>
	    		<td><input type="text" name="prix" placeholder="Prix" form="updateProduit"></td>
	    		<td><input type="text" name="descriptif" placeholder="Descriptif" form="updateProduit"></td>
	    		<td><input type="submit" value="MaJ" form="updateProduit"></td>
			</tr>
	  	</tbody>
		</table>
	</c:if>
</div>

</body>
</html>