<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stores</title>
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<%-- 		<%@ include file="../menus/left-menu.html"%> --%>
	<div class="container">
		<div class="col-sm-9">
			<div id="searchForm">
				<table border=1>
					<tr>
						<th style="color: #B6B6B4">Store Name</th>
						<th style="color: #B6B6B4">Store Description</th>
						<th style="color: #B6B6B4">Adrress Line 1</th>
						<th style="color: #B6B6B4">Adrress Line 2</th>
						<th style="color: #B6B6B4">Country</th>
						<th style="color: #B6B6B4">City</th>
						<th style="color: #B6B6B4">Post Code</th>
						<th style="color: #B6B6B4">Surface</th>
						<th style="color: #B6B6B4">Crée le</th>
						<th style="color: #B6B6B4">Modifié le</th>
					</tr>
					<c:forEach var="store" items="${listStore}">
						<tr>
							<td style="color: #FFFFFF">
								<option>${store.storeName}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.storeDescription}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.storeAddressFirstLine}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.storeAddressSecondLine}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.country}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.city}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.postCode}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.surface}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.createdAt}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.modifiedAt}
								<option />
							</td>
							<td><a
								href="${baseURL}/stores/show?idStore=${store.idStore}">Show</a>
							</td>
							<td>&nbsp;</td>
							<td><a
								href="${baseURL}/stores/delete?idStore=${store.idStore}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
							<%@ include file="../layouts/_footer.jsp"%>
	</div>
</body>
</html>
