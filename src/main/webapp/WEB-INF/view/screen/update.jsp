<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../header.jsp" %>
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
		
		
					<h1 align="center">Update Screen</h1>
				
		<form:form action="/screen/save" modelAttribute="screen"
			enctype="multipart/form-data" class="form-horizontal bgcolor"
			method="POST">
			<form:hidden class="form-control" id="screenName"
						path="id" />
			<div class="form-group">
				<label class="control-label col-sm-2" for="screenName">Screen Name:</label>
				<div>
					<form:input type="text" class="form-control" id="screenName"
						path="screenName" />
				</div>
			</div>
			<div class="form-group" id="platiniumSeats">
				<label class="control-label col-sm-2" for="platiniumSeats">Platinium Seats
					:</label>
				<div>
					<input type="text" class="form-control amount"
						id="platiniumSeats" name="platiniumSeats" min="10"  max="20" required>
				</div>
			</div>
			<div class="form-group" id="silverSeat">
				<label class="control-label col-sm-2" for="silverSeats">Silver Seats
					:</label>
				<div>
					<input type="text" class="form-control amount"
						id="silverSeats" name="silverSeats" min="10"  max="20" required>
				</div>
			</div>
			<div class="form-group" id="goldSeats">
				<label class="control-label col-sm-2" for="goldSeats">Gold Seats
					:</label>
				<div>
					<input type="text" class="form-control amount"
						id="goldSeats" name="goldSeats" min="10"  max="20" required>
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

</html>