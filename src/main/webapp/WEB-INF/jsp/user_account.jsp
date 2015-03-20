<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/taglib.jsp"%>

	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Ceate Blog
</button>

<!-- Modal -->
<form:form commandName="blog" cssClass="form-horizontal" method="POST">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Create new Blog</h4>
      </div>
      <div class="modal-body">
       
       <div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name :</label>
		<div class="col-sm-10">
			<form:input path="name" type="text" class="form-control" id="name"
				placeholder="Name" name="name" />
				<form:errors path="name"/>
		</div>
		</div>
		 <div class="form-group">
		<label for="url" class="col-sm-2 control-label">URL :</label>
		<div class="col-sm-10">
			<form:input path="url" type="text" class="form-control" id="url"
				placeholder="URL" name="url" />
				<form:errors path="url"/>
		</div>
	</div>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Save"/>
       
      </div>
    
    </div>
  </div>
</div>
</form:form>
<br/><br/>
<script>
$(document).ready(function(){
	  $('.nav-tabs a:first').tab('show');
	  $('.triggerRemove').click(function(e){
		  e.preventDefault();
		  $('#AlertRemove .removeBtn').attr('href',$(this).attr('href'));
		  $('#AlertRemove').modal();
		  
	  })
})
</script>
<div role="tabpanel">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
  <c:forEach items="${user.blogs}" var="blog">
    <li role="presentation"><a href="#blog_${blog.id}" aria-controls="blog_${blog.id}" role="tab" data-toggle="tab">${blog.name}</a></li>
    
    </c:forEach>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
   <c:forEach items="${user.blogs}" var="blog">
    <div role="tabpanel" class="tab-pane active" id="blog_${blog.id}">
    <h1>${blog.name}</h1>
    <p>
    
    <a href='<spring:url value="/blog/remove/${blog.id}"></spring:url>' class="btn btn-danger triggerRemove">remove this blog</a>
    ${blog.url}
    </p>
    <table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>Title</th>
					<th>Link</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${blog.items}" var="item">
			<tr>
			<td>${item.title}</td>
			<td>${item.link}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
    </div>
    </c:forEach>
    
  </div>

</div>

	<!-- Modal -->
<div class="modal fade" id="AlertRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
      </div>
      <div class="modal-body">
        Are you sure !
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
       
      </div>
    </div>
  </div>
</div>
		
		


