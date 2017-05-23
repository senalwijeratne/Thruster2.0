<%-- 
    Document   : productSearch
    Created on : Apr 30, 2017, 10:51:56 AM
    Author     : Ikhwan
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
            <c:forEach items="${searchResults}" var="results">
                <tr>
                    <td><c:out value="${results.productID}" /></td>
                    <td><c:out value="${results.productName}" /></td>
                    <td><c:out value="${results.productDescription}" /></td>
                    <td><c:out value="${results.productPrice}" /></td>
                    <td><c:out value="${results.inStock}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${results.createdDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${results.lastEdited}" /></td>
                    <td><a href="ProductController?action=edit&productID=<c:out value="${results.productID}"/>">Update</a></td>
                    <td><a href="ProductController?action=delete&productID=<c:out value="${results.productID}"/>">Delete</a></td>
                      
                </tr>
            </c:forEach>
        </tbody>
    </table>

