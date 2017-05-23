<%-- 
    Document   : listPurchases
    Created on : May 1, 2017, 3:33:10 PM
    Author     : Senal
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Purchases</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Purchase ID</th>
                <th>Purchase Date</th>
                <th>User ID</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${purchases}" var="purchase">
                <tr>
                    <td><c:out value="${purchase.purchaseID}" /></td>
                    <td><c:out value="${purchase.date}" /></td>
                    <td><c:out value="${purchase.userID}" /></td>
                    <td><a href="PurchasesController?action=edit&purchaseID=<c:out value="${purchase.purchaseID}"/>">Update</a></td>
                    <td><a href="PurchasesController?action=delete&purchaseID=<c:out value="${purchase.purchaseID}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="PurchasesController?action=insert">Add Category</a></p>
</body>
</html>