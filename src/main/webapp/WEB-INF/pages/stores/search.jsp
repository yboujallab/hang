<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stores</title>
</head>
<body>
	<div class="jumbotron">
		<%@ include file="../menus/left-menu.html"%>
		<div class="col-sm-9">
			<div class="container">
				<div id="searchForm">
					<table border=1>
						<tr>
							<th>Store Name</th>
							<th>Store Description</th>
							<th>Adrress Line 1</th>
							<th>Adrress Line 2</th>
							<th>Country</th>
							<th>City</th>
							<th>Post Code</th>
							<th>Surface</th>
							<th>Crée le</th>
							<th>Modifié le</th>
						</tr>
						<c:forEach var="store" items="${listStore}">
							<tr>
								<td>
									<option>${store.storeName}
									<option />
								</td>
								<td>
									<option>${store.storeDescription}
									<option />
								</td>
								<td>
									<option>${store.storeAddressFirstLine}
									<option />
								</td>
								<td>
									<option>${store.storeAddressSecondLine}
									<option />
								</td>
								<td>
									<option>${store.country}
									<option />
								</td>
								<td>
									<option>${store.city}
									<option />
								</td>
								<td>
									<option>${store.postCode}
									<option />
								</td>
								<td>
									<option>${store.surface}
									<option />
								</td>
								<td>
									<option>${store.createdAt}
									<option />
								</td>
								<td>
									<option>${store.modifiedAt}
									<option />
								</td>
								<td>
								<a href="${baseURL}/stores/show?idStore=${store.idStore}">Show</a>
								</td>
								<td><a href="#">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
