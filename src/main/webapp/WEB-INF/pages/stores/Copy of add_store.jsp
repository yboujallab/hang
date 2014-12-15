<%@ include file="../layouts/_header.jsp"%>
<html>
<head>
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stores</title>
</head>
<body>
		<div class="col-sm-9">
			<div class="container">
				<div id="updateStoreForm">
					<form:form method="POST" action="${pageContext.request.contextPath}/stores/add"   
							commandName="storeForm">
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
									<td style="color:black"><form:input path="surface" class="form-control"  id="surface" style="color:black" type="text"    /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td><form:errors path="storeAddressFirstLine" cssStyle="color: #ff0000;"/></td></tr>
								<tr>
									<td><form:label path="storeAddressFirstLine">Store Address First Line : </form:label></td>
									<td style="color:black"><form:textarea path="storeAddressFirstLine" class="form-control"  style="color:black" id="storeAddressFirstLine"   /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="storeAddressSecondLine">Store Address Second Line : </form:label></td>
									<td style="color:black"><form:textarea path="storeAddressSecondLine" class="form-control" style="color:black"  id="storeAddressSecondLine"    /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td><form:errors path="country" cssStyle="color: #ff0000;"/></td></tr>
								<tr>
									<td><form:label path="country">Country : </form:label></td>
									<td style="color:black"><form:input path="country" class="form-control"  id="country" style="color:black"  type="text"    /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td><form:errors path="city" cssStyle="color: #ff0000;"/></td></tr>
								<tr>
									<td><form:label path="city">City : </form:label></td>
									<td style="color:black"><form:input path="city" class="form-control"  id="city" type="text" style="color:black"/></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><form:label path="postCode">Post Code : </form:label></td>
									<td style="color:black"><form:input path="postCode" class="form-control"  id="postCode" type="text" style="color:black"  /></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
								<td colspan="2"><button id="save" class="btn btn-primary" type="submit" value="Save" >Save</button>
									</td>
								<td colspan="2"><button id="back" class="btn btn-primary" type="submit" value="Back">Back</button>
									</td>
								</tr>
							</table>
						</form:form>	
				</div>
			</div>
		</div>
</body>
</html>