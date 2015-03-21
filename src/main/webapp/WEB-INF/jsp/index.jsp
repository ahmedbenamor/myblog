<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/WEB-INF/layout/taglib.jsp" %>
<h1>Latest items</h1>

 <table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>date</th>
					<th>item</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${items}" var="item">
			<tr>
			<td>
			<c:out value="${item.publishDate}"></c:out>
			
			<br/>
			<c:out value="${item.blog.name}"></c:out>
			</td>
			<td>
			<strong>
			<a href='<c:out value="${item.link}"></c:out>' target="_blank" >
			<c:out value="${item.title}"></c:out>
			</a>
			</strong>
			<br/>
			${item.description}
			</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>