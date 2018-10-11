/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.daos;

import hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Michel
 */
public class SessionH {

    /**
     * * * @return
     */
    public Session getSession() {
        Session sessionH = null;
        try {
            sessionH = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
        }
        return sessionH;
    } /// getSession    

    /**
     *
     * @param session
     * @return
     */
    public boolean closeSession(Session session) {
        boolean lbOK = true;
        try {
            session.close();
        } catch (HibernateException e) {
            lbOK = false;

        }
        return lbOK;
    } /// closeSession 
} /// class

