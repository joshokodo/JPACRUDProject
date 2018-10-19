<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Let The Hunt Begin!</title>
</head>
<body>

	<c:if test="${bountiesByName == true}">
		<h2>Search by Name</h2>
	</c:if>
	<c:if test="${bountiesByCrime == true}">
		<h2>Search by Crime</h2>
	</c:if>
</body>
</html>