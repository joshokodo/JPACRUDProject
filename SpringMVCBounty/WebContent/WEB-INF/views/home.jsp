<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy Hunting</title>
</head>
<body>

	<%@ include file="navi.jsp" %>
	
	
	<form action="search.do">
		<table>
		<tr>
			
			<th style="color:blue; font-size:40px ">B</th>
			<th style="color:orange;  font-size:40px">O</th>
			<th style="color:red; font-size:40px">U</th>
			<th style="color:green; font-size:40px">N</th>
			<th style="color:blue; font-size:40px">T</th>
			<th style="color:orange; font-size:40px">Y</th>
		</tr>
		</table>
		<table>
			<tr style="text-align: center width:100%">
				<td><input type="search" name="searchText" size="30"  required pattern=".{3,}"/> (3 character minimum)</td>
				<td><input type="submit" name="search" value="Search"/></td>
				<td><input type="submit" name="lucky" value="I'm Feeling Lucky"/></td>
			<tr>
		
		</table>
	</form>	
	
	
</body>
</html>