<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
	
<title>Création d'un évènement</title>
</head>
<body>
	<div>
		<form method="get" action="EvenementServ">
			<fieldset>
				<legend>Création d'un évenement</legend>

				<label for="nomEv">Nom de l'event <span class="requis"></span></label>
				<input type="text" id="nomEv" name="nomEv" value="" size="20"	maxlength="20"/> <br/>
				<label for="date">Date de l'évènement </label>
				<input type="text" id="date" name="date" value="" size="20" maxlength="20"/> <br/>
				<label for="typeEv">Type de l'Event <span class="requis"></span></label>
				<select name="typeEv">
					<option value="Match">Match</option>
					<option value="Concert">Concert</option>
				</select> <br /> 
				<input type="submit" value="Valider" />
				<input type="reset" value="Remettre à zéro" /> <br />
			</fieldset>
		</form>
	</div>
</body>
</html>