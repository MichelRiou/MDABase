<%-- Document : PaysInsertFragment.jsp --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="/WebAppHibernateCours/ControleurPays" method="POST">
<label>Id pays : </label>
<input type="text" name="idPays" value="36" size="4" />
<label>Nom du Pays : </label>
<input type="text" name="nomPays" value="Hongrie" />
<input type="hidden" name="action" value="insertValider" />
<input type="submit" />
</form>