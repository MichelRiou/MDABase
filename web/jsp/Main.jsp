<%-- 
    Document   : main
    Created on : 13 oct. 2018, 23:54:32
    Author     : Michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>${titre}</title>
    </head>
    <body>
        <nav id="sommaire">
            <a href="/MDABase/Main?action=select">Les
                Models</a> |
            <a href="/MDABase/Main?action=insert">Nouveau
                pays</a> |
            <a href="/MDABase/Main?action=delete">Supprimer
                un pays</a> |
            <a href="#">Modifier un pays</a> |
        </nav>
        <jsp:include page="${fragment}" flush="true" />
        <br/>
        ${message}
    </body>
</html>
