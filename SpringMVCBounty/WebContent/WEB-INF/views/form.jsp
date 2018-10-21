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
	<%@ include file="navi.jsp" %>
	<c:if test="${detailSearch == true }">
		<h2>
			Search for Specify Bounty
		</h2>
			<form action="detailSearch.do" method="POST">
		<label for="firstNameSearched">First Name</label> 
		<input type="text" name="firstName" /> 
		<br> 
		<label for="lastNameSearched">Last Name</label> 
		<input type="text" name="lastName" /> 
		<br>
		<label for="nicknameSearched">Nickname</label> 
		<input type="text" name="nickname" /> 
		<br>
		<label for="description">Description</label>
		<input type="text" name="description"/>
		<br>
		<input type="submit" value="submit" />
	</form>
	</c:if>
	<c:if test="${addBounty == true }">
		<h2>
			Create a new Bounty
		</h2>
		<form action="addBounty.do" method="POST">
		<h6>* Required Fields</h6>
		<label for="firstNameSearched">*First Name</label> 
		<input type="text" name="firstName" /> 
		<br> 
		<label for="lastNameSearched">*Last Name</label> 
		<input type="text" name="lastName" /> 
		<br>
		<label for="nicknameSearched">Nickname</label> 
		<input type="text" name="nickname" /> 
		<br>
		<label for="description">*Description</label>
		<input type="text" name="description"/>
		<br>
		<br>
		<label for="wantedAlive">*Wanted Alive Only?</label> 
		<br> 
		<label>Yes</label><input type="radio" name="wantedAlive" value="Y" />
		<label>No</label><input type="radio" name="wantedAlive" value="N" checked />
		<br>
		<br>
		<label>*Crime Committed</label>
		<br> 
		<select name="crime" >
			<option value="J_WALKING">J-Walking</option>
			<option value="PUBLIC_INTOXICATION">Public Intoxication</option>
			<option value="DISORDERLY_CONDUCT">J-Walking</option>
			<option value="PETTY_THEFT">Petty Theft</option>
			<option value="VANDALISM">Vandalism</option>
			<option value="RECKLESS_DRIVING">Reckless Driving</option>
			<option value="TRESPASS">Trespass</option>
			
		</select>
		<br>
		<br>
		<label for="price">*Price</label>
		<input type="number" name="price" min="0" max="2000000000" required value="0"/>
		<br>
		<input type="submit" value="submit" />
	</form>
	</c:if>
	

</body>
</html>