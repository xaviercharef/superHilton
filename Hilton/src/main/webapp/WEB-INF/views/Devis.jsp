<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap.css">
<title>Gestionnaire devis</title>
</head>
<body>

<div>
	<c:if test="${allDevis != null}">
		<a class="btn btn-default" href="formAddDevis1">Nouveau devis</a>
	</c:if>
</div>

<div>
	<c:if test="${formAdd1}">
		<table>
			<thead>
				<th>Identifiant</th>
				<th>Date de debut</th>
				<th>Date de fin</th>
				<th>Etat</th>
				<th></th>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${listResa}" var="resa">	
						<th>${resa.idReservation}</th>
						<th>${resa.dateDebut}</th>
						<th>${resa.dateFin}</th>
						<th>${resa.etatReservation}</th>
						<th>
							<form action="formAddDevis2" method="post">
								<input type="hidden" name="idResa" value="${resa.idReservation}">
								<input type="submit" value="Selectionner">
							</form>
						</th>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</c:if>
</div>

<div>
	<c:if test="${formAdd2}">
	<h4>Vous avez selectionné la résevation ${selectResa.idReservation} du ${selectResa.dateDebut} au ${selectResa.dateFin}</h4>
		<table>
			<thead>
				<th>Identifiant</th>
				<th>Nom du produit</th>
				<th>Prix</th>
				<th>Description</th>
				<th></th>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${listProd}" var="prod">	
						<th>${prod.idProduit}</th>
						<th>${prod.nomProduit}</th>
						<th>${prod.prix}</th>
						<th>${prod.descriptif}</th>
						<th>
							<form action="addProduitToList" method="post">
								<input type="hidden" name="idResa" value="${selectResa.idReservation}">
								<input type="hidden" name="idProduit" value="${prod.idProduit}">
								<input type="hidden" name="listProduit" value="${listProdAchete}">
								<input type="submit" value="Selectionner">
							</form>
						</th>
					</c:forEach>
				</tr>
			</tbody>
		</table>
		<form action="addDevis" method="post">
			<input type="hidden" name="idReservation" value="${selectResa.idReservation}">
			<input type="hidden" name="listidProduit" value="${listProdAchete}">
			<input type="submit" value="Cree le devis">
		</form>
	</c:if>
</div>

<div>
	<c:if test="${allDevis != null}">
		<table>
			<thead>
				<th>Identifiant devis</th>
				<th>Identifiant Reservation</th>
				<th>Liste des produits</th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${allDevis}" var="dev">
					<tr>
						<td>${dev.idDevis}</td>
						<td>${dev.reservation.idReservation}</td>
						<td>
							<form action="afficherListProduit" method="post">
								<input type="hidden" name="idDevis" value="${dev.idDevis}">
								<input type="submit" value="Afficher les produits">
							</form>
							<c:if test="${listProdOfResa != null}">
								<c:forEach items="${listProdOfResa}" var="prod">
									<p>${prod.nomProduit}</p><br/>
								</c:forEach>
							</c:if>
						</td>
						<td>
							<form action="delDevis" method="post">
								<input type="hidden" name="idDevis" value="${dev.idDevis}">
								<input type="submit" value="Supprimer">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>


</body>
</html>