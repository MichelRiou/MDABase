<%-- 
Document : PaysInsertFragment.jsp 
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
GRID
<c:forEach var="objet" items="${listeGridSizes}">
${objet.grid_size_name} - ${objet.GS01} - ${objet.GS02} - ${objet.GS03} - ${objet.GS04} - ${objet.GS05} - ${objet.GS06}<br/>
</c:forEach>
GRID MANAGER