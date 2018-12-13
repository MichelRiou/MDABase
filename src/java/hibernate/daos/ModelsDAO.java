package hibernate.daos;

import hibernate.entities.Models;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
// ----------------

public class ModelsDAO {
// ------------    
// --- ATTRIBUTS    
// ------------    

    private Session sessionH = null;
// -----------    
// --- METHODES    
// -----------    
// ------------    

    public ModelsDAO(Session session) {
        sessionH = session;
    }
// --- Renvoie la liste des pays    

    public List<Models> getModels() {
        List<Models> modelListe = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Models ORDER BY modelId");
            modelListe = q.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return modelListe;
    }
/// getPays (Tous)    
// --- Renvoie un pays    

    public Models getModel(Integer asID) {
        Models model = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Models WHERE modelId=?");
            q.setInteger(0, asID);
            model = (Models) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return model;
    }
/// getPays (Un)    
// ----------------------------    

    public String ins(Models model) {
        String result = "Done";
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            sessionH.save(model);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            String msgSQL = e.getMessage() + e.getCause();
            result = (msgSQL.contains("Duplicate entry") ? "Modèle déjà existant" : "Erreur d'insertion");
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return result;
    }
/// ajouter    
// ------------------------------    

    public Boolean del(Models model) {
        Boolean OK = true;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            sessionH.delete(model);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            OK = false;
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return OK;
    }
/// supprimer    
// ------------------    

    public Boolean upd(Models model) {
        Boolean OK = true;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            sessionH.update(model);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            OK = false;
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return OK;
    }
/// modifier    
// ------------------------    

    public List getAttributsBean(Object objet) {
        Models model = (Models) objet;
        List listeColonnes = new ArrayList();
        Field[] tProprietes = model.getClass().getDeclaredFields();
        for (int i = 0; i < tProprietes.length; i++) {
            listeColonnes.add(tProprietes[i].getName());
        }
        return listeColonnes;
    } /// getAttributsBean 
}
