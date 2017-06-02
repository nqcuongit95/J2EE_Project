$(document).ready(function() {
	$("#back").click(function() {
		window.location.href = baseUrl;
		//window.history.back();
		$("#divReturn").css("display", "none");
	});
	$("#infoId").change(function() {
		var id = $('#infoId').val();
		var search = { "id" : id };
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url :  "book/search/",
			data : JSON.stringify(search),
			dataType : 'json',
			// timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#divReturn").css("display", "block");
				$("#divCheckbox").css("display", "none");
				$("#dataTable").find("tr:gt(0)").remove();
				$("#pagi").hide();
				$('#dataTable > tbody:last-child').append(
			            '<tr>'// need to change closing tag to an opening `<tr>` tag.
			            +'<td>'+data.id+'</td>'
			            +'<td>'+data.tenDocGia+'</td>'
			            +'<td>'+data.soDienThoai+'</td>'
			            +'<td>'+data.diaChi+'</td>'
			            +'<td>'+data.ghiChu+'</td>'
			            +'<td>'+data.ngayTao+'</td>'
			            +'<td><a href="/BookstoreRenting/bookrenting/'+data.id+'">Details</a></td>'
			            +'</tr>');
			},
			error : function(e) {
				$("#divReturn").css("display", "block");
				$("#dataTable").find("tr:gt(0)").remove();
				$("#pagi").hide();
				$("#divCheckbox").css("display", "block");
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	});
});