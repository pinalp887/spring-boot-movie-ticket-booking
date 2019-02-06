<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</style>
</head>
<body>
	<div class="container-fluid"">

		<div class="row">
			<div class="form-group">
				<div class="col-md-6">
					<h1 align="center">set Movie</h1>
				</div>
			</div>
		</div>
		<form:form action="/movieAllotment/save" modelAttribute="setshow"
			enctype="multipart/form-data" class="form-horizontal bgcolor"
			method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2" for="movieName">Movie
					Name :</label>
				<div class="col-sm-6">
					<select name="movieName" class="col-sm-5 " required>
						<option value=""></option>
						<c:forEach items="${movie }" var="l">
							<option value="${l.name}">${l.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="totalShow">totalShow
				</label>
				<div class="col-sm-6">
					<input type="number" class="form-control" id="totalShow"
						name="totalShow" required>
				</div>
			</div>
			<div class="form-group1"></div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="date">date </label>
				<div class="col-sm-6">

					<form:input type="date" class="form-control" id="datetimepicker"
						path="date" required />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="screen">screen </label>
				<div class="col-sm-6">
					<select name="screen" class="col-sm-5" required>
						<option value=""></option>
						<c:forEach items="${list }" var="l">
							<option value="${l.id }">${l.screenName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<button type="submit" class="btn btn-default btn btn-success"
						id="demo">Submit</button>
				</div>
			</div>

		</form:form>

	</div>
</body>

</script>
</html>