/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import thruster.models.DBConnection;
import thruster.models.Purchases;
/**
 *
 * @author Senal
 */
public class PurchasesDao {
    
    private Connection connection;

    public PurchasesDao() {
        
        connection = DBConnection.dbconnect();
        
    }
    
    public void addPurchases(Purchases purchases) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into purchases(purchaseID,date,userID) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, purchases.getPurchaseID());
            preparedStatement.setDate(2, (Date) purchases.getDate());
            preparedStatement.setInt(3, purchases.getUserID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePurchases(int purchaseID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from purchases where purchaseID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, purchaseID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePurchases(Purchases purchases) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update purchases set date=?, userID=?" +
                            "where purchaseID=?");
            // Parameters start with 1
            preparedStatement.setDate(1, (Date) purchases.getDate());
            preparedStatement.setInt(2, purchases.getUserID());
            preparedStatement.setInt(3, purchases.getPurchaseID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Purchases> getAllPurchases() {
        List<Purchases> purchase = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from purchases");
            while (rs.next()) {
                Purchases purchases = new Purchases();
                purchases.setPurchaseID(rs.getInt("purchaseID"));
                purchases.setDate(rs.getDate("date"));
                purchases.setUserID(rs.getInt("userID"));
                purchase.add(purchases);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchase;
    }
    
    public Purchases getPurchasesById(int purchaseID) {
        Purchases purchases = new Purchases();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from purchases where purchaseID=?");
            preparedStatement.setInt(1, purchaseID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                purchases.setPurchaseID(rs.getInt("purchaseID"));
                purchases.setDate(rs.getDate("date"));
                purchases.setUserID(rs.getInt("userID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchases;
    }
    
}
