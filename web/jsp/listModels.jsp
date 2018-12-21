<%-- 
Document : Gestion des grilles de tailles - Détail
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped table-hover">
    <thead>
        <tr>
    <div class="col-md-2"><th>Modèle</th></div>
    <div class="col-md-10"><th >Désignation</th><th >Saison</th><th >Grille de Taille</th>
            <th>Actions</th></div>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="objet" items="${listModels}">
            <tr>
                <td>${objet.modelModel}</td>
                <td>${objet.modelDesignation}</td><td>${objet.modelSeasonId.seasonName}</td><td>${objet.modelGridSize.gridSizeName}</td>
           <td class = "row">
                             <!--   <a href="#" class="view"><i class="material-icons" data-toggle="tooltip" title="Liste">&#xE242;</i></a> -->
                                <a href="#editModal"  modelid="${objet.modelId}" model="${objet.modelModel}"  designation="${objet.modelDesignation}" seasonid="${objet.modelSeasonId}" gridsize="${objet.modelGridSize}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                <a href="#deleteModal" serial_objet = ${objet} modelid="${objet.modelId}"  class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                            </td>
            </tr>
        </c:forEach>

    </tbody>
</table>
