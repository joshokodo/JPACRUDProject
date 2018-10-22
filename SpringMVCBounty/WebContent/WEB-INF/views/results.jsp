<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bounties Found</title>
</head>
<body>
	<%@ include file="navi.jsp" %>
	<c:if test="${deleteSuccess == true }">
		<h2>Delete Successful</h2>
	</c:if>
	<c:if test="${deleteSuccess == false }">
		<h2>Delete Successful</h2>
	</c:if>
	<c:if test="${not empty bounties }">
		<c:forEach items="${bounties }" var="b">

			<a href="getBounty.do?bountyId=${b.id }">${b.firstName} ${b.lastName } $${b.price }</a>
			
			<form action="alterBounty.do" method="post">
				<input type="submit" name="delete" value="Delete Bounty" /> 
				<input type="submit" name="update" value="Update Bounty" />
				<input type="hidden" name="id" value="${b.id}"/>
			</form>
			<br>
		</c:forEach>

	</c:if>

	<!-- detailed info on bounty  -->
	<c:if test="${not empty bounty  }">
		<h3>${bounty.firstName} ${bounty.lastName}</h3>
		
		<c:if test="${not empty bounty.nickname }">
			<h3> AKA "<em>${bounty.nickname}</em>"</h3>
		</c:if>
		<c:if test="${bounty.wantedAlive == 89 }">
			<h3>WANTED ALIVE ONLY</h3>
		</c:if>
		<c:if test="${bounty.wantedAlive == 78 }">
			<h3>WANTED DEAD OR ALIVE</h3>
		</c:if>
		<ul>
			<li>Description: ${bounty.description }</li>
			<li>Crime: ${bounty.crime }</li>
			<li>Price: $${bounty.price}</li>
		</ul>
		
		<form action="alterBounty.do" method="post">
				<input type="submit" name="delete" value="Delete Bounty" /> 
				<input type="submit" name="update" value="Update Bounty" />
				<input type="hidden" name="id" value="${bounty.id}"/>
			</form>
	</c:if>
	<c:if test="${empty bounty && empty bounties }">
		<h2>No Bounties Found</h2>
	</c:if>



</body>
</html>