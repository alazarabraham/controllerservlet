<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration and Login Page</title>
<style>
body{
	background-image: linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)), url(Clinic.jpg);
	height: 100vh;
	background-size: cover;
	background-position: center;
}

.login-page{
	width: 360px;
	padding: 10% 0 0;
	margin: auto;
}

.form{
	position: relative;
	z-index: 1;
	background: rgba(7, 40, 195, 0.8);
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
}

.form input{
	font-family: "Roboto", sans-serif;
	outline: 1;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button{
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;

}

.form button:hover,.form button:active{
	background: #43A047;
}

.form .message{
	margin: 15px 0 0;
	color: aliceblue;
	font-size: 12px;
}

.form .message a{
	color: #4CAF50;
	text-decoration: none;
}

.form .login-form{
	display: none;
}

</style>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
</head>
<body>
<div class="login-page">
<div class="form">

<form class="register-form" action="login" method="post">
<input name="email" type="text" placeholder="Email"/>
<input name="password" type="password" placeholder="Password"/>

<button>Login</button>

<br>${message}
</p>
</form>

</body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
         
                password: "required",
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
</html>