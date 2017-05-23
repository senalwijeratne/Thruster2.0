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
import thruster.models.Product_Information;

/**
 *
 * @author Ikhwan
 */
public class ProductDao {
    
    private Connection connection;
    
    public ProductDao(){
        
        connection = DBConnection.dbconnect();
    
    }
    
    public void addProduct(Product product) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into products("
                            + "productName,"
                            + "productDescription,"
                            + "inStock,"
                            + "createdDate,"
                            + "lastEdited) "
                            + "values (?, ?, ?, ?, ?)");
            // Parameters start with 1
            System.out.println("Last Edited : "+product.getLastEdited());
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductDescription());
            preparedStatement.setString(3, String.valueOf(product.getInStock()));
            preparedStatement.setDate(4, new java.sql.Date(product.getCreatedDate().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(product.getLastEdited().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteProduct(int productId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from products where productid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
            System.out.println("Product Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateProduct(Product product) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update products set "
                            + "productName=?, "
                            + "productDescription=?, "
                            + "inStock=?, "
                            + "createdDate=?, "
                            + "lastEdited=?" +
                            "where productid=?");
            // Parameters start with 1
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductDescription());
            preparedStatement.setString(3, String.valueOf(product.getInStock()));
            preparedStatement.setDate(4, new java.sql.Date(product.getCreatedDate().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(product.getLastEdited().getTime()));
            preparedStatement.setString(6, String.valueOf(product.getProductID()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from products");
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setProductPrice(rs.getBigDecimal("productPrice"));
                product.setInStock(rs.getInt("inStock"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setCreatedDate(rs.getDate("createdDate"));
                product.setLastEdited(rs.getDate("lastEdited"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
    
     public Product getProductById(int productID) {
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from products where productid=?");
            preparedStatement.setInt(1, productID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setInStock(rs.getInt("inStock"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setCreatedDate(rs.getDate("createdDate"));
                product.setLastEdited(rs.getDate("lastEdited"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
     
     
     public void setInStock(int productID, int inStock) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update products set "
                            + "inStock=?, "
                            + "where productid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, inStock);
            preparedStatement.setInt(2, productID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     
    public void setVisibility(int productID, int inStock) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update products set "
                            + "visibility=?, "
                            + "where productid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, inStock);
            preparedStatement.setInt(2, productID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
