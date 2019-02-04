<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	welcome ${name }
	<br>
	<br> ${id }${role }
	
	<c:set var="role1" scope="session" value="[ROLE_ADMIN]" />
	<c:set var="role2" scope="session" value="[ROLE_USER]" />
	
	<c:choose>
		<c:when test="${role == role1 }">
			admin
		</c:when>
		<c:when test="${role == role2 }">
			user
		</c:when>
	</c:choose>
	</body>
</html>