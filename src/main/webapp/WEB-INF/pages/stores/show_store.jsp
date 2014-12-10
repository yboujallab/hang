<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stores</title>
</head>
<body>
	<br />
	<br />
	<br />
	<div class="container">
		<div class="col-sm-9">
			<div id="updateStoreForm">
				<form:form method="GET"
					action="${baseURL}/stores/update?idStore=${storeForm.idStore}"
					modelAttribute="storeForm">
					<table>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="storeName" style="color: #B6B6B4">Store Name : </form:label></td>
							<td width="50%" style="color: black"><form:input
									class="form-control" path="storeName" style="color:black"
									type="text" disabled="true" /></td>
							<td><form:label path="storeDescription"
									style="color: #B6B6B4">Store Description : </form:label></td>
							<td width="50%" style="color: black"><form:textarea
									path="storeDescription" class="form-control"
									style="color:black" id="storeDescription" disabled="true" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="surface" style="color: #B6B6B4">Surface : </form:label></td>
							<td style="color: black"><form:input path="surface"
									class="form-control" id="surface" style="color:black"
									type="text" value="${storeForm.surface}" disabled="true" /></td>
							<td><form:label path="storeAddressFirstLine"
									style="color: #B6B6B4">Store Address First Line : </form:label></td>
							<td style="color: black"><form:textarea
									path="storeAddressFirstLine" class="form-control"
									style="color:black" id="storeAddressFirstLine"
									value="${storeForm.storeAddressFirstLine}" disabled="true" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="storeAddressSecondLine"
									style="color: #B6B6B4">Store Address Second Line : </form:label></td>
							<td style="color: black"><form:textarea
									path="storeAddressSecondLine" class="form-control"
									style="color:black" id="storeAddressSecondLine"
									value="${storeForm.storeAddressSecondLine}" disabled="true" /></td>
							<td><form:label path="country" style="color: #B6B6B4">Country : </form:label></td>
							<td style="color: black"><form:input path="country"
									class="form-control" id="country" style="color:black"
									type="text" value="${storeForm.country}" disabled="true" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="city" style="color: #B6B6B4">City : </form:label></td>
							<td style="color: black"><form:input path="city"
									class="form-control" id="city" type="text" style="color:black"
									value="${storeForm.city}" disabled="true" /></td>
							<td><form:label path="postCode" style="color: #B6B6B4">Post Code : </form:label></td>
							<td style="color: black"><form:input path="postCode"
									class="form-control" id="postCode" type="text"
									style="color:black" value="${storeForm.postCode}"
									disabled="true" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="createdAt" style="color: #B6B6B4">Created On : </form:label></td>
							<td><form:label path="createdAt" class="form-control">${storeForm.createdAt}</form:label></td>
							<td><form:label path="modifiedAt" style="color: #B6B6B4">Modified On : </form:label></td>
							<td><form:label path="modifiedAt" class="form-control">${storeForm.modifiedAt}</form:label></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2"><button id="update" class="btn btn-primary"
									type="submit" style="display: block;">Update</button></td>
						</tr>
						<form:input path="idStore" type="hidden"
							value="${storeForm.idStore}" />
					</table>
				</form:form>
			</div>
		</div>
	</div>
				<%@ include file="../layouts/_footer.jsp"%>
</body>
<script type="text/javascript">
	/** Fonction basculant la visibilité d'un élément dom
	 * @parameter anId string l'identificateur de la cible à montrer, cacher
	 */
	function changeForm() {
		ShowOrHide("save");
		ShowOrHide("update");
		ShowOrHide("back");
		//Enbled form 
		toggle_inputs();
	}
	function toggle_inputs() {
		var inputs = document.getElementsByTagName('input');
		for (var i = inputs.length, n = 0; n < i; n++) {
			inputs[n].disabled = !inputs[n].disabled;
		}
		var textareas = document.getElementsByTagName('textarea');
		for (var i = textareas.length, m = 0; m < i; m++) {
			textareas[m].disabled = !textareas[m].disabled;
		}
	}

	function ShowOrHide(anId) {
		node = document.getElementById(anId);
		if (node.style.display == "none") {
			node.style.display = "block";
		} else {
			// Contenu visible, le cacher
			node.style.display = "none";
		}
	}
</script>
</html>