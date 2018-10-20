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
		<form action="bountiesByName.do">
			<label for="firstNameSearched">First Name</label>
			<input type="text" name="firstNameSearched" />
			<br>
			<label for="lastNameSearched">Last Name</label>
			<input type="text" name="lastNameSearched" />
			<br>
			<input type="submit" value="submit"/>
		</form>
	</c:if>
	<c:if test="${bountiesByCrime == true}">
		<h2>Search by Crime</h2>
	</c:if>
	
	<form action="home.do">
		<input type="submit" value="Home Page"/>
	</form>
</body>
</html>