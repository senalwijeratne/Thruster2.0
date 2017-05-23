<%-- 
    Document   : category
    Created on : May 1, 2017, 10:34:22 AM
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
<title>Add New Category</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

    <form method="POST" action='CategoriesController' name="frmAddCategory">
        Category ID : <input type="text" readonly="readonly" name="catID"
            value="<c:out value="${categories.catID}" />" /> <br /> 
        Category Name : <input
            type="text" name="catName"
            value="<c:out value="${categories.catName}" />" /> <br /> 
        Category Description : <input
            type="text" name="catDescription"
            value="<c:out value="${categories.catDescription}" />" /> <br />
    </form>
</body>
</html>