<%@ include file="layouts/_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is your dashboard</title>
</head>
<body>
  <div class="jumbotron">
	<div class="container">
		<h1>Title : ${title}</h1>	
		<h1>Message : ${message}</h1>
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
	 	<!-- csrt for log out-->
		<form action="${logoutUrl}" method="post" id="logoutForm">
		  <input type="hidden" 
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		</form>
	 	<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
	 	<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				Welcome : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>
 	</div>
 </div>	
	
</body>
</html>