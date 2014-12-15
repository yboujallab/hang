<%@ include file="../layouts/_header.jsp"%>
<body>
		<div class="container">
			<div class="container-fluid">
			<form:form method="POST" action="${pageContext.request.contextPath}/suppliers/add"
				commandName="supForm" class="form-horizontal">
				<legend>Add a new Supplier</legend>
					<div class="span8">
						<div class="row-fluid">
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="name">Supplier Name</label>
									<div class="controls">
										<form:errors path="name" cssStyle="color: #ff0000;" />
										<form:input class="form-control" path="name"
											style="color:black" type="text" />
									</div>
								</div>
							</div>
						<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="activity">Supplier Activity</label>
									<div class="controls">
										<form:errors path="activity" cssStyle="color: #ff0000;" />
										<form:input class="form-control" path="activity"
											style="color:black" type="text"/>
									</div>
								</div>
							</div>								
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="description">Supplier
										Description</label>
									<div class="controls">
										<form:errors path="description"
											cssStyle="color: #ff0000;" />
										<form:textarea path="description" class="form-control"
											style="color:black" id="description" />
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
											id="address"
											 />
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
											type="text" style="color:black" />
									</div>
								</div>
							</div>
							<!--/span-->
							<div class="span6 bgcolor">
								<div class="control-group">
									<label class="control-label" for="state">Country</label>
									<div class="controls">
										<form:input path="country" class="form-control" id="country"
											style="color:black" type="text" />
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
										<form:errors path="postCode" cssStyle="color: #ff0000;" />
										<form:input path="postCode" class="form-control" id="postCode"
											type="text" style="color:black"  />
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