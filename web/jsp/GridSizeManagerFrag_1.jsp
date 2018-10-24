<%-- 
Document : PaysInsertFragment.jsp 
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    function refresh() {
        $.ajax({
            type: 'POST',
            url: '/MDABase/List?action=gridSize',
            /*  data:
             {
             "category": 0,
             },*/
            /* beforeSend: function(){
             $("#loader").show();  
             },*/
            success: function (data) {
                console.log(data);
                $("#ajax").html(data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(textStatus);

            }
        });
    }
    $(document).ready(function () {
        refresh();

    });

</script>
<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>Nom</th>
            <th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th>10</th><th>11</th><th></th><th></th>
        </tr>
        <tr>
            <th></th><th></th><th>12</th><th>13</th><th>14</th><th>15</th><th>16</th><th>17</th><th>18</th><th>19</th><th>20</th><th></th><th></th>

        </tr>
    </thead>
    <tbody>
        <c:forEach var="objet" items="${listeGridSizes}">
            <tr>
                <td>${objet.gridSizeName}</td>
                <td>${objet.gs01}</td><td>${objet.gs02}</td><td>${objet.gs03}</td><td>${objet.gs04}</td><td>${objet.gs05}</td><td>${objet.gs06}</td><td>${objet.gs07}</td><td>${objet.gs08}</td><td>${objet.gs09}</td><td>${objet.gs10}</td><td>${objet.gs11}</td>
            </tr>
            <tr>
                <td></td><td></td><td>${objet.gs12}</td><td>${objet.gs13}</td><td>${objet.gs14}</td><td>${objet.gs15}</td><td>${objet.gs16}</td><td>${objet.gs17}</td><td>${objet.gs18}</td><td>${objet.gs19}</td><td>${objet.gs20}</td>
            </tr>   
        </c:forEach>

    </tbody>
</table>

<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>Nom</th>
            <th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th>10</th><th>11</th><th></th><th></th>
        </tr>
        <tr>
            <th></th><th></th><th>12</th><th>13</th><th>14</th><th>15</th><th>16</th><th>17</th><th>18</th><th>19</th><th>20</th><th></th><th></th>

        </tr>
    </thead>
    <tbody><div id="ajax"></div>
</tbody>
</table>
