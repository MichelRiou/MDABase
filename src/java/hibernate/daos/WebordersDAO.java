package hibernate.daos;

import hibernate.entities.Weborders;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class WebordersDAO {
// ------------    
// --- ATTRIBUTS    
// ------------    

    private Session sessionH = null;
// -----------    
// --- METHODES    
// -----------    
// ------------    

    public WebordersDAO(Session session) {
        sessionH = session;
    }
// --- Renvoie la liste des pays    

    public List<Weborders> getWeborders() {
        List<Weborders> webordersListe = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Weborders ORDER BY weborderId");
            webordersListe = q.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return webordersListe;
    }
/// getPays (Tous)    
// --- Renvoie un pays    

    public Weborders getWebordersById(int asID) {
        Weborders weborder = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Weborders WHERE weborderId=?");
            q.setInteger(0, asID);
            weborder = (Weborders) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return weborder;
    }

    public Weborders getWebordersByCode(String asCode) {
        Weborders weborder = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Weborders WHERE weborderCode=?");
            q.setString(0, asCode);
            weborder = (Weborders) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return weborder;
    }
/// getPays (Un)    
// ----------------------------    

    public String ins(Weborders weborder) {
        String result = "Done";
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            sessionH.save(weborder);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            String msgSQL = e.getMessage() + e.getCause();
            result = (msgSQL.contains("Duplicate entry") ? "Commande déjà existante" : "Erreur d'insertion");
            //e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return result;
        
    }
/// ajouter    
// ------------------------------    

    public Boolean del(Weborders weborder) {
        Boolean OK = true;
        Transaction tx = null;

        try {
            tx = sessionH.beginTransaction();
            sessionH.delete(weborder);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            OK = false;

        } finally {
            sessionH.close();
        }
        return OK;
    }
/// supprimer    
// ------------------    

    public Boolean upd(Weborders weborder) {
        Boolean OK = true;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            sessionH.update(weborder);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            OK = false;

        } finally {
            sessionH.close();
        }
        return OK;
    }
/// modifier    
// ------------------------    
    
     public Boolean importWebOrders(Weborders weborder) {
        Boolean OK = true;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            sessionH.update(weborder);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            OK = false;

        } finally {
            sessionH.close();
        }
        return OK;
    }
/// modifier    
// ------------------------    

    public List getAttributsBean(Object objet) {
        Weborders weborder = (Weborders) objet;
        List listeColonnes = new ArrayList();
        Field[] tProprietes = weborder.getClass().getDeclaredFields();
        for (int i = 0; i < tProprietes.length; i++) {
            listeColonnes.add(tProprietes[i].getName());
        }
        return listeColonnes;
    } /// getAttributsBean 

 /// getAttributsBean 
} /// class PaysDAO
/*   public void setUserPassword(String userPassword) {
        this.userPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt(12));
    }
    
if (BCrypt.checkpw(candidate, hashed))
 */
