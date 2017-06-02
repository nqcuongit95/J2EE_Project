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
		<div class="ui horizontal divider header">Delete book</div>
	</div>

	<form id="book-crud-form" class="ui form"
		action="<c:url value="/book/deleteConfirm" />" method="post">
		<h4 class="ui dividing header">Book Information</h4>

		<input type="hidden" name="id" value="${sach.id}">

		<div class="two fields">
			<div class="field">
				<label>BookID</label> <input type="text" readonly="readonly"
					maxlength="12" value="${sach.maSach}" placeholder="BookID">
			</div>

			<div class="field">
				<label>Name</label> <input type="text" maxlength="500"
					readonly="readonly" value="${sach.ten}" placeholder="Book name">
			</div>
		</div>

		<div class="two fields">
			<div class="field">
				<label>Count</label> <input type="number" readonly="readonly"
					value="${sach.soBan}" placeholder="Count">
			</div>

			<div class="field">
				<label>Create date</label> <input type="date" readonly=""
					value="<fmt:formatDate type="date" value="${sach.ngayTao}" pattern = "yyyy-MM-dd"  />"
					placeholder="Create date">
			</div>
		</div>

		<div class="field">
			<label>Authors</label> <input type="text" readonly="readonly"
				maxlength="2000" value="${sach.tacGia}" placeholder="Authors" />
		</div>

		<div class="field">
			<label>ISBN</label> <input type="text" maxlength="2000"
				readonly="readonly" value="${sach.isbn}" placeholder="ISBN" />
		</div>

		<div class="field">
			<label>Kind</label> <input type="text" maxlength="1000"
				readonly="readonly" value="${sach.theLoai}" placeholder="Kind" />
		</div>

		<div class="field">
			<label>Price</label> <input type="number" money readonly="readonly"
				value="${sach.giaMuon.intValue()}" placeholder="Price" />
		</div>

		<div class="field">
			<label>Description</label>
			<textarea maxlength="1000" readonly="readonly">${sach.tomTat}</textarea>
		</div>

		<div class="field">
			<label>Note</label>
			<textarea maxlength="2000" rows="2" readonly="readonly">${sach.ghiChu}</textarea>
		</div>

		<button class="ui red labeled icon button submit">
			Delete book<i class="trash icon"></i>
		</button>
	</form>

	<script type="text/javascript"
		src="<c:url value="/resources/js/cleave.min.js" />"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/book.js" />"></script>
</div>
