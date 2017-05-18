<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'un évènement</title>
</head>
<body>
	<div>
		<form method="get" action="creationEvent">
			<fieldset>
				<legend>Création d'un évenement</legend>

				<label for="nomEvent">Nom de l'event <span class="requis"></span></label>
				<input type="text" id="nomEvent" name="nomEvent" value="" size="20"	maxlength="20" /> <br />
				<label for="DateEvent">Date de	l'évènement </label> 
				<input type="text" id="DateEvent" name="dateEvent"	value="" size="20" maxlength="20" /> <br /> 
				<label for="TypeEvent">Type de l'Event <span class="requis"></span></label>
				<select name="select1">
					<option value="Match">Match</option>
					<option value="Concert">Concert</option>
				</select> <br /> 
				<input type="submit"value="Valider" /> 
				<input type="reset" value="Remettre à zéro" />
				<br />
		</form>
	</div>
</body>
</html>