<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/resources/bootstrap.css"><!-- mauvais chemin -->
<link type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

<title>Booking Hotel</title>
</head>
<body >

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home">Booking Hotel</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="Reservation">Reservation</a></li>
        <li><a href="#">Chambre</a></li>
        <li><a href="Personne">Personne</a></li>
        <li><a href="#">Facture</a></li>
      </ul>
     <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <!-- <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Login <span class="caret"></span></a>
          <ul class="dropdown-menu">
  		    <li><a href="#"><span class="glyphicon glyphicon-log-out" aria-hidden=true ></span>Deconnexion</li>
            <li role="separator" class="divider" aria-hidden=true></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in" aria-hidden=true ></span>Connection</li> 
          </ul>
        </li> -->
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Login <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Deconnexion <span class="glyphicon glyphicon-log-out" aria-hidden=true ></span></a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Connection <span class="glyphicon glyphicon-log-in" aria-hidden=true ></span></a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>



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

	
		
	<div>
		<form name="order" action="typeMC" method="post" class="form-inline">
			<label for="motCle">Quelle type de recherche souhaitez vous faire?</label>
			<select name="typeMC">
				<option value="default" selected></option>
				<option value="Chambre">Chambre</option>
				<option value="Client">Client</option>
				<option value="Employe">Employe</option>
			</select>
			<input type="submit" class="btn btn-primary" value="Envoyer">
		</form>
		
		
		<c:if test="${typ=='Client'}">
			<form action="rechercherReservationParClient" method="post">
				<label for="motCle">recherche par Client</label>
				<input type="number" name="idClient" placeholder="idClient">
				<input type="submit" class="btn btn-primary" value="enregistrer">
				<span>${exc.exception}</span>
			</form>
		</c:if>
		
		<c:if test="${typ=='Chambre'}">
			<form action="rechercherReservationParChambre" method="post">
				<label for="motCle">recherche par Chambre</label>
				<input type="number" name="numeroChambre" placeholder="numeroChambre">
				<input type="submit" class="btn btn-primary" value="enregistrer">
				<span>${exc.exception}</span>
			</form>
		</c:if>	
		
		<c:if test="${typ=='Employe'}">
			<form action="rechercherReservationParEmploye" method="post">
				<label for="motCle">recherche par Employe</label>
				<input type="number" name="idEmploye" placeholder="idEmploye">
				<input type="submit" class="btn btn-primary" value="enregistrer">
				<span>${exc.exception}</span>
			</form>
		</c:if>
	</div>
	<div>
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
		      <td>
		      <c:forEach items="${rs.listeChambre}" var="ch">
		    	  ${ch.idChambre}<br/>
		      </c:forEach>
		      </td>
		      <td>
		      	<form action="goToModifierReservation" method="post">
		      	<input type="hidden" name="idReserv" value="${rs.idReservation}">
		      	<input type="submit"  value="update">
		      	</form>
		      </td>
		    </tr>
		    </c:forEach>  
		  </tbody>
		</table> 
	</div>
	
	<div>
		<c:if test="${ResaToUpdate != null}">
		<table class="table table-striped">
		 <thead>
		  	<th>La Reservation a modifier est:</th>
		    <tr>
		      <th class="success">Identifiant de la Reservation</th>
		      <th class="success">identifiant du Client</th>
		      <th class="success">Date de Debut</th>
		      <th class="success">Date de Fin</th>
		      <th class="success">liste des chambres de la reservation</th>
		      <th class="success">etat de la reservation</th>
		      <th class="success">identifiant de l'Employe ayant fait la reservation</th>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
		  	<tr>
		      <td>${ResaToUpdate.idReservation}</td>
		      <td>${ResaToUpdate.client.idPersonne}</td>
		      <td>${ResaToUpdate.dateDebut}</td>
		       <td>${ResaToUpdate.dateFin}</td>
		       <td>
			       <table>
				       <tbody>
				       		<c:forEach items="${ResaToUpdate.listeChambre}" var="chambre">
				       		<tr>
				       		<td>${chambre.idChambre}</td>
				       		</tr>
				       		</c:forEach>
				       </tbody>
			       </table>
				</td>
		      <td>${ResaToUpdate.etatReservation}</td>
		      <td>${ResaToUpdate.employe.idPersonne}</td>
		    </tr>
		    <tr>
		    
		  <form action="m" method="post" id="modifierReservation">
		    	<input type="hidden" name="idReserv" value="${ResaToUpdate.idReservation}">
		      <td>modification a faire</td>
		      <td><input type="number" name="idClient" placeholder="identifiant du Client" form="modifierReservation"></td>
		      <td><input type="Date" name="dateDebut" form="modifierReservation"></td>
		      <td><input type="Date" name="dateFin" form="modifierReservation"></td>
		      <td><input type="number" name="idChambre" form="modifierReservation"></td>
		      <td><select name="etat" form="modifierReservation">
					<option>-----Choisir-------</option>
					<option>en Cours</option>
					<option>Reservée</option>
					<option>Confirmée</option>
				</select>
				</td>
		      <td><input type="number" name="idEmploye" placeholder="identifiant du Employe" form="modifierReservation"></td>
		      <td><input type="submit" class="btn btn-primary" value="enregistrer" form="modifierReservation"></td>
		    
		     </form>
		    </tr>
		  </tbody>
		  </table> 
		  
		</c:if>
	</div>
	<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</body>
</html>