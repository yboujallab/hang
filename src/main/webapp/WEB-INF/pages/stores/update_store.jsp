<%@ include file="../layouts/_header.jsp"%>

<body>
	<br />
	<br />
	<br />
		<div class="container">
			<div class="container-fluid">
			<form:form method="POST" action="${baseURL}/stores/update"
				modelAttribute="storeForm" class="form-horizontal">
				<legend>Store Form</legend>
					<div class="span8">
						<div class="row-fluid">
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="storeName">Store Name</label>
									<div class="controls">
										<form:errors path="storeName" cssStyle="color: #ff0000;" />
										<form:input class="form-control" path="storeName"
											style="color:black" type="text" />
									</div>
								</div>
							</div>
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="storeDescription">Store
										Description</label>
									<div class="controls">
										<form:errors path="storeDescription"
											cssStyle="color: #ff0000;" />
										<form:textarea path="storeDescription" class="form-control"
											style="color:black" id="storeDescription" />
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
										<form:errors path="surface" cssStyle="color: #ff0000;" />
										<form:input path="surface" class="form-control" id="surface"
											style="color:black" type="text" value="${storeForm.surface}" />
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
										<form:errors path="storeAddressFirstLine"
											cssStyle="color: #ff0000;" />
										<form:textarea path="storeAddressFirstLine"
											class="form-control" style="color:black"
											id="storeAddressFirstLine"
											value="${storeForm.storeAddressFirstLine}" />
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
											value="${storeForm.storeAddressSecondLine}" />
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="city">City</label>
									<div class="controls">
										<form:errors path="city" cssStyle="color: #ff0000;" />
										<form:input path="city" class="form-control" id="city"
											type="text" style="color:black" value="${storeForm.city}" />
									</div>
								</div>
							</div>
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="state">Country</label>
									<div class="controls">
										<form:errors path="country" cssStyle="color: #ff0000;" />
										<form:input path="country" class="form-control" id="country"
											style="color:black" type="text" value="${storeForm.country}" />
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
											type="text" style="color:black" value="${storeForm.postCode}" />
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
								value="Save">Save</button>
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