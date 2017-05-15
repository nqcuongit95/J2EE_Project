$(document).ready(function() {

	$('#book-category-input').dropdown();

	$('#book-author-input').dropdown();

	$('#searchForm .primary.button').on('click', function() {

		event.preventDefault();
		console.log('test');
		searchBook(); 
	});

	function searchBook() {

		var search = {};
		search["title"] = $('#main-content-search').val();

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8080/BookstoreRenting/search/findBook",
			data : JSON.stringify(search),
			dataType : 'json',
			// timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	};

})