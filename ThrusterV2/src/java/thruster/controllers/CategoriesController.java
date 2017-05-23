/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thruster.dao.CategoriesDao;
import thruster.models.Categories;

/**
 *
 * @author Senal
 */
public class CategoriesController extends HttpServlet {

    
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "Categories/categories.jsp";
    private static String LIST_CATEGORIES = "Categories/listCategories.jsp";
    private CategoriesDao dao;

    public CategoriesController() {
        super();
        dao = new CategoriesDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int catID = Integer.parseInt(request.getParameter("catID"));
            dao.deleteCategories(catID);
            forward = LIST_CATEGORIES;
            request.setAttribute("categories", dao.getAllCategories());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int catID = Integer.parseInt(request.getParameter("catID"));
            Categories categories = dao.getCategoriesById(catID);
            request.setAttribute("categories", categories);
        } else if (action.equalsIgnoreCase("listCategories")){
            forward = LIST_CATEGORIES;
            request.setAttribute("categories", dao.getAllCategories());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Categories categories = new Categories();
        categories.setCatName(request.getParameter("catName"));
        categories.setCatDescription(request.getParameter("catDescription"));
        
        String catID = request.getParameter("catID");
        if(catID == null || catID.isEmpty())
        {
            dao.addCategories(categories);
        }
        else
        {
            categories.setCatID(Integer.parseInt(catID));
            dao.updateCategories(categories);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CATEGORIES);
        request.setAttribute("categories", dao.getAllCategories());
        view.forward(request, response);
    }
    
}