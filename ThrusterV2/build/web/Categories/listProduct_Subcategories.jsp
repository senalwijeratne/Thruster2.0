<%-- 
    Document   : listProduct_Subcategories
    Created on : May 1, 2017, 8:25:38 PM
    Author     : Senal
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Product-Sub-Categories</title>
</head>
<body>
    <c:out value="${ProductSubcategory.Subcategories_subcatID}" />
    <table border=1>
        <thead>
            <tr>
                <th>Sub-Categories_Sub-Cat ID</th>
                <th>Products_Product ID</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            
            <c:forEach items="${Product_Subcategories}" var="ProductSubcategory">
                <tr>
                    <td><c:out value="${ProductSubcategory.subcategories_subcatID}" /></td>
                    <td><c:out value="${ProductSubcategory.products_productID}" /></td>
                    <td><a href="Product_SubcategoriesController?action=edit&Subcategories_subcatID=<c:out value="${ProductSubcategory.subcategories_subcatID}" />">Update</a></td>
                    <td><a href="Product_SubcategoriesController?action=delete&Subcategories_subcatID=<c:out value="${ProductSubcategory.subcategories_subcatID}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="Product_SubcategoriesController?action=insert">Add Category</a></p>
</body>
</html>
