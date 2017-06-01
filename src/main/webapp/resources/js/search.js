$(document).ready(function() {
	
	
	$.fn.api.settings.api = {
			  'view details' : baseUrl + 'book/details/{id}',
			  'mark for renting' : baseUrl + '/book/renting/add/{id}'
			};	
	
	$('#book-category-input').dropdown({				
		apiSettings: {
			url: baseUrl + "/search/findCategory?query={query}",
			saveRemoteData: 'false',			
		}
		
	});

	$('#book-author-input').dropdown({				
		apiSettings: {
			url: baseUrl + "/search/findAuthor?query={query}",
			saveRemoteData: 'false',			
		}
		
	});

	$('#searchForm .primary.button').on('click', function() {

		event.preventDefault();
				
		//show loading status
		$('#divider-result i').removeClass('search');
		$('#divider-result i').addClass('spinner loading');
		
		searchBook(); 
	});

	function searchBook() {

		var search = {};
		search["keyword"] = $('#main-content-search').val();
		
		var category = $('#book-category-input').dropdown('get value');	
		
		if(category){
			search["categories"] = category.split(',');			
		}
		
		var author = $('#book-author-input').dropdown('get value');
		if(author){
			search["authors"] = author.split(',');
		}		
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : baseUrl + "search/findBook",
			data : JSON.stringify(search),
			dataType : 'json',
			// timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				
				//update loading status
				$('#divider-result i').removeClass('spinner loading');
				$('#divider-result i').addClass('search');
				
				clearResults();
				setTimeout(function(){
					showResults(data);
				},500)
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	};
	
	function clearResults(){
		$('#search-results .item').each(function(){
			$(this).fadeTo('slow',0,function(){				
				$(this).remove();
			})
		});
		
		
	}
	
	function showResults(data){
		
		$.each(data.results, function(index, book){
			
		var html ='<div class="item" style="display: none;">'
				  + '<div class="image">'		  
				  + '<img src="' + defaultBookCoverUrl + '">'
				  + '</div>'
				  + '<div class="content">'
				  + '<a class="header">'+ book.title +'</a>'
				  + '<div class="meta">'
				  + '<span class="date">'+ '<b>ISBN: </b>' + book.ISBN +'</span>'
				  + '</div>'
				  + '<div class="description">'
				  + '<p>' + book.description +'</p>'
				  + '</div>'
				  + '<div class="extra">'
				  
				  if (book.added === 'true') {
					  html += '<div class="ui right floated right labeled positive basic icon button" id="mark-btn">Add for renting'				 
					  + '<i class="checkmark icon"></i>'
					  + '</div>'
				  }
				  else{
					  html += '<div class="ui right floated right labeled secondary basic icon button" id="mark-btn">Add for renting'				 
					  + '<i class="plus icon"></i>'
					  + '</div>'
				  }
				  
				 html += '<div class="ui right floated primary button" id="detail-btn">Detail'				 
				  + '<i class="right chevron icon"></i>'
				  + '</div>';
				 
				 html += '<div class="ui right floated positive button" id="detail-btn">Rent'				 
					  + '<i class="right chevron icon"></i>'
					  + '</div>';
				 
				// categories
				$.each(book.categories, function(index, category){					
				  html+= '<div class="ui label">'				  
					  + category					  
					  + '</div>';
				});
		
							  
				  html+= '</div>'
					  + '</div>';
				  	  + '</div>';
		
		var $elem = $(html);	
		
//		$elem.find('.button').attr({
//			'data-action' : "view details",
//			'data-id': book.id
//		})
		
		$elem.find('#detail-btn').api({
			action: 'view details',
			urlData: {
			      id: book.id
			},
			onSuccess: function(response) {
			    
				setModalData(response);
				
			},			   
		});
		
		
		$elem.find('#mark-btn').api({
			action: 'mark for renting',
			urlData: {
			      id: book.id
			},
			onSuccess: function(response) {
			    	
				if(response.success==='added'){
					
					$(this).removeClass('secondary').addClass('positive');
					$(this).find('.icon').addClass('checkmark').removeClass('plus');
				}
				else if(response.success==='removed'){
					$(this).removeClass('positive').addClass('secondary');
					$(this).find('.icon').addClass('plus').removeClass('checkmark');
				}
			}
			
		});
		
		$('#search-results').append($elem);
		$elem.fadeIn('300');
		});
		
	};
	
	function setModalData(response){
		var $modal = $('#bookModal');
		
		$modal.find('img').attr('src',defaultBookCoverUrl);
		$modal.find('.ui.header').text(response.title);
		$modal.find('#description').text(response.description);
		$modal.find('#category').html('<b>Category: </b>' + response.categories[0]);
		$modal.find('#author').html('<b>Author: </b>'+ response.authors[0]);
		$modal.find('#rent-price').html('<b>Renting price: </b>' +response.rentPrice +'$');
		
		$modal.modal('show');
	}
});