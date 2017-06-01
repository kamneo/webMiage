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

	<h2>Evenement</h2>


	<div name="evenements">
		<c:if test="${evenements.size() == 0}">
			Aucun evenement n'est reseigné.
		</c:if>
		<c:forEach items="${evenements}" var="evenement">
			<option value="${evenement.key}">${evenement.value}</option>
		</c:forEach>
	</div>
</body>
</html>