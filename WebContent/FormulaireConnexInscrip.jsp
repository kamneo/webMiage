<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion & Inscription</title>
</head>
<body>
	<div>
		<form method="get" action="ClientServ">
			<fieldset>
				<legend>Connexion</legend>
				<label for="mail">Mail <span class="requis"></span></label>
				<input type="text" id="mail" name="mail" value="" size="20"	maxlength="20"/> <br/>
				<label for="mdp">Mot de passe </label>
				<input type="password" id="mdp" name="mdp" value="" size="20" maxlength="20"/> <br/>
				<br /> 
				<input type="submit" value="Connexion" />
			</fieldset>
		</form>
	</div>
</body>
</html>