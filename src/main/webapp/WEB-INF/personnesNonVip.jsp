<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Annuaire Personnes</title>
  </head>
  <body>
    <h1>Personnes normales</h1>

    <ul>
    <c:forEach items="${ personnes }" var="p">
        <li>${ p.nom } ${ p.prenom } </li>
    </c:forEach>
    </ul>

  </body>
</html>
