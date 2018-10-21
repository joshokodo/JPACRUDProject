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
	<h1 id="mainHeader">BOUNTY</h1>

	<form action="search.do">
		<input type="search" name="searchText"/>
		<br>
		<input type="submit" name="search" value="Search"/>
		<input type="submit" name="lucky" value="I'm Feeling Lucky"/>
	</form>	
	<form action="moreOptions.do">
		<h3>More Options</h3>
		<input type="submit" name="all" value="All Bounties"/>
		<input type="submit" name="detail" value="Specific Bounty"/>
		<input type="submit" name="add" value="Add Bounty"/>		
	</form>
	
	
</body>
</html>