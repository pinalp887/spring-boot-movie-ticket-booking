<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
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
	<form:form action="/register" modelAttribute="user"
		enctype="multipart/form-data">
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">First Name :</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="firstName" path="firstName"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Last Name :</label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="lastName" path="lastName"/>
			</div>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
</body>
</html>