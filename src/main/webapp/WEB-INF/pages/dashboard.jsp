
<%@ include file="layouts/_header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
</head>
<body>
	<div class="container">
		<!-- FIRST ROW OF BLOCKS -->
		<div class="row">
			<!-- USER PROFILE BLOCK -->
			<div class="col-sm-3 col-lg-3">
				<div class="dash-unit">
					<dtitle>User Profile</dtitle>
					<hr>
					<div class="thumbnail">
						<img src="<c:url value="/resources/assets/img/face80x80.jpg" />"
							alt="${pageContext.request.userPrincipal.name}"
							class="img-circle">
					</div>
					<!-- /thumbnail -->
					<h1>${pageContext.request.userPrincipal.name}</h1>
					<h3>Paris, France</h3>
					<br>
					<div class="info-user">
						<span aria-hidden="true" class="li_user fs1"></span> <span
							aria-hidden="true" class="li_settings fs1"></span> <span
							aria-hidden="true" class="li_mail fs1"></span> <span
							aria-hidden="true" class="li_key fs1"></span>
					</div>
				</div>
			</div>
			<!-- Stores BLOCK -->
			<div class="col-sm-3 col-lg-3">
				<div class="dash-unit">
					<dtitle>Stores</dtitle>
					<hr>
					<div class="info-user">
						<span aria-hidden="true" class="li_bubble fs2"></span>
					</div>
					<div class="cont">
						<p>
							<a href="${baseURL}/stores/findAll">Find store</a>
						</p>
						<p>
							<a href="${baseURL}/stores/add">New store</a>
						</p>
					</div>
				</div>
			</div>
			<!-- LOCAL TIME BLOCK -->
			<div class="col-sm-3 col-lg-3">
				<div class="dash-unit">
					<dtitle>Local Time</dtitle>
					<hr>
					<div class="clockcenter">
						<digiclock>12:45:25</digiclock>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Suppliers BLOCK -->
			<div class="col-sm-3 col-lg-3">
				<div class="dash-unit">
					<dtitle>Suppliers</dtitle>
					<hr>
					<div class="info-user">
						<span aria-hidden="true" class="li_bubble fs2"></span>
					</div>
					<div class="cont">
						<p>
							<a href="${baseURL}/suppliers/findAll">Find supplier</a>
						</p>
						<p>
							<a href="${baseURL}/suppliers/add">New supplier</a>
						</p>
					</div>
				</div>
			</div>
		</div>		
		<%@ include file="layouts/_footer.jsp"%>
	</div>
</body>
</html>