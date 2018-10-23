<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
	<div class="container">
		<form action="search.do">
			<div class="row">
				<div class="col-4"></div>
				<div class="col-4">
					<table>
						<tr>

							<th style="color: blue; font-size: 40px">B</th>
							<th style="color: orange; font-size: 40px">O</th>
							<th style="color: red; font-size: 40px">U</th>
							<th style="color: green; font-size: 40px">N</th>
							<th style="color: blue; font-size: 40px">T</th>
							<th style="color: orange; font-size: 40px">Y</th>
						</tr>
					</table>
				</div>

				<div class="col-4"></div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-5">
					<input type="search" name="searchText" size="30" required
						pattern=".{3,}" /> 
					<br>
					<input type="submit" name="search" value="Search" /> 
					<input type="submit" name="lucky" value="I'm Feeling Lucky"/>
				</div>

				<div class="col-4"></div>
			</div>
		</form>
	</div>




	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>