<%-- 
Document : Gestion des grilles de tailles
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    function refresh() {
        $.ajax({
            type: 'POST',
            url: '/MDABase/Route',
            data: {"action": "listGridSize"},
            success: function (tableHtml) {
                $("#tableList").html(tableHtml);
                $('[data-toggle="tooltip"]').tooltip();
                $('a[class="delete"]').click(function () {
                    // TODO : Gestion de l'objet entre Java-JSP-JSTL et AJAX-Javascript 
                    idDelete = this.getAttribute('gridSizeId');
                });
                $('a[class="edit"]').click(function () {
                    //MISE A JOUR DES CHAMPS POUR L'UPDATE 
                    $('#editGridName').val(this.getAttribute('gridsizename'));
                    $('#editGs01').val(this.getAttribute('gs01'));
                    $('#editGs02').val(this.getAttribute('gs02'));
                    $('#editGs03').val(this.getAttribute('gs03'));
                    $('#editGs04').val(this.getAttribute('gs04'));
                    $('#editGs05').val(this.getAttribute('gs05'));
                    $('#editGs06').val(this.getAttribute('gs06'));
                    $('#editGs07').val(this.getAttribute('gs07'));
                    $('#editGs08').val(this.getAttribute('gs08'));
                    $('#editGs09').val(this.getAttribute('gs09'));
                    $('#editGs10').val(this.getAttribute('gs10'));
                    $('#editGs11').val(this.getAttribute('gs11'));
                    $('#editGs12').val(this.getAttribute('gs12'));
                    $('#editGs13').val(this.getAttribute('gs13'));
                    $('#editGs14').val(this.getAttribute('gs14'));
                    $('#editGs15').val(this.getAttribute('gs15'));
                    $('#editGs16').val(this.getAttribute('gs16'));
                    $('#editGs17').val(this.getAttribute('gs17'));
                    $('#editGs18').val(this.getAttribute('gs18'));
                    $('#editGs19').val(this.getAttribute('gs19'));
                    $('#editGs20').val(this.getAttribute('gs20'));
                    idEdit = this.getAttribute('gridSizeId');
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
    function clearAdd() {
        $('#addGridName').val("");
        $('#addGs01').val("");
        $('#addGs01').val("");
        $('#addGs02').val("");
        $('#addGs03').val("");
        $('#addGs04').val("");
        $('#addGs05').val("");
        $('#addGs06').val("");
        $('#addGs07').val("");
        $('#addGs08').val("");
        $('#addGs09').val("");
        $('#addGs10').val("");
        $('#addGs11').val("");
        $('#addGs12').val("");
        $('#addGs13').val("");
        $('#addGs14').val("");
        $('#addGs15').val("");
        $('#addGs16').val("");
        $('#addGs17').val("");
        $('#addGs18').val("");
        $('#addGs19').val("");
        $('#addGs20').val("");

    }
    $(document).ready(function () {
        refresh();
        $("#back").click(function () {
            window.history.back();
        });
        $("#deleteCancel").click(function () {
            $("#deleteMessage").html("");
        });
        // Validation de la modal AJOUTER UNE REPONSE
        $("#addButton").click(function () {
            clearAdd()
        });
        // VALIDATION
        $("#addOk").on('click', (function () {
            if (ctrlAdd()) {
                $.ajax({
                    type: 'POST',
                    url: '/MDABase/Update',
                    data:
                            {
                                "action": "addGridSize",
                                "addGridName": $("#addGridName").val(),
                                "addGs01": $("#addGs01").val(),
                                "addGs02": $("#addGs02").val(),
                                "addGs03": $("#addGs03").val(),
                                "addGs04": $("#addGs04").val(),
                                "addGs05": $("#addGs05").val(),
                                "addGs06": $("#addGs06").val(),
                                "addGs07": $("#addGs07").val(),
                                "addGs08": $("#addGs08").val(),
                                "addGs09": $("#addGs09").val(),
                                "addGs10": $("#addGs10").val(),
                                "addGs11": $("#addGs11").val(),
                                "addGs12": $("#addGs12").val(),
                                "addGs13": $("#addGs13").val(),
                                "addGs14": $("#addGs14").val(),
                                "addGs15": $("#addGs15").val(),
                                "addGs16": $("#addGs16").val(),
                                "addGs17": $("#addGs17").val(),
                                "addGs18": $("#addGs18").val(),
                                "addGs19": $("#addGs19").val(),
                                "addGs20": $("#addGs20").val()
                            },
                    success: function (data) {
                        console.log(data);
                        if (data != "Done") {
                            $("#addMessage").html(data);
                        } else {
                            $('#addCancel').trigger('click');
                            refresh();
                        }

                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(textStatus);
                        $("#retour").html("Erreur d\'envoi de la requête d\'ajout");
                    }
                });
                return false;
            }
        }));
        $("#editOk").on('click', (function () {
            if (ctrlAdd()) {
                $.ajax({
                    type: 'POST',
                    url: '/MDABase/Update',
                    data:
                            {
                                "action": "editGridSize",
                                "id": idEdit,
                                "editGridName": $("#editGridName").val(),
                                "editGs01": $("#editGs01").val(),
                                "editGs02": $("#editGs02").val(),
                                "editGs03": $("#editGs03").val(),
                                "editGs04": $("#editGs04").val(),
                                "editGs05": $("#editGs05").val(),
                                "editGs06": $("#editGs06").val(),
                                "editGs07": $("#editGs07").val(),
                                "editGs08": $("#editGs08").val(),
                                "editGs09": $("#editGs09").val(),
                                "editGs10": $("#editGs10").val(),
                                "editGs11": $("#editGs11").val(),
                                "editGs12": $("#editGs12").val(),
                                "editGs13": $("#editGs13").val(),
                                "editGs14": $("#editGs14").val(),
                                "editGs15": $("#editGs15").val(),
                                "editGs16": $("#editGs16").val(),
                                "editGs17": $("#editGs17").val(),
                                "editGs18": $("#editGs18").val(),
                                "editGs19": $("#editGs19").val(),
                                "editGs20": $("#editGs20").val()
                            },
                    success: function (data) {
                        console.log(data);
                        if (data != "Done") {
                            $("#editMessage").html(data);
                        } else {
                            $('#editCancel').trigger('click');
                            refresh();
                        }

                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(textStatus);
                        $("#retour").html("Erreur d\'envoi de la requête de mise à jour");
                    }
                });
                return false;
            }
        }));
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
                            $("#deleteMessage").html("Erreur sur requête de suppression==>" + data);
                        } else {
                            $('#deleteCancel').trigger('click');
                            refresh();
                        }

                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(textStatus);
                        $("#retour").html("Erreur d\'envoi de la requête de suppression");
                    }
                });
                return false;
            }
        }));
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
                        <div class="form-group col-md-2">
                            <label>1</label>
                            <input type="text" class="form-control"  id="addGs01">
                        </div>
                        <div class="form-group col-md-2">
                            <label>2</label>
                            <input type="text" class="form-control"  id="addGs02">
                        </div>
                        <div class="form-group col-md-2">
                            <label>3</label>
                            <input type="text" class="form-control"  id="addGs03">
                        </div>
                        <div class="form-group col-md-2">
                            <label>4</label>
                            <input type="text" class="form-control"  id="addGs04">
                        </div>
                        <div class="form-group col-md-2">
                            <label>5</label>
                            <input type="text" class="form-control"  id="addGs05">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label>6</label>
                            <input type="text" class="form-control"  id="addGs06">
                        </div>
                        <div class="form-group col-md-2">
                            <label>7</label>
                            <input type="text" class="form-control"  id="addGs07">
                        </div>
                        <div class="form-group col-md-2">
                            <label>8</label>
                            <input type="text" class="form-control"  id="addGs08">
                        </div>
                        <div class="form-group col-md-2">
                            <label>9</label>
                            <input type="text" class="form-control"  id="addGs09">
                        </div>
                        <div class="form-group col-md-2">
                            <label>10</label>
                            <input type="text" class="form-control"  id="addGs10">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label>11</label>
                            <input type="text" class="form-control"  id="addGs11">
                        </div>
                        <div class="form-group col-md-2">
                            <label>12</label>
                            <input type="text" class="form-control"  id="addGs12">
                        </div>
                        <div class="form-group col-md-2">
                            <label>13</label>
                            <input type="text" class="form-control"  id="addGs13">
                        </div>
                        <div class="form-group col-md-2">
                            <label>14</label>
                            <input type="text" class="form-control"  id="addGs14">
                        </div>
                        <div class="form-group col-md-2">
                            <label>15</label>
                            <input type="text" class="form-control"  id="addGs15">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label>16</label>
                            <input type="text" class="form-control"  id="addGs16">
                        </div>
                        <div class="form-group col-md-2">
                            <label>17</label>
                            <input type="text" class="form-control"  id="addGs17">
                        </div>
                        <div class="form-group col-md-2">
                            <label>18</label>
                            <input type="text" class="form-control"  id="addGs18">
                        </div>
                        <div class="form-group col-md-2">
                            <label>19</label>
                            <input type="text" class="form-control"  id="addGs19">
                        </div>
                        <div class="form-group col-md-2">
                            <label>20</label>
                            <input type="text" class="form-control"  id="addGs20">
                        </div>
                    </div>
                </div>
                <div id="addMessage" class="text-warning text-justify"></div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Abandon" id="addCancel">
                    <input type="button" class="btn btn-info" value="Ajouter" id="addOk" >
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form >
                <div class="modal-header">						
                    <h4 class="modal-title">Edition Série de Taille</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Nom de la série</label>
                        <input type="text" readonly class="form-control"  id="editGridName">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label>1</label>
                            <input type="text" class="form-control"  id="editGs01">
                        </div>
                        <div class="form-group col-md-2">
                            <label>2</label>
                            <input type="text" class="form-control"  id="editGs02">
                        </div>
                        <div class="form-group col-md-2">
                            <label>3</label>
                            <input type="text" class="form-control"  id="editGs03">
                        </div>
                        <div class="form-group col-md-2">
                            <label>4</label>
                            <input type="text" class="form-control"  id="editGs04">
                        </div>
                        <div class="form-group col-md-2">
                            <label>5</label>
                            <input type="text" class="form-control"  id="editGs05">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label>6</label>
                            <input type="text" class="form-control"  id="editGs06">
                        </div>
                        <div class="form-group col-md-2">
                            <label>7</label>
                            <input type="text" class="form-control"  id="editGs07">
                        </div>
                        <div class="form-group col-md-2">
                            <label>8</label>
                            <input type="text" class="form-control"  id="editGs08">
                        </div>
                        <div class="form-group col-md-2">
                            <label>9</label>
                            <input type="text" class="form-control"  id="editGs09">
                        </div>
                        <div class="form-group col-md-2">
                            <label>10</label>
                            <input type="text" class="form-control"  id="editGs10">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label>11</label>
                            <input type="text" class="form-control"  id="editGs11">
                        </div>
                        <div class="form-group col-md-2">
                            <label>12</label>
                            <input type="text" class="form-control"  id="editGs12">
                        </div>
                        <div class="form-group col-md-2">
                            <label>13</label>
                            <input type="text" class="form-control"  id="editGs13">
                        </div>
                        <div class="form-group col-md-2">
                            <label>14</label>
                            <input type="text" class="form-control"  id="editGs14">
                        </div>
                        <div class="form-group col-md-2">
                            <label>15</label>
                            <input type="text" class="form-control"  id="editGs15">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label>16</label>
                            <input type="text" class="form-control"  id="editGs16">
                        </div>
                        <div class="form-group col-md-2">
                            <label>17</label>
                            <input type="text" class="form-control"  id="editGs17">
                        </div>
                        <div class="form-group col-md-2">
                            <label>18</label>
                            <input type="text" class="form-control"  id="editGs18">
                        </div>
                        <div class="form-group col-md-2">
                            <label>19</label>
                            <input type="text" class="form-control"  id="editGs19">
                        </div>
                        <div class="form-group col-md-2">
                            <label>20</label>
                            <input type="text" class="form-control"  id="editGs20">
                        </div>
                    </div>


                </div>
                <div id="editMessage" class="text-warning text-justify"></div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Abandon" id="editCancel">
                    <input type="button" class="btn btn-info" value="Edition" id="editOk" >
                </div>
            </form>
        </div>
    </div>
</div>
