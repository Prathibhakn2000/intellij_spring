<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>IssueManagement</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script  src="/issue-management/js/SignInValidation.js"></script>
    <script>
        function disableButton() {
            var accountLocked = "${accountLocked}";
            if (accountLocked === "true") {
                document.getElementById("signinButton").disabled = true;
            }
        }
        window.onload = disableButton;
    </script>
</head>

<body>

<nav class="navbar navbar-dark bg-info">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="xworkz" width="140" height="70">
            </a>
            <a class="navbar-brand " href="index.jsp"><b>Home</b></a>
        </div>
    </div>
</nav>

<div class="card border-dark container mt-5 mb-5 justify-content-center">
    <h3><b><center>SignIn</center></b></h3>
    <div class="card-body">
        <form action="sign-in" method="post" onsubmit="return validateForm()">
            <center><strong><span style="color:green">${msg1}</span></strong></center>
            <center><strong><span style="color:red">${error}</span></strong></center>

            <div class="row mb-3">
                <span id="emailError" style="color: red;"></span><br>
                <label for="email" class="form-label"><b>Email:</b></label>
                <input type="email" class="form-control" id="email" name="email" onblur="emailValidation()">
            </div>

            <div class="row mb-3">
                <span id="passwordError" style="color: red;"></span><br>
                <label for="password" class="form-label"><b>Password:</b></label>
                <input type="password" class="form-control" id="password" name="password" onblur="passwordValidation()">
            </div>

            <div>
                <input type="submit"   class="btn btn-primary" value="SignIn" id="signinButton">
            </div>
        </form>
    </div>
</div>

</body>
</html>
