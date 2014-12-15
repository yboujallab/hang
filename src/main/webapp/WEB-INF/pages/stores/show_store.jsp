<%@ include file="../layouts/_header.jsp"%>
<body>
		<div class="container">
			<div class="container-fluid">
			<form:form method="GET"
					action="${pageContext.request.contextPath}/stores/update?idStore=${storeForm.idStore}"
					modelAttribute="storeForm" class="form-horizontal">
				<legend>Store Details</legend>
					<div class="span8">
						<div class="row-fluid">
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="storeName">Store Name</label>
									<div class="controls">
										<form:input class="form-control" path="storeName"
											style="color:black" type="text" disabled="true"/>
									</div>
								</div>
							</div>
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="storeDescription">Store
										Description</label>
									<div class="controls">
										<form:textarea path="storeDescription" class="form-control"
											style="color:black" id="storeDescription" disabled="true"/>
									</div>
								</div>
							</div>
							<!--/span-->
						</div>
						<!--/row-->
						<div class="row-fluid">
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="surface">Surface</label>
									<div class="controls">
										<form:input path="surface" class="form-control" id="surface"
											style="color:black" type="text" value="${storeForm.surface}" disabled="true"/>
									</div>
								</div>
							</div>
							<!--/span-->
						</div>
						<!--/row-->
						<legend>Address</legend>
						<div class="row-fluid">
							<div class="span12 bgcolor">
								<div class="control-group">
									<label class="control-label" for="street">Store Address
										First Line</label>
									<div class="controls">
										<form:textarea path="storeAddressFirstLine"
											class="form-control" style="color:black"
											id="storeAddressFirstLine"
											value="${storeForm.storeAddressFirstLine}" disabled="true"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span12 bgcolor">
								<div class="control-group">
									<label class="control-label" for="street-2">Store Address
										Second Line</label>
									<div class="controls">
										<form:textarea path="storeAddressSecondLine"
											class="form-control" style="color:black"
											id="storeAddressSecondLine"
											value="${storeForm.storeAddressSecondLine}" disabled="true"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="city">City</label>
									<div class="controls">
										<form:input path="city" class="form-control" id="city"
											type="text" style="color:black" value="${storeForm.city}" disabled="true"/>
									</div>
								</div>
							</div>
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="state">Country</label>
									<div class="controls">
										<form:input path="country" class="form-control" id="country"
											style="color:black" type="text" value="${storeForm.country}" disabled="true" />
									</div>
								</div>
							</div>
							<!--/span-->
						</div>
						<!--/row-->
						<div class="row-fluid">
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="postCode">Post Code</label>
									<div class="controls">
										<form:input path="postCode" class="form-control" id="postCode"
											type="text" style="color:black" value="${storeForm.postCode}" disabled="true"/>
									</div>
								</div>
							</div>
							<!--/span-->
						</div>
						<!--/row-->
						<!--/span-->
						<legend>Dates</legend>
						<div class="row-fluid">
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="createdDate">Created
										On :</label>
									<div class="controls">
										<form:label path="createdAt" class="form-control">${storeForm.createdAt}</form:label>
									</div>
								</div>
							</div>
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="ModificarionDate">Modified
										On:</label>
									<div class="controls">
										<form:label path="modifiedAt" class="form-control">${storeForm.modifiedAt}</form:label>
									</div>
								</div>
							</div>
							<!--/span-->
						</div>
						<br />
						<!--/row-->
						<div class="span4">
							<button id="save" class="btn btn-primary" type="submit"
								value="Update">Update</button>
						</div>
						<!--/span-->
					</div>
					<!--/row-->
					<form:input path="idStore" type="hidden"
						value="${storeForm.idStore}" />
			</form:form>
		</div>
		<hr>
		<%@ include file="../layouts/_footer.jsp"%>
	</div>
</body>
</html>