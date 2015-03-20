<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/taglib.jsp"%>

<form:form commandName="user" cssClass="form-horizontal registrationForm">
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">registration successfull</div>
	</c:if>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name :</label>
		<div class="col-sm-10">
			<form:input path="name" type="text" class="form-control" id="name"
				placeholder="Name" name="name" />
				<form:errors path="name"/>
		</div>
	</div>

	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email :</label>
		<div class="col-sm-10">
			<form:input path="email" type="text" class="form-control" id="email"
				placeholder="Email" name="email" />
				<form:errors path="email"/>
		</div>
	</div>


	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password
			:</label>
		<div class="col-sm-10">
			<form:password path="password" class="form-control" id="password"
				placeholder="Password" name="password" />
				<form:errors path="password"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password again
			:</label>
		<div class="col-sm-10">
			<input type="password" name="password_match" id="password_match" class="form-control"/>
		</div>
	</div>

	<div class="form-group">

		<div class="col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		</div>
	</div>
</form:form>
<script>
$(document).ready(function(){
	$(".registrationForm").validate(
	{
		rules : {
			name : {
				required : true,
				minlength : 3
			},
			email : {
				required : true,
				email : true
			},
			password : {
				required : true,
				minlength : 5
			},
			password_match : {
				required : true,
				equalTo : "#password"
			}
			
			
		},
		highlight: function(element){
			$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		},
		unhighlight: function(element){
			$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
		}
	}		
	);
})
</script>