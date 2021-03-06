<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>Bounties Found</title>
</head>
<body>
	<%@ include file="navi.jsp"%>
	<c:if test="${deleteSuccess == true }">
		<h2>Delete Successful</h2>
	</c:if>
	<c:if test="${deleteSuccess == false }">
		<h2>Delete Successful</h2>
	</c:if>
	<c:if test="${not empty bounties }">
		<c:forEach items="${bounties }" var="b">

			<a href="getBounty.do?bountyId=${b.id }">${b.firstName}
				${b.lastName } $${b.price }</a>

			<form action="alterBounty.do" method="post">
				<input type="submit" name="delete" value="Delete Bounty" /> <input
					type="submit" name="update" value="Update Bounty" /> <input
					type="hidden" name="id" value="${b.id}" />
			</form>
			<br>
		</c:forEach>

	</c:if>

	<!-- detailed info on bounty  -->
	<c:if test="${not empty bounty  }">
		<br>
		<h3 style="text-align: center">${bounty.firstName}
			${bounty.lastName}</h3>

		<c:if test="${not empty bounty.nickname }">
			<h3 style="text-align: center">
				AKA "<em>${bounty.nickname}</em>"
			</h3>
		</c:if>
		<c:if test="${bounty.wantedAlive == 89 }">
			<h3 style="text-align: center">WANTED ALIVE ONLY</h3>
		</c:if>
		<c:if test="${bounty.wantedAlive == 78 }">
			<h3 style="text-align: center">WANTED DEAD OR ALIVE</h3>
		</c:if>

		<p style="text-align: center">Description: ${bounty.description }</p>
		<p style="text-align: center">Crime: ${bounty.crime }</p>
		<p style="text-align: center">Price: $${bounty.price}</p>

		<div class="container">
			<div class="row">
				<div class="col-4"></div>
				<div class="col-4">
					<form action="alterBounty.do" method="post">

						<input type="submit" name="delete" value="Delete Bounty" /> <input
							type="submit" name="update" value="Update Bounty" /> <input
							type="hidden" name="id" value="${bounty.id}" />
					</form>
				</div>
				<div class="col-4"></div>
			</div>

		</div>

	</c:if>
	<c:if test="${empty bounty && empty bounties }">
		<h2>No Bounties Found</h2>
	</c:if>


	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

</body>
</html>