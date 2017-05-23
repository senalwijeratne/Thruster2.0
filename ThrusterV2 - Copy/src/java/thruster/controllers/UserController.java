
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thruster.dao.UserDao;
import thruster.servlets.encryption;
import thruster.models.User;

/**
 *
 * @author Ikhwan
 */
public class UserController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "user.jsp";
    private static String LIST_USER = "listUser.jsp";
    private UserDao dao;

    public UserController() {
        super();
        dao = new UserDao();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserControllers</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserControllers at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = new User();
            user.setFirstName(request.getParameter("firstName"));
            user.setMiddleName(request.getParameter("middleName"));
            user.setLastName(request.getParameter("lastName"));
            user.setAddressLine1(request.getParameter("addressLine1"));
            user.setAddressLine2(request.getParameter("addressLine2"));
            user.setAddressLine3(request.getParameter("addressLine3"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            //Encryption//
            encryption enc = new encryption();
            String encPassword = enc.encrypting(user.getPassword());
            String salt = enc.Salt();
            String passAndSalt = encPassword+salt;
            //////////////
            user.setSalt(salt);
            user.setSaltedpw(passAndSalt);
            user.setMobileNo(request.getParameter("mobileNo"));
            user.setHomeNo(request.getParameter("homeNo"));
            try {
                Date dob = new SimpleDateFormat("MM-dd-yyyy").parse(request.getParameter("dateOfBirth"));
                user.setDateOfBirth(dob);
                
                Date createdDate = new Date();
                user.setCreatedDate(createdDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setEmail(request.getParameter("email"));
            String userid = request.getParameter("userid");
            System.out.println(user);
            if(userid == null || userid.isEmpty())
            {
                System.out.println(user);
                dao.addUser(user);
            }
            else
            {
                user.setUserid(Integer.parseInt(userid));
                dao.updateUser(user);
            }
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            request.setAttribute("users", dao.getAllUsers());
            view.forward(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}