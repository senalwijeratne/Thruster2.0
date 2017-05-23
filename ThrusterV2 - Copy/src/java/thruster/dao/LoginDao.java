
package thruster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import thruster.models.DBConnection;
import thruster.models.User;


public class LoginDao {
    
    private Connection connection;
    
    public String loginAuth(User user) throws SQLException{
        
        connection = DBConnection.dbconnect();
        String passResult = "";
         String loginPass = user.getSaltedpw();
       
        PreparedStatement preparedStatement = connection.
            prepareStatement("select * from users where saltedpw=? and email=?");
            preparedStatement.setString(1, user.getSaltedpw());
            preparedStatement.setString(2, user.getEmail());
            ResultSet rs = preparedStatement.executeQuery();
           
            while(rs.next()){
                
                String dbPass = rs.getString("saltedpw");
                if (loginPass.equals(dbPass)) {
                    
                passResult = "success";
                }
                else
                {
                 passResult = "failure";
                }
            }
            return passResult;
        }
    
        
        
        public String getUid(String email,String password) throws SQLException{
            connection = DBConnection.dbconnect();
            System.out.println("Inside getUID: "+email);
            System.out.println("Inside getUID: "+password);
            String userID="";
//            String sqlstring = "select * from users where email LIKE '"+email+"' and saltedpw LIKE '"+password+"'";
//            PreparedStatement preparedStatement = connection.prepareStatement(sqlstring);
////            preparedStatement.setString(1, email);
////            preparedStatement.setString(2, password);
//            ResultSet rs = preparedStatement.executeQuery();
            User user = new User();
            try {
                PreparedStatement preparedStatement = connection.
                        prepareStatement("select * from users where "+
                                "email LIKE '"+email+"' and "
                                + "saltedpw LIKE '"+password+"'");
//                preparedStatement.setString(1, email);
//                preparedStatement.setString(2, password);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    user.setUserid(rs.getInt("userID"));  
                    userID = String.valueOf(rs.getInt("userID"));
                    System.out.println("Value of USERID in getUID/LoginDAO is : "+String.valueOf(user.getUserid()));
                    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Value of USERID in getUID/LoginDAO is : "+userID);
            System.out.println("Value of USERID in getUID/LoginDAO is : "+String.valueOf(user.getUserid()));
            return String.valueOf(user.getUserid());
        
        
        
        }



}
    
