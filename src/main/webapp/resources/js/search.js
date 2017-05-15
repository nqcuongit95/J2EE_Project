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
			url : baseUrl + "search/findBook",
			data : JSON.stringify(search),
			dataType : 'json',
			// timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				showResults(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	};
	
	function showResults(data){
		
		$.each(data.results, function(index, book){
			
		var html ='<div class="item">'
				  + '<div class="blurring dimmable image">'
				  + '<div class="ui dimmer">'
				  + '<div class="content">'
				  + '<div class="center">'
				  + '<div class="ui inverted button">Add Friend</div>'
				  + '</div>'
				  + '</div>'
				  + '</div>'
				  + '<img src="' + defaultBookCoverUrl + '">'
				  + '</div>'
				  + '<div class="content">'
				  + '<a class="header">'+ book.ten +'</a>'
				  + '<div class="meta">'
				  + '<span class="date">'+ '<b>ISBN: </b>' + book.maSach +'</span>'
				  + '</div>'
				  + '<div class="description">'
				  + '<p>' + book.tomTat +'</p>'
				  + '</div>'
				  + '<div class="extra">'
				  + '<div class="ui label">'				  
				  + 'poem'
				  + '</div>'
				  + '</div>'
				  + '</div>'
				  + '</div>';
		
		$('#search-results').append(html);
		});
		
	};

})