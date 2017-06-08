<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/css/freelancer.min.css" rel="stylesheet">
<link href="CSS/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="JS/jquery-3.2.1.js"></script>
<title>nouvelle résa</title>
</head>
<body>
	<FORM action="reservation" method="Post">
	<input type='hidden' name="idEvent" value="${idEvent}"/>
		<div id="orientation" class="form-resa">
			Orientation : <SELECT name="orientation">
				<c:forEach items="${orientations}" var="orientation">
					<OPTION value="${orientation}"><c:out
							value="${orientation }" /></OPTION>
				</c:forEach>
			</SELECT>
		</div>
		<div id="escalier" class="form-resa">
			Escalier : <SELECT name="escalier">

			</SELECT>
		</div>
		<div id="rang" class="form-resa">
			Rang : <SELECT name="rang">

			</SELECT>
		</div>
		
		<div id="place" class="form-resa">
			Place : <SELECT name="place">

			</SELECT>
		</div>

		<div id="form-submit" class="form-resa">
			<label for="mail">Email</label> <input type="mail"
								class="form-control" placeholder="Email Address" id="mail"
								name="mail" required
								data-validation-required-message="Entrez votre Mail">
			Tarif : 
			<SELECT name="idReduc">
				<option value="1">Enfant (- 12 ans) </option>
				<option value="2">Etudiant </option>
				<option value="3">Adulte (+12 ans) </option>
			</SELECT>
			<button type="submit" value="OK">Réserver cette place</button>
		</div>
	</FORM>


	<script>
	$( document ).ready(function() {
		$.ajaxSetup({
			timeout: "10000"
		});
		
		
		$("div.form-resa").hide();
		$("#orientation").show();
		var idEvent= $("input[name='idEvent']").val();
	    $("#orientation select").change(function() {
	    	 var orientation= $("#orientation option:selected").val();
	    	 $.get( "/Billeterie/AjaxEscalier?idEvent="+idEvent+"&orientation="+orientation, function(data) {
	    		  $("#escalier select").html(data);
	    		  $("#escalier").show();
	    		  
	    		  $("#escalier select").change(function(){
	    			  var escalier = $("#escalier option:selected").val();
	    			  $.get("/Billeterie/AjaxRang?idEvent="+idEvent+"&orientation="+orientation+"&escalier="+escalier, function(data){
	    				  $("#rang select").html(data);
	    				  $("#rang").show();
	    				  
	    				  $("#rang select").change(function(){
	    					  var rang = $("#rang option:selected").val();
	    					  $.get("/Billeterie/AjaxPlace?idEvent="+idEvent+"&orientation="+orientation+"&escalier="+escalier+"&rang="+rang, function(data){
	    						  $("#place select").html(data);
	    	    				  $("#place").show();
	    	    				  
	    	    				  $("#place select").change(function(){
	    	    					  $("#form-submit").show();
	    	    				  });
	    					  });
	    				  });
	    			  });	    			  
	    		  });
	    	 });	  
	    });
	});
	</script>
</body>
</html>