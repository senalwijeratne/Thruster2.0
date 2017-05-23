/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.models;

/**
 *
 * @author Ikhwan
 */
public class Cart_Information {


    int userID;
    int productID;
    int qty;
    int productName;
    int productDescription;
    int productPrice;
    int inStock;
    int subcatID;
    String subcatName;
    int catID;
    String catName;
    String catDescription;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getProductName() {
        return productName;
    }

    public void setProductName(int productName) {
        this.productName = productName;
    }

    public int getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(int productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
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
    
    
    @Override
    public String toString() {
        return "Cart_Information{" + 
                "userID=" + userID + 
                ",productID=" + productID + 
                ",qty=" + qty + 
                ",productName=" + productName + 
                ",productDescription=" + productDescription + 
                ",productPrice=" + productPrice + 
                ",inStock=" + inStock + 
                ",subcatID=" + subcatID + 
                ",subcatName=" + subcatName + 
                ",catID=" + catID + 
                ",catName=" + catName + 
                ", catDescription=" + catDescription + '}';
    }
    
    
    
}
