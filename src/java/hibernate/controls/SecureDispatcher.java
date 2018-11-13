/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controls;

import hibernate.daos.SessionH;
import hibernate.daos.UsersDAO;
import hibernate.entities.Users;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SecureDispatcher", urlPatterns = {"/Secure"})
public class SecureDispatcher extends HttpServlet {

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
        try {
            if (request.getParameter("username") != null && request.getParameter("password") != null) {

                Users user = this.getAuthentificatedUser(request.getParameter("username"), request.getParameter("password"));
                if (user != null) {
                    HttpSession userSession = request.getSession();
                    userSession.setAttribute("user", user);
                    //   response.setContentType("text/html;charset=UTF-8");
                    request.setAttribute("fragment", "bonjour.jsp");
                    //     request.getRequestDispatcher("jsp/Main.jsp").forward(request, response);

                } else {
                    //  response.setContentType("text/html;charset=UTF-8");
                    // System.out.println("OK");
                    request.setAttribute("fragment", "secureLogin.jsp");
                    request.setAttribute("message", "Erreur d'authentification");
                    //  request.getRequestDispatcher("jsp/Main.jsp").forward(request, response);

                }

            } else if ("disconnectUser".equals(request.getParameter("action"))) {
                // HttpSession userSession = request.getSession();
                HttpSession userSession = request.getSession(false);
                if (userSession != null) {
                    userSession.invalidate();
                }
                // response.setContentType("text/html;charset=UTF-8");
                // System.out.println("OK");
                request.setAttribute("fragment", "secureLogin.jsp");
                // request.getRequestDispatcher("jsp/Main.jsp").forward(request, response);
                //response.sendRedirect("index.jsp");
            } else {
                //response.setContentType("text/html;charset=UTF-8");
                request.setAttribute("fragment", "secureLogin.jsp");
                HttpSession userSession = request.getSession(false);
                if (userSession != null) {
                    userSession.invalidate();
                }
                //request.getRequestDispatcher("jsp/Main.jsp").forward(request, response);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("jsp/Main.jsp").forward(request, response);
        }

        /*public function controlSession() {
        if (filter_has_var(INPUT_POST, 'username') && filter_has_var(INPUT_POST, 'password')) {
            $username = filter_input(INPUT_POST, "username", FILTER_SANITIZE_STRING);
            $password = filter_input(INPUT_POST, "password", FILTER_SANITIZE_STRING);
            try {
                $adminDAO = new \model\AdminDAO();

                $user = $adminDAO->selectUser($username, $password, 'yes');
                if ($user != null) {
                    $_SESSION["user"] = serialize($user);
                    $bu = $user->getUser_default_bu();

                    if ($bu != 0)
                        $_SESSION["bu"] = $bu;
                    if (filter_has_var(INPUT_POST, 'rememberme')) {
                        setcookie('CAL1', $user->getUser_pseudo(), time() + 365 * 24 * 3600, null, null, false, true);
                        setcookie('CAL2', $user->getUser_password(), time() + 365 * 24 * 3600, null, null, false, true);
                    }
                }
            } catch (Exception $e) {
                echo $e->getMessage();
            }
        }
        if (!isset($_SESSION['user'])) {
            if (isset($_COOKIE['CAL1']) && isset($_COOKIE['CAL2'])) {
                try {
                    $adminDAO = new \model\AdminDAO();
                    $user = $adminDAO->selectUser($_COOKIE['CAL1'], $_COOKIE['CAL2'], '');
                    if ($user != null) {
                        $_SESSION["user"] = serialize($user);
                        $bu = $user->getUser_default_bu();
                        if ($bu != 0)
                            $_SESSION["bu"] = $bu;
                        return true;
                        header("location:/routes.php");
                    }else {
                        // $messageErreur='Identifiant ou mot de passe erroné';
                       // require('view/frontend/login.php');
                         $this->getViewContent('login', array(), 'template');
                        return false;
                    }
                } catch (Exception $e) {
                    echo '<h1>Erreur : ' . $e->getMessage() . '</h1>';
                }
            } else {
                $messageErreur='';
                if (filter_has_var(INPUT_POST, 'username') && filter_has_var(INPUT_POST, 'password')){
                    $messageErreur = 'Identifiant ou mot de passe erroné';}
                  $this->getViewContent('login', array('messageErreur'=>$messageErreur), 'template');
               // require('view/frontend/login.php');
                return false;
            }
        } else {
            return true;
            header("location:/routes.php");
        }
    }

    public function disconnectUser() {
        session_destroy();
        setcookie("CAL1", "", time() - 3600);
        setcookie("CAL2", "", time() - 3600);
        header("location:/routes.php");
    }*/
    }

    private Users getAuthentificatedUser(String userName, String plainText) {
        SessionH sessionH = new SessionH();
        Session session = sessionH.getSession();
        UsersDAO dao = new UsersDAO(session);
        Users user = dao.checkUser(userName, plainText);
        return user;
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
