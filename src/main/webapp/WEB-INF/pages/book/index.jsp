<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!--
<style type="text/css">

#home-body-div {
	background-image: url("<c:url value="/resources/img/home-bg.jpg" />")
}
</style>
-->

<div id="home-body-div" class="container">
	<div class="ui center aligned basic segment">
<!-- 		<div class="ui left icon action input">
			<i class="search icon"></i> <input type="text" placeholder="Order #">
			<div class="ui blue submit button">Search</div>
		</div> -->
		<div class="ui horizontal divider">List of books</div>
		<a href="<c:url value="/book/create" />"
			class="ui blue labeled icon button">Create new book<i
			class="add icon"></i>
		</a>
	</div>

	<table class="ui celled table">
		<thead>
			<tr>
				<th>Index</th>
				<th>Book ID</th>
				<th>Name</th>
				<th>Count</th>
				<th>Create date</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="sach" items="${listSach}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${sach.maSach}</td>
					<td>${sach.ten}</td>
					<td>${sach.soBan}</td>
					<td><fmt:formatDate type="date" value="${sach.ngayTao}" /></td>

					<td><a
						href="<c:url value="/book/details">
					<c:param name="id" value="${sach.id}" />
					</c:url>">Detail</a><br />
						<a
						href="<c:url value="/book/update">
					<c:param name="id" value="${sach.id}" />
					</c:url>">Update</a><br />
						<a
						href="<c:url value="/book/delete">
					<c:param name="id" value="${sach.id}" />
					</c:url>">Delete</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>