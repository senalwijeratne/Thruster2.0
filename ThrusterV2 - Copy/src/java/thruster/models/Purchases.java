/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.models;

import java.util.Date;


/**
 *
 * @author Senal
 */
public class Purchases {
    
    private int purchaseID;
    private Date date;
    private int userID;

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCatID() {
        return purchaseID;
    }

    @Override
    public String toString() {
        return "Purchases{" + "purchaseID=" + purchaseID + ", date=" + date + ", userID=" + userID + '}';
    }
    
}
