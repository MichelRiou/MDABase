package hibernate.daos;

import hibernate.entities.GridSize;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
// ----------------

public class GridSizeDAO {
// ------------    
// --- ATTRIBUTS    
// ------------    

    private Session sessionH = null;
// -----------    
// --- METHODES    
// -----------    
// ------------    

    public GridSizeDAO(Session session) {
        sessionH = session;
    }
// --- Renvoie la liste des pays    

    public List<GridSize> getGridSizes() {
        List<GridSize> GridSizeList = null;
        try {
            Query q = this.sessionH.createQuery("from GridSize ORDER BY grid_size_name");
            GridSizeList = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return GridSizeList;
    }
/// getPays (Tous)    
// --- Renvoie un pays    

    public GridSize getGridSize(String asName) {
        GridSize gridSize = null;
        try {
            Query q = this.sessionH.createQuery("from GridSize WHERE grid_size_name=?");
            q.setString(0, asName);
            gridSize = (GridSize) q.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return gridSize;
    }
/// getPays (Un)    
// ----------------------------    

    public Boolean ins(GridSize gridSize) {
        Boolean OK = false;

        org.hibernate.Transaction tx = sessionH.beginTransaction();
        try {
            sessionH.save(gridSize);
            tx.commit();

            OK = true;
        } catch (HibernateException e) {
            tx.rollback();

        }
        return OK;
    }
/// ajouter    
// ------------------------------    

    public Boolean del(GridSize gridSize) {
        Boolean OK = false;
        org.hibernate.Transaction tx = sessionH.beginTransaction();
        try {
            sessionH.delete(gridSize);
            tx.commit();
            OK = true;
        } catch (HibernateException e) {
            tx.rollback();

        }
        return OK;
    }
/// supprimer    
// ------------------    

    public Boolean upd(GridSize gridSize) {
        Boolean OK = false;
        org.hibernate.Transaction tx = sessionH.beginTransaction();
        try {
            sessionH.update(gridSize);
            tx.commit();
            OK = true;
        } catch (HibernateException e) {
            tx.rollback();
        }
        return OK;
    }
/// modifier    
// ------------------------    

    public List getAttributsBean(Object objet) {
        GridSize gridSize = (GridSize) objet;
        List listeColonnes = new ArrayList();
        Field[] tProprietes = gridSize.getClass().getDeclaredFields();
        for (int i = 0; i < tProprietes.length; i++) {
            listeColonnes.add(tProprietes[i].getName());
        }
        return listeColonnes;
    } /// getAttributsBean 
} /// class PaysDAO
