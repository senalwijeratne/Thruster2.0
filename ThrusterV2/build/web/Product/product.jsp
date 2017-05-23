<%-- 
    Document   : product
    Created on : May 1, 2017, 10:31:49 AM
    Author     : Ikhwan
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new user</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>
    
    <form method="POST" action='ProductController' name="frmAddProduct">
          Product ID : <input
            type="text" name="productID"    
            value="<c:out value="${product.productID}" />" /> <br /> 
        
        Product Name : <input
            type="text" name="productName"    
            value="<c:out value="${product.productName}" />" /> <br /> 
        
        Product Description : <input
            type="text" name="productDescription"
            value="<c:out value="${product.productDescription}" />" /> <br /> 

        Product in Stock : <input
            type="text" name="inStock"
            value="<c:out value="${product.inStock}" />" /> <br /> 
        
        created Date : <input
            type="text" name="createdDate"
            value="<fmt:formatDate pattern="yyyy/MM/dd" value="${product.createdDate}" />" /> <br />

        last Edited : <input
            type="text" name="lastEdited"
            value="<fmt:formatDate pattern="yyyy/MM/dd" value="${product.lastEdited}" />" /> <br />  
        

            <input type="submit" value="Submit" />
    </form>
</body>
</html>