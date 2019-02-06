<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<title>Login Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body class="text-center">

	<div class="container pt-3">
		<div class="row justify-content-sm-center">
			<div class="col-sm-6 col-md-4">

				<div class="card border-info text-center">
					<div class="card-header">Log in</div>
					<div class="card-body">
						<form method="POST" action="${contextPath}/login-process"
							class="form-signin">
							<div class="form-group ${error != null ? 'has-error' : ''}">
								<span style="color: red;">${msg}</span>
								<div class="row">
									<div class="col-md-1 field-label-responsive">
										<label for="name">Name</label>
									</div>
									<div class="col-md-9">
										<div class="form-group">
											<div class="input-group mb-2 mr-sm-2 mb-sm-0">
												<div class="input-group-addon" style="width: 2.6rem">
													<i class="fa fa-user"></i>
												</div>
												<input type="text" name="username" class="form-control"
													autofocus="autofocus" required/>
											</div>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-md-1 field-label-responsive">
										<label for="name">Password</label>
									</div>
									<div class="col-md-9">
										<div class="form-group">
											<div class="input-group mb-2 mr-sm-2 mb-sm-0">
												<div class="input-group-addon" style="width: 2.6rem">
													<i class="fa fa-user"></i>
												</div>
												<input type="password" name="password" class="form-control" required />
											</div>
										</div>
									</div>
								</div>
								<button class="btn btn-lg btn-primary " type="submit">Log
									In</button>
							</div>

						</form>
					</div>
				</div>
				<a href="/user" class="float-right">Create an account </a>
			</div>
		</div>
	</div>

</body>

</html>