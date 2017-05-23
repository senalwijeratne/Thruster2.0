/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Ikhwan
 */
public class DBConnection {
    
    public static Connection dbconnect()
    {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String db = "thrusterdb";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "";
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url + db, user, pass);
            if(conn == null){
                System.out.println("Connection is not established");
            }else{
                System.out.println("Connection is established");
            }
            return conn ;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null ;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
