<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<c:set var="role1" scope="session" value="[ROLE_ADMIN]" />
	<c:set var="role2" scope="session" value="[ROLE_USER]" />

	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<div class="collapse navbar-collapse" id="navbarSupportContent">


			<c:choose>
				<c:when test="${role == role1 }">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="/logout"><i
								class="fa fa-bullseye"></i> Log Out</i></a></li>
					</ul>
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link"
							href="/movie/register"><i class="fa fa-plus"> Add Movie</i></a></li>
					</ul>
					<ul class="navbar-nav ml-auto">

						<li class="nav-item"><a class="nav-link" href="/book/setShow"><i
								class="fa fa-floppy-o"> Set movie Show</i></a></li>
					</ul>
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="/screen/list"><i
								class="fa fa-folder-open"> Screens</i></a></li>
					</ul>

					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="/movie/list"><i
								class="fa fa-list"> Movie list</i></a></li>
					</ul>
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link"
							href="/book/datewise"><i class="fa fa-film"> Book Seats</i></a></li>
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/user/booked"><i
								class="fa fa-folder-open"> Booked Seats</i></a></li>
					</ul>
				</c:when>
				<c:when test="${role == role2 }">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/logout"><i
								class="fa fa-bullseye"></i> Log Out</i></a></li>
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="/book/datewise"><i class="fa fa-file-movie-o"> Book
									Seats</i></a></li>
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/user/booked"><i
								class="fa fa-folder-open"> Booked Seats</i></a></li>
					</ul>
				</c:when>
			</c:choose>
		</div>
	</nav>


</body>
</html>