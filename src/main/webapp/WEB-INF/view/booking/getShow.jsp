<%@page import="com.cignex.entities.Screen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.io.File"%>
<%@page import="com.cignex.entities.Movie"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@page import="com.cignex.entities.Show"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
</head>
<body>

	<%
		Show show = (Show) request.getAttribute("show");
		Movie movie = show.getMovie();
		int id = show.getId();

		String name = movie.getName();
		Screen screen = show.getScreen();
		List<String> gs = Arrays.asList(screen.getGoldSeats());
		List<String> ps = Arrays.asList(screen.getPlatiniumSeats());
		List<String> ss = Arrays.asList(screen.getSilverSeats());
		File file = new File(movie.getMoviePath().toString());
		byte[] byteimg = Files.readAllBytes(file.toPath());
		String imgString = Base64.encodeBase64String(byteimg);
		List<String> bs = new ArrayList<String>();
		if (show.getBookedSeats() != null) {
			bs = Arrays.asList(show.getBookedSeats());

		}
	%>
	<div class="col-sm-12">
		<div class="card-deck">

			<img
				class="pinned-repo-item p-3 mb-3 border border-gray-dark rounded-1 public source"
				width="250" height="200" src="data:image/png;base64,<%=imgString%>"
				border="20px"  ontoggle=""/>

		</div>
	</div>
	<div class="container">
		<div class="row">

			<div class="col-sm-10">
				<!-- Default unchecked -->
				<div class="check">
					<form:form action="/book/bookT" method="post" modelAttribute="show">
						<form:hidden path="id" />
						<b><i>Platinium Seats</i></b>
						<div style="border: thin solid black;">
						
							<%
								for (int i = 1; i <= ps.size(); i++) {
										if (bs.contains("p" + i)) {
							%>
							<input type="checkbox" data-toggle="toggle"
								data-on="p<%=i%> booked<br>" data-off="p<%=i%><br>"
								data-size="mini" name="p<%=i%>" id="book" value="p<%=i%>"
								checked="checked" readonly="readonly" disabled="disabled">
							&nbsp;&nbsp;&nbsp;
							<%
								} else {
							%>
							<input type="checkbox" data-toggle="toggle" data-on="booked<br>"
								data-off="p<%=i%><br>" data-size="mini" name="p<%=i%>" id="book"
								value="p<%=i%>"> &nbsp;&nbsp;&nbsp;
							<%
								}
							%>

							<%
								}
							%>
						</div>
						<b><i>Silver Seats</i></b>
						<div style="border: thin solid black;">
							<%
								for (int i = 1; i <= ss.size(); i++) {
										if (bs.contains("s" + i)) {
							%>
							<input type="checkbox" data-toggle="toggle"
								data-on="s<%=i%> booked<br>" data-off="s<%=i%><br>"
								data-size="mini" name="s<%=i%>" id="book" value="s<%=i%>"
								checked="checked" readonly="readonly" disabled="disabled">
							&nbsp;&nbsp;&nbsp;
							<%
								} else {
							%>
							<input type="checkbox" data-toggle="toggle" data-on="booked<br>"
								data-off="s<%=i%><br>" data-size="mini" name="s<%=i%>" id="book"
								value="s<%=i%>"> &nbsp;&nbsp;&nbsp;
							<%
								}
							%>

							<%
								}
							%>
						</div>
						<b><i>Gold Seats</i></b>
						<div style="border: thin solid black;">
							<%
								for (int i = 1; i <= gs.size(); i++) {
										if (bs.contains("g" + i)) {
							%>
							<input type="checkbox" data-toggle="toggle"
								data-on="g<%=i%> booked<br>" data-off="g<%=i%><br>"
								data-size="mini" name="g<%=i%>" id="book" value="g<%=i%>"
								checked="checked" readonly="readonly" disabled="disabled">
							&nbsp;&nbsp;&nbsp;
							<%
								} else {
							%>
							<input type="checkbox" data-toggle="toggle" data-on="booked<br>"
								data-off="g<%=i%><br>" data-size="mini" name="g<%=i%>" id="book"
								value="g<%=i%>"> &nbsp;&nbsp;&nbsp;
							<%
								}
							%>

							<%
								}
							%>
						</div>
						<input type="submit" class="btn btn-sucess" value="save">
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>