<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Bibliotheque</title>
  </head>
  <body>
    <h1>Bibliotheque : recherche d'un Livre</h1>

    <form action="search" method="POST">
          <label>Recherche:</label>
          <input type="text" name="recherche" />

          <input type="submit" value="Envoyer" />
    </form>


    <ul>
    <c:forEach items="${ livres }" var="livre">
        <li>${ livre.titre } ${ livre.auteur } ${ livre.isbn }</li>
    </c:forEach>
    </ul>

    <p>Historique de recherche:</p>

    <ul>
    <c:forEach items="${ historiqueDeRecherche }" var="recherche">
        <li>${ recherche } </li>
    </c:forEach>
    </ul>

  </body>
</html>
