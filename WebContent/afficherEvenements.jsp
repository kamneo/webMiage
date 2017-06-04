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
		<div>
			<h2>Evenements à venir</h2>
			<br />
		</div>
		<c:if test="${evenements.size() == 0}">
			Aucun evenement n'est reseigné.
		</c:if>
		<c:forEach items="${evenements}" var="evenement">
			<div class="date-container">
				<div class="date-pht load" style="height: 146px; border: 2px solid #18BC9C;">
					<img src="images/soccer.png"
						class="imgHeight" alt=""
						style="transform: translate(0px, 0px) scale(1, 1);">
					<div class="ic-circle"></div>
				</div>
				<div class="date-txt" style="min-height: 136px;">
					<div class="genre light cap">
						<c:choose>
							<c:when test="${evenement.value.getClass().getName().equals('com.model.Evenement.Sport') }">
								Evenement sportif
							</c:when>
							<c:when test="${evenement.value.getClass().getName().equals('com.model.Evenement.Concert') }">
								Evenement musical
							</c:when>
						</c:choose>
					</div>
					<div class="titre coul-txt cap">
						<b>${evenement.value.getNomEv()}</b>
					</div>
					<div class="date cap">
						<b>${evenement.value.getDate() }</b>
					</div>
				</div>
				<div class="container-billetterie">
					<div style="margin-right: 5px;">
						<button type="button" class="btn btn-primary">Reserver en ligne</button>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	</section>
</body>
</html>

