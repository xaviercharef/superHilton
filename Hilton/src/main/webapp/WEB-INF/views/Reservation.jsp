<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/bootstrap.css">
<title>Booking Hotel</title>
</head>
<body class="container">
 <br/><br/><br/><br/>
	<form action="enregistrerReservation" method="post">
		<label>nomClient :</label>
        <select name="idClient">
			<c:forEach items="${allClient}" var="cl">
				<option value="${cl.idPersonne}">${cl.nom}</option>
			</c:forEach>
		</select>
		<label>numeroChambre</label> 
		<select name="idChambre">
			<c:forEach items="${allCh}" var="ch">
				<option value="${ch.idChambre}">${ch.idChambre}</option>
			</c:forEach>
		</select>
		<label>nomEmploye</label>
		<select name="idEmploye">
			<c:forEach items="${allEmploye}" var="em">
				<option value="${em.idPersonne}">${em.nom}</option>
			</c:forEach>
		</select>
		<label>Etat de Reservation :</label> 
			
		<select name="etatReservation">
			<option>-----Choisir-------</option>
			<option>en Cours</option>
			<option>Reservée</option>
			<option>Confirmée</option>
		</select>

		<button class="btn btn-info">Enregistrer </button>
			
		
	</form>

	<%-- <form action="modifierReservation" method="post">
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
			
	</div>--%>
	
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
	       <th class="success">Chambre reservee</th>
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