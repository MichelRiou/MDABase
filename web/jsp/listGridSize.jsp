<%-- 
Document : Gestion des grilles de tailles - Détail
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped table-hover">
    <thead>
        <tr>
    <div class="col-md-2"><th>Nom</th></div>
    <div class="col-md-10"><th >1</th><th >2</th><th >3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th>10</th><th>11</th>
            <th>Actions</th></div>
        </tr>
        <tr>
            <th></th><th></th><th>12</th><th>13</th><th>14</th><th>15</th><th>16</th><th>17</th><th>18</th><th>19</th><th>20</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="objet" items="${listeGridSizes}">
            <tr>
                <td>${objet.gridSizeName}</td>
                <td>${objet.gs01}</td><td>${objet.gs02}</td><td>${objet.gs03}</td><td>${objet.gs04}</td><td>${objet.gs05}</td><td>${objet.gs06}</td><td>${objet.gs07}</td><td>${objet.gs08}</td><td>${objet.gs09}</td><td>${objet.gs10}</td><td>${objet.gs11}</td>
           <td class = "row">
                             <!--   <a href="#" class="view"><i class="material-icons" data-toggle="tooltip" title="Liste">&#xE242;</i></a> -->
                                <a href="#editModal"  gridsizeid="${objet.gridSizeId}" gridsizename="${objet.gridSizeName}"  gs01="${objet.gs01}" gs02="${objet.gs02}" gs03="${objet.gs03}" gs04="${objet.gs04}" gs05="${objet.gs05}" gs06="${objet.gs06}" gs07="${objet.gs07}" gs08="${objet.gs08}" gs09="${objet.gs09}" gs10="${objet.gs10}" gs11="${objet.gs11}" gs12="${objet.gs12}" gs13="${objet.gs13}" gs14="${objet.gs14}" gs15="${objet.gs15}" gs16="${objet.gs16}" gs17="${objet.gs17}" gs18="${objet.gs18}" gs19="${objet.gs19}" gs20="${objet.gs20}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                <a href="#deleteModal" serial_objet = ${objet} gridsizeid="${objet.gridSizeId}"  class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                            </td>
            </tr>
            <tr>
                <td></td><td></td><td>${objet.gs12}</td><td>${objet.gs13}</td><td>${objet.gs14}</td><td>${objet.gs15}</td><td>${objet.gs16}</td><td>${objet.gs17}</td><td>${objet.gs18}</td><td>${objet.gs19}</td><td>${objet.gs20}</td>
                <td></td>
            </tr>   
        </c:forEach>

    </tbody>
</table>
