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
import thruster.models.Categories;
import thruster.models.DBConnection;
import thruster.models.Product_Information;

/**
 *
 * @author Senal
 */
public class CategoriesDao {
    
    private Connection connection;

    public CategoriesDao() {
        
        connection = DBConnection.dbconnect();
        
    }
    
    public void addCategories(Categories categories) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into categories(catID,catName,catDescription) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, categories.getCatID());
            preparedStatement.setString(2, categories.getCatName());
            preparedStatement.setString(3, categories.getCatDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCategories(int catID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from categories where userid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, catID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateCategories(Categories categories) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update categories set CatName=?, CatDescription=?" +
                            "where userid=?");
            // Parameters start with 1
            preparedStatement.setString(1, categories.getCatName());
            preparedStatement.setString(2, categories.getCatDescription());
            preparedStatement.setInt(3, categories.getCatID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Categories> getAllCategories() {
        List<Categories> category = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from categories");
            while (rs.next()) {
                Categories categories = new Categories();
                categories.setCatID(rs.getInt("catID"));
                categories.setCatName(rs.getString("catName"));
                categories.setCatDescription(rs.getString("catDescription"));
                category.add(categories);
                System.out.println(rs.getInt("catID"));
                System.out.println(rs.getString("catName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }
    
    public Categories getCategoriesById(int catID) {
        Categories category = new Categories();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from categories where catID=?");
            preparedStatement.setInt(1, catID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                category.setCatID(rs.getInt("catID"));
                category.setCatName(rs.getString("catName"));
                category.setCatDescription(rs.getString("catDescription"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }
    
    public List<Product_Information> getAllExistingCategories() {
        List<Product_Information> productCatInfo = new ArrayList<Product_Information>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `product_information` GROUP BY catName");
            while (rs.next()) {
                Product_Information product_information = new Product_Information();
                       
                product_information.setProductID(rs.getInt("productID"));
                product_information.setProductName(rs.getString("productName"));
                product_information.setProductDescription(rs.getString("productDescription"));
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
                
                
                
                
                productCatInfo.add(product_information);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productCatInfo;
    }
    
}
