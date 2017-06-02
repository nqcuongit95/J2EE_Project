<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<div id="home-body-div">
	<div class="ui grid">
		<div class="row" style="padding-top: 0">
			<div class="seven wide column">
				<h2>List of borrower</h2>
			</div>
			<div class="five wide right floated column">
			
				<div class="ui transparent fluid input">
					<input type="text" placeholder="Search ID or Phone..." id="infoId">
					<i class="search icon"></i>
				</div>
				<div class="ui divider" style="margin:0"></div>
			</div>
		</div>
		<div class="row" style="padding-top: 0">
			<div class="sixteen wide column">
				<table class="ui single line table" id="dataTable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Phone</th>
							<th>Address</th>
							<th>Note</th>
							<th>Date</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${data}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.tenDocGia}</td>
								<td>${item.soDienThoai}</td>
								<td>${item.diaChi}</td>
								<td>${item.ghiChu}</td>
								<td>${item.ngayTao}</td>
								<td><a class="ui blue label" href="<c:url value='/bookrenting/${item.id}' />">Details</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div id="divCheckbox" class="ui center aligned vertical segment" style="display: none;">
					<h2>Borrower not found</h2>
				</div>
				<div id="divReturn" class="ui center aligned vertical segment" style="display: none;">
					<button class="ui primary button" style="margin-bottom: 9px" id="back">
					Back to list</button>
				</div>
				<div id="pagi">
				<tag:paginate max="10" offset="${offset}" count="${count}"
					uri="bookrenting" next="»" previous="«" />
				</div>
				
			</div>
		</div>
	</div>
</div>

<script>
	var baseUrl = "${home}";
</script>

<script src="<c:url value="/resources/js/searchInfo.js" />"></script>