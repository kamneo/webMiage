<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des evenements</title>
<link href="CSS/css/freelancer.min.css" rel="stylesheet">
<link href="CSS/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="WEB-INF/navbar.jsp" />
	<section id="afficherEvenement">
	<div class="container">
		<c:forEach items="${evenementSupprime }" var="ev">
			<div class="alert alert-info">
  				<strong>Info!</strong> l'événement <strong><c:out value="${ev }"></c:out></strong> a été supprimé car il est dépassé.
			</div>
		</c:forEach>
		<c:if test="${!empty client.mail}">
			Vous êtes connecté avec l'adresse mail <c:out value="${client.mail}" /> </br>
		</c:if>
		
		<div>
			<h2>Evenements à venir</h2>
			<br />
		</div>
		<c:if test="${evenements.size() == 0}">
			Aucun evenement n'est reseigné.
		</c:if>
		<c:forEach items="${evenements}" var="evenement">
			<div class="date-container"  style="height: 200px; border: 2px solid #18BC9C; padding-left: 25px;padding-top : 12px;">
				<div class="date-pht load" >
					<img src="images/soccer.png"
						class="imgHeight" alt=""
						style="transform: translate(0px, 0px) scale(1, 1);">
					<div class="ic-circle"></div>
				</div>
				<div class="date-txt" style="min-height: 75px;">
					<div class="genre light cap">
						<c:choose>
							<c:when test="${evenement.getClass().getName().equals('com.model.Evenement.Sport') }">
								Evenement sportif
							</c:when>
							<c:when test="${evenement.getClass().getName().equals('com.model.Evenement.Musique') }">
								Evenement musical
							</c:when>
						</c:choose>
					</div>
					<div class="titre coul-txt cap">
						<b>${evenement.getNomEv()}</b>
					</div>
					<div class="date cap">
						<b>${evenement.getDate() }</b>
					</div>
					<div class="descrition cap">
						<b>${evenement.getDescription() }</b>
					</div>
				</div>
				<div class="container-billetterie text-center"">
					<div style="margin-right: 5px;">
						<button type="button" class="btn btn-primary">Reserver en ligne</button>
						<button type="button" class="btn btn-danger" title="supprimer evenement"><span class="glyphicon glyphicon-trash"></span></button>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	</section>
</body>
</html>

