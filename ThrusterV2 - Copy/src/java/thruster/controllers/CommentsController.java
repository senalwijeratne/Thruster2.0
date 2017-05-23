/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thruster.dao.CommentsDao;
import thruster.models.Comments;

/**
 *
 * @author Senal
 */
public class CommentsController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "Product/comments.jsp";
    private static String LIST_COMMENTS = "Product/listComments.jsp";
    private CommentsDao dao;

    public CommentsController() {
        super();
        dao = new CommentsDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int commentID = Integer.parseInt(request.getParameter("commentID"));
            dao.deleteComments(commentID);
            forward = LIST_COMMENTS;
            request.setAttribute("comments", dao.getAllComments());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int commentID = Integer.parseInt(request.getParameter("commentID"));
            Comments comments = dao.getCommnetsById(commentID);
            request.setAttribute("comments", comments);
        } else if (action.equalsIgnoreCase("listComments")){
            forward = LIST_COMMENTS;
            request.setAttribute("comments", dao.getAllComments());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Comments comments = new Comments();
        comments.setUserID(Integer.parseInt(request.getParameter("userID")));
        comments.setProductID(Integer.parseInt(request.getParameter("productID")));
        comments.setTimestamp(Timestamp.valueOf(request.getParameter("timestamp")));
        comments.setComment(request.getParameter("comment"));
        

        String commnetID = request.getParameter("commnetID");
        if(commnetID == null || commnetID.isEmpty())
        {
            dao.addComments(comments);
        }
        else
        {
            comments.setCommentID(Integer.parseInt(commnetID));
            dao.updateComments(comments);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_COMMENTS);
        request.setAttribute("comments", dao.getAllComments());
        view.forward(request, response);
    }

}
