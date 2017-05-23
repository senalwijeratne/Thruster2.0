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
import thruster.models.SubCategories;

/**
 *
 * @author Hashan Maduwantha
 */
public class SubCategoriesDao {
    
private Connection connection;
    
    public SubCategoriesDao(){
        
        connection = DBConnection.dbconnect();
    
    }

     public void addSubCategories(SubCategories subCategories) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into subcategories("
                            + "subcatID,"
                            + "subcatName,"
                            + "catID,"
                            
                            + "values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, subCategories.getsubcatID());
            preparedStatement.setString(2, subCategories.getsubcatName());
            preparedStatement.setString(3, subCategories.getcatID());

            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSubCategories(int subcatID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from subcategories where subcatID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, subcatID);
        
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSubCategories(SubCategories subCategories) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update subcategories set "
                            + "subcatID=?, "
                            + "subcatName=?, "
                            + "catID=?, "
                            
                            + "where subcatID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, subCategories.getsubcatID());
            preparedStatement.setString(2, subCategories.getsubcatName());
            preparedStatement.setString(3, subCategories.getcatID());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SubCategories> getAllsubCategories() {
        List<SubCategories> subCategories = new ArrayList<SubCategories>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from subCategories");
            while (rs.next()) {
                SubCategories subCat = new SubCategories();
                subCat.setsubcatID(rs.getInt("subcatID"));
                subCat.setsubcatName(rs.getString("subcatName"));
                subCat.setcatID(rs.getString("catID"));
                
                subCategories.add(subCat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subCategories;
    }

    public SubCategories getsubcatID(int subcatID) {
        SubCategories subCat = new SubCategories();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from subCategories where subcatID=?");
            preparedStatement.setInt(1, subcatID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                subCat.setsubcatID(rs.getInt("subcatID"));
                subCat.setsubcatName(rs.getString("subcatName"));
                subCat.setcatID(rs.getString("catID"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subCat;
    }
    
    
    public List<Product_Information> getAllSubCategoriesByCategoryID(int SubCatID) {
        List<Product_Information> productSubCatInfo = new ArrayList<Product_Information>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `product_information` where categoryID = ? GROUP BY subcatName");
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
