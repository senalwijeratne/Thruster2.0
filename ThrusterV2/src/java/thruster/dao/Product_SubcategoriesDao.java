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
import thruster.models.Product_Information;
import thruster.models.Product_Subcategories;

/**
 *
 * @author Senal
 */
public class Product_SubcategoriesDao {
    
    private Connection connection;

    public Product_SubcategoriesDao() {
        
        connection = DBConnection.dbconnect();
        
    }
    
    public void addProduct_Subcategories(Product_Subcategories product_Subcategories) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Product_Subcategories(Subcategories_subcatID,Products_productID) values (?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, product_Subcategories.getSubcategories_subcatID());
            preparedStatement.setInt(2, product_Subcategories.getProducts_productID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteProduct_Subcategories(int Subcategories_subcatID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Product_Subcategories where Subcategories_subcatID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, Subcategories_subcatID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateProduct_Subcategories(Product_Subcategories product_subcategories) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update Product_Subcategories set Products_productID=?" +
                            "where Subcategories_subcatID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, product_subcategories.getProducts_productID());
            preparedStatement.setInt(2, product_subcategories.getSubcategories_subcatID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Product_Subcategories> getAllProduct_Subcategories() {
        List<Product_Subcategories> Product_Subcategory = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Product_Subcategories");
            while (rs.next()) {
                Product_Subcategories product_subcategories = new Product_Subcategories();
                product_subcategories.setSubcategories_subcatID(rs.getInt("Subcategories_subcatID"));
                product_subcategories.setProducts_productID(rs.getInt("Products_productID"));
                Product_Subcategory.add(product_subcategories);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Product_Subcategory;
    }
    
    public Product_Subcategories getProduct_SubcategoriesById(int Subcategories_subcatID) {
        Product_Subcategories product_subcategories = new Product_Subcategories();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from product_subcategories where Subcategories_subcatID=?");
            preparedStatement.setInt(1, Subcategories_subcatID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                product_subcategories.setSubcategories_subcatID(rs.getInt("Subcategories_subcatID"));
                product_subcategories.setProducts_productID(rs.getInt("Products_productID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product_subcategories;
    }
//    try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from product_subcategories where Subcategories_subcatID=?");
//            preparedStatement.setInt(1, categoryID);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                product_subcategories.setSubcategories_subcatID(rs.getInt("Subcategories_subcatID"));
//                product_subcategories.setProducts_productID(rs.getInt("Products_productID"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
        //}
    
    public List<Product_Information> getAllExistingSubCategoriesByCategoryID(String subCatID) {
        List<Product_Information> productSubCatInfo = new ArrayList<Product_Information>();
        try {
            System.out.println(subCatID);
            PreparedStatement preparedStatement = connection.
            prepareStatement("select * from product_information where catID=? Group By Subcategories_subcatID");
            preparedStatement.setString(1, subCatID);
            // ISSUE HERE
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product_Information product_information = new Product_Information();
                       
                product_information.setProductID(rs.getInt("productID"));
                product_information.setProductName(rs.getString("productName"));
                product_information.setProductDescription(rs.getString("productDescription"));
                product_information.setProductPrice(rs.getBigDecimal("productPrice"));
                product_information.setInStock(rs.getInt("inStock"));
                product_information.setCreatedDate(rs.getDate("createdDate"));
                product_information.setLastEdited(rs.getDate("lastEdited"));
                
                product_information.setSubcategories_subcatID(rs.getInt("subcategories_subcatID"));
                product_information.setProducts_productID(rs.getInt("products_productID"));
                product_information.setSubcatID(rs.getInt("subcatID"));
                
                product_information.setProductDescription(rs.getString("subcatName"));
                
                product_information.setCatID(rs.getInt("catID"));
                product_information.setCategoriescatID(rs.getInt("categoriescatID"));
                
                product_information.setCatName(rs.getString("catName"));
                product_information.setCatDescription(rs.getString("catDescription"));
                
                productSubCatInfo.add(product_information);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productSubCatInfo;
    }
    
    
}
