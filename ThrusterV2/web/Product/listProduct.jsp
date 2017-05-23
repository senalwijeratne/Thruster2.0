<%-- 
    Document   : productSearch
    Created on : Apr 30, 2017, 10:51:56 AM
    Author     : Ikhwan
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Products</title>
</head>
<body>
    
    <table border=1>
        <thead>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Description</th>
                <th>Product In Stock</th>
                <th>Product Created Date</th>
                <th>Product Last Edited</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><c:out value="${product.productID}" /></td>
                    <td><c:out value="${product.productName}" /></td>
                    <td><c:out value="${product.productDescription}" /></td>
                    <td><c:out value="${product.productPrice}" /></td>
                    <td><c:out value="${product.inStock}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${product.createdDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${product.lastEdited}" /></td>
                    <td><a href="ProductController?action=edit&productID=<c:out value="${product.productID}"/>">Update</a></td>
                    <td><a href="ProductController?action=delete&productID=<c:out value="${product.productID}"/>">Delete</a></td>
                      
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ProductController?action=insert">Add Product</a></p>
</body>
</html>
