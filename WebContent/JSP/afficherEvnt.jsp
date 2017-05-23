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
        <p>Nom de l'event : ${ evnt.nomEv }</p>
        <p>Type de l'Event : ${ evnt.typeEv }</p>
    </body>
</html>