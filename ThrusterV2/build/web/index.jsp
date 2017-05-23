<%-- 
    Document   : index
    Created on : May 1, 2017, 8:02:37 AM
    Author     : Ikhwan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP HomePage</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href ="CategoriesController?action=listCategories"> List Categories</a>
        <a href ="CommentsController?action=listComments"> List Comments</a>
        <a href ="Login/login.jsp"> LogIn</a>
        <a href ="ProductController?action=listProduct"> List Products</a>
        <a href ="ProductInformationController?action=listProducts"> List All Products</a>
        <a href ="Product_SubcategoriesController?action=listProduct_Subcategories"> List Product subcategories</a>
        <a href ="Purchase_detailsController?action=listPurchase_details"> List purchase Details</a>
        <a href ="PurchasesController?action=listPurchases"> List Purchases</a>
        <a href ="ShoppingCartController?action=listProduct"> List Shopping Cart</a>
        <a href ="SubCategoriesController?action=listsubCategories"> List Sub_Categories</a>
        <a href ="UserController?action=listUser"> List Users</a>
        <a href ="ProductInformationController?action=searchProducts"> Search </a>
        <a href ="Login/registertest.html"> Register </a>
        
    </body>
</html>
