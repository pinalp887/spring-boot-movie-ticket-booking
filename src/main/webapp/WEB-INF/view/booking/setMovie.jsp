<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<div class="container-fluid">
		<h1 align="center">Set Movie Show</h1>

		<form:form action="/book/save" modelAttribute="setshow"
			class="form-horizontal bgcolor" method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2" for="movieName">Movie
					Name :</label>
				<div>
					<select name="movieName" class="form-control">
						<option value=""></option>
						<c:forEach items="${list }" var="l">
							<option value="${l.id}">${l.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="totalShow">totalShow
				</label>
				<div>
					<input type="number" class="form-control" id="totalShow"
						name="totalShow" required>
				</div>
			</div>
			<div class="form-group1"></div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="date">date </label>
				<div>

					<input type="date" class="form-control" id="datetimepicker"
						name="date" required/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="screen">screen </label>
				<div>
					<select name="screen" class="form-control">
						<option value=""></option>
						<c:forEach items="${slist }" var="l">
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