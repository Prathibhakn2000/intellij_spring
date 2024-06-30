<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IssueManagement</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

 <!-- card desiging(highlight)-->
    <style>
        .highlight-card {
            border: 2px solid #f8f9fa;
            background-color: #f8f9fa;  /* Light background color */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);  /* Shadow effect */
        }
    </style>

</head>

<body>

<nav class="navbar navbar-light bg-info">
  <div class="container-fluid">
  <div class="navbar-header">
<a class="navbar-brand" href="#">
      <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70">
</a>
    <a class="navbar-brand" href="index.jsp"><b>Home</b></a>
 <!-- <a class="navbar-brand " href="SignIn.jsp"><b>SignIn</b></a> -->


           </div>
        </div>
    </nav>

<div class="d-flex justify-content-center mt-3 mb-2 align-items-center vh-80">
  <div class="card highlight-card" style="width: 40%; padding: 20px;">
    <div class="card-body">
      <h3><b><center>SIGNUP</center></b></h3>
      <form action="sign-up" method="post">

      <center><strong><span style="color:green">${msg}</span></strong></center>

<!----//within page we need response we can use this line..
//if we need another page to response the create another result page--!>

<span style="color:red;">
    <c:forEach items="${errors}" var="objectError">
    ${objectError.defaultMessage}<br>
    </c:forEach>
</span>


<div class="mb-3">
  <span id="firstNameError"></span><br>
  <label for="firstName" class="form-label"><b>FirstName</b></label>
  <input type="text" class="form-control" id="firstName" placeholder="Enter Firstname" onblur="firstNameValidation()" name="firstName" value="${signUpDTO.firstName}">
</div>

<div class="mb-3">
 <span id="lastNameError"></span><br>
  <label for="lastName" class="form-label"><b>LastName</b></label>
  <input type="text" class="form-control"  id="lastName" placeholder="Enter Lastname" onblur="lastNameValidation()" name="lastName" value="${signUpDTO.lastName}">
</div>

<div class="mb-3">
  <span id="emailError" style="color: red;"></span><br>
  <label for="email" class="form-label"><b>Email address</b></label>
  <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email" onblur="emailValidation()">
</div>

<div class="mb-3">
  <span id="contactNumberError"></span><br>
  <label for="contactNumber" class="form-label"><b>Contact Number</b></label>
  <input type="tel" class="form-control" id="contactNumber" placeholder="Enter Contact Number" onblur="contactNumberValidation()" name="contactNumber" value="${signUpDTO.contactNumber}">
</div>

<div class="mb-3">
  <span id="AltContactNbrError"></span><br>
  <label for="alternateContactNumber" class="form-label"><b>Alternative Contact Number</b></label>
  <input type="tel" class="form-control" id="alternateContactNumber" placeholder="Enter Alternative Contact Number" onblur="alternateContactNumber()" name="alternateContactNumber" value="${signUpDTO.alternateContactNumber}">
</div>

<div class="mb-3">
  <span id="addressError"></span><br>
  <label for="address" class="form-label"><b>Address</b></label>
  <textarea class="form-control" id="address" rows="3" name="address" placeholder="Enter Address" onblur="addressValidation()">${signUpDTO.address}></textarea>
</div>

<div class="list-group">
<span  id="confirmError"></span>
  <label class="list-group-item" for="agree">
    <input class="form-check-input me-1" type="checkbox" value="agree" name="agree"  id="agree"  onchange="agreeValidation()" >
    <b>Agree</b>
  </label>
</div>
<br>

 <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</div>
  </div>
    </div>
 </body>
 </html>