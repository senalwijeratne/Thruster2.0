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
import thruster.models.Comments;
import thruster.models.DBConnection;

/**
 *
 * @author Senal
 */
public class CommentsDao {
    
    private Connection connection;

    public CommentsDao() {
        
        connection = DBConnection.dbconnect();
        
    }
    
    public void addComments(Comments comments) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into comments(commentsID,userID,productID,datetime,comment) values (?, ?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, comments.getCommentID());
            preparedStatement.setInt(2, comments.getUserID());
            preparedStatement.setInt(3, comments.getProductID());
            preparedStatement.setTimestamp(4, comments.getTimestamp());
            preparedStatement.setString(5, comments.getComment());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteComments(int commentID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from comments where commentID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, commentID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateComments(Comments comments) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update comments set userID=?, productID=?, datetime=?, comment=?" +
                            "where commentID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, comments.getUserID());
            preparedStatement.setInt(2, comments.getProductID());
            preparedStatement.setTimestamp(3, comments.getTimestamp());
            preparedStatement.setString(4, comments.getComment());
            preparedStatement.setInt(5, comments.getCommentID());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Comments> getAllComments() {
        List<Comments> comment = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from comments");
            while (rs.next()) {
                Comments comments = new Comments();
                comments.setCommentID(rs.getInt("commentID"));
                comments.setUserID(rs.getInt("userID"));
                comments.setProductID(rs.getInt("productID"));
                comments.setTimestamp(rs.getTimestamp("timestamp"));
                comments.setComment(rs.getString("comment"));
                comment.add(comments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comment;
    }
    
    public Comments getCommnetsById(int commnetID) {
        Comments comments = new Comments();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from comments where commnetID=?");
            preparedStatement.setInt(1, commnetID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                comments.setCommentID(rs.getInt("commentID"));
                comments.setUserID(rs.getInt("userID"));
                comments.setProductID(rs.getInt("productID"));
                comments.setTimestamp(rs.getTimestamp("timestamp"));
                comments.setComment(rs.getString("comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }
    
}
