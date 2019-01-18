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
<c:forEach items="${slist}" var="s">
<c:url value="/book/getShow" var="getShow">
	<c:param name="id" value="${s.id }"></c:param>
</c:url>
${s.id }
<a href="${getShow }" class="btn btn-success">${s.time }</a>
</c:forEach>
</body>
</html>