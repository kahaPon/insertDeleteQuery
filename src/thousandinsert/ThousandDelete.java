/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thousandinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 *
 * @author nierema_sd2081
 */
public class ThousandDelete {
    
    public static void main (String[] args)
    {
        try
        {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/niere";
            
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, "root", "");
            
            int count = 0;
//            LocalDateTime now = LocalDateTime.now();  
            System.out.println("Time start: " + java.time.LocalTime.now());
            while(!(count == 1000))
            {
                
                String deleteQuery = " delete from insertThousand where one = 1"; 

                Statement st = conn.createStatement();
//                System.out.println(wan + " " + two + " " + three + " " + four + " " + five);
                st.execute(deleteQuery);
                count++;
            }   
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
