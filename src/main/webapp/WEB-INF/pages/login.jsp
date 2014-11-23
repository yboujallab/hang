<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<title>Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>
	<div class="container">
		<h3>Welcome to Hang, the other way to manage you store</h3>

		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
				<h1 class="text-center login-title">Log in</h1>
				<div class="account-wall">
<!-- 					<img class="profile-img"
						src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
						alt=""> -->
						<br />
					<form class="form-signin"
						action="<c:url value='j_spring_security_check' />" method='POST'>
						<br />
						<input type="text" name='email' class="form-control"
							placeholder="Email" required autofocus> 
						<br />
						<input
							type="password" name='password' class="form-control"
							placeholder="Password" required>
							<br />
						<button class="btn btn-lg btn-primary btn-block" type="submit">
							Sign in</button>
						<label class="checkbox pull-left"> <input type="checkbox"
							value="remember-me"> Remember me
						</label> <input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <a href="#"
							class="pull-right need-help">Need help? </a><span
							class="clearfix"></span>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>