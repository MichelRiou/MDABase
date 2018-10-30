package hibernate.daos;

import hibernate.entities.GridSize;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    /**
     *
     * @return
     */
    public List<GridSize> getGridSizes() {
        Transaction tx = null;
        List<GridSize> gridSizeList = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from GridSize ORDER BY gridSizeName");
            gridSizeList = q.list();
            // gridSizeList = this.sessionH.createQuery("from GridSize ORDER BY gridSizeName").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return gridSizeList;
    }

    public GridSize getGridSize(String asName) {
        Transaction tx = null;
        GridSize gridSize = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from GridSize WHERE gridSizeName=?");
            q.setString(0, asName);
            gridSize = (GridSize) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
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
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return OK;
    }
/// ajouter    
// ------------------------------    

    public Boolean del(GridSize gridSize) {
        Boolean OK = false;
        Transaction tx = null;
       // tx = sessionH.beginTransaction();
        try {
            tx = sessionH.beginTransaction();
            sessionH.delete(gridSize);
            tx.commit();
            OK = true;
            System.out.println(Integer.toString(gridSize.getGridSizeId()));
            System.out.println("delete OK");
        } catch (HibernateException e) {
            System.out.println(Integer.toString(gridSize.getGridSizeId()));
            System.out.println("delete KO");
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            sessionH.close();
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
