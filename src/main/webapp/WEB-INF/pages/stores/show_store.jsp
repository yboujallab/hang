<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suppliers</title>
</head>
<body>
	<div class="jumbotron">
		<%@ include file="../menus/left-menu.html"%>
		<div class="col-sm-9">
			<div class="container">
				<!-- Form stores  -->
				<div id="store-form">
							<table>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label>Store Name : </label></td>
									<td><label>${storeDetails.storeName}</label></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label>Store Description : </label></td>
									<td><label>${storeDetails.storeDescription}</label></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label >Surface : </label></td>
									<td><label>${storeDetails.surface}</label></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label>Store Address First Line : </label></td>
									<td><label>${storeDetails.storeAddressFirstLine}</label></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label>Store Address Second Line : </label></td>
									<td><label>${storeDetails.storeAddressSecondLine}</label></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label>Country : </label></td>
									<td><label>${storeDetails.country}</label></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label>City : </label></td>
									<td><label>${storeDetails.city}</label></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label>Post Code : </label></td>
									<td><label>${storeDetails.postCode}</label></td>
								</tr>
								<tr>
									<td><label>Created On : </label></td>
									<td><label>${storeDetails.createdAt}</label></td>
								</tr>
								<tr>
									<td><label>Modified On : </label></td>
									<td><label>${storeDetails.modifiedAt}</label></td>
								</tr>															
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td colspan="2"><input type="submit" value="Update" />
									</td>
								</tr>
							</table>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	/** Fonction basculant la visibilité d'un élément dom
	 * @parameter anId string l'identificateur de la cible à montrer, cacher
	 */
	function toggle(anId) {
		node = document.getElementById(anId);
		if (node.style.visibility == "hidden") {
			node.style.visibility = "visible";
			node.style.height = "auto"; // Optionnel rétablir la hauteur
		} else {
			// Contenu visible, le cacher
			node.style.visibility = "none";
			node.style.height = "0"; // Optionnel libérer l'espace
		}
	}
</script>
</html>