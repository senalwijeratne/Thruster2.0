/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.models;
import java.util.Date;


public class User {
    
    
    // PRODUCT MODEL 
    
    private int userid;
    private String firstName;
    private String middleName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String email;
    private String salt;
    private String password;
    private String saltedpw;
    private Date dateOfBirth;
    private String mobileNo;
    private String homeNo;
    private Date createdDate;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSaltedpw() {
        return saltedpw;
    }

    public void setSaltedpw(String saltedpw) {
        this.saltedpw = saltedpw;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(String homeNo) {
        this.homeNo = homeNo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
   
    @Override
    public String toString() {
        return "User [userid=" + userid + 
                ", firstName=" + firstName+ 
                ", middleName=" + middleName + 
                ", lastName=" + lastName + 
                ", addressLine1=" + addressLine1 + 
                ", addressLine2=" + addressLine2 +
                ", addressLine3=" + addressLine3 +
                ", email=" + email + 
                ", salt=" + salt + 
                ", saltedpw=" + saltedpw + 
                ", dateOfBirth=" + dateOfBirth + 
                ", mobileNo=" + mobileNo + 
                ", homeNo=" + homeNo + 
                ", createdDate="+ createdDate+ "]";
    } 
}
