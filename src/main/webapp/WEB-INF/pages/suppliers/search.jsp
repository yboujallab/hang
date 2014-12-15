<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suppliers Search</title>
</head>
<body>
	<script type="text/javascript">
	function DoNav(url)
	{
	   document.location.href = url;
	}
    	function confirmDelete(idSup){
        	bootbox.confirm("Are you sure?", function(result) {
        		if(result==true)
        			{
                    $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath}/suppliers/delete?idSup='+idSup});
        			}
        	});
    	}
    </script>
	<div class="container">
		<div class="col-sm-9">
			<div class="container-fluid">
				<legend>Search</legend>
				<form:form class="navbar-form navbar-left"
					action="${pageContext.request.contextPath}/suppliers/search"
					role="search" commandName="supForm">
					<div class="form-group">
						<form:input type="text" path="name" class="form-control"
							placeholder="Supplier Name" />
						<form:input type="text" path="activity" class="form-control"
							placeholder="Activity" />
						<form:input type="text" path="description" class="form-control"
							placeholder="Supplier Description" />
						<form:input type="text" path="address" class="form-control"
							placeholder="Supplier Address" />
						<form:input type="text" path="city" class="form-control"
							placeholder="City" />
						<form:input type="text" path="country" class="form-control"
							placeholder="Country" />
						<form:input type="text" path="postCode" class="form-control"
							placeholder="postCode" />
						<form:input type="text" path="creationDate" class="form-control"
							placeholder="Creation Date" />
						<form:input type="text" path="modificationDate"
							class="form-control" placeholder="Modification Date" />
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</form:form>
			</div>
			<div id="searchForm">
				<legend>Results</legend>
				<table class="table table-bordered table-hover">
					<tr>
						<th style="color: #B6B6B4">Supplier Name</th>
						<th style="color: #B6B6B4">Supplier Description</th>
						<th style="color: #B6B6B4">Address</th>
						<th style="color: #B6B6B4">Country</th>
						<th style="color: #B6B6B4">City</th>
						<th style="color: #B6B6B4">Activity</th>
					</tr>
					<c:forEach var="sup" items="${listSuppliers}">
						<tr
							onclick="DoNav('${pageContext.request.contextPath}/suppliers/show?idSup=${sup.idSupplier}')">
							<td style="color: #FFFFFF">
								<option>${sup.name}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${sup.description}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${sup.address}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${sup.country}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${sup.city}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${sup.activity}
								<option />
							</td>
							<td><a
								href="${pageContext.request.contextPath}/suppliers/show?idSup=${sup.idSupplier}">Show</a>
							</td>
							<td><a onclick="confirmDelete(${sup.idSupplier})" href=#>Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<%@ include file="../layouts/_footer.jsp"%>
		</div>
	</div>
</body>
</html>
