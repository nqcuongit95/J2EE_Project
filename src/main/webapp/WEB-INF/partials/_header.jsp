<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />

<div class="ui fixed inverted menu">
	<div class="ui container">
		<a href="<c:url value="/" />" class="header item"> 
			<img class="logo"
			src="<c:url value="/resources/img/logo.jpg" />" style="margin-right:1.4em">
			Bookstore Renting
		</a> 
		<a href="<c:url value="/" />" class="item">
			<i class="home icon"></i>
			Home
		</a> 
		<a href="<c:url value="/book" />" class="item">
			<i class="book icon"></i>
			Book Management
		</a> 
		<a href="#" class="item">
			<i class="area chart icon"></i>
			Book Renting
		</a> 
		<a href="<c:url value="/search" />" class="item">
			<i class="book icon"></i>
			
			Searching
		</a>
		
		<div class="right menu">			
			<h5 class="ui inverted header item">
				<img src="<c:url value="/resources/img/clock.jpg" />" 
					 class="ui image">
				<div class="content">
					<fmt:setLocale value="en_US" scope="session"/>
					<fmt:formatDate value="${date}" dateStyle = "full" />
					<div class="sub header" id="clock"></div>
				</div>
			</h5>
			<div class="item clock"></div>
		</div>
	</div>
</div>