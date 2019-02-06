<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<h1 align="center">Total Shows</h1>
<c:forEach items="${show}" var="s">
<c:url value="/book/getShow" var="getShow">
	<c:param name="id" value="${s.id }"></c:param>
</c:url>
<b><i class="fa fa-film">Book </i></b>
<div>
<%-- <a href="${getShow }" class="btn btn-success">${s.date } ${s.movie.name }</a> --%>
<a href="${getShow }" class="btn btn-success">${s.time } ${s.movie.name }</a>
</div>

<%-- ${s.id } --%><%-- 
<a href="${getShow }" class="btn btn-success">${s.time }</a>
<a href="${getShow }" class="btn btn-success">${s.date }</a> --%>
</c:forEach>
</body>
</html>