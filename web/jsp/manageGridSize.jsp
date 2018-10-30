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
            success: function (tableHtml) {
                $("#tableList").html(tableHtml);
                $('[data-toggle="tooltip"]').tooltip();
                $('a[class="delete"]').click(function () {
                    idDelete = this.getAttribute('gridSizeId');
                    // console.log(idDelete);
                    idObjet = this.getAttribute('serial_objet');
                    //  console.log(idObjet);
                });
                $('a[class="edit"]').click(function () {
                    //MISE A JOUR DES CHAMPS POUR L'UPDATE 
                    //value a qualifier
                    idEdit = this.getAttribute('producttagid');
                    $('#editName').val(this.getAttribute('producttagname'));
                    designationEdit = this.getAttribute('producttagdesignation');
                    $('#editDesignation').val(designationEdit);
                    alphaEdit = this.getAttribute('producttagvalue');
                    $('#editAlpha').val(alphaEdit);
                    numericEdit = this.getAttribute('producttagnumeric');
                    $('#editNumeric').val(numericEdit);

                    console.log(idEdit);
                });
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(textStatus);

            }
        });
    }
    function ctrlDelete() {
        return true;
    }
    function ctrlEdit() {
        return true;
    }
    function ctrlAdd() {
        return true;
    }
    $(document).ready(function () {
        refresh();
        $("#back").click(function () {
            window.history.back();
        });
        $("#deleteCancel").click(function () {
            $("#deleteMessage").html("");
        });

        // Activate tooltip
        // $('[data-toggle="tooltip"]').tooltip();
        // Validation de la modal AJOUTER UNE REPONSE
        $("#addButton").click(function () {
            $("#addAlpha").val('');
            $("#addNumeric").val('');
            $("#addMessage").html('');
            $("#addModal").modal('show');
        });
        // Validation de la modal SUPPRIMER UNE QUESTION
        /*   $("#deletebutton").click(function () {
         $("#message").html('');
         $("#deleteModal").modal('show');
         });
         // Requête AJAX pour validation
         $("#addProduct").on('click', (function () {
         if (ctrlAddProduct()) {
         $.ajax({
         type: 'POST',
         url: '/routes.php?action=addProduct&builderref=' + $("#addRefBuilder").val() + '&ref=' + $("#addRef").val() + '&model=' + $("#addModel").val() + '&builder=' + $("#addBuilder").val() + '&designation=' + $("#addDesignation").val() + '&ean=' + $("#addEan").val() + '&category=' + $("#addCategory").val(),
         // url: '/routes.php?action=addForm&name=' + $("#addName").val() + '&designation=' + $("#addDesignation").val() + '&category=' + $("#addCategory").val() + '&searchtype=' + $("#addSearchType").val(),
         success: function (data) {
         console.log(data + '/routes.php?action=addProduct&builderref=' + $("#addBuilderRef").val() + '&ref=' + $("#addRef").val() + '&model=' + $("#addModel").val() + '&builder=' + $("#addBuilder").val() + '&designation=' + $("#addDesignation").val() + '&ean=' + $("#addEan").val() + '&category=' + $("#addCategory").val());
         if (data != 1) {
         $("#addMessage").html("Erreur d\'ajout" + data);
         } else {
         $('#addCancel').trigger('click');
         refresh();
         }
         },
         error: function (XMLHttpRequest, textStatus, errorThrown) {
         alert(textStatus);
         $("#retour").html("Erreur d\'envoi de la requête");
         }
         });
         return false;
         }
         }));*/
        // Requête AJAX pour validation
        $("#deleteOk").on('click', (function () {
            if (ctrlDelete()) {
                $.ajax({
                    type: 'POST',
                    url: '/MDABase/Update',
                    data:
                            {
                                "action": "deleteGridSize",
                                "id": idDelete,
                            },
                    success: function (data) {

                        if (data == false) {
                            $("#deleteMessage").html("Erreur sur requête ==>" + data);
                        } else {
                            $('#deleteCancel').trigger('click');
                            refresh();
                        }

                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(textStatus);
                        $("#retour").html("Erreur d\'envoi de la requête");
                    }
                });
                return false;
            }
        }));
        // AJAX 
        /*  $("#editProduct").on('click', (function () {
         // var next = this.getAttribute('id');
         // console.log(next);
         if (ctrlEditProduct()) {
         $.ajax({
         type: 'POST',
         url: '/routes.php?action=updateProduct&id=' + idEdit + '&builderref=' + $("#editBuilderRef").val() + '&ref=' + $("#editRef").val() + '&model=' + $("#editModel").val() + '&builder=' + $("#editBuilder").val() + '&designation=' + $("#editDesignation").val() + '&ean=' + $("#editEan").val() + '&category=' + $("#editCategory").val(),
         success: function (data) {
         console.log(data);
         if (data == 0) {
         $("#editMessage").html("Erreur d'insert".data);
         } else {
         $('#editCancel').trigger('click');
         refresh(); 
         
         }
         },
         error: function (XMLHttpRequest, textStatus, errorThrown) {
         alert(textStatus);
         $("#retour").html("Erreur d\'envoi de la requête");
         }
         });
         return false;
         }
         }
         ));*/

    });
