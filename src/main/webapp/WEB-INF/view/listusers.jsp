<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<h1 align="center">User List</h1>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>last Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Action</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="t">
					<c:url value="/user/delete/${t.id }" var="deleteUrl">
					</c:url>
					<c:url value="/user/get/${t.id }" var="editUrl">
					</c:url>
					<tr>
						<td>${t.id }</td>
						<td>${t.name }</td>
						<td>${t.lastName }</td>
						<td>${t.email }</td>
						<td>${t.password }</td>

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