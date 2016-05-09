<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap.css">
<title>Revenu de l'hotel</title>
</head>
<body>
	
	<div style="background-color: rgb(24, 126, 188);">
		<h2 style="text-align: center;">
			<small>Revenu de l'hotel</small>
		</h2>
	</div>
	
	<form action="choixAction" method="post">
		<select name="typeTableRevenu">
			<div>
				<label for="revenu"> Quelle compte souhaitez vous consulter</label>
			</div>
			<option value="Default" selected></option>
			<option value="allRevenu">Tout les revenus de l'hotel</option>
			<option value="revenuParAnne"> Les revenus d'une année au choix</option>
			<option value="revenuEnCours"> Les revenus de l'année en cours</option>
		</select>
		<input type="submit" name="Consulter">
	</form>
	
	<c:if test="${action='revenuParAnne'}">
		<form action="revenuParAnne" method="post">
			<label for="revenu">Quelle annee souhaitez vous consulter</label>
			<input type="number" value="annee" placeholder="Annee">
			<input type="submit" name="Consulter">
		</form>
	</c:if>


	<div>
	<h3>Table des revenus</h3>
	<table>
		<tr>
			<th>Revenu du au resevation</th>
			<th>Revenu du au produit vendu</th>
			<th>Revenu total</th>
		</tr>
		<tr>
			<td>${revResa}</td>
			<td>${revProd}</td>
			<td>${revTotal}</td>
		</tr>
	</table>
	</div>



</body>
</html>