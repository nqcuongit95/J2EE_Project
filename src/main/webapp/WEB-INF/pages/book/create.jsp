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
		<div class="ui horizontal divider header">Create book</div>
	</div>

	<form id="book-crud-form" class="ui form"
		action="<c:url value="/book/createConfirm" />" method="post">
		<h4 class="ui dividing header">Book Information</h4>
		<div class="two fields">
			<div class="field">
				<label>BookID</label> <input type="text" name="maSach"
					maxlength="12" value="${sach.maSach}" placeholder="BookID">
			</div>

			<div class="field">
				<label>Name</label> <input type="text" name="ten" maxlength="500"
					value="${sach.ten}" placeholder="Book name">
			</div>
		</div>

		<div class="two fields">
			<div class="field">
				<label>Count</label> <input type="number" name="soBan"
					value="${sach.soBan}" placeholder="Count">
			</div>

			<div class="field">
				<label>Create date</label> <input type="date" readonly=""
					value="<fmt:formatDate type="date" value="${sach.ngayTao}" pattern = "yyyy-MM-dd"  />"
					placeholder="Create date">
			</div>
		</div>

		<div class="field">
			<label>Authors</label> <input type="text" name="tacGia"
				maxlength="2000" value="${sach.tacGia}" placeholder="Authors" />
		</div>

		<div class="field">
			<label>ISBN</label> <input type="text" name="isbn" maxlength="2000"
				value="${sach.isbn}" placeholder="ISBN" />
		</div>

		<div class="field">
			<label>Kind</label> <input type="text" name="theLoai"
				maxlength="1000" value="${sach.theLoai}" placeholder="Kind" />
		</div>

		<div class="field">
			<label>Price</label> <input type="number" name="giaMuon" money
				value="${sach.giaMuon}" placeholder="Price" />
		</div>

		<div class="field">
			<label>Description</label>
			<textarea name="tomTat" maxlength="1000">${sach.tomTat}</textarea>
		</div>

		<div class="field">
			<label>Note</label>
			<textarea name="ghiChu" maxlength="2000" rows="2">${sach.ghiChu}</textarea>
		</div>

		<button class="ui blue labeled icon button submit">
			Create book<i class="checkmark icon"></i>
		</button>
	</form>

	<script type="text/javascript"
		src="<c:url value="/resources/js/cleave.min.js" />"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/book.js" />"></script>
</div>
