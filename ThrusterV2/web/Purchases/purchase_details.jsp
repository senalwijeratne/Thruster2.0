<%-- 
    Document   : purchase_details
    Created on : May 2, 2017, 5:01:18 AM
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
<title>Add New Purchase Details</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

    <form method="POST" action='PurchaseController' name="frmAddPurchases">
        Purchase ID : <input type="text" readonly="readonly" name="purchaseID"
            value="<c:out value="${purchase_detail.purchaseID}" />" /> <br /> 
        Product ID : <input
            type="date" name="productID"
            value="<c:out value="${purchase_detail.productID}" />" /> <br /> 
        Qty : <input
            type="text" name="qty"
            value="<c:out value="${purchase_detail.qty}" />" /> <br />
        Price : <input
            type="text" name="price"
            value="<c:out value="${purchase_detail.price}" />" /> <br />
        Discount : <input
            type="text" name="discount"
            value="<c:out value="${purchase_detail.discount}" />" /> <br />
    </form>
</body>
</html>