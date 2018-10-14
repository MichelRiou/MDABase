<%--
Document : PaysSelectFragment
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="objet" items="${listeModels}">
${objet.modelId} - ${objet.modelModel} <br/>
</c:forEach>
TEST