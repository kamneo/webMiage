<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ajouter un Evenement</title>
	<link href="CSS/css/freelancer.min.css" rel="stylesheet">
	<link href="CSS/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="WEB-INF/navbar.jsp" />
	<section id="addEvent">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Création d'un événement</h2>
				<br />
			</div>
		</div>
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<form method="get" action="">
					<div class="row control-group">
						<label for="typeEvenement" >Type d'événement</label>
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<div class="radio" id="typeEvenement">
							  	<label><input type="radio" name="typeEvenement" value="1">Rencontre sportive</label>
							 	<label><input type="radio" name="typeEvenement" value="2">Concert</label>			
						 	</div>
					 	</div>
					</div>
					<div class="row control-group">
						<label for="nom">Nom de l'événement</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<input type="text" class="form-control" placeholder="nom de l'évenement" id="nom" name="nom"
								value="" size="20" maxlength="20" />
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<label for="date">Date de l'événement</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<input type="date" class="form-control" id="date" name="date"
								value="" style="width: 180px"/>
							<input type="time" class="form-control" id="time" name="time"
								value="" style="width: 180px"/>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<label for="date">Catégorie accéssibles</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<c:forEach items="${categories}" var="categorie">
								<div class="checkbox">
								  <label>
								    <input type="checkbox" name="${categorie }" value="" checked>
								    <c:out value="${categorie }"/>
								  </label>
								</div>
							</c:forEach>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<label for="date">Orientations accéssibles</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<c:forEach items="${orientations}" var="orientation">
								<div class="checkbox">
								  <label>
								    <input type="checkbox" name="${orientation }" checked>
								    <c:out value="${orientation }"/>
								  </label>
								</div>
							</c:forEach>
							<p class="help-block text-danger"></p>
						</div>
					</div>
				</div>
					<br>
					<div id="success"></div>
					<div class="row">
						<div class="col-lg-12 text-center">
							<button type="submit" class="btn btn-success btn-lg">Creer l'evenement</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
</body>
</html>