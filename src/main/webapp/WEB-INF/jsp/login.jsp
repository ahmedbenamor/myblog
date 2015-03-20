<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/WEB-INF/layout/taglib.jsp" %>
     	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/signin.css">
 <form class="form-signin" action='<spring:url value="/j_spring_security_check"/>' method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="j_username" class="sr-only">Email address</label>
        <input type="text" name="j_username" id="j_username" class="form-control" placeholder="Name" required autofocus>
        <label for="j_password" class="sr-only">Password</label>
        <input type="password" id="j_password" name="j_password" class="form-control" placeholder="Password" required>
       
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>