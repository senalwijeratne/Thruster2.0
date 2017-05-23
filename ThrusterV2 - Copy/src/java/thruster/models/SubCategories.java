/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.models;

import java.util.Date;

/**
 *
 * @author Hashan Maduwantha
 */
public class SubCategories {
    

    private int subcatID;
    private String subcatName;
    private String catID;
    

    public int getsubcatID() {
        return subcatID;
    }

    public void setsubcatID(int userisubcatID) {
        this.subcatID = subcatID;
    }

    public String getsubcatName() {
        return subcatName;
    }

    public void setsubcatName(String subcatName) {
        this.subcatName = subcatName;
    }

    public String getcatID() {
        return catID;
    }

    public void setcatID(String catID) {
        this.catID = catID;
    }

    
   
    @Override
    public String toString() {
        return    "subcategories "
                  + "[subcatID=" + subcatID + 
                  ", subcatName=" + subcatName+ 
                  ", catID=" + catID + "]";
                
                
    } 
}