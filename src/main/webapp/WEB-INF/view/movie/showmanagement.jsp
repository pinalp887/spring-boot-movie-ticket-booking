<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		
		<div class="row">
			<div class="form-group">
				<div class="col-md-6">
					<h1 align="center">add show</h1>
				</div>
			</div>
		</div>
		<form:form class="form-horizontal bgcolor" method="POST"
			action="/movieManagement/save" modelAttribute="management">

			<%
				Object show = request.getAttribute("name");

					String movieName = (String) request.getAttribute("moviename");
					String screen = (String) request.getAttribute("screen");
					//out.print(movieName);
					int sh = Integer.valueOf((String) show);
					out.print(sh);
					int count = 0;
					for (int i = 0; i < sh; i++) {
						count++;
			%>
			<div class="row" style="border: thin solid black;">
				<div class="form-group">
					<label class="control-label col-sm-2" for="movieName">movieName:</label>
					<div class="col-sm-3">
						<%-- <input type="text" class="form-control" id="screenName<%=count%>" name="screenName<%=count%>" /> --%>
						<input type="text" name="movieName" value="<%=movieName%>"
							readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="screenName">screenid:</label>
					<div class="col-sm-3">
						<%-- <input type="text" class="form-control" id="screenName<%=count%>" name="screenName<%=count%>" /> --%>
						<input type="text" name="screen" value="<%=screen%>"
							readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="showTime">Show
						time:</label>
					<div class="col-sm-3">
						<input type="time" class="form-control" id="showTime<%=count%>"
							name="showTime<%=count%>" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="platiniumprice">platiniumprice:</label>
					<div class="col-sm-3">
						<input type="number" class="form-control"
							id="platiniumprice<%=count%>" name="platiniumprice<%=count%>" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="silverPrice">silverPrice:</label>
					<div class="col-sm-3">
						<input type="number" class="form-control"
							id="silverPrice<%=count%>" name="silverPrice<%=count%>" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="goldPrice">goldPrice:</label>
					<div class="col-sm-3">
						<input type="number" class="form-control" id="goldPrice<%=count%>"
							name="goldPrice<%=count%>" required/>
					</div>
				</div>

			</div>
			<%
				}
			%>
			<input type="text" name="count" value="<%=count%>">
			<input type="submit" value="submit" class="btn btn-warning">
		</form:form>
	</div>
</body>

</html>