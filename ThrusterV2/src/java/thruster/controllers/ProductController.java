/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thruster.dao.CategoriesDao;
import thruster.dao.ProductDao;
import thruster.dao.ProductInformationDao;
import thruster.dao.Product_SubcategoriesDao;
import thruster.models.Product;

/**
 *
 * @author Ikhwan
 */
public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "Product/product.jsp";
    private static String LIST_PRODUCTS = "Admin/admin.jsp";
    private static String VIEW_PRODUCTS = "Admin/admin.jsp";
    private ProductDao dao;
    private ProductInformationDao dao2;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public ProductController() {
        super();
        dao = new ProductDao();
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
       // processRequest(request, response);
       
       String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int productID = Integer.parseInt(request.getParameter("productID"));
            dao.deleteProduct(productID);
            forward = LIST_PRODUCTS;
            request.setAttribute("allProductInfo", dao2.getAllProductInformation());   
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int productID = Integer.parseInt(request.getParameter("productID"));
            Product product = dao.getProductById(productID);
            
            request.setAttribute("allProductInfo", dao2.getAllProductInformation());
        } else if (action.equalsIgnoreCase("listProduct")){
            forward = LIST_PRODUCTS;
            request.setAttribute("products", dao.getAllProducts());
        }
        
        
        // TOGGLES THE VISIBILITY
        else if(action.equalsIgnoreCase("listProducts")){
            
            int visibility;
            int productID;
            
           forward = LIST_PRODUCTS;
            request.setAttribute("products", dao.getAllProducts());
        // TOGGLES THE INSTOCK     
        }else if(action.equalsIgnoreCase("listProducts")){
            
            int inStock;
            int productID;
            
            forward = LIST_PRODUCTS;
            request.setAttribute("products", dao.getAllProducts());
            
        } 
//        else if (action.equalsIgnoreCase("searchProducts")){
//            forward = SEARCH_PRODUCTS;
//            Product_SubcategoriesDao catDao= new Product_SubcategoriesDao();
//            request.setAttribute("productCategories", catDao.getAllExistingSubCategoriesByCategoryID());
//            
//        }
        else {
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
        
        Product product = new Product();
        
        product.setProductName(request.getParameter("productName"));
        product.setProductDescription(request.getParameter("productDescription"));
        product.setInStock(Integer.parseInt(request.getParameter("inStock")));
        System.out.println("Last Edited in Controller :  " + product);
        try {
            Date createdDate = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("createdDate"));
            product.setCreatedDate(createdDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
             Date lastEdited = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("lastEdited"));
            product.setLastEdited(lastEdited);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String productID = request.getParameter("productID");
        System.out.println(productID);
        if(productID == null || productID.isEmpty())
        {
            dao.addProduct(product);
        }
        else
        {
            product.setProductID(Integer.parseInt(productID));
            dao.updateProduct(product);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCTS);
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
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

