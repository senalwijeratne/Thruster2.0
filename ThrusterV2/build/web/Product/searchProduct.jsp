<%-- 
    Document   : searchProduct
    Created on : May 2, 2017, 7:10:14 AM
    Author     : Ikhwan
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Searching for Answers</title>
    </head>
    <body>
    
        <h1>Hello World!</h1>
        
        
        
<!--      // Search Form   -->
     <form method="POST" action="ProductInformationController?action=searchSubmit">
      <p>What would you like to search for?</p>
      
      Search Key: <input type="text" name="searchKey"><br><br>
      <select id="category-select" name="catSelected">
            <c:forEach items="${allProductInfo}" var="productCategory">  
                <option value="<c:out value="${productCategory.catID}"/>"><c:out value="${productCategory.catName}" /></option>  
            </c:forEach>
      </select>
      
      <select id="subcategory-select" name="subcatSelected">
      
      </select> 
      <br><br>
      
      <div class="priceminmax">
          Price Min: <input type="number" name="priceFloor"><br>
          Price Max: <input type="number" name="priceCeiling">
      </div>
          
          
      <input type="submit">  


      <div id="result">
          
          
      </div>
      
    
     </form>
         
        
<!--    // Sub Category Auto Update Code   -->
    <script>
      function updateSubcategories() {
        var cat_select = document.getElementById("category-select");
        var subcat_select = document.getElementById("subcategory-select");

        var cat_id = cat_select.options[cat_select.selectedIndex].value;

        var url = 'ProductInformationController?action=returnSubCat&selectedCat=' + cat_id;

        var xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.onreadystatechange = function () {
          if(xhr.readyState == 4 && xhr.status == 200) {
            subcat_select.innerHTML = xhr.responseText;
            subcat_select.style.display = 'inline';
          }
        }
        xhr.send();
      }

      var cat_select = document.getElementById("category-select");
      cat_select.addEventListener("change", updateSubcategories);
    </script>

    <script>
      function returnResults() {
        var result = document.getElementById("result");

        var url = 'ProductInformationController';

        var xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.onreadystatechange = function () {
          if(xhr.readyState == 4 && xhr.status == 200) {
            result.innerHTML = xhr.responseText;
            result.display = 'inline';
          }
        }
        xhr.send();
      }
    </script>
    </body>
</html>
