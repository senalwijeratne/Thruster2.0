<%-- 
    Document   : listCategories
    Created on : May 1, 2017, 10:29:30 AM
    Author     : Senal
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Categories</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Category ID</th>
                <th>Category Name</th>
                <th>Category Description</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td><c:out value="${category.catID}" /></td>
                    <td><c:out value="${category.catName}" /></td>
                    <td><c:out value="${category.catDescription}" /></td>
                    <td><a href="CategoriesController?action=edit&catID=<c:out value="${category.catID}"/>">Update</a></td>
                    <td><a href="CategoriesController?action=delete&catID=<c:out value="${category.catID}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="CategoriesController?action=insert">Add Category</a></p>
</body>
</html>