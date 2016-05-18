<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/bootstrap.css">
<title>Gestion employe et client</title>
</head>
<body>

	<h1>Gestion employe et client</h1>
	
	<div>
		<form action="typeOperation" method="post">
			<select name="typeOperation">
				<label for="personne"> Que souhaitez vous faire?</label>
				<option value="Default" selected="selected"></option>
				<option value="AffAll">Afficher toutes les personnes enregistrées</option>
				<option value="AffClient">Afficher la liste des clients</option>
				<option value="AffEmploye">Afficher la liste des employes</option>
				<option value="SearchClientEmploye">Rechercher une personne par mot cle</option>
				<option value="GetPersonne">Chercher une personne avec son identifiant</option>
				<option value="AddClient">Ajouter un client</option>
				<!-- <option value="DelClient">Supprimer un client</option>
				<option value="UpdateClient">Mettre à jour un client</option> -->
				<option value="AddEmploye">Ajouter un employe</option>
				<!-- <option value="DelEmploye">Supprimer un employe</option>
				<option value="UpdateEmploye">Mettre à jour un employe</option> -->
			</select>
			<input type="submit" value="Formulaire">
		</form>
		
		<c:if test="${typeOpe=='SearchClientEmploye'}">
			<form action="searchClientEmploye" method="post">
				<label for="Personne">Rechercher une personne</label>
				<input type="text" name="mc" placeholder="Mot cle">
				<input type="submit" value="Chercher">
			</form>
		</c:if>
		
		<c:if test="${typeOpe=='GetPersonne'}">
			<form action="getPersonne" method="post">
				<label for="Personne">Rechercher une personne par identifiant</label>
				<input type="number" name="id" placeholder="Identifiant">
				<input type="submit" value="Chercher">
			</form>
		</c:if>
		
		<c:if test="${typeOpe=='AddClient'}">
			<form action="addClient" method="post">
				<label for="client">Ajouter un client</label>
				<input type="text" name="nom" placeholder="Nom">
				<input type="text" name="prenom" placeholder="Prenom">
				<input type="text" name="sexe" placeholder="Sexe">
				<input type="text" name="dateDeNaissance" placeholder="jj/mm/aaaa" id="client"> <!-- class="form-control" -->
				<!-- <input type="date" name="dateDeNaissance" placeholder="Date de naissance"> -->
				<input type="text" name="adresse" placeholder="Adresse">
				<input type="text" name="tel" placeholder="Numero de telephone">
				<input type="text" name="mail" placeholder="Adresse E-mail">
				
				<input type="submit" value="Ajouter">
			</form>
		</c:if>
		
		<%-- <c:if test="${typeOpe=='DelClient'}">
			<form action="delClient" method="post">
				<label for="client">Supprimer un client</label>
				<input type="text" name="id" placeholder="Identifiant">
				<input type="submit" value="Supprimer">
			</form>
		</c:if>
		
		<c:if test="${typeOpe=='UpdateClient'}">
			<form action="updateClient" method="post">
				<label for="client">Mettre a jour un client</label>
				<input type="text" name="id" placeholder="Identifiant">
				<input type="text" name="nom" placeholder="Nom">
				<input type="text" name="prenom" placeholder="Prenom">
				<input type="text" name="sexe" placeholder="Sexe">
				<input type="text" name="dateDeNaissance" placeholder="jj/mm/aaaa" id="client" class="form-control"/> 
				<!-- <input type="date" name="dateDeNaissance" placeholder="Date de naissance"> -->
				<input type="text" name="adresse" placeholder="Adresse">
				<input type="text" name="tel" placeholder="Numero de telephone">
				<input type="text" name="mail" placeholder="Adresse E-mail">
				
				<input type="submit" value="MaJ">
			</form>
		</c:if> --%>
		
		<c:if test="${typeOpe=='AddEmploye'}">
			<form action="addEmploye" method="post">
				<label for="client">Ajouter un employer</label>
				<input type="text" name="nom" placeholder="Nom">
				<input type="text" name="prenom" placeholder="Prenom">
				<input type="text" name="sexe" placeholder="Sexe">
				<input type="text" name="dateDeNaissance" placeholder="jj/mm/aaaa" id="client"/> 
				<!-- <input type="date" name="dateDeNaissance" placeholder="Date de naissance"> -->
				<input type="text" name="adresse" placeholder="Adresse">
				<input type="text" name="tel" placeholder="Numero de telephone">
				<input type="text" name="mail" placeholder="Adresse E-mail">
				
				<input type="submit" value="Ajouter">
			</form>
		</c:if>
		
		<%-- <c:if test="${typeOpe=='DelEmploye'}">
		<form action="delEmploye" method="post">
				<label for="client">Supprimer un employer</label>
				<input type="text" name="id" placeholder="Identifiant">
				<input type="submit" value="Supprimer">
			</form>
		</c:if>
		
		<c:if test="${typeOpe=='UpdateEmploye'}">
			<form action="updateEmploye" method="post">
				<label for="client">Mettre a jour un employe</label>
				<input type="text" name="id" placeholder="Identifiant">
				<input type="text" name="nom" placeholder="Nom">
				<input type="text" name="prenom" placeholder="Prenom">
				<input type="text" name="sexe" placeholder="Sexe">
				<input type="text" name="dateDeNaissance" placeholder="jj/mm/aaaa" id="client" class="form-control"/> 
				<!-- <input type="date" name="dateDeNaissance" placeholder="Date de naissance"> -->
				<input type="text" name="adresse" placeholder="Adresse">
				<input type="text" name="tel" placeholder="Numero de telephone">
				<input type="text" name="mail" placeholder="Adresse E-mail">
				
				<input type="submit" value="MaJ">
			</form>
		</c:if>
	
	</div> --%>

	<div>
	<c:if test="${allPers != null}" >
	<h3> Liste de toutes les personne</h3>
	<table class="table">
	    <tr class="success">
	      <th>Identifiant</th>
	      <th>Type</th>
	      <th>Nom</th>
	      <th>Prenom</th>
	      <th>Sexe</th>
	      <th>Date de Naissance</th>
	      <th>Adresse</th>
	      <th>Telephone</th>
	      <th>E-mail</th>
		</tr>
	  <tbody>
	  <c:forEach items="${allPers}" var="pers"> 
	    <tr>
	    	<td>${pers.idPersonne}</td>
	    	<td>${pers.type}</td>
	  	    <td>${pers.nom}</td>
		    <td>${pers.prenom}</td>
			<td>${pers.sexe}</td>
	      	<td>${pers.dateDeNaissance}</td>
	      	<td>${pers.adresse}</td>
	      	<td>${pers.tel}</td>
	      	<td>${pers.mail}</td>
	      	<td>
	      		<%-- <form action="delClient" method="post">
					<input type="hidden" value="${pers.idPersonne}">
					<input type="submit" value="Supprimer">
				</form>
				<form action="getToUpdatePers" method="post">
					<input type="hidden" value="${cli.idPersonne}">
					<input type="submit" value="MaJ">
				</form> --%>
				
	      	</td>
	    </tr>
	    </c:forEach>
	    <tr>
	    	<td>${getPers.idPersonne}</td>
	    	<td>${getPers.type}</td>
	  	    <td>${getPers.nom}</td>
		    <td>${getPers.prenom}</td>
			<td>${getPers.sexe}</td>
	      	<td>${getPers.dateDeNaissance}</td>
	      	<td>${getPers.adresse}</td>
	      	<td>${getPers.tel}</td>
	      	<td>${getPers.mail}</td>
	      	<!-- <td>
	      		<input type="button" name="supr"><br/>
	      		<button> maj</button>
	      	</td> -->
	  	</tr>
	  </tbody>
	</table>
	</c:if>
	</div>
	
	<div>
	<c:if test="${allCli != null}" >
	<h3> Liste des clients</h3>
	<table class="table">
	    <tr class="success">
	      <th>Identifiant</th>
	      <th>Type</th>
	      <th>Nom</th>
	      <th>Prenom</th>
	      <th>Sexe</th>
	      <th>Date de Naissance</th>
	      <th>Adresse</th>
	      <th>Telephone</th>
	      <th>E-mail</th>
	     </tr>
	  <tbody>
	  <c:forEach items="${allCli}" var="cli">
	    <tr>
	    	<td>${cli.idPersonne}</td>
	    	<td>${cli.type}</td>
	  	    <td>${cli.nom}</td>
		    <td>${cli.prenom}</td>
			<td>${cli.sexe}</td>
	      	<td>${cli.dateDeNaissance}</td>
	      	<td>${cli.adresse}</td>
	      	<td>${cli.tel}</td>
	      	<td>${cli.mail}</td>
	      	<td>
	      		<form action="delClient" method="post">
					<input type="hidden" name="id" value="${cli.idPersonne}">
					<input type="submit" value="Supprimer">
				</form>
				<form action="getToUpdatePers" method="post">
					<input type="hidden" name="idPers" value="${cli.idPersonne}">
					<input type="submit" value="MaJ">
				</form>
	      	<td>
	      	</td>
	    </tr>
	    </c:forEach>  
	  </tbody>
	</table>
	</c:if>
	</div>
	
	<div>
	<c:if test="${allEmpl != null}" >
	<h3> Liste des employes</h3>
	<table class="table">	
	    <tr class="success">
	      <th>Identifiant</th>
	      <th>Nom</th>
	      <th>Prenom</th>
	      <th>Sexe</th>
	      <th>Date de Naissance</th>
	      <th>Adresse</th>
	      <th>Telephone</th>
	      <th>E-mail</th>
		</tr>
	  <tbody>
	  <c:forEach items="${allEmpl}" var="empl">
	    <tr>
	    	<td>${empl.idPersonne}</td>
	  	    <td>${empl.nom}</td>
		    <td>${empl.prenom}</td>
			<td>${empl.sexe}</td>
	      	<td>${empl.dateDeNaissance}</td>
	      	<td>${empl.adresse}</td>
	      	<td>${empl.tel}</td>
	      	<td>${empl.mail}</td>
	      	<td>
	      		<form action="delEmploye" method="post">
					<input type="hidden" name="id" value="${empl.idPersonne}">
					<input type="submit" value="Supprimer">
				</form>
				<form action="getToUpdatePers" method="post">
					<input type="hidden" name="idPers" value="${empl.idPersonne}" >
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
	<c:if test="${getUpdatePers != null}" >
	<h3> Mise a jour </h3>
	<table class="table">	
	    <tr class="success">
	      <th>Identifiant</th>
	      <th>Nom</th>
	      <th>Prenom</th>
	      <th>Sexe</th>
	      <th>Date de Naissance</th>
	      <th>Adresse</th>
	      <th>Telephone</th>
	      <th>E-mail</th>
	      <th></th>
		</tr>
	  <tbody>
	    <tr>
	    	<td>${getUpdatePers.idPersonne}</td>
	  	    <td>${getUpdatePers.nom}</td>
		    <td>${getUpdatePers.prenom}</td>
			<td>${getUpdatePers.sexe}</td>
	      	<td>${getUpdatePers.dateDeNaissance}</td>
	      	<td>${getUpdatePers.adresse}</td>
	      	<td>${getUpdatePers.tel}</td>
	      	<td>${getUpdatePers.mail}</td>
	      	<td>
	    </tr>
	    <tr>
	    	<c:if test="${getUpdatePers.type == 'Client'}">
	    	<form action="updateClient" method="post" id="updateClient">
	    	<input type="hidden" name="id" value="${getUpdatePers.idPersonne}">
	    	</form>
	    	<td>Elément à mettre à jour</td>
	    	<td><input type="text" name="nom" placeholder="Nom" form="updateClient"></td>
	    	<td><input type="text" name="prenom" placeholder="Prenom" form="updateClient"></td>
	    	<td><input type="text" name="sexe" placeholder="Sexe" form="updateClient"></td>
	    	<td><input type="text" name="dateDeNaissance" placeholder="jj/mm/aaaa" form="updateClient"/> 
				<!-- <input type="date" name="dateDeNaissance" placeholder="Date de naissance"> -->
			</td>
	    	<td><input type="text" name="adresse" placeholder="Adresse" form="updateClient"></td>
	    	<td><input type="text" name="tel" placeholder="Numero de telephone" form="updateClient"></td>
	    	<td><input type="text" name="mail" placeholder="Adresse E-mail" form="updateClient"></td>
	    	<td><input type="submit" value="MaJ" form="updateClient"></td>
			</c:if>
			
			
			<c:if test="${getUpdatePers.type == 'Employe'}">
	    	<form action="updateEmploye" method="post" id="updateEmploye">
	    		<input type="hidden" name="id" value="${getUpdatePers.idPersonne}">
	    	</form>
	    	<td>Elément à mettre à jour</td>
	    	<td><input type="text" name="nom" placeholder="Nom" form="updateEmploye"></td>
	    	<td><input type="text" name="prenom" placeholder="Prenom" form="updateEmploye"></td>
	    	<td><input type="text" name="sexe" placeholder="Sexe" form="updateEmploye"></td>
	    	<td><input type="text" name="dateDeNaissance" placeholder="jj/mm/aaaa" form="updateEmploye"/> 
				<!-- <input type="date" name="dateDeNaissance" placeholder="Date de naissance"> -->
			</td>
	    	<td><input type="text" name="adresse" placeholder="Adresse" form="updateEmploye"></td>
	    	<td><input type="text" name="tel" placeholder="Numero de telephone" form="updateEmploye"></td>
	    	<td><input type="text" name="mail" placeholder="Adresse E-mail" form="updateEmploye"></td>
	    	<td><input type="submit" value="MaJ" form="updateEmploye"></td>
			</c:if>
		</tr>
			

	  </tbody>
	</table>
	</c:if>
	</div>
	
	<div>
		<c:if test="${ExcepPersonne != null}">
		<br/>
			<!-- Indicates caution should be taken with this action -->
			<button type="button" class="btn btn-warning">${ExcepPersonne.exception}</button>
		</c:if>
	</div>

	
</body>
</html>