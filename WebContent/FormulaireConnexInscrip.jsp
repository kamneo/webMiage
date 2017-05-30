<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion & Inscription</title>
<link href="CSS/css/freelancer.min.css" rel="stylesheet">
<link href="CSS/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav id="mainNav"
		class="navbar navbar-default navbar-fixed-top navbar-custom">
	<div class="container">

		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="hidden"><a href="#page-top"></a></li>
				<li class="page-scroll"><a href="#portfolio">Portfolio</a></li>
				<li class="page-scroll"><a href="#about">About</a></li>
				<li class="page-scroll"><a href="#contact">Contact</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<header>
	<div class="container" id="maincontent" tabindex="-1">
		<div class="row">
			<div class="col-lg-12">
				<img class="img-responsive" src="img/profile.png" alt="">
				<div class="intro-text">
					<h1 class="name">JEE C TRO BIEN</h1>
					<hr class="star-light">
					<span class="skills">TONTON MARCEL AKA TONTON THOMAS</span>
				</div>
			</div>
		</div>
	</div>
	</header>
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
				<form method="get" action="SessionServ">
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label for="mail">Email</label> <input type="mail"
								class="form-control" placeholder="Email Address" id="mail"
								name="mail">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label for="mdp">Mot de passe</label> <input type="password"
								class="form-control" placeholder="Password" id="mdp" name="mdp"
								value="" size="20" maxlength="20" />
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
				<form method="get" action="ClientServ">
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label for="mail">Email</label> <input type="mail"
								class="form-control" placeholder="Email Address" id="mail"
								name="mail" required
								data-validation-required-message="Entrez votre mail.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label for="mdp">Mot de passe</label> <input type="password"
								class="form-control" placeholder="Password" id="mdp" name="mdp"
								required data-validation-required-message="Entrez le mdp."
								value="" size="20" maxlength="20" />
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
								<label for="prenom">Prenom</label> <input type="text"
									class="form-control" placeholder="Prenom" id="prenom"
									name="prenom" required
									data-validation-required-message="Entrez votre prenom.">
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