/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.models;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ShoppingCart {
    private int userid;
    private int productID;
    private int qty;
   

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProductid() {
        return userid;
    }

    public void setProductid(int productID) {
        this.productID = productID;
    }

       public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    

}
