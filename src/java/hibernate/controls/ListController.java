/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controls;

import hibernate.daos.GridSizeDAO;
import hibernate.daos.ModelsDAO;
import hibernate.daos.SessionH;
import hibernate.entities.GridSize;
import hibernate.entities.Models;
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
@WebServlet(name = "ListController", urlPatterns = {"/List"})
public class ListController extends HttpServlet {

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
        // --- Les variables communes
        String lsAction;
        SessionH sessionH = null;
        sessionH = new SessionH();
        Session session = sessionH.getSession();
    

        try {
            lsAction = request.getParameter("action");

            ////////////
            switch (lsAction) {

                case "gridSize":
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
                case "gridSize2":
                    //session.refresh();
                    List<GridSize> listeGridSizes2=null;
                    GridSizeDAO gridsizeDAO2=null;
                    gridsizeDAO2 = new GridSizeDAO(session);
                    listeGridSizes2 = gridsizeDAO2.getGridSizes();
                   
                     
                    for (GridSize gridsize : listeGridSizes2) {
                        System.out.println(gridsize.getGridSizeName());
                        System.out.println(gridsize.getGs01());
                        System.out.flush();
                    }
                    response.setContentType("text/html");
                    request.setAttribute("titre", "Grille de taille");
                    request.setAttribute("listeGridSizes2", listeGridSizes2);
                    request.getRequestDispatcher("jsp/listGridSize.jsp").forward(request, response);
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
