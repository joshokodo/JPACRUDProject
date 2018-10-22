<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>

<form action="navigationOptions.do" method="post">
<table>
	<tr>
		<th><h3>Navigate</h3></th>
	</tr>
	<tr>
		<td><input type="submit" name="home" value="Home Page" /></td>
		<td><input type="submit" name="all" value="All Bounties"/></td>
		<td><input type="submit" name="detail" value="Detail Search"/></td>
		<td><input type="submit" name="add" value="Add Bounty"/></td>		
	</tr>

</table>
</form>

</nav>

