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
<title>Registration Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<div class="container-fluid">
		<div class="container">
			<form:form class="form-horizontal bgcolor" method="POST"
				action="/user/save" modelAttribute="user">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h2>Register New User</h2>
						<hr>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 field-label-responsive">
						<label for="name">Name</label>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-user"></i>
								</div>
								<form:input path="name" class="form-control" />
							</div>
						</div>
					</div>
					<!-- <div class="col-md-3">
						<div class="form-control-feedback">
							<span class="text-danger align-middle"> Put name validation error messages here
							</span>
						</div>
					</div> -->
				</div>
				<div class="row">
					<div class="col-md-3 field-label-responsive">
						<label for="name">Last Name</label>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-user"></i>
								</div>
								<form:input path="lastName" class="form-control" />
							</div>
						</div>
					</div>
					<!-- <div class="col-md-3">
						<div class="form-control-feedback">
							<span class="text-danger align-middle"> Put name validation error messages here
							</span>
						</div>
					</div> -->
				</div>
				<div class="row">
					<div class="col-md-3 field-label-responsive">
						<label for="email">E-Mail Address</label>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-at"></i>
								</div>
								<form:input path="email" class="form-control" />
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-control-feedback">
							<span class="text-danger align-middle"> <!-- Put e-mail validation error messages here -->
							</span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 field-label-responsive">
						<label for="password">Password</label>
					</div>
					<div class="col-md-6">
						<div class="form-group has-danger">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-key"></i>
								</div>
								<form:password path="password" class="form-control" />
							</div>
						</div>
					</div>
					<!-- <div class="col-md-3">
						<div class="form-control-feedback">
							<span class="text-danger align-middle"> <i
								class="fa fa-close"> Example Error Message</i>
							</span>
						</div>
					</div> -->
				</div>
				<div class="row">
					<div class="col-md-3 field-label-responsive">
						<label for="roles">Role</label>
					</div>
					<div class="col-md-6">
						<div class="form-group has-danger">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-key"></i>
								</div>
								<form:select path="roles" class="form-control">
								
										<form:option value="${list.roleId}">${list.role }</form:option>
								
								</form:select>
							</div>
						</div>
					</div>
					<!-- <div class="col-md-3">
						<div class="form-control-feedback">
							<span class="text-danger align-middle"> <i
								class="fa fa-close"> Example Error Message</i>
							</span>
						</div>
					</div> -->
				</div>
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<button type="submit" class="btn btn-success">
							<i class="fa fa-user-plus"></i> Register
						</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>

</html>