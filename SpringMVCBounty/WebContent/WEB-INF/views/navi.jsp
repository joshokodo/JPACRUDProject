<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>

	<div class="container">
		<c:choose>
			<c:when test="${atHome}">
				<form action="navigationOptions.do" method="post">
					<div class="row">
						<div class="col-4"></div>
						<div class="col-5">
							<input type="submit" name="all" value="All Bounties" /> <input
								type="submit" name="detail" value="Detail Search" /> <input
								type="submit" name="add" value="Add Bounty" />

						</div>
						<div class="col-3"></div>
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="col">
						<form action="search.do">

							<table>
								<tr>
									<th style="color: blue; font-size: 20px">B</th>
									<th style="color: orange; font-size: 20px">O</th>
									<th style="color: red; font-size: 20px">U</th>
									<th style="color: green; font-size: 20px">N</th>
									<th style="color: blue; font-size: 20px">T</th>
									<th style="color: orange; font-size: 20px">Y</th>
									<th><input type="search" name="searchText" size="30" /> <input
										type="submit" name="search" value="Search" /></th>

								</tr>
							</table>
						</form>
					</div>
				</div>

				<div class="row">
					<div class="col-2"></div>
					<div class="col-8">
						<form action="navigationOptions.do" method="post">
							<table>
								<tr>
									<td><input type="submit" name="home" value="Home Page" />
									</td>
									<td><input type="submit" name="all" value="All Bounties" />
									</td>
									<td><input type="submit" name="detail"
										value="Detail Search" />
									</td>
									<td><input type="submit" name="add" value="Add Bounty" /></td>
								</tr>
							</table>
						</form>
					</div>
					<div class="col-2"></div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>




</nav>

