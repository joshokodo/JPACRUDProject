<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy Hunting</title>
<link href="../css/loginstyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="navi.jsp" %>
	<h1 id="mainHeader">BOUNTY</h1>

	<form action="search.do">
		<input type="search" name="searchText"  pattern=".{3,}"/> (3 character minimum)
		<br>
		<input type="submit" name="search" value="Search"/>
		<input type="submit" name="lucky" value="I'm Feeling Lucky"/>
	</form>	
	
	
	
</body>
</html>