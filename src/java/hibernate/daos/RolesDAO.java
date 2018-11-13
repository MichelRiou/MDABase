package hibernate.daos;

import hibernate.entities.Roles;
import hibernate.entities.Users;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.util.BCrypt;
// ----------------

public class RolesDAO {
// ------------    
// --- ATTRIBUTS    
// ------------    

    private Session sessionH = null;
// -----------    
// --- METHODES    
// -----------    
// ------------    

    public RolesDAO(Session session) {
        sessionH = session;
    }
// --- Renvoie la liste des pays    

    public List<Roles> getRoles() {
        List<Roles> roleListe = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Roles ORDER BY roleId");
            roleListe = q.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return roleListe;
    }
/// getPays (Tous)    
// --- Renvoie un pays    

    public Roles getRole(int asID) {
        Roles role = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Roles WHERE roleId=?");
            q.setInteger(0, asID);
            role = (Roles) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return role;
    }

    public Roles getRole(String asName) {
        Roles role = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Roles WHERE roleName=?");
            q.setString(0, asName);
            role = (Roles) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return role;
    }
// ----------------------------    

    public String ins(Roles role) {
        String result = "Done";
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            sessionH.save(role);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            String msgSQL = e.getMessage() + e.getCause();
            result = (msgSQL.contains("Duplicate entry") ? "Ce rôle existe déjà" : "Erreur d'insertion");
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return result;
        
    }
/// ajouter    
// ------------------------------    

    public Boolean del(Roles role) {
        Boolean OK = true;
        Transaction tx = null;

        try {
            tx = sessionH.beginTransaction();
            sessionH.delete(role);
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

    public Boolean upd(Roles role) {
        Boolean OK = true;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            sessionH.update(role);
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
        Roles role = (Roles) objet;
        List listeColonnes = new ArrayList();
        Field[] tProprietes = role.getClass().getDeclaredFields();
        for (int i = 0; i < tProprietes.length; i++) {
            listeColonnes.add(tProprietes[i].getName());
        }
        return listeColonnes;
    } 
    
} 