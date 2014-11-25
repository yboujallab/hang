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
					<li><a href="#">Search stores</a></li>
					<li><a href="#">New store</a></li>
					<li><a href="#">Remove store</a></li>
					<li><a href="#">Update store</a></li>
					<li><a href="#">Delete store</a></li>
	   				<c:forEach var="store" items="${listStore}">
     						 <option>${store.storeName}<option/>
   					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>