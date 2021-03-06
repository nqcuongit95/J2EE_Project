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
		<div class="ui horizontal divider header">Detail of book</div>
	</div>

	<c:choose>
		<c:when test="${empty sach.imageUrl}">
			<img class="ui centered medium image"
				src="https://pbs.twimg.com/profile_images/600060188872155136/st4Sp6Aw.jpg">
		</c:when>
		<c:otherwise>
			<img class="ui centered medium image"
				src="/BookstoreRenting/${sach.imageUrl}" />
		</c:otherwise>
	</c:choose>

	<form method="POST" action="<c:url value="/book/uploadImage" />"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="${sach.id}"> <input
			type="file" name="file" id="file" accept="image/*"> <input
			type="submit" value="Upload Image" name="submit"
			class="ui primary button" />
	</form>

	<form id="book-crud-form" class="ui form">
		<h4 class="ui dividing header">Book Information</h4>

		<div class="two fields">
			<div class="field">
				<label>BookID</label> <input type="text" name="maSach"
					readonly="readonly" maxlength="12" value="${sach.maSach}"
					placeholder="BookID">
			</div>

			<div class="field">
				<label>Name</label> <input type="text" name="ten" maxlength="500"
					readonly="readonly" value="${sach.ten}" placeholder="Book name">
			</div>
		</div>

		<div class="two fields">
			<div class="field">
				<label>Count</label> <input type="number" name="soBan"
					readonly="readonly" value="${sach.soBan}" placeholder="Count">
			</div>

			<div class="field">
				<label>Create date</label> <input type="date" readonly=""
					value="<fmt:formatDate type="date" value="${sach.ngayTao}" pattern = "yyyy-MM-dd"  />"
					placeholder="Create date">
			</div>
		</div>

		<div class="field">
			<label>Authors</label> <input type="text" name="tacGia"
				readonly="readonly" maxlength="2000" value="${sach.tacGia}"
				placeholder="Authors" />
		</div>

		<div class="field">
			<label>ISBN</label> <input type="text" name="isbn" maxlength="2000"
				readonly="readonly" value="${sach.isbn}" placeholder="ISBN" />
		</div>

		<div class="field">
			<label>Kind</label> <input type="text" name="theLoai"
				maxlength="1000" readonly="readonly" value="${sach.theLoai}"
				placeholder="Kind" />
		</div>

		<div class="field">
			<label>Price</label> <input type="number" name="giaMuon" money
				readonly="readonly" value="${sach.giaMuon.intValue()}"
				placeholder="Price" />
		</div>

		<div class="field">
			<label>Description</label>
			<textarea name="tomTat" maxlength="1000" readonly="readonly">${sach.tomTat}</textarea>
		</div>

		<div class="field">
			<label>Note</label>
			<textarea name="ghiChu" maxlength="2000" rows="2" readonly="readonly">${sach.ghiChu}</textarea>
		</div>

		<a class="ui blue labeled icon button"
			href="<c:url value="/book/update">
					<c:param name="id" value="${sach.id}" />
					</c:url>">Edit
			book<i class="checkmark icon"></i>
		</a>
	</form>

	<script type="text/javascript"
		src="<c:url value="/resources/js/cleave.min.js" />"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/book.js" />"></script>
</div>
