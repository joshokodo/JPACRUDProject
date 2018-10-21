<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>

<form action="navigationOptions.do">
		<h3>Navigate</h3>
		<input type="submit" name="home" value="Home Page" />
		<input type="submit" name="all" value="All Bounties"/>
		<input type="submit" name="detail" value="Specific Bounty"/>
		<input type="submit" name="add" value="Add Bounty"/>		
</form>

</nav>