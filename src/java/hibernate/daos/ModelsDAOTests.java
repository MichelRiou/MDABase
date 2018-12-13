/* */
package hibernate.daos;

import hibernate.entities.GridSize;
import hibernate.entities.Models;
import hibernate.entities.Seasons;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/**
 * * * @author Pascal
 */
public class ModelsDAOTests {

    public static void main(String[] args) {
        SessionH sessionH = new SessionH();

        Session session = sessionH.getSession();
        ModelsDAO dao = new ModelsDAO(session);
        String lsMessage;
        // SELECT       
        List<Models> listemodel = dao.getModels();
        for (int i = 0; i < listemodel.size(); i++) {
            Models model = listemodel.get(i);

            System.out.println(model.getModelModel());
            System.out.println(model.getModelId());
        }
        for (Models model : listemodel) {
            System.out.println(model.getModelModel());
            System.out.println(model.getModelId());
            System.out.println(model.getModelGridSize().getGridSizeName());
            System.out.println(model.getModelSeasonId().getSeasonName());

        }
        sessionH.closeSession(session);
        sessionH = new SessionH();
        session = sessionH.getSession();
        dao = new ModelsDAO(session);
        // INSERT 
        GridSize gridSize = new GridSize();
        gridSize.setGridSizeId(10);
        Seasons season = new Seasons();
        season.setSeasonId(1);

        Models model = new Models("29658999", "test 4", season, gridSize);

// 
        String result = dao.ins(model);
        if (result == "Done") {
//  
            System.out.println("insert OK " + model.getModelId().toString());
        } else {
            System.out.println("insert KO " +result);
        }
        // DELETE   
        //lsMessage = dao.supprimer(model);
        //  System.out.println(lsMessage);
        sessionH.closeSession(session);
    } /// main 
} 
/// class
