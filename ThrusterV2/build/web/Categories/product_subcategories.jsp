<%-- 
    Document   : product_subcategories
    Created on : May 1, 2017, 8:26:18 PM
    Author     : Senal
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add New Product Categories</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

    <form method="POST" action='Product_SubcategoriesController' name="frmAddProduct_Subcategories">
        Subcategories_subcatID : <input type="text" readonly="readonly" name="Subcategories_subcatID"
            value="<c:out value="${Product_Subcategories.Subcategories_subcatID}" />" /> <br /> 
        Products_productID : <input
            type="text" name="Products_productID"
            value="<c:out value="${Product_Subcategories.Products_productID}" />" /> <br /> 
        </form>
</body>
</html>