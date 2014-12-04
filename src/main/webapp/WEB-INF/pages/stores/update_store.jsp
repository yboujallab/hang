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
					<form:form method="post" action="stores/update"
							modelAttribute="storeForm">
							<table>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeName">Store Name : </form:label></td>
									<td  width="80%" style="color:black"><form:input class="form-control" path="storeName" style="color:black" id="storeName" type="text" disabled="disabled" value="${storeDetails.storeName}" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeDescription">Store Description : </form:label></td>
									<td style="color:black"><form:textarea path="storeDescription" class="form-control"  id="storeDescription"  disabled="disabled" value="${storeDetails.storeDescription}"/></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="surface">Surface : </form:label></td>
									<td style="color:black"><form:input path="surface" class="form-control"  id="surface"  type="text"  disabled="disabled" value="${storeDetails.surface}"/></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeAddressFirstLine">Store Address First Line : </form:label></td>
									<td style="color:black"><form:textarea path="storeAddressFirstLine" class="form-control"  id="storeAddressFirstLine" disabled="disabled" value="${storeDetails.storeAddressFirstLine}"/></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeAddressSecondLine">Store Address Second Line : </form:label></td>
									<td style="color:black"><form:textarea path="storeAddressSecondLine" class="form-control"  id="storeAddressSecondLine"  disabled="disabled" value="${storeDetails.storeAddressSecondLine}"/></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="country">Country : </form:label></td>
									<td style="color:black"><form:input path="country" class="form-control"  id="country"  type="text"  disabled="disabled" value="${storeDetails.country}"/></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="city">City : </form:label></td>
									<td style="color:black"><form:input path="city" class="form-control"  id="city" type="text"  disabled="disabled" value="${storeDetails.city}"/></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="postCode">Post Code : </form:label></td>
									<td style="color:black"><form:input path="postCode" class="form-control"  id="postCode" type="text"  disabled="disabled" value="${storeDetails.postCode}"/></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="createdAt">Created On : </form:label></td>
									<td><form:label path="createdAt" class="form-control">${storeDetails.createdAt}</form:label></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="modifiedAt">Modified On : </form:label></td>
									<td><form:label path="modifiedAt" class="form-control">${storeDetails.modifiedAt}</form:label></td>
								</tr>															
								<tr><td>&nbsp;</td></tr>
								<tr>
								<td colspan="2"><button id="update"  class="btn btn-primary" type="submit" onclick="changeForm()" style="display:block;">Update</button></td>
 								</tr>
								<tr>
								<td colspan="2"><button id="save" class="btn btn-primary" type="submit" value="Save" onclick="changeForm()" style="display:none;">Save</button>
									</td>
								<td colspan="2"><button id="back" class="btn btn-primary" type="submit" value="Back"  onclick="changeForm()" style="display:none;">Back</button>
									</td>
								</tr>
							</table>
						</form:form>	
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	/** Fonction basculant la visibilité d'un élément dom
	 * @parameter anId string l'identificateur de la cible à montrer, cacher
	 */
	 function changeForm(){
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