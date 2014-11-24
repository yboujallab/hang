<%@ include file="layouts/_header.jsp"%>
<html>
<head>
	<link href="<c:url value="/resources/css/custom.css" />"
		rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dashboard</title>
</head>
<body>
	<div class="jumbotron">
		<%@ include file="menus/left-menu.html"%>
		<div class="col-sm-9">
			<div class="container">
				<h1>${title}</h1>
				<h1>${message}</h1>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h2>
						Welcome : ${pageContext.request.userPrincipal.name} 
					</h2>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>