<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/taglib.jsp"%>

<form:form commandName="user" cssClass="form-horizontal">
<div class="form-group">
<label for="name" class="col-sm-2 control-label">Name :</label>
<div class="col-sm-10">
      <form:input path="name" type="text" class="form-control" id="name" placeholder="Name" name="name"/>
    </div>
</div>

<div class="form-group">
<label for="email" class="col-sm-2 control-label">Email :</label>
<div class="col-sm-10">
      <form:input path="email" type="email" class="form-control" id="email" placeholder="Email" name="email"/>
    </div>
</div>


<div class="form-group">
<label for="password" class="col-sm-2 control-label">Password :</label>
<div class="col-sm-10">
      <form:password path="password" class="form-control" id="email" placeholder="Password" name="password"/>
    </div>
</div>

<div class="form-group">

<div class="col-sm-2">
      <input type="submit" value="Save" class="btn btn-lg btn-primary"/>
 </div>
</div>
</form:form>