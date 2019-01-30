<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<h1 align="center">Movie List</h1>
	<div class="container">


		<div class="row">


			<div class="card-deck">

				<c:forEach items="${list }" var="l">
					<div class="card">

						<c:url var="editUrl" value="/movie/get">
							<c:param name="id" value="${l.id }"></c:param>
						</c:url>
						<c:url var="deleteUrl" value="/movie/delete/${l.id}"></c:url>
						<center>
							<img
								class="pinned-repo-item p-3 mb-3 border border-gray-dark rounded-1 public source"
								width="250" height="200"
								src="data:image/png;base64,${ l.moviePath}" border="20px" />
						</center>
						<div class="card-body">
							<div class="clear" align="center"">${l.name }</div>
							<div class="clear" align="center"">${l.cast }</div>
							<div class="clear" align="center"">
								<a type="button" class="btn btn-sucess" href="${editUrl }">EDIT</a>
								| | <a class="btn btn-danger" href="${deleteUrl }">DELETE</a>
							</div>

						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
</body>
</html>