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
import hibernate.entities.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author Michel
 */
@WebServlet(name = "RouteDispatcher", urlPatterns = {"/Route"})
public class RouteDispatcher extends HttpServlet {

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
        String lsURL = "";
        SessionH sessionH = null;
        sessionH = new SessionH();
        Session session = sessionH.getSession();
        HttpSession userSession = request.getSession(false);

        //Users user = (Users) userSession.getAttribute("user");
        if (userSession == null || userSession.getAttribute("user") == null) {
            request.getRequestDispatcher("Secure").forward(request, response);
            //response.sendRedirect("Secure");
        } else {
            try {
                lsAction = request.getParameter("action");
                String lURL = "";
                ////////////
                switch (lsAction) {
                    case "manageGridSize":
                        request.setAttribute("titre", "Ajout");
                        request.setAttribute("fragment", "manageGridSize.jsp");
                        lsURL = "jsp/Main.jsp";
                        break;
                    case "listGridSize":
                        List<GridSize> listeGridSizes = null;
                        GridSizeDAO gridsizeDAO2 = null;
                        gridsizeDAO2 = new GridSizeDAO(session);
                        listeGridSizes = gridsizeDAO2.getGridSizes();
                        request.setAttribute("listeGridSizes", listeGridSizes);
                        lsURL = "jsp/listGridSize.jsp";
                        break;
                    case "manageModels":
                        request.setAttribute("titre", "Modèles");
                        request.setAttribute("fragment", "manageModels.jsp");
                        lsURL = "jsp/Main.jsp";
                        break;
                    case "listModels":
                        List<Models> listModels = null;
                        ModelsDAO modelsDAO = new ModelsDAO(session);
                        listModels = modelsDAO.getModels();
                        request.setAttribute("listModels", listModels);
                        lsURL = "jsp/listModels.jsp";
                        break;
                    default:
                        request.setAttribute("titre", "Main");
                        lsURL = "jsp/Main.jsp";
                        break;
                }
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
            } /// catch
            finally {
                sessionH.closeSession(session);
            }

            request.getRequestDispatcher(lsURL).forward(request, response);
            // Pas de relative path??
            // this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
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
