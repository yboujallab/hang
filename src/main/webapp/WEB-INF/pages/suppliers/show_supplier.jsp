<%@ include file="../layouts/_header.jsp"%>
<body>
		<div class="container">
			<div class="container-fluid">
			<form:form method="GET"
					action="${pageContext.request.contextPath}/suppliers/update?idSupplier=${supForm.idSupplier}"
					modelAttribute="supForm" class="form-horizontal">
				<legend>Supplier Details</legend>
					<div class="span8">
						<div class="row-fluid">
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="supplierName">Supplier Name</label>
									<div class="controls">
										<form:input class="form-control" path="name"
											style="color:black" type="text" disabled="true"/>
									</div>
								</div>
							</div>
						<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="supplierActivity">Supplier Activity</label>
									<div class="controls">
										<form:input class="form-control" path="activity"
											style="color:black" type="text" disabled="true"/>
									</div>
								</div>
							</div>							
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="storeDescription">Supplier
										Description</label>
									<div class="controls">
										<form:textarea path="description" class="form-control"
											style="color:black" id="supDescription" disabled="true"/>
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
									<label class="control-label" for="street">Address</label>
									<div class="controls">
										<form:textarea path="address"
											class="form-control" style="color:black"
											id="address" disabled="true"/>
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
											type="text" style="color:black"  disabled="true"/>
									</div>
								</div>
							</div>
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="state">Country</label>
									<div class="controls">
										<form:input path="country" class="form-control" id="country"
											style="color:black" type="text" disabled="true" />
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
											type="text" style="color:black"  disabled="true"/>
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
										<form:label path="creationDate" class="form-control">${supForm.creationDate}</form:label>
									</div>
								</div>
							</div>
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="ModificarionDate">Modified
										On:</label>
									<div class="controls">
										<form:label path="modificationDate" class="form-control">${supForm.modificationDate}</form:label>
									</div>
								</div>
							</div>
							<!--/span-->
						</div>
						<br />
						<!--/row-->
						<div class="span4">
							<button id="save" class="btn btn-primary" type="submit"
								value="update">Update</button>
						</div>
						<!--/span-->
					</div>
					<!--/row-->
					<form:input path="idSupplier" type="hidden"
						value="${supForm.idSupplier}" />
			</form:form>
		</div>
		<hr>
		<%@ include file="../layouts/_footer.jsp"%>
	</div>
</body>
</html>