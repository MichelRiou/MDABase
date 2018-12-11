/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.daos;

import hibernate.entities.Countries;
import hibernate.entities.Roles;
import hibernate.entities.Users;
import hibernate.entities.Weborders;
import hibernate.util.BCrypt;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Michel
 */
public class testWebordersDAO {

    public static void main(String[] args) {
        SessionH sessionH = new SessionH();
        String plainText = "toto";

        Session session = sessionH.getSession();
        final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        try {
            Date date1 = formatter.parse("21/04/66");

            Countries france = new Countries();
            france.setCountryId((int) 1);
            WebordersDAO weborderDAO = new WebordersDAO(session);
            Weborders weborder = new Weborders(48, "bbb", "m.riou@mdaparis.fr", date1, "2013-04-21", (short) 5, "USD", (float) 500.42, (float) 15.00, (float) 25.00, (float) 5.00, "CODEPROMO", (float) 12.25, "UPS SAVER", date1, "Michel RIOU", "67 RUE DE NOISY", "2eme ADRESSE", "VILLIERS SUR MARNE", "94350", "IDF", france, "0612443890", "Michel RIOU", "67 RUE DE NOISY", "2eme ADRESSE", "VILLIERS SUR MARNE", "94350", "IDF", france);
            //public Weborders(Integer weborderId, String weborderNum, String weborderEmail, Date weborderDate, String weborderCreated, short weborderStatus, String weborderCurrency, BigDecimal weborderSubtotal, BigDecimal weborderShipping, BigDecimal weborderTaxes, BigDecimal weborderRefunded, String weborderDiscountCode, BigDecimal weborderDiscount, String weborderShippingMethod, Date weborderShippingDate, String weborderBillingName, String weborderBillingAd1, String weborderBillingAd2, String weborderBillingCity, String weborderBillingZip, String weborderBillingProvince, Countries weborderBillingCountryId, String weborderBillingPhone, String weborderShippingName, String weborderShippingAd1, String weborderShippingAd2, String weborderShippingCity, String weborderShippingProvince, Countries weborderShippingCountryId)
            String msg = weborderDAO.ins(weborder);
            System.out.println("Message " + msg);
        } catch (Exception e) {

        }
            Session session2 = sessionH.getSession();
             WebordersDAO weborderDAO2 = new WebordersDAO(session2);
            Weborders weborder2 = weborderDAO2.getWebordersByCode("aaa");
           // Weborders weborder2 = weborderDAO2.getWebordersById((int)2);
            if (weborder2 !=null){
            System.out.println(weborder2.getWeborderBillingAd1().toString());
            System.out.println(weborder2.toString());
            }
    }

}
