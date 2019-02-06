<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="container-fluid"">
	
		<center>
			<h1>Add Movie</h1>
		</center>
		<form:form action="/movie/save" modelAttribute="movie"
			enctype="multipart/form-data" class="form-horizontal bgcolor"
			method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name :</label>
				<div>
					<form:input type="text" class="form-control" id="name" path="name"  />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="durationTime">DurationTime
					:</label>
				<div>
					<form:input type="miniute" class="form-control inputs time"
						id="durationExample" path="durationTime" />
				</div>
			</div>

			<div class="custom-file">
				<input type="file" class="custom-file-input" id="moviePath"
					name="file" required> <label class="custom-file-label"
					for="validatedCustomFile">Choose file...</label>
				
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="rate">Rate :</label>
				<div>
					<form:input type="text" class="form-control" id="rate" path="rate" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Cast :</label>
				<div>
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
<script type="text/javascript">
	$(document).ready(function() {
		$('#country').change(function(event) {
			var val = $(this).val();
			alert(val);
			$.ajax({
				url : '/movie/state',
				dataType : 'json',
				type : 'GET',
				data : {
					id : $('#country').val()
				},
				success : function(data) {
					$('state').empty();
				}
			});

		});
	});
</script>

</html>