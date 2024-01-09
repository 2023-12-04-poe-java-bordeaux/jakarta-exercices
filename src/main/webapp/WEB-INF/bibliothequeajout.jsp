<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Bibliotheque</title>
  </head>
  <body>
    <h1>Bibliotheque : Ajouter un Livre</h1>

    <p>${errorMessage}</p>

    <form action="add" method="POST">
          <label>Titre:</label>
          <input type="text" name="titre" value="${titre}"/>

          <label>Auteur:</label>
          <input type="text" name="auteur" value="${auteur}" />

           <label>Isbn:</label>
           <input type="text" name="isbn" value="${isbn}" />

          <input type="submit" value="Envoyer" />
    </form>


    <ul>
    <c:forEach items="${ livres }" var="livre">
        <li>${ livre.titre } ${ livre.auteur } ${ livre.isbn }</li>
    </c:forEach>
    </ul>

  </body>
</html>
