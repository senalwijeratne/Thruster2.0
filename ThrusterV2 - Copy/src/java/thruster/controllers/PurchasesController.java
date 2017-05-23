/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thruster.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thruster.dao.PurchasesDao;
import thruster.models.Purchases;

/**
 *
 * @author Senal
 */
public class PurchasesController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "Purchases/purchases.jsp";
    private static String LIST_PURCHASES = "Purchases/listPurchases.jsp";
    private PurchasesDao dao;

    public PurchasesController() {
        super();
        dao = new PurchasesDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int purchaseID = Integer.parseInt(request.getParameter("purchaseID"));
            dao.deletePurchases(purchaseID);
            forward = LIST_PURCHASES;
            request.setAttribute("purchases", dao.getAllPurchases());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int purchaseID = Integer.parseInt(request.getParameter("purchaseID"));
            Purchases purchases = dao.getPurchasesById(purchaseID);
            request.setAttribute("purchases", purchases);
        } else if (action.equalsIgnoreCase("listPurchases")){
            forward = LIST_PURCHASES;
            request.setAttribute("purchases", dao.getAllPurchases());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Purchases purchases = new Purchases();
        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("date"));
            purchases.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        purchases.setUserID(Integer.parseInt(request.getParameter("userID")));
        
        String purchaseID = request.getParameter("purchaseID");
        if(purchaseID == null || purchaseID.isEmpty())
        {
            dao.addPurchases(purchases);
        }
        else
        {
            purchases.setPurchaseID(Integer.parseInt(purchaseID));
            dao.updatePurchases(purchases);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PURCHASES);
        request.setAttribute("purchases", dao.getAllPurchases());
        view.forward(request, response);
    }

}
