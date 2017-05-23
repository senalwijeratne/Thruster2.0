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
import thruster.models.Purchase_details;

/**
 *
 * @author Senal
 */
public class Purchase_detailsDao {
    
    private Connection connection;

    public Purchase_detailsDao() {
        
        connection = DBConnection.dbconnect();
        
    }
    
    public void addPurchase_details(Purchase_details purchase_details) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into purchase_details(purchaseID,productID,qty,price,discount) values (?, ?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, purchase_details.getPurchaseID());
            preparedStatement.setInt(2, purchase_details.getProductID());
            preparedStatement.setInt(3, purchase_details.getQty());
            preparedStatement.setDouble(4, purchase_details.getPrice());
            preparedStatement.setDouble(5, purchase_details.getDiscount());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePurchase_details(int purchaseID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Purchase_details where purchaseID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, purchaseID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePurchase_details(Purchase_details purchase_details) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update purchase_details set productID=?, qty=?,price=?,discount=?," +
                            "where purchaseID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, purchase_details.getProductID());
            preparedStatement.setInt(2, purchase_details.getQty());
            preparedStatement.setDouble(3, purchase_details.getPrice());
            preparedStatement.setDouble(4, purchase_details.getDiscount());
            preparedStatement.setInt(5, purchase_details.getPurchaseID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Purchase_details> getAllPurchase_details() {
        List<Purchase_details> Purchase_detail = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from purchase_details");
            while (rs.next()) {
                Purchase_details purchase_details = new Purchase_details();
                purchase_details.setPurchaseID(rs.getInt("purchaseID"));
                purchase_details.setProductID(rs.getInt("productID"));
                purchase_details.setQty(rs.getInt("qty"));
                purchase_details.setPrice(rs.getDouble("price"));
                purchase_details.setDiscount(rs.getDouble("discount"));
                Purchase_detail.add(purchase_details);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Purchase_detail;
    }
    
    public Purchase_details getPurchase_detailsById(int purchaseID) {
        Purchase_details purchase_detail = new Purchase_details();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from purchase_details where purchaseID=?");
            preparedStatement.setInt(1, purchaseID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                purchase_detail.setPurchaseID(rs.getInt("purchaseID"));
                purchase_detail.setProductID(rs.getInt("productID"));
                purchase_detail.setQty(rs.getInt("qty"));
                purchase_detail.setPrice(rs.getDouble("price"));
                purchase_detail.setDiscount(rs.getDouble("discount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchase_detail;
    }
    
}
