/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thruster.dao.SubCategoriesDao;
//import thruster.dao.UserDao;
import thruster.models.SubCategories;

/**
 *
 * @author Hashan Maduwantha
 */
public class SubCategoriesController extends HttpServlet {

    
    
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "Categories/subCategoriesInsert.jsp";
    private static String LIST_USER = "Categories/listsubCategories.jsp";
    private SubCategoriesDao SubCategoriesDao;

    public SubCategoriesController() {
        super();
        SubCategoriesDao = new SubCategoriesDao();
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
            out.println("<title>Servlet SubCategoriesController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubCategoriesController at " + request.getContextPath() + "</h1>");
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
       
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int subcatID = Integer.parseInt(request.getParameter("subcatID"));
            SubCategoriesDao.deleteSubCategories(subcatID);
            forward = LIST_USER;
            request.setAttribute("subcategories", SubCategoriesDao.getAllsubCategories());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int subcatID = Integer.parseInt(request.getParameter("subcatID"));
            SubCategories subCat = SubCategoriesDao.getsubcatID(subcatID);
            request.setAttribute("subcategories", subCat);
        } else if (action.equalsIgnoreCase("listsubCategories")){
            forward = LIST_USER;
            request.setAttribute("subcategories", SubCategoriesDao.getAllsubCategories());
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SubCategories subcat = new SubCategories();
        subcat.setsubcatID( Integer.parseInt(request.getParameter("subcatID")));
        subcat.setsubcatName(request.getParameter("subcatName"));
        subcat.setcatID(request.getParameter("catID"));
        
//        try {
//            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dateOfBirth"));
//            user.setDateOfBirth(dob);
//            Date createdDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("createdDate"));
//            user.setCreatedDate(createdDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
////        }
        //user.setEmail(request.getParameter("email"));
        String subcatID = request.getParameter("subcatID");
        if(subcatID == null || subcatID.isEmpty())
        {
            SubCategoriesDao.addSubCategories(subcat);
        }
        else
        {
            subcat.setsubcatID(Integer.parseInt(subcatID));
            SubCategoriesDao.updateSubCategories(subcat);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("subcategories", SubCategoriesDao.getAllsubCategories());
        view.forward(request, response);
    }
    
     @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   


