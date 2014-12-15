<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stores</title>
</head>
<body>
<%-- 		<%@ include file="../menus/left-menu.html"%> --%>
		<div class="col-sm-9">
			<div class="container">
				<div>
					<ul>
						<li><a href="<c:url value='stores/findAll' />">Search
								stores</a></li>
<!-- 								
						<li><a href="#"
							onClick="toggle('addForm');toggle('searchForm')">New store</a></li>
 -->							<li><a href="${pageContext.request.contextPath}/stores/add">New store</a></li>
						<li><a href="#">Remove store</a></li>
						<li><a href="#">Update store</a></li>
						<li><a href="#">Delete store</a></li>
					</ul>
				</div>
				<!-- Form stores  -->
				<div id="addForm" style="visibility: hidden;">
					<ul>
						<form:form method="post" action="stores/save"
							modelAttribute="storeForm">
							<table>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeName">Store Name : </form:label></td>
									<td><form:input path="storeName" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeDescription">Store Description : </form:label></td>
									<td><form:textarea path="storeDescription" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="surface">Surface : </form:label></td>
									<td><form:input path="surface" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeAddressFirstLine">Store Address First Line : </form:label></td>
									<td><form:textarea path="storeAddressFirstLine" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeAddressSecondLine">Store Address Second Line : </form:label></td>
									<td><form:textarea path="storeAddressSecondLine" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="country">Country : </form:label></td>
									<td><form:input path="country" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="city">City : </form:label></td>
									<td><form:input path="city" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="postCode">Post Code : </form:label></td>
									<td><form:input path="postCode" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td colspan="2"><input type="submit" value="Add store" />
									</td>
									<td colspan="2"><input type="reset" value="Reset" />
									</td>
								</tr>
							</table>
						</form:form>
					</ul>
				</div>
				<div id="searchForm" style="visibility: hidden;">
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
								<option>${store.storeName}<option />
							</td>
							<td>
								<option>${store.storeDescription}<option />
							</td>
							<td>
								<option>${store.storeAddressFirstLine}<option />
							</td>	
							<td>
								<option>${store.storeAddressSecondLine}<option />
							</td>	
							<td>
								<option>${store.country}<option />
							</td>	
							<td>
								<option>${store.city}<option />
							</td>	
							<td>
								<option>${store.postCode}<option />
							</td>	
							<td>
								<option>${store.surface}<option />
							</td>	
							<td>
								<option>${store.createdAt}<option />
							</td>	
							<td>
								<option>${store.modifiedAt}<option />
							</td>
							<td>
								<a href="<c:url value='stores/show?idStore=${store.idStore}' />">Show</a>
							</td>
							<td>
								<a href="#">Delete</a>
							</td>														
							</tr>																																																														
						</c:forEach>
					</table>
				</div>
			</div>
					<%@ include file="../layouts/_footer.jsp"%>
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