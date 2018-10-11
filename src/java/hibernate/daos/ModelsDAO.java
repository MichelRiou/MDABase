package hibernate.daos;

import hibernate.entities.Models;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
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

    public List<Models> getModels()  {
        List<Models> modelListe = null;
        try {
            Query q = this.sessionH.createQuery("from Models ORDER BY modelId");
            modelListe = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return modelListe;
    }
/// getPays (Tous)    
// --- Renvoie un pays    

    public Models getModels(String asID) {
        Models model = null;
        try {
            Query q = this.sessionH.createQuery("from Models WHERE modelId=?");
            q.setString(0, asID);
            model = (Models) q.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return model;
    }
/// getPays (Un)    
// ----------------------------    

    public Boolean inserer(Models model) {
        Boolean OK =false;

        org.hibernate.Transaction tx = sessionH.beginTransaction();
        try {
            sessionH.save(model);
            tx.commit();

            OK = true;
        } catch (HibernateException e) {
            tx.rollback();
          
        }
        return OK;
    }
/// ajouter    
// ------------------------------    

    public String supprimer(Models model) {
        String lsMessage;
        org.hibernate.Transaction tx = sessionH.beginTransaction();
        try {
            sessionH.delete(model);
            tx.commit();
            lsMessage = "Suppression OK";
        } catch (HibernateException e) {
            tx.rollback();
            lsMessage = e.getMessage();
        }
        return lsMessage;
    }
/// supprimer    
// ------------------    

    public String modifier(Models model) {
        String lsMessage;
        org.hibernate.Transaction tx = sessionH.beginTransaction();
        try {
            sessionH.update(model);

            tx.commit();
            lsMessage = "Modification OK";
        } catch (HibernateException e) {
            tx.rollback();
            lsMessage = "Erreur modification : " + e.getMessage();
        }
        return lsMessage;
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
} /// class PaysDAO
