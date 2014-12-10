<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
 --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL"
	value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/assets/css/bootstrap-responsive.css" />"
	rel="stylesheet">
	
<link href="<c:url value="/resources/assets/css/main.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/assets/css/font-style.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/assets/css/flexslider.css" />"
	rel="stylesheet">
<!-- Google Fonts call. Font Used Open Sans & Raleway -->
<link href="http://fonts.googleapis.com/css?family=Raleway:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>

<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .bgcolor {
        background-color: none;
      }      
      .lightblue {
       background-color: none;
      }
</style>
<script type="text/javascript">
$(document).ready(function () {

    $("#btn-blog-next").click(function () {
      $('#blogCarousel').carousel('next')
    });
     $("#btn-blog-prev").click(function () {
      $('#blogCarousel').carousel('prev')
    });

     $("#btn-client-next").click(function () {
      $('#clientCarousel').carousel('next')
    });
     $("#btn-client-prev").click(function () {
      $('#clientCarousel').carousel('prev')
    });
    
});

 $(window).load(function(){

    $('.flexslider').flexslider({
        animation: "slide",
        slideshow: true,
        start: function(slider){
          $('body').removeClass('loading');
        }
    });  
});

</script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<!-- NAVIGATION MENU -->

    <div class="navbar-nav navbar-inverse navbar-fixed-top">
        <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html"><img src="<c:url value="/resources/assets/img/logo30.png" />"  alt="">Hang</a>
        </div> 
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="${baseURL}/dashboard"><i class="icon-home icon-white"></i>Home</a></li>
              <li><a href="#"><i class="icon-folder-open icon-white"></i>Settings</a></li>
              <li><a href="#"><i class="icon-calendar icon-white"></i>Help</a></li>
              <li><a href="#"><i class="icon-th icon-white"></i>About</a></li>
              	<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a href="javascript:formSubmit()" class="icon-th icon-white"> Logout</a></li>
				</c:if>

            </ul>
          </div><!--/.nav-collapse -->
        </div>
    </div>


<%-- 	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Hang</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${baseURL}/dashboard">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="<c:url value='help' />">Help</a></li>
				<li><a href="#">About</a></li>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a href="javascript:formSubmit()"> Logout</a></li>
				</c:if>
			</ul>
		</div>
	</div> --%>
	<c:url value="/j_spring_security_logout" var="logoutUrl" /> <!-- csrt for log out-->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script> </nav>
	
</body>
</html>