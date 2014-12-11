<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stores</title>
</head>
<body>
	<script>
    	function confirmDelete(idSup){
        	bootbox.confirm("Are you sure?", function(result) {
        		if(result==true)
        			{
                    $.ajax({
                    type: 'GET',
                    url: '${baseURL}/suppliers/delete?idSup='+idSup                    });
        			}
        		else
        			alert("false");
        	});
    	}
    </script>
	<div class="container">
		<div class="col-sm-9">
			<div id="searchForm">
				<table border=1>
					<tr>
						<th style="color: #B6B6B4">Supplier Name</th>
						<th style="color: #B6B6B4">Supplier Description</th>
						<th style="color: #B6B6B4">Address</th>
						<th style="color: #B6B6B4">Country</th>
						<th style="color: #B6B6B4">City</th>
						<th style="color: #B6B6B4">Activity</th>
					</tr>
					<c:forEach var="sup" items="${listSuppliers}">
						<tr>
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
								href="${baseURL}/suppliers/show?idSup=${sup.idSupplier}">Show</a>
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
