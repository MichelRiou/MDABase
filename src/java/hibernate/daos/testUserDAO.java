/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.daos;

import hibernate.entities.Roles;
import hibernate.entities.Users;
import hibernate.util.BCrypt;
import org.hibernate.Session;

/**
 *
 * @author Michel
 */
public class testUserDAO {

    public static void main(String[] args) {
        SessionH sessionH = new SessionH();
        String plainText="toto";
        
        Session session = sessionH.getSession();
        Session session2 = sessionH.getSession();
        UsersDAO dao = new UsersDAO(session);
        RolesDAO roleDAO = new RolesDAO(session2);
        Users user = new Users();
        user.setUserName("Michel");
        Roles role=roleDAO.getRole("ADMIN");
        user.setRoles(role);
        user.setUserPassword(BCrypt.hashpw(plainText, BCrypt.gensalt(12)));
        String msg = dao.ins(user);
        //
     /*   Session session3 = sessionH.getSession();
        UsersDAO dao3 = new UsersDAO(session3);
        Users user3 = new Users();
        user3.setUserName("Andre");
        RolesDAO roleDAO3 = new RolesDAO(session3);
        Roles role3=roleDAO3.getRole("USER");
        user.setRoles(role3);
        user3.setUserPassword(BCrypt.hashpw(plainText, BCrypt.gensalt(12)));
        String msg2 = dao3.ins(user3);
        System.out.println(msg);
        //
        Session session2 = sessionH.getSession();
        UsersDAO dao2 = new UsersDAO(session2);
        Users checkUser=dao2.checkUser("Andre", plainText);
        if (checkUser!=null) {
            System.out.println("OK");
        } else {
            System.out.println("Pas OK");
        };*/

    }

}
