<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="com.cignex.entities.UserBooked"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of bookings</title>
</head>
<body>
	<h1 align="center">Boked Seats</h1>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Movie Name</th>
					<th>Screen Name</th>
					<th>Date</th>
					<th>Time</th>
					<th>BookedSeats</th>
					<th>Total</th>
				</tr>
			<tbody>
	<%
		List<UserBooked> booked = (List) request.getAttribute("list");
		List<String> bs = new ArrayList<String>();
		for (UserBooked u : booked) {
			if (bs != null) {
				bs = Arrays.asList(u.getBookedSeats());
			}
	%>
	
				<tr>
					<td><%= u.getId() %></td>
					<td><%= u.getMovie().getName() %></td>
					<td><%= u.getScreen().getScreenName() %></td>
					<td><%= u.getDate() %></td>
					<td><%= u.getTime() %></td>
					<td><%= bs %></td>
					<td><%= u.getTotal() %></td>
					
				</tr>
			</tbody>
			</thead>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>