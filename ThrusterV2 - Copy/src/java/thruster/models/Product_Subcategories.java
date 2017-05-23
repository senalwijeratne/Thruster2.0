/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.models;

/**
 *
 * @author Senal
 */
public class Product_Subcategories {
    
    private int  Subcategories_subcatID;
    private int  Products_productID;
    
    public int Product_Subcategories() {
        return Subcategories_subcatID;
    }

    public int getSubcategories_subcatID() {
        return Subcategories_subcatID;
    }

    public void setSubcategories_subcatID(int Subcategories_subcatID) {
        this.Subcategories_subcatID = Subcategories_subcatID;
    }

    public int getProducts_productID() {
        return Products_productID;
    }

    public void setProducts_productID(int Products_productID) {
        this.Products_productID = Products_productID;
    }

    @Override
    public String toString() {
        return "Product_Subcategories{" + "Subcategories_subcatID=" + Subcategories_subcatID + ", Products_productID=" + Products_productID + '}';
    }
    
    
    
}
