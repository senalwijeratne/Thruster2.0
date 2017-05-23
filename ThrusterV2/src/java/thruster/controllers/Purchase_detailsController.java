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
import thruster.dao.Purchase_detailsDao;
import thruster.models.Purchase_details;

/**
 *
 * @author Senal
 */
public class Purchase_detailsController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "Purchases/purchase_details.jsp";
    private static String LIST_PURCHASES_DETAILS = "Purchases/listPurchase_details.jsp";
    private Purchase_detailsDao dao;

    public Purchase_detailsController() {
        super();
        dao = new Purchase_detailsDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int purchaseID = Integer.parseInt(request.getParameter("purchaseID"));
            dao.deletePurchase_details(purchaseID);
            forward = LIST_PURCHASES_DETAILS;
            request.setAttribute("purchase_details", dao.getAllPurchase_details());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int purchaseID = Integer.parseInt(request.getParameter("purchaseID"));
            Purchase_details purchase_details = dao.getPurchase_detailsById(purchaseID);
            request.setAttribute("purchase_details", purchase_details);
        } else if (action.equalsIgnoreCase("listPurchase_details")){
            forward = LIST_PURCHASES_DETAILS;
            request.setAttribute("purchase_details", dao.getAllPurchase_details());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Purchase_details purchase_details = new Purchase_details();
        
        purchase_details.setProductID(Integer.parseInt(request.getParameter("productID")));
        purchase_details.setQty(Integer.parseInt(request.getParameter("qty")));
        purchase_details.setPrice(Double.parseDouble(request.getParameter("price")));
        purchase_details.setDiscount(Double.parseDouble(request.getParameter("discount")));
        
        String purchaseID = request.getParameter("purchaseID");
        if(purchaseID == null || purchaseID.isEmpty())
        {
            dao.addPurchase_details(purchase_details);
        }
        else
        {
            purchase_details.setPurchaseID(Integer.parseInt(purchaseID));
            dao.updatePurchase_details(purchase_details);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PURCHASES_DETAILS);
        request.setAttribute("purchase_details", dao.getAllPurchase_details());
        view.forward(request, response);
    }

}
