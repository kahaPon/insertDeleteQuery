/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thousandinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nierema_sd2081
 */
public class Average {
    
    public static void main (String[] args) 
    {
        try
        {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/niere";
            
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, "root", "");
            
        
            System.out.println("Time start: " + java.time.LocalTime.now());
   
              String avgQuery = "SELECT AVG(one) AS 'fst', AVG(two) AS 'scn', AVG(tree) AS 'trd', AVG(four) AS 'fr', AVG(five) AS 'fv' FROM insertthousand";
              
              String av1= "";
              String av2= "";
              String av3= "";
              String av4= "";
              String av5= "";
              
              Statement st = conn.createStatement();
              ResultSet results = st.executeQuery(avgQuery);
              
              while (results.next()) {

                  av1 = results.getString(1);
                  av2 = results.getString(2);
                  av3 = results.getString(3);
                  av4 = results.getString(4);
                  av5 = results.getString(5);

              }
              System.out.println("total: "+ av1);
              System.out.println("total: "+ av2);
              System.out.println("total: "+ av3);
              System.out.println("total: "+ av4);
              System.out.println("total: "+ av5);

            System.out.println("Time end: " + java.time.LocalTime.now());
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Got an exception.");
            System.out.println(e.getMessage());
        }
    }
}
