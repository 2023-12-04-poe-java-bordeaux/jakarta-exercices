<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Annuaire Personnes</title>
  </head>
  <body>
    <h1>Personnes VIP</h1>

    <form action="annuaireform" method="POST">

      <label>Prénom:</label>
      <input type="text" name="prenom" />

      <label>Nom:</label>
      <input type="text" name="nom" />


      <p>VIP:</p>
      <label for="vip-true">Oui</label>
      <input type="radio" id="vip-true" name="vip" value="true"/>
      <label for="vip-false">Non</label>
      <input type="radio" id="vip-false" name="vip" value="false"/>

      <input type="submit" value="Envoyer" />
    </form>

  </body>
</html>
