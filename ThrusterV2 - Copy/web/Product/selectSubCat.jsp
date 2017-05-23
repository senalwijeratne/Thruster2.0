<%-- 
    Document   : searchProduct
    Created on : May 2, 2017, 7:10:14 AM
    Author     : Ikhwan
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>    
<meta name="viewport" content="width=device-width, initial-scale=1">
       
        <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <title>Searching for Answers</title>
</head>
    <c:set var ="catID" value ="${selectedCat}"/>
    
    
    <c:forEach items="${allSubCats}" var="searchSubCat">  
        
             <option value="<c:out value="${searchSubCat.subcatID}"/>"><c:out value="${searchSubCat.subcatName}" /></option>  
       
    </c:forEach>
      
    
    
            
    