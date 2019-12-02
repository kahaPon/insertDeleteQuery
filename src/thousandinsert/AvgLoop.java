
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nierema_sd2081
 */
public class AvgLoop {
    public static void main (String[] args) 
    {
        try
        {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/niere";
            
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, "root", "");
            
        
            System.out.println("Time start: " + java.time.LocalTime.now());
   
              String avgQuery = "SELECT one,two,tree,four,five FROM insertThousand";
              
              int av1 = 0;
              int av2 = 0;
              int av3 = 0;
              int av4 = 0;
              int av5 = 0;
              
              
              
              Statement st = conn.createStatement();
              ResultSet results = st.executeQuery(avgQuery);
              
              while (results.next()) {

                  av1 += results.getDouble(1);
                  av2 += results.getDouble(2);
                  av3 +=results.getDouble(3);
                  av4 += results.getDouble(4);
                  av5 += results.getDouble(5);
              }
              System.out.println("total: "+ av1/1000);
              System.out.println("total: "+ av2/1000);
              System.out.println("total: "+ av3/1000);
              System.out.println("total: "+ av4/1000);
              System.out.println("total: "+ av5/1000);

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
