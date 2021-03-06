<%-- 
    Document   : main
    Created on : 13 oct. 2018, 23:54:32
    Author     : Michel
--%>
<%@page import="hibernate.entities.Roles"%>
<%@page import="hibernate.entities.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${titre}</title>
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/extended.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
        <script src="js/common.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    </head>

    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <a class="navbar-brand" href="/MDABase/Route">M.D.A</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" 
                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/routes.php">Home </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
                       role="button" data-toggle="dropdown" 
                       aria-haspopup="true" aria-expanded="false">
                        Business Unit
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="routes.php?action=changeBU&bu=2">AUDIOVISUEL</a>
                        <a class="dropdown-item" href="routes.php?action=changeBU&bu=3">IT</a>
                        <a class="dropdown-item" href="routes.php?action=changeBU&bu=1">PRINT</a>
                    </div>
                </li>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item ">
                        <a class="nav-link " href="#">
                        </a>
                    </li>
                </ul>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
                       role="button" data-toggle="dropdown" aria-haspopup="true" 
                       aria-expanded="false">
                        Formulaires
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <a class="dropdown-item" 
                           href="routes.php?action=manageForm">LISTE DES FORMULAIRES</a>
                        <div class="dropdown-divider"></div>

                        <a class="dropdown-item" href="routes.php?action=manageFormValid">UTILISER UN FORMULAIRE</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
                       role="button" data-toggle="dropdown" aria-haspopup="true" 
                       aria-expanded="false">
                        Paramètres
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" 
                           href="/MDABase/Route?action=manageGridSize">GRILLE DE TAILLE</a>
                        <a class="dropdown-item" 
                           href="/MDABase/Route?action=manageModels">MODELES</a>

                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" 
                           href="routes.php?action=manageTag">GESTION DES MOTS-CLES</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
                       role="button" data-toggle="dropdown" aria-haspopup="true" 
                       aria-expanded="false">
                        Back-office
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" 
                           href="routes.php?action=manageUser">CREER UTILISATEUR</a>
                        <a class="dropdown-item" 
                           href="routes.php?action=getProductsFile">IMPORT FICHIER</a>
                    </div>
                </li>

            </ul> 
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ">
                    <a class="nav-link " href="Secure?action=disconnectUser">Utilisateur  : 
                        <c:choose> 
                            <c:when test="${!empty sessionScope.user}">
                                <%-- Si l'utilisateur existe en session --%>
                                ${sessionScope.user.userName} &nbsp;&nbsp;

                               ${sessionScope.user.roles.roleName}
                            </c:when>
                            <c:otherwise>Non connecté</c:otherwise></c:choose></a>
                        </li>
                    </ul>
                </div>
            </nav> 

            <noscript>
            <div>
                <div class="container py-5 extra">
                    <div class="row"></div><h2><p>Sans Javascript ce site ne peut pas fonctionner.</p></h2></div>
            </div>
            </noscript>
            <body>
                <div>

            <jsp:include page="${fragment}" flush="true" />
          
        </div>
    </body>
</html>
