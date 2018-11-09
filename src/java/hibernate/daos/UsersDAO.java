package hibernate.daos;

import hibernate.entities.Models;
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

public class UsersDAO {
// ------------    
// --- ATTRIBUTS    
// ------------    

    private Session sessionH = null;
// -----------    
// --- METHODES    
// -----------    
// ------------    

    public UsersDAO(Session session) {
        sessionH = session;
    }
// --- Renvoie la liste des pays    

    public List<Users> getUsers() {
        List<Users> userListe = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Users ORDER BY userId");
            userListe = q.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return userListe;
    }
/// getPays (Tous)    
// --- Renvoie un pays    

    public Users getUserById(int asID) {
        Users user = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Users WHERE userId=?");
            q.setInteger(0, asID);
            user = (Users) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return user;
    }

    public Users getUserByName(String asName) {
        Users user = null;
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            Query q = this.sessionH.createQuery("from Users WHERE userName=?");
            q.setString(0, asName);
            user = (Users) q.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return user;
    }
/// getPays (Un)    
// ----------------------------    

    public String ins(Users user) {
        String result = "Done";
        Transaction tx = null;
        try {
            tx = sessionH.beginTransaction();
            sessionH.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            String msgSQL = e.getMessage() + e.getCause();
            result = (msgSQL.contains("Duplicate entry") ? "Nom d'utilisateur déjà existant" : "Erreur d'insertion");
            e.printStackTrace();
        } finally {
            sessionH.close();
        }
        return result;
    }
/// ajouter    
// ------------------------------    

    public Boolean del(Users user) {
        Boolean OK = true;
        Transaction tx = null;

        try {
            tx = sessionH.beginTransaction();
            sessionH.delete(user);
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

    public Boolean modifier(Models model) {
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
        Users user = (Users) objet;
        List listeColonnes = new ArrayList();
        Field[] tProprietes = user.getClass().getDeclaredFields();
        for (int i = 0; i < tProprietes.length; i++) {
            listeColonnes.add(tProprietes[i].getName());
        }
        return listeColonnes;
    } /// getAttributsBean 

    public Boolean checkUser(String name, String plainText) {

        Users user = this.getUserByName(name);
        String cipheredText = user.getUserPassword().trim();
        boolean OK = BCrypt.checkpw(plainText, cipheredText.trim());
        System.out.println("Nom        :" + user.getUserName());
        System.out.println("MDP :>>" + plainText + "<<");
        System.out.println("OK :" + OK);
        System.out.println("PWD DB              >>" + user.getUserPassword() + "<<");
        System.out.println("PWD DB string       >>" + cipheredText + "<<");
        System.out.println("PWD DB  string trim >>" + cipheredText.trim() + "<<");
        System.out.println("PWD envoyé          >>" + BCrypt.hashpw(plainText, BCrypt.gensalt(12)) + "<<");
        System.out.println("===============================");
        String hashed = BCrypt.hashpw(plainText, BCrypt.gensalt(12));
        if (BCrypt.checkpw(plainText, hashed)) {
            System.out.println("C'est OK");
        } else {
            System.out.println("C'est pas encore OK");
        }

        return OK;
    } /// getAttributsBean 
} /// class PaysDAO
/*   public void setUserPassword(String userPassword) {
        this.userPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt(12));
    }
    
if (BCrypt.checkpw(candidate, hashed))
 */
