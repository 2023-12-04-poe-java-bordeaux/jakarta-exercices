<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Etes-vous majeur ??</h1>

    <form action="majorite" method="POST">
      <label>Prénom:</label>
      <input type="text" name="prenom" />

      <label>Nom:</label>
      <input type="text" name="nom" />

      <label>Age:</label>
      <input type="number" name="age" />

      <input type="submit" value="Envoyer" />
    </form>
  </body>
</html>
