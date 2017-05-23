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
public class ProductInformationDao {
    
    private Connection connection;

    public ProductInformationDao() {
        
        connection = DBConnection.dbconnect();
        
    }

   
    
    
    
    public List<Product_Information> getAllExistingSubCategoriesWhereCatIDGroupedBySubCategoryID(int catID) {
        List<Product_Information> productSubCatInfo = new ArrayList<Product_Information>();
       System.out.println("subcatID in SQL call is : " + catID);
        try {
            PreparedStatement preparedStatement = connection.
            prepareStatement("select * from product_information where catID=? Group by subcatid");
            
            preparedStatement.setInt(1, catID);
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
                
                product_information.setSubcatName(rs.getString("subcatName"));
                
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
    
    
    public List<Product_Information> getAllProductInformationGroupedByCatID() {
        List<Product_Information> productSubCatInfo = new ArrayList<Product_Information>();
        try {
            PreparedStatement preparedStatement = connection.
            prepareStatement("select * from product_information group by catID");
            
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
                
                 product_information.setSubcatName(rs.getString("subcatName"));
                
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
    public List<Product_Information> getAllProductInformation() {
        List<Product_Information> productSubCatInfo = new ArrayList<Product_Information>();
        try {
            PreparedStatement preparedStatement = connection.
            prepareStatement("select * from product_information");
            
            
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
                
                product_information.setSubcatName(rs.getString("subcatName"));
                
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
    public List<Product_Information> getSearchResults(String searchKey, int catSelected, int subcatSelected, int priceFloor, int priceCeiling) {
        
       
        
        // Putting in the wildcards into searchKey
        int[] arr = new int[23];
        
        int max = ((searchKey.length())*2)+1;
        char[] breakItDown = new char[max]; 
        breakItDown[0]='%';
        int j = 0;
        for(int i = 1; i<max; i=i+2){
             
             breakItDown[i]=searchKey.charAt(j);
             breakItDown[i+1]='%'; 
             j++;
        }
        String wildSearchKey =  String.valueOf(breakItDown);
        System.out.println(wildSearchKey);
        
        
        // Check for Nulls
        // or not?
        // no wait I need it.
        
        String query = "Select * from product_information ";
        // If category is selected 
        if(catSelected != 0){           
            query =  query + " where catID = "+catSelected;      
        }
        
        // SubCategory stuff
        if(catSelected !=0 && subcatSelected !=0){          
            query =  query + " AND subcatID = "+subcatSelected;
        
        }else if (subcatSelected != 0){
            query =  query + " where subcatID = "+subcatSelected;
            
        }
        
        // priceFloor & ceiling
        
        if(priceFloor != 0){           
            query =  query + " AND   productPrice >= "+priceFloor;      
        }
        
        if(priceCeiling != 0){           
            query =  query + " AND   productPrice <= "+priceCeiling;      
        }
        
        // SubCategory stuff
        if(catSelected !=0 && subcatSelected !=0){          
            query =  query + " AND  productName LIKE '"+wildSearchKey +"'";
        
        }else if (subcatSelected != 0){
            query =  query + " where productName LIKE '"+wildSearchKey +"'";
            
        }
        System.out.println("query : " + query);
        // building the query   
        
        // select* from product_information where 
        
        
        List<Product_Information> productSubCatInfo = new ArrayList<Product_Information>();
        try {
            PreparedStatement preparedStatement = connection.
            prepareStatement(query);
            
            
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
                
                System.out.println("Result : "+rs.getString("productName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productSubCatInfo;
    }
    
    
}
