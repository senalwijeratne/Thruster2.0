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
public class Product {
    
     // PRODUCT MODEL 
    
    private int productID;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int inStock;
    private Date createdDate;
    private Date lastEdited;

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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
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

    public void setLastEdited(Date editedDate) {
        this.lastEdited = editedDate;
    }
    
    public String toString() {
        return "Product [ productID=" + productID + 
                       ", productName=" + productName+ 
                       ", productDescription=" + productDescription + 
                       ", inStock=" + inStock + 
                       ", createdDate=" + createdDate + 
                       ", editedDate="+ lastEdited + "]";
    }
    
    
    
}
