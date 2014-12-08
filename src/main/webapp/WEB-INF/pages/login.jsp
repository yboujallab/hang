<%@ include file="layouts/_header.jsp"%>
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>
	<div class="container">
		<h2 style="color:#FFFFFF">Welcome to Hang, the other way to manage you store</h2>
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
				<h1 class="text-center login-title text" style="color:#FFFFFF" >Log in</h1>
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
<%@ include file="layouts/_footer.jsp"%>
</html>