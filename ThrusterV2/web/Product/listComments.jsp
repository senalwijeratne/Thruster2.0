<%-- 
    Document   : listCommnets
    Created on : May 1, 2017, 6:27:49 PM
    Author     : Senal
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Comments</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Comment ID</th>
                <th>User ID</th>
                <th>Product ID</th>
                <th>Date-Time</th>
                <th>Comment</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${comments}" var="comment">
                <tr>
                    <td><c:out value="${comment.commentID}" /></td>
                    <td><c:out value="${comment.userID}" /></td>
                    <td><c:out value="${comment.productID}" /></td>
                    <td><c:out value="${comment.timestamp}" /></td>
                    <td><c:out value="${comment.comment}" /></td>
                    <td><a href="CommentsController?action=edit&commentID=<c:out value="${comment.commentID}"/>">Update</a></td>
                    <td><a href="CommentsController?action=delete&commentID=<c:out value="${comment.commentID}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="CommentsController?action=insert">Add Category</a></p>
</body>
</html>
