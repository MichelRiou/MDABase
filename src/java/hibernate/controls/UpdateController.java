/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controls;

import hibernate.daos.GridSizeDAO;
import hibernate.daos.SessionH;
import hibernate.entities.GridSize;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author Michel
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/Update"})
public class UpdateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String lsAction;
        SessionH sessionH = null;
        sessionH = new SessionH();
        Session session = sessionH.getSession();

        try {
            lsAction = request.getParameter("action");

            ////////////
            switch (lsAction) {

                case "deleteGridSize":
                    Integer idDelete = Integer.parseInt(request.getParameter("id"));
                    System.out.println("id " + idDelete);
                    GridSizeDAO deleteGridSizeDAO = new GridSizeDAO(session);
                    GridSize deleteGridSize = new GridSize();
                    deleteGridSize.setGridSizeId(idDelete);
                    deleteGridSize.setGridSizeName("toto");
                    deleteGridSizeDAO.del(deleteGridSize);
                    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
                    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
                    //response.getWriter().write("OK c'est cool" + obj.getGridSizeName()); 
                    System.out.println("test2 " + Integer.toString(idDelete));// Write response body.
                    response.getWriter().write("OK c'est cool");
                case "addGridSize":
                    String addGridName = request.getParameter("addGridName");
                    String addGs01 = request.getParameter("addGs01");
                    String addGs02 = request.getParameter("addGs02");
                    String addGs03 = request.getParameter("addGs03");
                    String addGs04 = request.getParameter("addGs04");
                    String addGs05 = request.getParameter("addGs05");
                    String addGs06 = request.getParameter("addGs06");
                    String addGs07 = request.getParameter("addGs07");
                    String addGs08 = request.getParameter("addGs08");
                    String addGs09 = request.getParameter("addGs09");
                    String addGs10 = request.getParameter("addGs10");
                    String addGs11 = request.getParameter("addGs11");
                    String addGs12 = request.getParameter("addGs12");
                    String addGs13 = request.getParameter("addGs13");
                    String addGs14 = request.getParameter("addGs14");
                    String addGs15 = request.getParameter("addGs15");
                    String addGs16 = request.getParameter("addGs16");
                    String addGs17 = request.getParameter("addGs17");
                    String addGs18 = request.getParameter("addGs18");
                    String addGs19 = request.getParameter("addGs19");
                    String addGs20 = request.getParameter("addGs20");
                    GridSizeDAO addGridSizeDAO = new GridSizeDAO(session);
                    GridSize addGridSize = new GridSize(addGridName, addGs01, addGs02, addGs03, addGs04, addGs05, addGs06, addGs07, addGs08, addGs09, addGs10, addGs11, addGs12, addGs13, addGs14, addGs15, addGs16, addGs17, addGs18, addGs19, addGs20);
                    String result = addGridSizeDAO.ins(addGridSize);
                    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
                    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
                    //response.getWriter().write("OK c'est cool" + obj.getGridSizeName()); 
                    System.out.println("result = " + result);// Write response body.
                    response.getWriter().write(result);
                case "editGridSize":
                    Integer idEdit = Integer.parseInt(request.getParameter("id"));
                    String editGridName = request.getParameter("editGridName");
                    String editGs01 = request.getParameter("editGs01");
                    String editGs02 = request.getParameter("editGs02");
                    String editGs03 = request.getParameter("editGs03");
                    String editGs04 = request.getParameter("editGs04");
                    String editGs05 = request.getParameter("editGs05");
                    String editGs06 = request.getParameter("editGs06");
                    String editGs07 = request.getParameter("editGs07");
                    String editGs08 = request.getParameter("editGs08");
                    String editGs09 = request.getParameter("editGs09");
                    String editGs10 = request.getParameter("editGs10");
                    String editGs11 = request.getParameter("editGs11");
                    String editGs12 = request.getParameter("editGs12");
                    String editGs13 = request.getParameter("editGs13");
                    String editGs14 = request.getParameter("editGs14");
                    String editGs15 = request.getParameter("editGs15");
                    String editGs16 = request.getParameter("editGs16");
                    String editGs17 = request.getParameter("editGs17");
                    String editGs18 = request.getParameter("editGs18");
                    String editGs19 = request.getParameter("editGs19");
                    String editGs20 = request.getParameter("editGs20");
                    GridSizeDAO editGridSizeDAO = new GridSizeDAO(session);
                   GridSize editGridSize = new GridSize(editGridName, editGs01, editGs02, addGs03, addGs04, addGs05, addGs06, addGs07, addGs08, addGs09, addGs10, addGs11, addGs12, addGs13, addGs14, addGs15, addGs16, addGs17, addGs18, addGs19, addGs20);
                    Boolean resultedit = editGridSizeDAO.upd(editGridSize);
                    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
                    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
                    //response.getWriter().write("OK c'est cool" + obj.getGridSizeName()); 
                    System.out.println("result = " + result);// Write response body.
                    response.getWriter().write(result);
                default:
            }
            /*   if (lsAction.equals("gridSize")) {
                GridSizeDAO gridsizeDAO = new GridSizeDAO(session);
                List<GridSize> listeGridSizes = gridsizeDAO.getGridSizes();
                String HTML = "";
                response.setContentType("text/html");

                for (GridSize gridsize : listeGridSizes) {
                    HTML = HTML + "<tr><td>" + gridsize.getGridSizeName() + "</td>" + "<td>" + gridsize.getGs01() + "</td>" + "<td>" + gridsize.getGs02() + "</td>" + "<td>" + gridsize.getGs03() + "</td>" + "<td>" + gridsize.getGs04() + "</td>" + "<td>" + gridsize.getGs05() + "</td>" + "<td>" + gridsize.getGs06() + "</td>" + "<td>" + gridsize.getGs07() + "</td>" + "<td>" + gridsize.getGs08() + "</td>" + "<td>" + gridsize.getGs09() + "</td>" + "<td>" + gridsize.getGs10() + "</td>" + "<td>" + gridsize.getGs11() + "</td></tr>";
                }

                response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
                response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
                response.getWriter().write(HTML);       // Write response body.
            }*/
 /*    if (lsAction.equals("gridSize2")) {
                GridSizeDAO gridsizeDAO = new GridSizeDAO(session);
                List<GridSize> listeGridSizes = gridsizeDAO.getGridSizes();
                response.setContentType("text/html");
                request.setAttribute("listeGridSizes", listeGridSizes);
                request.getRequestDispatcher("jsp/listGridSize.jsp").forward(request, response);
            }*/

        } /// try
        catch (Exception e) {
            request.setAttribute("message", e.getMessage());
        } /// catch
        finally {
            sessionH.closeSession(session);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
