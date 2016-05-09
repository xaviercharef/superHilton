<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<option value="AffEmploye">Afficher la liste des employe</option>
				<option value="SearchClientEmploye">Rechercher une personne par mot cle</option>
				<option value="GetPersonne">Chercher une personne avec sont identifiant</option>
				<option value="AddClient">Ajouter un Client</option>
				<option value="DelClient">Supprimer un client</option>
				<option value="UpdateClient">Mettre à jour un client</option>
				<option value="AddEmploye">Ajouter un Client</option>
				<option value="DelEmploye">Supprimer un client</option>
				<option value="UpdateEmploye">Mettre à jour un client</option>
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
				<input type="date" name="dateDeNaissance" placeholder="Date de naissance">
				<input type="text" name="adresse" placeholder="Adresse">
				<input type="text" name="tel" placeholder="Numero de telephone">
				<input type="text" name="mail" placeholder="Adresse E-mail">
				
				<input type="submit" value="Ajouter">
			</form>
		</c:if>
		
		<c:if test="${typeOpe=='DelClient'}">
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
				<input type="date" name="dateDeNaissance" placeholder="Date de naissance">
				<input type="text" name="adresse" placeholder="Adresse">
				<input type="text" name="tel" placeholder="Numero de telephone">
				<input type="text" name="mail" placeholder="Adresse E-mail">
				
				<input type="submit" value="MaJ">
			</form>
		</c:if>
		
		<c:if test="${typeOpe=='AddEmploye'}">
			<form action="addEmploye" method="post">
				<label for="client">Ajouter un employer</label>
				<input type="text" name="nom" placeholder="Nom">
				<input type="text" name="prenom" placeholder="Prenom">
				<input type="text" name="sexe" placeholder="Sexe">
				<input type="date" name="dateDeNaissance" placeholder="Date de naissance">
				<input type="text" name="adresse" placeholder="Adresse">
				<input type="text" name="tel" placeholder="Numero de telephone">
				<input type="text" name="mail" placeholder="Adresse E-mail">
				
				<input type="submit" value="Ajouter">
			</form>
		</c:if>
		
		<c:if test="${typeOpe=='DelEmploye'}">
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
				<input type="date" name="dateDeNaissance" placeholder="Date de naissance">
				<input type="text" name="adresse" placeholder="Adresse">
				<input type="text" name="tel" placeholder="Numero de telephone">
				<input type="text" name="mail" placeholder="Adresse E-mail">
				
				<input type="submit" value="MaJ">
			</form>
		</c:if>
	
	</div>

	<div>
	<h3> Liste de toutes les personne</h3>
	<table>
	    <tr>
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
	    </tr>
	    </c:forEach>  
	  </tbody>
	</table>
	</div>
	
	<div>
	<h3> Liste des clients</h3>
	<table>
	    <tr>
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
	    </tr>
	    </c:forEach>  
	  </tbody>
	</table>
	</div>
	
	<div>
	<h3> Liste des employes</h3>
	<table>	
	    <tr>
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
	    </tr>
	    </c:forEach>  
	  </tbody>
	</table>
	</div>
	
</body>
</html>