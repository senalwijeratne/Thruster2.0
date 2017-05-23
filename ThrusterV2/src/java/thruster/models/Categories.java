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
public class Categories {
    
    private int catID;
    private String catName;
    private String catDescription;

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
    public int getUserid() {
        return catID;
    }
    
    @Override
    public String toString() {
        return "Categories{" + "catID=" + catID + ", catName=" + catName + ", catDescription=" + catDescription + '}';
    }
    
}
