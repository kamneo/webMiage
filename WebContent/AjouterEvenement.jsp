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
	<style>
		.desaprouve{
			display: none;
		}
		
		.erreur {
		    color: #900;
		}
	</style>
	<script type="text/javascript">
		function onChangeRadio(){
			var isChecked = false;
			
			if(document.getElementById('rencontreSportive').checked){
				isChecked = true;
				document.getElementById("nomEquipes").classList.remove('desaprouve');
				document.getElementById('OR').classList.add('desaprouve');
			}else if(document.getElementById('concert').checked){
				isChecked = true;
				document.getElementById("nomEquipes").classList.add('desaprouve');
				document.getElementById("OR").classList.remove('desaprouve');
			}
			if(isChecked)
				document.getElementById('prixCategorie').classList.remove('desaprouve');
		}
	</script>
	<script>		
		function load(){
			var typeEvent = '${param.typeEvenement }';
			if(typeEvent == '1'){
				document.getElementById('rencontreSportive').checked = true;
			}
			
			if(typeEvent == '2'){
				document.getElementById('concert').checked = true;
			}

			document.getElementById('prixCategorie').classList.add('desaprouve');
			onChangeRadio();
		}
	</script>
</head>
<body onload="load()">
	<jsp:include page="WEB-INF/navbar.jsp" />

	<section id="addEvent">
	<div class="container">
		<div>
			<div>
				<h2>Création d'un événement</h2>
				<br />
			</div>
		</div>
		<div>
			<div class="col-lg-12">
				<form name="nouvelEvenemnt" method="post" action="#">
					<div class="row control-group">
						<label for="typeEvenement" >Type d'événement</label>
						<div class="form-group col-xs-12" style="border-bottom: 1px solid #eee; border-left: 1px solid #eee;">
							<div class="radio" id="typeEvenement"> 
							  	<label class="radio-inline"><input type="radio" name="typeEvenement" id="rencontreSportive" value="1" onChange="onChangeRadio();">Rencontre sportive</label>
							 	<label class="radio-inline"><input type="radio" name="typeEvenement" id="concert" onChange="onChangeRadio();" value="2">Concert</label>			
						 	</div>
					 		<span class="erreur">${erreurs['type']}</span>
					 	</div>
					</div>
					<div class="row control-group">
						<label for="nom">Nom de l'événement</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<input type="text" class="form-control" placeholder="nom de l'évenement" id="nom" name="nom"
								value="${param.nom }" size="20" maxlength="20" />
					 			<span class="erreur">${erreurs['nom']}</span>
						</div>
					</div>
					<div class="row form-inline control-group">
						<label for="date">Date de l'événement</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<input type="date" class="form-control" id="date" name="date"
								value="${param.date }" style="width: 180px"/>
				 			<span class="erreur">${erreurs['date']}</span>
							<input type="time" class="form-control" id="time" name="time"
								value="${param.time }" style="width: 180px"/>
				 			<span class="erreur">${erreurs['time']}</span>
						</div>
					</div>
					<div class="row control-group">
						<label for="prixCategorie">Prix des billets pour chaques catégories</label> 
						<div id="prixCategorie" class="form-group col-xs-12 floating-label-form-group controls desaprouve">
							<c:forEach items="${categories}" var="categorie">
								<div class="checkbox">
								  	<div id="${categorie }">
						  				<c:set value="" var="value"/>	
									  	<c:forEach items="${param}" var="p">									  			
										  		<c:if test="${p.key == categorie }">
										  			<c:set value="${p.value }" var="value"/>
											    </c:if>
										</c:forEach>
								    	<input type="text" name="${categorie }" class="form-control" placeholder="Prix catégorie ${categorie }" value="${value }">
						 				<span class="erreur">${erreurs[categorie]}</span>								  	
								  	</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="row control-group">
						<label for="description">Description de l'évenement</label> 
						<div class="form-group col-xs-12 floating-label-form-group controls">
							<textarea id="description" name="description" class="form-control" placeholder="Description de l'evenement" rows="3">${param.description }</textarea>
				 			<span class="erreur">${erreurs['description']}</span>
						</div>
					</div>
					<div id="nomEquipes" class="desaprouve">
						<div class="row control-group">
							<label for="equipe1">Nom de l'équipe 1</label> 
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<input type="text" id="equipe1" name="equipe1" class="form-control" placeholder="nom de l'équipe 1" value="${param.equipe1 }"/>
					 			<span class="erreur">${erreurs['equipe1']}</span>
							</div>
						</div>
						<div class="row control-group">
							<label for="equipe2">Nom de l'équipe 2</label> 
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<input type="text" id="equipe2" name="equipe2" class="form-control" placeholder="nom de l'équipe 2" value="${param.equipe2 }"/>
					 			<span class="erreur">${erreurs['equipe2']}</span>
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