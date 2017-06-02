<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- https://blackrockdigital.github.io/startbootstrap-freelancer/  -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion & Inscription</title>
<link href="CSS/css/freelancer.min.css" rel="stylesheet">
<link href="CSS/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="WEB-INF/navbar.jsp" />
	<section id="contact">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Connexion</h2>
				<br />
			</div>
		</div>
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<form method="post" action="SessionServ">
					<div class="row control-group">
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<label for="mail">Email</label> <input type="mail" class="form-control" placeholder="Email Address" id="mail" name="mail" required data-validation-required-message="Entrez votre Mail">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<label for="mdp">Mot de passe</label> <input type="password" class="form-control" placeholder="Password" id="mdp" name="mdp" required data-validation-required-message="Entrez votre Mot de passe">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
					<div id="success"></div>
					<div class="row">
						<div class="col-lg-12 text-center">
							<button type="submit" class="btn btn-success btn-lg">Connexion</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<section id="contact">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Inscription</h2>
				<br />
			</div>
		</div>
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<form method="post" action="ClientServ">
					<div class="row control-group">
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<label for="mail">Email</label> <input type="mail" class="form-control" placeholder="Email Address" id="mail" name="mail" required data-validation-required-message="Entrez votre mail.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label for="mdp">Mot de passe</label> <input type="password" class="form-control" placeholder="Password" id="mdp" name="mdp" required data-validation-required-message="Entrez le mdp." value="" size="20" maxlength="20" />
							<p class="help-block text-danger"></p>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="nom">Nom</label> <input type="text"
									class="form-control" placeholder="Nom" id="nom" name="nom"
									required data-validation-required-message="Entrez votre nom.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label for="prenom">Prenom</label> <input type="text" class="form-control" placeholder="Prenom" id="prenom" name="prenom" required data-validation-required-message="Entrez votre prenom.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
					</div>
					<br>
					<div id="success"></div>
					<div class="row">
						<div class="col-lg-12 text-center">
							<button type="submit" class="btn btn-success btn-lg">Valider
								Inscription</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
</body>
</html>