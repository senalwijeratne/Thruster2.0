/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Ikhwan
 */
public class Product_Information {
    
    private int productID;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int inStock;
    private Date createdDate ;
    private Date lastEdited;
    private int subcategories_subcatID;
    private int products_productID;
    private int subcatID;
    private String subcatName;
    private int catID;
    private int categoriescatID;
    private String catName;
    private String catDescription;
    
    
    
     public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    public int getSubcategories_subcatID() {
        return subcategories_subcatID;
    }

    public void setSubcategories_subcatID(int subcategories_subcatID) {
        this.subcategories_subcatID = subcategories_subcatID;
    }

    public int getProducts_productID() {
        return products_productID;
    }

    public void setProducts_productID(int products_productID) {
        this.products_productID = products_productID;
    }

    public int getSubcatID() {
        return subcatID;
    }

    public void setSubcatID(int subcatID) {
        this.subcatID = subcatID;
    }

    public String getSubcatName() {
        return subcatName;
    }

    public void setSubcatName(String subcatName) {
        this.subcatName = subcatName;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public int getCategoriescatID() {
        return categoriescatID;
    }

    public void setCategoriescatID(int categoriescatID) {
        this.categoriescatID = categoriescatID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }
    
    // Search Related Values
    private String searchCat;
    private String searchSubCat;
    private String searchKey;
    private BigDecimal searchPriceFloor;
    private BigDecimal searchCeiling;
    
    // Search Related Inputs

    public String getSearchCat() {
        return searchCat;
    }

    public void setSearchCat(String searchCat) {
        this.searchCat = searchCat;
    }

    public String getSearchSubCat() {
        return searchSubCat;
    }

    public void setSearchSubCat(String searchSubCat) {
        this.searchSubCat = searchSubCat;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public BigDecimal getSearchPriceFloor() {
        return searchPriceFloor;
    }

    public void setSearchPriceFloor(BigDecimal searchPriceFloor) {
        this.searchPriceFloor = searchPriceFloor;
    }

    public BigDecimal getSearchCeiling() {
        return searchCeiling;
    }

    public void setSearchCeiling(BigDecimal searchCeiling) {
        this.searchCeiling = searchCeiling;
    }
    
    
    
    
    @Override
    public String toString() {
        return    "Product_Information "
                  + "[productID=" + productID + 
                  ", productName=" + productName+ 
                  ", productDescription=" + productDescription+ 
                  ", productPrice=" + productPrice+ 
                  ", inStock=" + inStock+ 
                  ", createdDate=" + createdDate+ 
                  ", lastEdited=" + lastEdited+ 
                  ", subcategories_subcatID=" + subcategories_subcatID+ 
                  ", products_productID=" + products_productID+ 
                  ", subcatID=" + subcatID+ 
                  ", subcatName=" + subcatName+ 
                  ", catID=" + catID+ 
                  ", categoriescatID=" + categoriescatID+ 
                  ", catName=" + catName+
                  ", catDescription=" + catDescription + 
                

                    // Search Related Terms 
                
                  ", category=" + searchCat + 
                  ", subcategory=" + searchSubCat + 
                  ", searchKey=" + searchKey + 
                  ", priceFloor=" + searchPriceFloor + 
                  ", priceCeiling=" + searchCeiling + 
                
                
                
                "]";
                
                
    } 
    
    
}
