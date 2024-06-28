<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IssueManagement</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-dark bg-info">
    <div class="container-fluid">
        <div class="navbar-header">

    <!-- Add your logo here -->

              <a class="navbar-brand" href="#">
                  <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70">
               </a>

    <!-- End of logo -->

 <a class="navbar-brand " href="index.jsp"><b>Home</b></a>
 <a class="navbar-brand " href="SignIn.jsp"><b>SignIn</b></a>


           </div>
        </div>
    </nav>


       <div class="card border-dark container  mt-5 mb-5 justify-content-center" >
        <!---<h3><b><center>SignIn</center></b></h3>--->


                <h1><center>SignIn</center></h1>

         <div class="card-body text-dark">



      <form action="sign-up" method="post">

      <center><strong><span style="color:green">${msg}</span></strong></center>



<!----//within page we need response we can use this line..
//if we need another page to response the create another result page--!>



<span style="color:red;">
                    <c:forEach items="${errors}" var="objectError">
                        ${objectError.defaultMessage}<br>
                    </c:forEach>
                </span>





<div class="row mb-3">
                    <span id="firstNameError"></span><br>
                    <label for="firstName" class="form-label"><b>First Name:</b></label>
                    <input type="text" class="form-control" id="firstName" onblur="firstNameValidation()" name="firstName" value="${signUpDTO.firstName}">
               </div>



<div class="row mb-3">
                    <span id="lastNameError"></span><br>
                    <label for="lastName" class="form-label"><b>Last Name:</b></label>
                    <input type="text" class="form-control" id="lastName" onblur="lastNameValidation()" name="lastName" value="${signUpDTO.lastName}">
               </div>




 <div class="row mb-3">
                  <span id="emailError"></span><br>
                  <label for="email" class="form-label"><b>Email:</b></label>
                   <input type="email" class="form-control" id="email" onblur="emailValidation()" name="email" value="${signUpDTO.email}">
                 </div>



 <div class="row mb-3">
                     <span id="contactNumberError"></span><br>
                     <label for="contactNumber" class="form-label"><b>Contact Number:</b></label>
                     <input type="tel" class="form-control" id="contactNumber" onblur="contactNumberValidation()" name="contactNumber" value="${signUpDTO.contactNumber}">
                </div>



<div class="row mb-3">
                 <span id="AltContactNbrError"></span><br>
                 <label for="alternateContactNumber" class="form-label"><b>Alternative Contact Number:</b></label>
                 <input type="tel" class="form-control" id="alternateContactNumber" onblur="alternateContactNumber()" name="alternateContactNumber" value="${signUpDTO.alternateContactNumber}">
                </div>




<div class="mb-3">
                 <span id="addressError"></span><br>
                 <b>Address</b>
                 <label for="address" class="form-floating"></label>
                 <textarea class="form-control" placeholder="Leave a comment here" id="address" style="height: 100px" name="address" onblur="addressValidation()">${signUpDTO.address} </textarea>
                </div>


<div>
     <span  id="confirmError"></span>
       <label  for="agree" class="list-group-item">
     <input name="agree"  id="agree"  onchange="agreeValidation()"  class="form-check-input me-1" type="checkbox"  value="agree">
     <b>Agree</b>
            </label>
          </div><br>

          <div>
                  <input type="submit"   class="btn btn-primary"  value="SignUp"  >
              </div>

         </form>


     </div>
  </div>

       </bod>
       </html>