<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*"%>
<!DOCTYPE HTML>

<html>
<head>
<title>welcome</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="<%=request.getContextPath()%>/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/js/app.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="<%=request.getContextPath()%>/css/app.css" rel="stylesheet" />


<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/util.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/main.css">
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/alertify.css">
<!--===============================================================================================-->

<!--===============================================================================================-->
<script
	src="<%=request.getContextPath()%>/css/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script
	src="<%=request.getContextPath()%>/css/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="<%=request.getContextPath()%>/css/bootstrap/js/popper.js"></script>
<script
	src="<%=request.getContextPath()%>/css/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="<%=request.getContextPath()%>/css/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script
	src="<%=request.getContextPath()%>/css/daterangepicker/moment.min.js"></script>
<script
	src="<%=request.getContextPath()%>/css/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script
	src="<%=request.getContextPath()%>/css/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="<%=request.getContextPath()%>/js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>


</head>
<body>
	<div class="container-login100">
		<!-- style="background-image: url('images/bg-01.jpg');"> -->
		 <!-- class="container" --> <div ng-app="quoteApp">

			<div ng-controller="loginController"
				class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method="post"
					ng-submit="login()">
					<span class="login100-form-title p-b-49"> Login </span>

					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Username is reauired">
						<span class="label-input100">Username</span> <input
							class="input100" type="text" placeholder="Type your username"
							name="username" id="username" placeholder="Enter username"
							ng-model="username"> <span class="focus-input100"
							data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">Password</span> <input
							class="input100" type="password" placeholder="Type your password"
							name="password" id="password" placeholder="Enter password"
							ng-model="password"> <span class="focus-input100"
							data-symbol="&#xf190;"></span>
					</div>

					<div class="text-right p-t-8 p-b-31">
						<a href="#"> Forgot password? </a>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit">Login</button>
						</div>
					</div>

				</form>
			</div>



		</div>
	</div>
</body>
</html>