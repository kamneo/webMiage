<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- https://blackrockdigital.github.io/startbootstrap-freelancer/  -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Validation Inscription</title>
<link href="CSS/css/freelancer.min.css" rel="stylesheet">
<link href="CSS/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="WEB-INF/navbar.jsp" />
	<c:out value="Vous êtes connecté avece le mail suivant : " />
	<c:set scope="session" var="tonBean" value="${client}" />
	<c:out value="${client.mail}" />
	<c:out value="${message}" />
	
	
</body>
</html>