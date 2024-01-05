<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Etes vous majeur</h1>

    <p>Votre prénom: ${ prenom } </p>
    <p>Votre nom: ${ nom } </p>
    <p>Votre age: ${ age } </p>

  <c:if test="${ age > 17 }">
  <p>Vous êtes majeur</p>
  </c:if>

  <c:if test="${ age < 18 }">
  <p>Vous êtes mineur</p>
    </c:if>

  </body>
</html>