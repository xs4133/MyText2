package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/4/26.
 */
public class DBUtil
{
    static Connection conn=null;
     public static Connection connGet(){
         try
         {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");


         } catch (ClassNotFoundException e)
         {
             e.printStackTrace();
         }catch (SQLException e)
         {
             e.printStackTrace();
         }

         return conn;
     }

    public static void colse(){
        try
        {
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
