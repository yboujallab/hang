<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suppliers</title>
</head>
<body>
<%-- 		<%@ include file="../menus/left-menu.html"%> --%>
		<div class="col-sm-9">
			<div class="container">
				<!-- Form stores   <%-- action="${baseURL}/stores/update" --%>-->
				<div id="updateStoreForm">
					<form:form method="POST" action="${baseURL}/stores/update"   
							modelAttribute="storeForm">
							<table>
								<tr><td>&nbsp;</td></tr>
								<tr><td><form:errors path="storeName" cssStyle="color: #ff0000;"/></td></tr>
								<tr>
									<td><form:label path="storeName">Store Name : </form:label></td>
									<td  width="80%" style="color:black"><form:input class="form-control" path="storeName" style="color:black"  type="text"  /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td><form:errors path="storeDescription" cssStyle="color: #ff0000;"/></td></tr>
								<tr>
									<td><form:label path="storeDescription">Store Description : </form:label></td>
									<td style="color:black"><form:textarea path="storeDescription" class="form-control"  style="color:black" id="storeDescription" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td><form:errors path="surface" cssStyle="color: #ff0000;"/></td></tr>
								<tr>
									<td><form:label path="surface">Surface : </form:label></td>
									<td style="color:black"><form:input path="surface" class="form-control"  id="surface" style="color:black" type="text"   value="${storeForm.surface}" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td><form:errors path="storeAddressFirstLine" cssStyle="color: #ff0000;"/></td></tr>
								<tr>
									<td><form:label path="storeAddressFirstLine">Store Address First Line : </form:label></td>
									<td style="color:black"><form:textarea path="storeAddressFirstLine" class="form-control"  style="color:black" id="storeAddressFirstLine"  value="${storeForm.storeAddressFirstLine}" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeAddressSecondLine">Store Address Second Line : </form:label></td>
									<td style="color:black"><form:textarea path="storeAddressSecondLine" class="form-control" style="color:black"  id="storeAddressSecondLine"   value="${storeForm.storeAddressSecondLine}" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td><form:errors path="country" cssStyle="color: #ff0000;"/></td></tr>
								<tr>
									<td><form:label path="country">Country : </form:label></td>
									<td style="color:black"><form:input path="country" class="form-control"  id="country" style="color:black"  type="text"   value="${storeForm.country}" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td><form:errors path="city" cssStyle="color: #ff0000;"/></td></tr>
								<tr>
									<td><form:label path="city">City : </form:label></td>
									<td style="color:black"><form:input path="city" class="form-control"  id="city" type="text" style="color:black"  value="${storeForm.city}" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="postCode">Post Code : </form:label></td>
									<td style="color:black"><form:input path="postCode" class="form-control"  id="postCode" type="text" style="color:black"  value="${storeForm.postCode}" /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="createdAt">Created On : </form:label></td>
									<td><form:label path="createdAt" class="form-control">${storeForm.createdAt}</form:label></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="modifiedAt">Modified On : </form:label></td>
									<td><form:label path="modifiedAt" class="form-control">${storeForm.modifiedAt}</form:label></td>
								</tr>															
								<tr><td>&nbsp;</td></tr>
								<tr>
								<td colspan="2"><button id="save" class="btn btn-primary" type="submit" value="Save" >Save</button>
									</td>
								<td colspan="2"><button id="back" class="btn btn-primary" type="submit" value="Back">Back</button>
									</td>
								</tr>
								<form:input path="idStore" type="hidden"  value="${storeForm.idStore}"/>
							</table>
						</form:form>	
				</div>
			</div>
		</div>
</body>
</html>