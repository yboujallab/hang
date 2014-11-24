<%@ include file="layouts/_header.jsp"%>
<html>
<head>
	<link href="<c:url value="/resources/css/custom.css" />"
		rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Suppliers</title>
</head>
<body>
	<div class="jumbotron">
		<%@ include file="menus/left-menu.html"%>
		<div class="col-sm-9">
			<div class="container">
			   <ul>
					<li><a href="#">Search supplier</a></li>
					<li><a href="#">New supplier</a></li>
					<li><a href="#">Remove supplier</a></li>
					<li><a href="#">Update supplier</a></li>
					<li><a href="#">Delete supplier</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>