<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un Evenement</title>
    </head>
    <body>
        <%-- Affichage de la chaîne "message" transmise par la servlet --%>
        <%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
        <p>Nom du client : ${ client.nom 	}</p>
        <p>Mail			 : ${ client.mail 	}</p>
        <p>Mot de passe  : ${ client.mdp 	}</p>
    </body>
</html>