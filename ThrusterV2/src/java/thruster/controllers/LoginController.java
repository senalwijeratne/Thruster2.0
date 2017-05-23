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
import java.sql.SQLException;
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
import javax.servlet.http.HttpSession;
import thruster.dao.UserDao;
import thruster.servlets.encryption;
import thruster.models.User;
import thruster.dao.LoginDao;


/**
 *
 * @author Rimzan
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            User user = new User();
            LoginDao p =new LoginDao();
            
            user.setEmail(request.getParameter("email"));
            String password = request.getParameter("password");
            
            encryption enc = new encryption();
            
            
            String passEnc = enc.encrypting(password);
            String salt = enc.Salt();
            String fullPassword = passEnc+salt;
            user.setSaltedpw(fullPassword);
            
            LoginDao dao = new LoginDao();
            String result = dao.loginAuth(user);
            if(result.equals("success"))
            {   
                //session creation ///
                //String userID = dao.getUid(request.getParameter("email"), password);
                HttpSession session = request.getSession();
                String email = user.getEmail();
                String password2 = fullPassword;
                
//                System.out.println("The Email inside login controller is : "+email);
//                System.out.println("The Password inside login controller is : "+password2);

                String stringID = p.getUid(email,password2);
                System.out.println("result of UID in LOGINController : "+stringID);
                session.setAttribute("userid",stringID);
                System.out.println("test");
                System.out.println(session.getAttribute("userid"));
                /////to be used anywhere///
//                String uID = session.getAttribute(userID);
                /////////////////////////////////
                
                if(email.equals("admin@gmail.com")){
                    getServletContext().getRequestDispatcher("../Admin/admin.jsp").forward(request,response);
                }else{
                
                getServletContext().getRequestDispatcher("/Success.jsp").forward(request,response);
//                response.sendRedirect("Success.jsp");
                }
            }
            
            else{
                response.sendRedirect("tryagain.jsp");
            }
                
            
            
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
