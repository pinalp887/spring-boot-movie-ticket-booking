<%@page import="java.sql.Date"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</style>
</head>
<body>
	<div class="container-fluid">

					<h1 align="center">Add show</h1>
				
		<form:form class="form-horizontal bgcolor" method="POST"
			action="/book/shows" modelAttribute="shows">

			<%
				int show = (int) request.getAttribute("total");

					String movieName = (String) request.getAttribute("movieName");
					String screen = (String) request.getAttribute("screen");
					//out.print(movieName);
					Date date = (Date) request.getAttribute("date");
					int count = 0;
					for (int i = 0; i < show; i++) {
						count++;
			%>
			<center>
				<b>Show <%=count%></b>
			</center>
			<div class="row" style="border: thin solid black;">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label class="control-label col-sm-6" for="movieName">Movie Name:</label>
						<div>
							<%-- <input type="text" class="form-control" id="screenName<%=count%>" name="screenName<%=count%>" /> --%>
							<input type="text" class="form-control" name="movieName" value="<%=movieName%>"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group col-md-6">
						<label class="control-label col-sm-2" for="screen">Screen Id:</label>
						<div>
							<%-- <input type="text" class="form-control" id="screenName<%=count%>" name="screenName<%=count%>" /> --%>
							<input type="number" class="form-control" name="screen" value="<%=screen%>"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group col-md-6">
						<label class="control-label col-sm-2" for="silverPrice">Date:</label>
						<div>
							<input type="date" class="form-control" id="date<%=count%>"
								name="date" value="<%=date%>" readonly="readonly">
						</div>
					</div>
					<div class="form-group col-md-6">
						<label class="control-label col-sm-6" for="showTime">Show
							time:</label>
						<div>
							<input type="time" class="form-control" id="showTime<%=count%>"
								name="showTime<%=count%>" required/>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label class="control-label col-sm-6" for="platiniumprice">Platinium Price:</label>
						<div>
							<input type="number" class="form-control"
								id="platiniumprice<%=count%>" name="platiniumprice<%=count%>" required/>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label class="control-label col-sm-6" for="silverPrice">Silver Price:</label>
						<div>
							<input type="number" class="form-control"
								id="silverPrice<%=count%>" name="silverPrice<%=count%>" required/>
						</div>
					</div>

					<div class="form-group col-md-4">
						<label class="control-label col-sm-6" for="goldPrice">Gold Price:</label>
						<div>
							<input type="number" class="form-control"
								id="goldPrice<%=count%>" name="goldPrice<%=count%>" required/>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
			<input type="hidden" name="count" value="<%=count%>">
			<input type="submit" value="submit" class="btn btn-sucess">
		</form:form>
	</div>
</body>

</html>