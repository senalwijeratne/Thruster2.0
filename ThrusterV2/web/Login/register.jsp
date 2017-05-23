<%-- 
    Document   : index
    Created on : May 1, 2017, 12:36:40 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-signin" action="UserController" method="POST">  
            <center><h2 class="form-signin-heading">Sign up</h2></center>
            <label for="inputFName" class="sr-only">first Name </label>
            <input type="text" id="inputEmail" class="form-control" placeholder="firstName" name="firstName" required autofocus>
            <hr class="spacer">
             <label for="inputMName" class="sr-only">Middle Name</label>
            <input type="text" id="inputPassword" class="form-control" placeholder="middleName"  name="middleName" required>
             <hr class="spacer">
             <label for="inputLName" class="sr-only">Last Name</label>
            <input type="text" id="inputPassword" class="form-control" placeholder="lastName"  name="lastName" required>
             <hr class="spacer">
               <label for="inputAddressLine1" class="sr-only">address line 1</label>
            <input type="text" id="inputPassword" class="form-control" placeholder="addressLine1"  name="addressLine1" required>
             <hr class="spacer">
               <label for="inputAddressLine2" class="sr-only">address line 2</label>
            <input type="text" id="inputPassword" class="form-control" placeholder="addressLine2"  name="addressLine2" required>
             <hr class="spacer">
               <label for="inputAddressLine3" class="sr-only">address line 3</label>
            <input type="text" id="inputPassword" class="form-control" placeholder="addressLine3"  name="addressLine3" required>
             <hr class="spacer">
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password"  name="password" required>
             <hr class="spacer">
            <label for="inputEmail" class="sr-only">Email</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="email" name="email" required autofocus>
            <hr class="spacer">
            <label for="inputDOB" class="sr-only">Date Of Birth</label>
            <input type="date" id="inputPassword" class="form-control" placeholder="dateOfBirth"  name="dateOfBirth" required>
             <hr class="spacer">
             <label for="createdDate" class="sr-only">Date Of create</label>
            <input type="date" id="inputPassword" class="form-control" placeholder="createdDate"  name="createdDate" required>
             <hr class="spacer">
              <label for="inputMobile" class="sr-only">Mobile</label>
            <input type="text" id="inputPassword" class="form-control" placeholder="mobileNo"  name="mobileNo" required>
             <hr class="spacer">
              <label for="inputHNo" class="sr-only">Home no</label>
            <input type="text" id="inputPassword" class="form-control" placeholder="homeNo"  name="homeNo" required>
             <hr class="spacer">
             
            
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
          </form>
    </body>
</html>
