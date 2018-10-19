<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bounties Found</title>
</head>
<body>

	<c:forEach items="${bounties }" var="b">

		<a href="getBounty.do?bountyId=${b.id }">${b.id}. Name: ${b.firstName}</a>
		<br>
		<br>
	</c:forEach>
	
	<c:if test="${not empty bounty  }">
		<ul>
			<li>${bounty.firstName}</li>
		</ul>
	</c:if>
	
	<form action="home.do">
		<input type="submit" value="Home Page"/>
	</form>

</body>
</html>