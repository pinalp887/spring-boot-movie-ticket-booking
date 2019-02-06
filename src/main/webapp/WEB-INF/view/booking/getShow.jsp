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
<style type="text/css">
#tickets {
	display: none;
}
</style>
</head>
<body>

	<%
		Show show = (Show) request.getAttribute("show");
		Movie movie = show.getMovie();
		int id = show.getId();
		int m1 = show.getPlatiniumPrice();
		int m2 = show.getSilverPrice();
		int m3 = show.getGoldPrice();
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
				border="20px" ontoggle="" />

		</div>
	</div>
	<button type="button" id="tickets" class="btn btn-primary"
		data-toggle="modal" data-target="#exampleModal">Launch demo
		modal</button>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Enter Number Of
						seats</h5>
					<button type="button" id="close" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Total
								Seats:</label> <input type="number" class="form-control" id="seats"
								autofocus="autofocus" required>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="total" class="btn btn-primary">Save
						changes</button>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">

			<div class="col-sm-10">
				<!-- Default unchecked -->
				<div class="check">
					<!-- action="/book/bookT" -->
					<%-- 	<form:form  method="post" modelAttribute="show"
						id="bookForm"> --%>
					<form:form action="/book/bookT" method="post" modelAttribute="show"
						id="bookForm">
						<form:hidden path="id" />
						<input type="hidden" id="m1" name="m1" value="<%=m1%>">
						<input type="hidden" id="m2" name="m2" value="<%=m2%>">
						<input type="hidden" id="m3" name="m3" value="<%=m3%>">
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
							<input type="checkbox" class="platinium" data-toggle="toggle"
								data-on="booked<br>" data-off="p<%=i%><br>" data-size="mini"
								name="p<%=i%>" id="book" value="p<%=i%>">
							&nbsp;&nbsp;&nbsp;
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
							<input type="checkbox" class="silver" data-toggle="toggle"
								data-on="booked<br>" data-off="s<%=i%><br>" data-size="mini"
								name="s<%=i%>" id="book" value="s<%=i%>">
							&nbsp;&nbsp;&nbsp;
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
							<input type="checkbox" class="gold" data-toggle="toggle"
								data-on="booked<br>" data-off="g<%=i%><br>" data-size="mini"
								name="g<%=i%>" id="book" value="g<%=i%>">
							&nbsp;&nbsp;&nbsp;
							<%
								}
							%>

							<%
								}
							%>
						</div>
						<form:hidden path="time" />
						<form:hidden path="date" />
						<form:hidden path="movie.name" />
						<%-- <form:hidden path="screen.screenName" /> --%>
						<input type="number" name="t" id="t">
						<input type="submit" class="amount" id="save"
							class="btn btn-sucess" value="save">
					</form:form>
				</div>
			</div>
			<input type="hidden" name="totaLSeats" id="totaLSeats">
		</div>
	</div>

</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#tickets").trigger('click');
		$('#bookForm').hide();
		$('#total').click(function() {
			var total = $('#seats').val();
			$('#bookForm').show();
			$("#close").trigger('click');
			$('input[name="totaLSeats"]').val(total);

		});

		var m1 = $('#m1').val();
		var m2 = $('#m2').val();
		var m3 = $('#m3').val();

		var checked = 0;
		var totals = 0;

		$('.platinium').change(function() {
			totals = $('#totaLSeats').val();
			if ($(this).prop('checked') === true) {
				checked = checked + 1;
				var t = checked * m1;
				$("#t").val(t);
			} else {
				checked = checked - 1;
				var t = checked * m1;
				$("#t").val(t);
			}

		});
		$('.silver').change(function() {
			totals = $('#totaLSeats').val();
			if ($(this).prop('checked') === true) {
				checked = checked + 1;
				var t = checked * m2;
				$("#t").val(t);
			} else {
				checked = checked - 1;
				var t = checked * m2;
				$("#t").val(t);
			}

		});
		$('.gold').change(function() {
			totals = $('#totaLSeats').val();
			if ($(this).prop('checked') === true) {
				checked = checked + 1;
				var t = checked * m3;
				$("#t").val(t);
			} else {
				checked = checked - 1;
				var t = checked * m3;
				$("#t").val(t);
			}
		});
		$('#save').click(function() {
			if (totals < checked) {
				alert("you can select only " + totals + " seats");
				location.reload();
				return false;
			} else if (totals > checked) {
				alert("you have to select total " + totals + " seats");
				location.reload();
				return false;
			} else {
				console.log("done");
			}
		});
	});

</script>
</html>