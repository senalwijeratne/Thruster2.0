/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.servlets;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author ASUS
 */
public class encryption {

    public encryption() {
    }
    
    
     public String encrypting(String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
     MessageDigest md = MessageDigest.getInstance("MD5");
     md.update(password.getBytes());
     byte[] b = md.digest();
     StringBuffer sb = new StringBuffer();
     for (byte b1 :b){
         sb.append(Integer.toHexString( b1 & 0xff).toString());
     }
     String hash = sb.toString();

    return hash;
    }

   public String Salt (){
       String userSalt = "her";
       return userSalt;
   }
}
