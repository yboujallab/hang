<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stores</title>
</head>
<body>
	<script>
    	function confirmDelete(idStore){
        	bootbox.confirm("Are you sure?", function(result) {
        		if(result==true)
        			{
                    $.ajax({
                    type: 'GET',
                    url: '${baseURL}/stores/delete?idStore='+idStore                    });
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
						<th style="color: #B6B6B4">Store Name</th>
						<th style="color: #B6B6B4">Store Description</th>
						<th style="color: #B6B6B4">Adrress Line 1</th>
						<th style="color: #B6B6B4">Country</th>
						<th style="color: #B6B6B4">City</th>
						<th style="color: #B6B6B4">Surface</th>
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
								href="${baseURL}/stores/show?idStore=${store.idStore}">Show</a>
							</td>
							<td><a onclick="confirmDelete(${store.idStore})" href=#>Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		<%@ include file="../layouts/_footer.jsp"%>
		</div>
	</div>
</body>
</html>
