<%@ include file="../layouts/_header.jsp"%>
<body>
	<div class="container">
		<div class="container-fluid">
			<form:form method="POST"
				action="${pageContext.request.contextPath}/products/add"
				commandName="productForm" class="form-horizontal">
				<legend>Add a new Product</legend>
				<div class="span8">
					<div class="row-fluid">
						<div class="span6 bgcolor">
							<div class="control-group">
								<label class="control-label" for="name">Product Name</label>
								<div class="controls">
									<form:errors path="name" cssStyle="color: #ff0000;" />
									<form:input class="form-control" path="name"
										style="color:black" type="text" />
								</div>
							</div>
						</div>
						<div class="span6 bgcolor">
							<div class="control-group">
								<label class="control-label" for="qteMin">Minimum
									Quantity</label>
								<div class="controls">
									<form:errors path="qteMin" cssStyle="color: #ff0000;" />
									<form:input class="form-control" path="qteMin"
										style="color:black" type="text" />
								</div>
							</div>
						</div>
						<!--/span-->
						<div class="span12 bgcolor">
							<div class="control-group">
								<label class="control-label" for="description">Product
									Description</label>
								<div class="controls">
									<form:errors path="description" cssStyle="color: #ff0000;" />
									<form:textarea path="description" class="form-control"
										style="color:black" id="description" />
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<!--/row-->
					<div class="row-fluid">
						<div class="span6 bgcolor">
							<div class="control-group">
								<label class="control-label" for="street">Capacity</label>
								<div class="controls">
									<form:errors path="capacity" cssStyle="color: #ff0000;" />
									<form:input path="capacity" class="form-control"
										style="color:black" id="capacity" />
								</div>
							</div>
						</div>
						<div class="span6 bgcolor">
							<div class="control-group">
								<label class="control-label" for="city">Unity</label>
								<div class="controls">
									<form:errors path="unity" cssStyle="color: #ff0000;" />
									<form:input path="unity" class="form-control" id="unity"
										type="text" style="color:black" />
								</div>
							</div>
						</div>
					</div>
					<div class="row-fluid">

						<!--/span-->
						<div class="span6 bgcolor">
							<div class="control-group">
								<label class="control-label" for="state">Box Capacity</label>
								<div class="controls">
									<form:errors path="boxCapacity" cssStyle="color: #ff0000;" />
									<form:input path="boxCapacity" class="form-control"
										id="boxCapacity" style="color:black" type="text" />
								</div>
							</div>
						</div>
						<div class="span6 bgcolor">
							<div class="control-group">
								<label class="control-label" for="state">Supplier</label>
								<div class="controls">
									<form:errors path="idSupplier" cssStyle="color: #ff0000;" />
									<form:select path="idSupplier" class="form-control">
										<form:option value="NONE" label="--- Select ---" />
										<form:options path="mapSup"  items="${productForm.mapSup}" />
									</form:select>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
					<!--/row-->
					<br />
					<!--/row-->
					<div class="span4">
						<button id="save" class="btn btn-primary" type="submit"
							value="Save">Save</button>
					</div>
					<!--/span-->
				</div>
			</form:form>
		</div>
		<hr>
		<%@ include file="../layouts/_footer.jsp"%>
	</div>
</body>
</html>