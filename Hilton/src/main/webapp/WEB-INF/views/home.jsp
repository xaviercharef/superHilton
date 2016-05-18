<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Booking Hotel</title>
	<link type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

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
        <li><a href="Reservation">Reservation</a></li>
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

	<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
