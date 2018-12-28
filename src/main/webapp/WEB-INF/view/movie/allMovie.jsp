<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<table class="table table-condensed">
			<thead>
				<tr>
					<th>ID</th>
					<th>name</th>
					<th>Duration time</th>
					<th>total show</th>
					<th>movie path</th>
					<th>rate</th>
					<th>Cast</th>
					<th align="center">ACTION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="l">
				<c:url var="editUrl" value="/Movie/get">
					<c:param name="id" value="${l.id }"></c:param>
				</c:url>
				<c:url var="deleteUrl" value="/Movie/delete/${l.id}"></c:url>
					<tr>
						<td><c:out value="${l.id }"></c:out></td>
						<td><c:out value="${l.name }"></c:out></td>
						<td><c:out value="${l.durationTime }"></c:out></td>
						<td><c:out value="${l.totalShowPerDay }"></c:out></td>
						<td><c:out value="${l.moviePath }"></c:out></td>
						<td><c:out value="${l.rate }"></c:out></td>
						<td><c:out value="${l.cast }"></c:out></td>
						<td><a href="${editUrl }">EDIT</a> | | <a href="${deleteUrl }">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>