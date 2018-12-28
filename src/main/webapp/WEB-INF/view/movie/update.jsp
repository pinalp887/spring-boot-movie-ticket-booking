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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style type="text/css">
.bgcolor {
	color: gray;
}
</style>
</head>
<body>
	<div class="container-fluid"">
		<nav class="navbar navbar-expand-lg navbar-dark bg-danger bgcolor">

			<div class="collapse navbar-collapse" id="navbarSupportContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
				</ul>
			</div>
		</nav>
		<div class="row">
			<div class="form-group">
				<div class="col-md-3">
					<h1>Add Movie</h1>
				</div>
			</div>
		</div>
		<form:form action="/addMovie/save" modelAttribute="movie"
			enctype="multipart/form-data" class="form-horizontal bgcolor" method="POST">
			<div class="form-group">
			<form:input type="hidden" class="form-control" id="id" path="id" />
				<label class="control-label col-sm-2" for="name">name:</label>
				<div class="col-sm-6">
					<form:input type="text" class="form-control" id="name" path="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="durationTime">DurationTime
					:</label>
				<div class="col-sm-6">
					<form:input type="time" class="form-control" id="durationTime"
						path="durationTime" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="totalShowPerDay">Total
					ShowPerDay :</label>
				<div class="col-sm-6">
					<form:input type="text" class="form-control" id="totalShowPerDay"
						path="totalShowPerDay" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="moviePath">MoviePath
					:</label>
				<div class="col-md-1">
					<input type="file" class="file" id="moviePath" name="file" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="rate">Rate :</label>
				<div class="col-sm-6">
					<form:input type="text" class="form-control" id="rate" path="rate" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Cast :</label>
				<div class="col-sm-6">
					<form:input type="text" class="form-control" id="rate" path="cast" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<button type="submit" class="btn btn-default btn btn-success">Submit</button>
				</div>
			</div>

		</form:form>

	</div>
</body>
</html>