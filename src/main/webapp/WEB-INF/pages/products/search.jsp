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
    	function confirmDelete(idProduct){
        	bootbox.confirm("Are you sure?", function(result) {
        		if(result==true)
        			{
                    $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath}/products/delete?idProduct='+idProduct});
        			}
        	});
    	}
    </script>
	<div class="container">
		<div class="col-sm-9">
			<div id="searchForm">
				<legend>Results</legend>
				<table class="table table-bordered table-hover">
					<tr>
						<th style="color: #B6B6B4">Name</th>
						<th style="color: #B6B6B4">Description</th>
						<th style="color: #B6B6B4">Qte Min</th>
						<th style="color: #B6B6B4">Capacity</th>
						<th style="color: #B6B6B4">Unity</th>
						<th style="color: #B6B6B4">Box Capacity</th>
					</tr>
					<c:forEach var="product" items="${listProducts}">
						<tr
							onclick="DoNav('${pageContext.request.contextPath}/products/show?idProduct=${product.idProduct}')">
							<td style="color: #FFFFFF">
								<option>${product.name}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${product.description}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${product.qteMin}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${product.capacity}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${product.unity}
								<option />
							</td>
							<td style="color: #FFFFFF">
								<option>${product.boxCapacity}
								<option />
							</td>
							<td><a
								href="${pageContext.request.contextPath}/products/show?idSup=${product.idProduct}">Show</a>
							</td>
							<td><a onclick="confirmDelete(${product.idProduct})" href=#>Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<%@ include file="../layouts/_footer.jsp"%>
		</div>
	</div>
</body>
</html>
