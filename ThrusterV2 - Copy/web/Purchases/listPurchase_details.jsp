<%-- 
    Document   : listPurchase_details
    Created on : May 2, 2017, 5:01:08 AM
    Author     : Senal
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Purchases Details</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Purchase ID</th>
                <th>Product ID</th>
                <th>Qty</th>
                <th>Price</th>
                <th>Discount</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${purchase_details}" var="purchase_detail">
                <tr>
                    <td><c:out value="${purchase_detail.purchaseID}" /></td>
                    <td><c:out value="${purchase_detail.productID}" /></td>
                    <td><c:out value="${purchase_detail.qty}" /></td>
                    <td><c:out value="${purchase_detail.price}" /></td>
                    <td><c:out value="${purchase_detail.discount}" /></td>
                    <td><a href="Purchase_detailsController?action=edit&purchaseID=<c:out value="${purchase_detail.purchaseID}"/>">Update</a></td>
                    <td><a href="Purchase_detailsController?action=delete&purchaseID=<c:out value="${purchase_detail.purchaseID}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="Purchase_detailsController?action=insert">Add Category</a></p>
</body>
</html>