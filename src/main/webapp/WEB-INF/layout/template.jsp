<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/navbar-fixed-top.css">
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/default.css">

<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>


	
	

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<tilesx:useAttribute name="current" />
<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<spring:url value="/"/>">My Blog</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="${current  == 'index' ? 'active' : '' }"><a href='<spring:url value="/"/>'>Home</a></li>
             <security:authorize access="hasRole('ROLE_ADMIN')">
            <li class="${current  == 'users' ? 'active' : '' }"><a  href="<spring:url value="/users"/>">Users</a></li>
            </security:authorize>
             <li class="${current  == 'signup' ? 'active' : '' }"><a  href="<spring:url value="/signup"/>">Signup</a></li>
             <security:authorize access="! isAuthenticated()">
              <li class="${current  == 'login' ? 'active' : '' }"><a  href="<spring:url value="/login"/>">Login</a></li>
              </security:authorize>
               <security:authorize access="isAuthenticated()">
                <li class="${current  == 'account' ? 'active' : '' }"><a  href="<spring:url value="/account"/>">My account</a></li>
               <li><a  href="<spring:url value="/logout"/>">Logout</a></li>
               </security:authorize>
          
            
          </ul>
        
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
     <div class="jumbotron">
    
	<tiles:insertAttribute name="body" />
	<br />
	<br />
	
	</div>
	<center>
	<tiles:insertAttribute name="footer" />
	</center>
</div>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
	
</body>
</html>