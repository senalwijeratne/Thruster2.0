<%-- 
    Document   : comments
    Created on : May 1, 2017, 6:27:26 PM
    Author     : Senal
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
<title>Add New Comments</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

    <form method="POST" action='CommentsController' name="frmAddComments">
        Comment ID : <input type="text" readonly="readonly" name="commentID"
            value="<c:out value="${comments.commnetID}" />" /> <br /> 
        User ID : <input
            type="date" name="userID"
            value="<c:out value="${comments.userID}" />" /> <br /> 
        Product ID : <input
            type="text" name="productID"
            value="<c:out value="${comments.productID}" />" /> <br />
        Date-Time : <input
            type="text" name="timestamp"
            value="<c:out value="${comments.timestamp}" />" /> <br />
        Comment : <input
            type="text" name="comment"
            value="<c:out value="${comments.comment}" />" /> <br />
    </form>
</body>
</html>
