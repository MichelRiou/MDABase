/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.daos;

import hibernate.entities.Users;
import org.hibernate.Session;

/**
 *
 * @author Michel
 */
public class testUserDAO {

    public static void main(String[] args) {
        SessionH sessionH = new SessionH();
        String plainText="123";
        
        Session session = sessionH.getSession();
        UsersDAO dao = new UsersDAO(session);
        Users user = new Users();
        user.setUserName("Michel");
        user.setUserPassword(plainText);
        String msg = dao.ins(user);
        //
        Session session3 = sessionH.getSession();
        UsersDAO dao3 = new UsersDAO(session3);
        Users user3 = new Users();
        user3.setUserName("Andre");
        user3.setUserPassword(plainText);
        String msg2 = dao3.ins(user3);
        System.out.println(msg);
        //
        Session session2 = sessionH.getSession();
        UsersDAO dao2 = new UsersDAO(session2);
        if (dao2.checkUser("Andre", plainText)) {
            System.out.println("OK");
        } else {
            System.out.println("Pas OK");
        };

    }

}
