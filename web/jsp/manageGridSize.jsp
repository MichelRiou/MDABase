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
    
        $("#btn").click(function () {
            refresh();
        });

    });

</script>
<button id='btn'></button> 
<div id="ajax"></div>

