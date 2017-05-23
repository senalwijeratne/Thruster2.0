/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import thruster.models.DBConnection;
import thruster.models.Product;
import thruster.models.ShoppingCart;
import thruster.models.User;

/**
 *
 * @author ASUS
 */
public class ShoppingCartDao {
    private Connection connection;
    
    public ShoppingCartDao()
    {
        connection = DBConnection.dbconnect();
    }
        
     public void addToCart(ShoppingCart shoppingcart) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into cart("
                            + "userID,"
                            + "productID,"
                            + "qty)"                           
                            + "values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, shoppingcart.getUserid());
            preparedStatement.setInt(2, shoppingcart.getProductid());
            preparedStatement.setInt(3, shoppingcart.getQty());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     
      public void RemoveAllFromCart(ShoppingCart shoppingcart) {
          
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Cart where userid=?");
            // Parameters start with 1
            preparedStatement.setInt(1,shoppingcart.getUserid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     
      public void RemoveFromCart(ShoppingCart shoppingcart) {
          
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Cart where userid=? AND productID=?");
            // Parameters start with 1
            preparedStatement.setInt(1,shoppingcart.getUserid());
            preparedStatement.setInt(1,shoppingcart.getProductid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
