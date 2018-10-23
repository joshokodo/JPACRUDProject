<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Happy Hunting</title>
</head>
<body>
	<%@ include file="navi.jsp"%>
	<c:if test="${detailSearch == true }">
		<h2>Search for Specify Bounty</h2>

		<form action="nameSearch.do" method="POST">
			<h2>By Name</h2>
			<label for="firstNameSearched">First Name</label> <input type="text"
				name="firstName" value="" /> <br> <label
				for="lastNameSearched">Last Name</label> <input type="text"
				name="lastName" value="" /> <br> <label for="nicknameSearched">Nickname</label>
			<input type="text" name="nickname" value="" /> <input type="submit"
				name="name" value="submit" />
			<hr>
		</form>
		<form action="descriptionSearch.do" method="POST">
			<h2>By Description</h2>
			<label for="description">Description</label> <input type="text"
				name="description" /> <input type="submit" name="desciption"
				value="submit" />
			<hr>
		</form>
		<form action="wantedSearch.do" method="POST">
			<h2>Wanted Alive?</h2>
			<label>Yes</label><input type="radio" name="wantedAlive" value="Y" />
			<label>No</label><input type="radio" name="wantedAlive" value="N"
				checked /> <input type="submit" name="wantedAlive" value="submit" />
			<hr>
		</form>
		<form action="crimeSearch.do" method="POST">
			<h2>By Crime</h2>
			<select name="crimeCategory">
				<option value="J WALKING">J-Walking</option>
				<option value="PUBLIC INTOXICATION">Public Intoxication</option>
				<option value="DISORDERLY_CONDUCT">J-Walking</option>
				<option value="PETTY THEFT">Petty Theft</option>
				<option value="VANDALISM">Vandalism</option>
				<option value="RECKLESS DRIVING">Reckless Driving</option>
				<option value="TRESPASS">Trespass</option>

			</select> <input type="submit" name="crime" value="submit" />
			<hr>
		</form>
		<form action="priceSearch.do" method="POST">
			<h2>By Price Range</h2>
			Minimum:<input name="minPrice" min="0" max="2000000000" type="number" />
			Maximum:<input name="maxPrice" min="0" max="2000000000" type="number" />
			<input type="submit" name="price" value="submit" />
		</form>
	</c:if>
	<c:if test="${addBounty == true }">
		<h2>Create a new Bounty</h2>
		<form action="addBounty.do" method="POST">
			<h6>* Required Fields</h6>
			<label for="firstNameSearched">*First Name</label> <input type="text"
				name="firstName" pattern=".{3,}" required /> <br> <label
				for="lastNameSearched">*Last Name</label> <input type="text"
				name="lastName" pattern=".{3,}" required /> <br> <label
				for="nicknameSearched">Nickname</label> <input type="text"
				name="nickname" /> <br> <label for="description">*Description</label>
			<input type="text" name="description" pattern=".{3,}" required /> <br>
			<br> <label for="wantedAlive">*Wanted Alive Only?</label> <br>
			<label>Yes</label><input type="radio" name="wantedAlive" value="Y" />
			<label>No</label><input type="radio" name="wantedAlive" value="N"
				checked /> <br> <br> <label>*Crime Committed</label> <br>
			<select name="crime">
				<option value="J_WALKING">J-Walking</option>
				<option value="PUBLIC_INTOXICATION">Public Intoxication</option>
				<option value="DISORDERLY_CONDUCT">J-Walking</option>
				<option value="PETTY_THEFT">Petty Theft</option>
				<option value="VANDALISM">Vandalism</option>
				<option value="RECKLESS_DRIVING">Reckless Driving</option>
				<option value="TRESPASS">Trespass</option>

			</select> <br> <br> <label for="price">*Price</label> <input
				type="number" name="price" min="0" max="2000000000" required
				value="0" /> <br> <input type="submit" name="add"
				value="submit" />
		</form>
	</c:if>
	<c:if test="${edit == true }">
		<h2>Edit Bounty</h2>
		<form action="alterBounty.do" method="POST">
			<label for="firstNameSearched">First Name</label> <input type="text"
				pattern=".{3,}" required name="firstName"
				value="${editBounty.firstName }" /> <br> <label
				for="lastNameSearched">Last Name</label> <input type="text"
				pattern=".{3,}" required name="lastName"
				value="${editBounty.lastName }" /> <br> <label
				for="nicknameSearched">Nickname</label> <input type="text"
				name="nickname" value="${editBounty.nickname }" /> <br> <label
				for="description">Description</label> <input type="text"
				pattern=".{3,}" required name="description"
				value="${editBounty.description }" /> <br> <br> <label
				for="wantedAlive">Wanted Alive Only?</label> <br>
			<c:if test="${editBounty.wantedAlive == 89 }">
				<label>Yes</label>
				<input type="radio" name="wantedAlive" value="Y" checked />
				<label>No</label>
				<input type="radio" name="wantedAlive" value="N" />

			</c:if>
			<c:if test="${editBounty.wantedAlive == 78 }">
				<label>Yes</label>
				<input type="radio" name="wantedAlive" value="Y" />
				<label>No</label>
				<input type="radio" name="wantedAlive" value="N" checked />

			</c:if>
			<br> <br> <label>Crime Committed</label> <br> <select
				name="crime">

				<option value="J_WALKING"
					<c:if test="${editBounty.crime == 'J_WALKING' }">selected</c:if>>J-Walking</option>
				<option value="PUBLIC_INTOXICATION"
					<c:if test="${editBounty.crime == 'PUBLIC_INTOXICATION' }">selected</c:if>>Public
					Intoxication</option>
				<option value="DISORDERLY_CONDUCT"
					<c:if test="${editBounty.crime == 'DISORDERLY_CONDUCT' }">selected</c:if>>J-Walking</option>
				<option value="PETTY_THEFT"
					<c:if test="${editBounty.crime == 'PETTY_THEFT' }">selected</c:if>>Petty
					Theft</option>
				<option value="VANDALISM"
					<c:if test="${editBounty.crime == 'VANDALISM' }">selected</c:if>>Vandalism</option>
				<option value="RECKLESS_DRIVING"
					<c:if test="${editBounty.crime == 'RECKLESS_DRIVING' }">selected</c:if>>Reckless
					Driving</option>
				<option value="TRESPASS"
					<c:if test="${editBounty.crime == 'TRESPASS' }">selected</c:if>>Trespass</option>

			</select> <br> <br> <label for="price">Price</label> <input
				type="number" name="price" min="0" max="2000000000"
				value="${editBounty.price }" /> <br> <input type="submit"
				name="updateBounty" value="submit" /> <input type="hidden"
				name="id" value="${editBounty.id }" />
		</form>
	</c:if>


	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>