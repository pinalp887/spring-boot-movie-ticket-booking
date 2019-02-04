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
	<h1 align="center">Movie Shows</h1>
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
							<form action="/book/getDatewise" method="post">
								<input type="hidden" name="id" value=${l.id }>
								<input type="date" name="date" id="date">
								<input type="submit" value="book" class="btn btn-success">
							</form>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
</body>
</html>