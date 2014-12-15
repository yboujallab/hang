<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stores</title>
</head>
<body>
	<script type="text/javascript">
		function DoNav(url)
		{
		   document.location.href = url;
		}
    	function confirmDelete(idStore){
        	bootbox.confirm("Are you sure?", function(result) {
        		if(result==true)
        			{
                    $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath}/stores/delete?idStore='+idStore                    });
        			}
        	});
    	}
    </script>
	<div class="container">
			<div class="container-fluid">
				<legend>Search</legend>
				<form:form class="navbar-form navbar-left"
					action="${pageContext.request.contextPath}/stores/search"
					role="search" commandName="storeForm">
					<div class="form-group">
						<form:input type="text" path="storeName" class="form-control"
							placeholder="Store Name" />
						<form:input type="text" path="storeDescription" class="form-control"
							placeholder="Store Description" />
						<form:input type="text" path="surface" class="form-control"
							placeholder="Surface" />
						<form:input type="text" path="storeAddressFirstLine" class="form-control"
							placeholder="Store Address First Line" />
						<form:input type="text" path="storeAddressSecondLine" class="form-control"
							placeholder="Store Address Second Line" />
						<form:input type="text" path="city" class="form-control"
							placeholder="City" />
						<form:input type="text" path="country" class="form-control"
							placeholder="Country" />
						<form:input type="text" path="postCode" class="form-control"
							placeholder="Post Code" />
						<form:input type="text" path="modifiedAt"
							class="form-control" placeholder="Modification Date" />
						<form:input type="text" path="createdAt"
							class="form-control" placeholder="Creation Date" />
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</form:form>
			</div>
		<div class="col-sm-9">
			<div id="searchForm">
			<legend>Results</legend>
				<table class="table table-bordered table-hover">
					<tr>
						<th style="color: #B6B6B4">Store Name</th>
						<th style="color: #B6B6B4">Store Description</th>
						<th style="color: #B6B6B4">Adrress Line 1</th>
						<th style="color: #B6B6B4">Country</th>
						<th style="color: #B6B6B4">City</th>
						<th style="color: #B6B6B4">Surface</th>
					</tr>
					<c:forEach var="store" items="${listStore}">
						<tr
							onclick="DoNav('${pageContext.request.contextPath}/stores/show?idStore=${store.idStore}')">
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
								<option>${store.country}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.city}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${store.surface}
								<option />
							</td>
							<td><a
								href="${pageContext.request.contextPath}/stores/show?idStore=${store.idStore}">Show</a>
							</td>
							<td><a onclick="confirmDelete(${store.idStore})" href=#>Delete</a></td>
						</tr>
						</a>
					</c:forEach>
				</table>
			</div>
			<%@ include file="../layouts/_footer.jsp"%>
		</div>
	</div>
</body>
</html>