</script>
<div class="container-fluid">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-4">
                    <h5>LISTE DES PRODUITS</h5><input type="hidden" value="" id="idForm">
                </div>
                <div class="col-sm-3">		
                    <button id="back" class="btn btn-default" data-toggle="modal"><i class="material-icons">&#xE314;</i> <span class="black-write">Retour</span></button>
                    <button id="addButton" class="btn btn-info" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Ajouter un produit</span></button>

                </div>
                <div class="col-sm-5">

                    <input class=" pull-right" type="submit" value="Rechercher" onclick="searchString()" />
                    <input class="pull-right" id="search" name="search" type="text" value="" onfocus="clearSearch()" />
                </div>
            </div>
        </div>
        <div><button id='btn'></button></div>
        <!-- RAFRAICHISSEMENT DU DETAIL VIA AJAX -->
        <!-- <div id="loader" class="offset-md-5 col-md-1 mx-auto"><img src="public/images/ajax-loader.gif"/></div> -->
        <div id="tableList" class="container scrollDiv2"></div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">						
                    <h4 class="modal-title">Supprimer une grille de taille</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">					
                    <h6 class="text-warning">Etes-vous sur ?</h6>
                </div>
                <div id="deleteMessage" class="text-warning align-center"></div>
                <div class="modal-footer">
                    <input type="button" id="deleteCancel" class="btn btn-default" data-dismiss="modal" value="Abandon">
                    <input type="button"  class="btn btn-danger" value="Suppr." id="deleteOk">
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Add Modal HTML -->
<div id="addModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form >
                <div class="modal-header">						
                    <h4 class="modal-title">Ajout Série de Taille</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Nom de la série</label>
                        <input type="text" class="form-control"  id="addGridName">
                    </div>
                    <div class="form-row">
                        <div class="form-group ">
                            <label>1</label>
                            <input type="text" class="form-control"  id="addGs01">
                        </div>
                        <div class="form-group ">
                            <label>2</label>
                            <input type="text" class="form-control"  id="addGs02">
                        </div>
                        <div class="form-group ">
                            <label>3</label>
                            <input type="textr" class="form-control"  id="addGs03">
                        </div>
                        <div class="form-group">
                            <label>4</label>
                            <input type="textr" class="form-control"  id="addGs04">
                        </div>
                        <div class="form-group">
                            <label>5</label>
                            <input type="textr" class="form-control"  id="addGs05">
                        </div>
                    </div>


                </div>
                <div id="addMessage" class="text-warning align-center"></div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Abandon" id="addCancel">
                    <input type="button" class="btn btn-info" value="Ajouter" id="addTag" >
                </div>
            </form>
        </div>
    </div>
</div>
