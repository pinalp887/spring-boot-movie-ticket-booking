<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<div class="container-fluid">
		<div class="container">
			<form:form class="form-horizontal bgcolor" method="POST"
				action="/user/save" modelAttribute="user">
				<form:hidden path="id"/>
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
									<form:input path="roles" class="form-control" />
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