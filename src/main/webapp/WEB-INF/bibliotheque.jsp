<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Bibliotheque</title>
  </head>
  <body>
    <h1>Bibliotheque</h1>



    <ul>
    <c:forEach items="${ livres }" var="livre">
        <li>${ livre.titre } ${ livre.auteur } ${ livre.isbn }</li>
    </c:forEach>
    </ul>

    <c:if test="${ showprevious == true }">
        <a href="livres?page=${page-1}">Précédent</a>
    </c:if>

    <c:if test="${ shownext == true }">
        <a href="livres?page=${page+1}">Suivant</a>
    </c:if>

  </body>
</html>
