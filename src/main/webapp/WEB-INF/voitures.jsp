<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Garage</title>
  </head>
  <body>
    <h1>Garage</h1>

    <form action="voitures" method="POST">
      <label>Nom:</label>
      <input type="text" name="nom" />

      <label>Marque:</label>
      <input type="text" name="marque" />

      <label>immatriculation:</label>
      <input type="text" name="immatriculation" />

      <label>Annee:</label>
      <input type="number" name="annee" />

      <input type="submit" value="Envoyer" />
    </form>

    <table border="1px">
    <tr><th>Nom</th><th>Marque</th><th>Immatriculation</th><th>Année</th></tr>
    <c:forEach items="${ voitures }" var="v">
        <tr>
            <td>${ v.nom }</td><td>${ v.marque }</td><td> ${ v.immatriculation }</td> <td>${ v.annee }</td>
            <td>
                <form method="POST" action="voitures2">
                <input type="hidden" name="nomVoitureASupprimer" value="${ v.nom }"/>
                <input type="submit" value="Supprimer"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </table>

  </body>
</html>
