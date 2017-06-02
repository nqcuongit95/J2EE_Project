<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="home-body-div">
	<div class="ui grid">
		<div class="row">
			<div class="twelve wide column">
				<!-- <div class="ui transparent icon fluid input">
	  	<input type="text" placeholder="Book ID">
	  	<i class="search icon"></i>
		</div>
		<div class="ui divider"></div> -->
				<h3>List of books borrowed</h3>
				<table class="ui single line table">
					<thead>
						<tr>
							<th>Book ID</th>
							<th>Name</th>
							<th>Author</th>
							<th>Price</th>
							<th>Date borrow</th>
							<th>Date return</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${data}" var="item">
							<tr>
								<td>${item.maSach}</td>
								<td>${item.ten}</td>
								<td>${item.tacGia}</td>
								<td>${item.giaMuon}</td>
								<td>${item.ngayMuon}</td>
								<td>${item.ngayTra}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<div class="four wide column">
				<h3>Borrower information</h3>
				<div class="ui transparent fluid input">
					<p>${info.tenDocGia}</p>
				</div>
				<div class="ui divider"></div>
				<div class="ui transparent fluid input">
					<p>${info.soDienThoai}</p>
				</div>
				<div class="ui divider"></div>
				<div class="ui transparent fluid input">
					<p>${info.diaChi}</p>
				</div>
				<div class="ui divider"></div>
				<div class="ui transparent fluid input">
					<p>${info.ghiChu}</p>
				</div>
				<div class="ui divider"></div>
				<input type="hidden" value="${info.id}" id="thongtinid"></input>
				<button class="ui primary fluid button" style="margin-bottom: 9px" id="return">
					Return</button>
				<button class="ui fluid button" id="back">Back</button>
			</div>
		</div>
	</div>

</div>

<script>
	$("#back").click(function() {
		window.history.back();
	});
	$("#return").click(function() {		
		//$.get('returnbookrenting', {
		//	id : $("#thongtinid").val()
		//}, function(response) {	
		//	alert("asdasdas dddddddddddddd")
		//});
		$.ajax({
            url : "/BookstoreRenting/returnbookrenting",
            data: { id : $("#thongtinid").val() },
            success : 
                function(response) {
            	alert("asdasdas dddddddddddddd")
                }
    });
	});
</script>