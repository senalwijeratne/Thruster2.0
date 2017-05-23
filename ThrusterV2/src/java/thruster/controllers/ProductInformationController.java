/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thruster.dao.CommentsDao;
import thruster.dao.ProductInformationDao;
import thruster.dao.Product_SubcategoriesDao;
import thruster.models.Comments;
import thruster.models.Product_Subcategories;

/**
 *
 * @author Senal
 */
public class ProductInformationController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String SEARCH_PRODUCTS = "Product/searchProduct.jsp";
    private static String SEARCH_SUBMIT = "Product/searchResults.jsp";
    private static String RETURN_SUBCATS = "Product/selectSubCat.jsp";
    private static String VIEW_PRODUCTS = "Admin/admin.jsp";
    private ProductInformationDao dao;

    public ProductInformationController() {
        super();
        dao = new ProductInformationDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        String catID = request.getParameter("catID");

        if (action.equalsIgnoreCase("searchProducts")){
            
            forward = SEARCH_PRODUCTS;
            request.setAttribute("allProductInfo", dao.getAllProductInformationGroupedByCatID());    
        } else if(action.equalsIgnoreCase("returnSubCat")) {
            forward = RETURN_SUBCATS;
            int selectedCat = Integer.parseInt(request.getParameter("selectedCat"));
            request.setAttribute("selectedCat", selectedCat);
            System.out.println(selectedCat);
             
            request.setAttribute("allSubCats",dao.getAllExistingSubCategoriesWhereCatIDGroupedBySubCategoryID(selectedCat)) ; 
        }else if(action.equalsIgnoreCase("searchSubmit")) {
            forward = SEARCH_SUBMIT;
            
            String searchKey =request.getParameter("searchKey");
            request.setAttribute("catSelected", searchKey);
            System.out.println(searchKey);
            
            int catSelected = Integer.parseInt(request.getParameter("catSelected"));
            request.setAttribute("catSelected", catSelected);
            System.out.println(catSelected);
            
            int subcatSelected = Integer.parseInt(request.getParameter("subcatSelected"));
            request.setAttribute("catSelected", subcatSelected);
            System.out.println(subcatSelected);
            
            int priceFloor = Integer.parseInt(request.getParameter("priceFloor"));
            request.setAttribute("catSelected", priceFloor);
            System.out.println(priceFloor);
            
            int priceCeiling = Integer.parseInt(request.getParameter("priceCeiling"));
            request.setAttribute("catSelected", priceCeiling);
            System.out.println(priceCeiling);
            
            
            request.setAttribute("searchResults",dao.getSearchResults(searchKey, catSelected, subcatSelected, priceFloor, priceCeiling)) ; 
        }else if(action.equalsIgnoreCase("listProducts")){
            
            forward = VIEW_PRODUCTS;
            request.setAttribute("allProductInfo", dao.getAllProductInformation());
        

        //TOGGLES THE VISIBILITY    
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             String forward=SEARCH_SUBMIT;
              
                
            String searchKey =request.getParameter("searchKey");
            request.setAttribute("catSelected", searchKey);
            System.out.println(searchKey);
            
            int catSelected = Integer.parseInt(request.getParameter("catSelected"));
            request.setAttribute("catSelected", catSelected);
            System.out.println(catSelected);
            
            int subcatSelected = Integer.parseInt(request.getParameter("subcatSelected"));
            request.setAttribute("catSelected", subcatSelected);
            System.out.println(subcatSelected);
            
            int priceFloor = Integer.parseInt(request.getParameter("priceFloor"));
            request.setAttribute("catSelected", priceFloor);
            System.out.println(priceFloor);
            
            int priceCeiling = Integer.parseInt(request.getParameter("priceCeiling"));
            request.setAttribute("catSelected", priceCeiling);
            System.out.println(priceCeiling);
            
            
            
            
            
            request.setAttribute("searchResults",dao.getSearchResults(searchKey, catSelected, subcatSelected, priceFloor, priceCeiling)) ; 
            
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
    }

}
