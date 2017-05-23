/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thruster.dao.CommentsDao;
import thruster.dao.Product_SubcategoriesDao;
import thruster.models.Comments;
import thruster.models.Product_Subcategories;

/**
 *
 * @author Senal
 */
public class Product_SubcategoriesController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "Product/product_subcategories.jsp";
    private static String LIST_PRODUCT_SUBCATEGORIES = "Product/listProduct_Subcategories.jsp";
    private static String SEARCH_SUBCAT = "Product/searchProduct.jsp";
    private Product_SubcategoriesDao dao;

    public Product_SubcategoriesController() {
        super();
        dao = new Product_SubcategoriesDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int Subcategories_subcatID = Integer.parseInt(request.getParameter("Subcategories_subcatID"));
            dao.deleteProduct_Subcategories(Subcategories_subcatID);
            forward = LIST_PRODUCT_SUBCATEGORIES;
            request.setAttribute("comments", dao.getAllProduct_Subcategories());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int Subcategories_subcatID = Integer.parseInt(request.getParameter("Subcategories_subcatID"));
            Product_Subcategories product_subcategories = dao.getProduct_SubcategoriesById(Subcategories_subcatID);
            request.setAttribute("Product_Subcategories", product_subcategories);
        } else if (action.equalsIgnoreCase("listProduct_Subcategories")){
            forward = LIST_PRODUCT_SUBCATEGORIES;
            System.out.println("Result of AllProducts:"+dao.getAllProduct_Subcategories());
            request.setAttribute("Product_Subcategories", dao.getAllProduct_Subcategories());
        }
//        else if (action.equalsIgnoreCase("searchSubCat")){
//            forward = SEARCH_SUBCAT;
//            request.setAttribute("Product_Subcategories", dao.getAllExistingSubCategoriesByCategoryID(request.getParameter("catID")));
//        } 
        else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product_Subcategories product_subcategories = new Product_Subcategories();
        product_subcategories.setProducts_productID(Integer.parseInt(request.getParameter("Products_productID")));
        

        String Subcategories_subcatID = request.getParameter("Subcategories_subcatID");
        if(Subcategories_subcatID == null || Subcategories_subcatID.isEmpty())
        {
            dao.addProduct_Subcategories(product_subcategories);
        }
        else
        {
            product_subcategories.setSubcategories_subcatID(Integer.parseInt(Subcategories_subcatID));
            dao.updateProduct_Subcategories(product_subcategories);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCT_SUBCATEGORIES);
        request.setAttribute("Product_Subcategories", dao.getAllProduct_Subcategories());
        view.forward(request, response);
    }

}
