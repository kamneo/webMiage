<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ajouter un Evenement</title>
	<!-- <link href="CSS/css/freelancer.min.css" rel="stylesheet">
	<link href="CSS/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
	<style>
		.desaprouve{
			display: none;
		}
		
		.erreur {
		    color: #900;
		}
	</style>
</head>
<body>
	<jsp:include page="WEB-INF/navbar.jsp" />
	
	<script type="text/javascript">
		function onChangeRadio(){
			document.getElementById('prixCategorie').classList.remove('desaprouve');
			
			if(document.getElementById('rencontreSportive').checked){
				document.getElementById("nomEquipes").classList.remove('desaprouve');
				document.getElementById('OR').classList.add('desaprouve');
			}else{
				document.getElementById("nomEquipes").classList.add('desaprouve');
				document.getElementById("OR").classList.remove('desaprouve');
			}
		}
	</script>
	
	<section id="addEvent">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Cr�ation d'un �v�nement</h2>
				<br />
			</div>
		</div>
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<form name="nouvelEvenemnt" method="post" action="#">
					<div class="row control-group">
						<label for="typeEvenement" >Type d'�v�nement</label>
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<div class="radio" id="typeEvenement"> 
							  	<label><input type="radio" name="typeEvenement" id="rencontreSportive" class="form-control" value="1" onChange="onChangeRadio();">Rencontre sportive</label>
							 	<label><input type="radio" name="typeEvenement" id="concert" class="form-control" onChange="onChangeRadio();" value="2">Concert</label>			
						 	</div>
					 		<span class="erreur">${erreurs['type']}</span>
					 	</div>
					</div>
					<div class="row control-group">
						<label for="nom">Nom de l'�v�nement</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<input type="text" class="form-control" placeholder="nom de l'�venement" id="nom" name="nom"
								value="" size="20" maxlength="20" />
						</div>
					</div>
					<div class="row control-group">
						<label for="date">Date de l'�v�nement</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<input type="date" class="form-control" id="date" name="date"
								value="" style="width: 180px"/>
							<input type="time" class="form-control" id="time" name="time"
								value="" style="width: 180px"/>
						</div>
					</div>
					<div class="row control-group">
						<label for="prixCategorie">Prix des billets pour chaques cat�gories</label> 
						<div id="prixCategorie" class="form-group col-xs-12 floating-label-form-group controls desaprouve">
							<c:forEach items="${categories}" var="categorie">
								<div class="checkbox">
								  <label>
								    <input type="text" id="${categorie }" name="${categorie }" class="form-control" placeholder="Prix cat�gorie ${categorie }" value="" checked>
								  </label>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="row control-group">
						<label for="description">Description de l'�venement</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<textarea id="description" name="description" class="form-control" placeholder="Description de l'evenement" rows="3"></textarea>
						</div>
					</div>
					<div id="nomEquipes" class="desaprouve">
						<div class="row control-group">
							<label for="equipe1">Nom de l'�quipe 1</label> 
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<input type="text" id="equipe1" name="equipe1" class="form-control" placeholder="nom de l'�quipe 1" value=""/>
							</div>
						</div>
						<div class="row control-group">
							<label for="equipe2">Nom de l'�quipe 2</label> 
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<input type="text" id="equipe2" name="equipe2" class="form-control" placeholder="nom de l'�quipe 2" value=""/>
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