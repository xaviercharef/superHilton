<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/bootstrap.css">
<title>Booking Hotel</title>
</head>
<body>

	<form action="enregisterReservation" method="post">
		<input type="number" name="idClient" placeholder="idClient">
		<input type="number" name="numeroChambre" placeholder="numeroChambre">
		<input type="number" name="idEmploye" placeholder="idEmploye">
		<input type="submit" class="btn btn-primary" name="enregistrer">
	</form>
	
	<form action="modifierReservation" method="post">
		<input type="number" name="idReservation" placeholder="idReservation">
		<input type="number" name="idClient" placeholder="idClient">
		<input type="number" name="numeroChambre" placeholder="numeroChambre">
		<input type="date" name="dateDebut" placeholder="date Debut">
		<input type="date" name="dateFin" placeholder="date Fin">
		<input type="number" name="idEmploye" placeholder="idEmploye">
		<input type="submit" class="btn btn-primary" name="enregistrer">
	</form>
	
	<div>
		<form name="order" action="typeMC" method="post" class="form-inline">
			<label for="reservation">Quelle type de recherche souhaitez vous faire?</label>
			<select name="typeMC">
				<option value="default" selected></option>z
				<option value="Chambre">Chambre</option>
				<option value="Client">Client</option>
				<option value="Employe">Employe</option>
			</select>
			<input type="submit" class="btn btn-primary" value="Envoyer">
		</form>
		
		
		<c:if test="${typMC=='Client'}">
			<form action="rechercherReservationParClient" method="post">
				<label for="reservation">recherche par Client</label>
				<input type="number" name="idClient" placeholder="idClient">
				<input type="submit" class="btn btn-primary" name="enregistrer">
			</form>
		</c:if>
		<c:if test="${typMC=='Chambre'}">
			<form action="rechercherReservationParChambre" method="post">
				<label for="reservation">recherche par Chambre</label>
				<input type="number" name="numeroChambre" placeholder="numeroChambre">
				<input type="submit" class="btn btn-primary" name="enregistrer">
			</form>
		</c:if>	
		<c:if test="${typMC=='Employe'}">
			<form action="rechercherReservationParEmploye" method="post">
				<label for="reservation">recherche par Employe</label>
				<input type="number" name="idEmploye" placeholder="idEmploye">
				<input type="submit" class="btn btn-primary" name="enregistrer">
			</form>
		</c:if>
			
	</div>
	
	<table class="table table-striped">
	  <thead>
	  	<th>La liste des Reservations est:</th>
	    <tr>
	      <th class="success">Identifiant de la Reservation</th>
	      <th class="success">Nom du Client</th>
	      <th class="success">Date de Debut</th>
	      <th class="success">Date de Fin</th>
	      <th class="success">etat de la reservation</th>
	      <th class="success">Nom de l'Employe ayant fait la reservation</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${allRes}" var="rs"> <!-- pour chaque cl dans c -->
	    <tr>
	      <td>${rs.idReservation}</td>
	      <td>${rs.client.nom}</td>
	      <td>${rs.dateDebut}</td>
	       <td>${rs.dateFin}</td>
	      <td>${rs.etatReservation}</td>
	      <td>${rs.employe.nom}</td>
	      <!-- faire bouton defilement si plusieurs chambres -->
	      <c:forEach items="${rs.listeChambre}" var="ch">
	      <td>${ch.idChambre}</td>
	      </c:forEach>
	      
	    </tr>
	    </c:forEach>  
	  </tbody>
	</table>
	
</body>
</html>