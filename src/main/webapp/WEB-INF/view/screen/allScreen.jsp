<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<h1>${name}</h1>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="t">
				 	<c:url value="/delete" var="deleteUrl">
						<c:param name="id" value="${t.id }"></c:param>
					</c:url>
					<c:url value="/get" var="editUrl">
						<c:param name="id" value="${t.id }"></c:param>
					</c:url> 
					<tr>
						<td>${t.id }</td>
						<td>${t.screenName }</td>
					
						<td><a type="button" class="btn btn-primary btn-rounded"
							href="${editUrl }">EDIT</a> <a type="button"
							class="btn btn-danger" href="${deleteUrl }">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<a href="/screen/new">Add new</a>
	</div>
</body>
</html>