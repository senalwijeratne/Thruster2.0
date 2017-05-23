/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import thruster.models.DBConnection;
import thruster.models.User;

public class UserDao {
    private Connection connection;
    
    public UserDao(){
        
        connection = DBConnection.dbconnect();
    
    }

     public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into users("
                            + "firstName,"
                            + "middleName,"
                            + "lastName,"
                            + "addressLine1,"
                            + "addressLine2,"
                            + "addressLine3,"
                            + "email,"
                            + "salt,"
                            + "saltedpw,"
                            + "dateOfBirth,"
                            + "mobileNo,"
                            + "homeNo,"
                            + "createdDate)"
                            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getMiddleName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getAddressLine1());
            preparedStatement.setString(5, user.getAddressLine2());
            preparedStatement.setString(6, user.getAddressLine3());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getSalt());
            preparedStatement.setString(9, user.getSaltedpw());
            preparedStatement.setDate(10, new java.sql.Date(user.getDateOfBirth().getTime()));
            preparedStatement.setString(11, user.getMobileNo());
            preparedStatement.setString(12, user.getHomeNo());
            preparedStatement.setDate(13, new java.sql.Date(user.getCreatedDate().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where userid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set "
                            + "firstName=?, "
                            + "middleName=?, "
                            + "lastName=?, "
                            + "addressLine1=?, "
                            + "addressLine2=?, "
                            + "addressLine3=?, "
                            + "email=?, "
                            + "salt=?, "
                            + "saltedpw=?, "
                            + "dateOfBirth=?, "
                            + "mobileNo=?, "
                            + "homeNo=?, "
                            + "createdDate?, "
                            + "where userid=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getMiddleName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getAddressLine1());
            preparedStatement.setString(5, user.getAddressLine3());
            preparedStatement.setString(6, user.getAddressLine3());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getSalt());
            preparedStatement.setString(9, user.getSaltedpw());
            preparedStatement.setDate(10, new java.sql.Date(user.getDateOfBirth().getTime()));
            preparedStatement.setString(11, user.getMobileNo());
            preparedStatement.setString(12, user.getHomeNo());
            preparedStatement.setDate(13, new java.sql.Date(user.getCreatedDate().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setUserid(rs.getInt("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setMiddleName(rs.getString("middlename"));
                user.setLastName(rs.getString("lastname"));
                user.setAddressLine1(rs.getString("addressline1"));
                user.setAddressLine2(rs.getString("addressline2"));
                user.setAddressLine3(rs.getString("addressline3"));
                user.setEmail(rs.getString("email"));
                user.setSalt(rs.getString("salt"));
                user.setSaltedpw(rs.getString("saltedpw"));
                user.setDateOfBirth(rs.getDate("dateOfBirth"));
                user.setMobileNo(rs.getString("mobileNo"));
                user.setHomeNo(rs.getString("homeNo"));
                user.setCreatedDate(rs.getDate("createddate"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User getUserById(int userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setUserid(rs.getInt("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setMiddleName(rs.getString("middlename"));
                user.setLastName(rs.getString("lastname"));
                user.setAddressLine1(rs.getString("addressline1"));
                user.setAddressLine2(rs.getString("addressline2"));
                user.setAddressLine3(rs.getString("addressline3"));
                user.setEmail(rs.getString("email"));
                user.setSalt(rs.getString("salt"));
                user.setSaltedpw(rs.getString("saltedpw"));
                user.setDateOfBirth(rs.getDate("dateOfBirth"));
                user.setMobileNo(rs.getString("mobileNo"));
                user.setHomeNo(rs.getString("homeNo"));
                user.setCreatedDate(rs.getDate("createddate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}