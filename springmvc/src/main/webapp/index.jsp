<%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<script>
let fieldsChecks = {

	    "name" : false,
	    "phone" : false,
	    "email" :false,
	    "tour" : false,
	     "contact" : false,

	}

function validate(){
    let flag = false;

    for(let [key, value] of Object.entries(fieldsChecks)){

        if(value === false){
            flag = true;
            break;
        }
    }

    if(!flag){
        document.getElementById("submit").removeAttribute("disabled");
    }else{
        document.getElementById("submit").setAttribute("disabled","");
    }
}


function nameValidation()
{
 let element = document.getElementById("name");
                let error = document.getElementById("errorname");
                let nameRegex = /^[A-Za-z]+$/;

                if (element.value.length > 3 && element.value.length < 30 && nameRegex.test(element.value)) {
                    error.innerHTML = "";
                    fieldsChecks["name"] = true;
                } else {
                    error.innerHTML = "Invalid name. Name should be alphabetic characters only and length should be greater than 3 and less than 30.";
                    error.style.color = "red";
                    fieldsChecks["name"] = false;

    }
    validate();
}



   function phoneValidation() {
             let element = document.getElementById("phone");
             let error = document.getElementById("errorphone");

             // Regular expression pattern for validating a 10-digit mobile number
             let mobileRegex = /^\d{10}$/;

             // Check if the mobile number is valid
             if (mobileRegex.test(element.value)) {

                 // Mobile number is valid
                 error.innerHTML = "";
                 fieldsChecks["phone"] = true;
             } else {
                 // Mobile number is invalid

                 error.innerHTML = "Invalid mobile number. It should be exactly 10 digits.";
                 error.style.color = "red";
                 fieldsChecks["phone"] = false;
             }
             validate();
         }

   function emailValidation() {
               let element = document.getElementById("email");
              let error = document.getElementById("erroremail");

                              <!----Regular expression pattern for validating email address--!>
      let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

                                  <!---Check if the email is valid--!>
      if (emailRegex.test(element.value)) {
                                   //Email is valid
                                  error.innerHTML = "";
                                  fieldsChecks["email"] = true;
                              } else {
                            //email is Invalid
                                  error.innerHTML = "Invalid email address.";
                                  error.style.color = "red";
                                  fieldsChecks["email"] = false;
                              }
                              validate();
                          }
                  function tourValidation()
                      	{
                      		 let error = document.getElementById("errortour");
                      		 if(document.travel.tour[0].checked==false && document.travel.tour[1].checked==false && document.travel.tour[2].checked==false ){
                      		 error.innerHTML = "Please select  tour experiencece";
                      		 error.style.color="red"
                      		 fieldsChecks["tour"] = false;

                      	}
                      		 else
                      			 {
                      			    error.innerHTML = "";
                      		        fieldsChecks["tour"] = true;
                      			 }

                      	            validate()
                      			 }



              function serviceValidation()
              {
               let element = document.getElementById("service");
                              let error = document.getElementById("errorservice");
                              let nameRegex = /^[A-Za-z]+$/;

                              if (element.value.length > 3 && element.value.length < 30 && nameRegex.test(element.value)) {
                                  error.innerHTML = "";
                                  fieldsChecks["service"] = true;
                              } else {
                                  error.innerHTML = " Service should be alphabetic characters only and length should be greater than 3 and less than 30.";
                                  error.style.color = "red";
                                  fieldsChecks["service"] = false;

                  }
                  tourValidation();
                  validate();
              }

                       </script>

<body>
<nav class="navbar navbar-light bg-info">
  <div class="container-fluid">
  <div class="navbar-header">
<a class="navbar-brand" href="#">
      <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70">
    </a>
</div>
  </div>
</nav>

<div class="d-flex justify-content-center align-items-center vh-100">
    <div class="card" style="width: 50%; padding: 20px;">
        <div class="card-body">



                                 <form  name= "travel" action="enjoy" method="post" class="mt-3">
                                  <h1>  &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp   &nbsp  TravelAgency FeedBack Form </h1>
                                  <span style="color:red;">
                                          <c:forEach items="${errors}" var="objectError">
                                          ${objectError.defaultMessage}</br>
                                           </c:forEach>
                                            </span>
                                           ${travelDTO}
                            <div>
                                <span id="errorname"></span><br> <b> Name</b> <label
                                    for="name" class="form-label" ></label>
                               <input type="text"  value="${travelDTO.name}" class="form-control" id="name" name="name" onblur="nameValidation()" >
                            </div>
                            <br>
                            <div >
                                 <span id="errorphone"></span><br> <b>   Phone Number</b> <label
                                     for="phone" class="form-label" ></label>
                                 <input type="number"  value="${travelDTO.phone}" class="form-control" id="phone" name="phone" onblur="phoneValidation()" >
                            </div>
                            </br>
                            <div >
                                    <span id="erroremail"></span><br> <b>  Email</b> <label
                                        for="email" class="form-label" ></label>
                                         <input type="text"  value="${travelDTO.email}" class="form-control" id="email" name="email" onblur="emailValidation()" >
                                </div>
                                </br>

                           <div>
                             <span id="errortour"></span>
                               <b>How About The Tour</b><div class="form-check">
                                 <input class="form-check-input"    type="radio" name="tour" value="Very Good" id="flexRadioDefault1" ${travelDTO.tour=='Very Good' ? 'checked' : ''} onblur="tourValidation()">
                                    <label class="form-check-label" for="flexRadioDefault1" >Very Good</label>
                                   </div>
                               <div class="form-check">
                              <input class="form-check-input" type="radio" name="tour"  value="Good" id="flexRadioDefault2" ${travelDTO.tour=='Good' ? 'checked' : ''} onblur="tourValidation()">
                                 <label class="form-check-label" for="flexRadioDefault2" >Good</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="tour"  value="Bad" id="flexRadioDefault2" ${travelDTO.tour=='Bad' ? 'checked' : ''} onblur="tourValidation()">
                                     <label class="form-check-label" for="flexRadioDefault2" >Bad</label>
                                       </div>
                              </div>
                                 <br>

                               <div >
                                  <span id="errorservice"></span><br> <b>How can Improve The service</b> <label
                                  for="service" class="form-floating"></label>
                                  <textarea class="form-control"   placeholder="Leave a comment here" id="service" style="height: 100px" name="service" onblur="serviceValidation()" >${travelDTO.service}</textarea>
                              </div>
                              </br>

                       <div>
                          <button type="submit" class="text-primary"  id="submit" >Submit</button>
                          </div>
                         </form>

        </div>
    </div>
</div>

</body>
</html>
