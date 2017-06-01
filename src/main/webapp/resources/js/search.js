$(document).ready(function() {
			
	$.fn.api.settings.api = {
			  'view details' : baseUrl + 'book/details/{id}',
			  'mark for renting' : baseUrl + '/book/renting/add/{id}',
			  'view order' : baseUrl + '/book/renting/order'
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
	
	//renting form validation
	$('#renting-form').form({
		inline : true,
		on: 'blur',
		fields:{
			fullName: {
				identifier: 'fullName',
				rules:[
					{
						type: 'empty',
						prompt: 'Please enter full name'
					},
					{
						type: 'maxLength[30]',
						prompt: 'Full name can not exceed 30 characters' 
					}
				]
			},
			phone: {
				identifier: 'phoneNumber',
				rules:[
					{
						type: 'empty',
						prompt: 'Please enter phone number '
					},
					{
						type: 'regExp[^[0-9]*$]',
						prompt: 'Please enter a valid phone number '
					},
					{
						type: 'minLength[10]',
						prompt: 'Please enter a valid phone number' 
					},
					{
						type: 'maxLength[11]',
						prompt: 'Please enter a valid phone number' 
					}					
				]
			},
			address: {
				identifier: 'address',
				rule: [
					{
						type: 'empty',
						prompt: 'Please enter address'
					}
				]
			},
			borrowedDay: {
				identifier: 'borrowed',
				rule: [
					{
						type: 'empty',
						prompt: 'Please select borrowed day'
					}
				]
			},
			returnDay: {
				identifier: 'return',
				rule: [
					{
						type: 'empty',
						prompt: 'Please select return day'
					}
				]
			}
		}
		
	});

	$('#searchForm .primary.button').on('click', function(event) {

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
				 
				 html += '<div class="ui right floated positive button" id="rent-btn">Rent'				 
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
		
		//details modal
		$elem.find('#detail-btn').api({
			action: 'view details',
			urlData: {
			      id: book.id
			},
			onSuccess: function(response) {
			    
				setModalData(response);
				
			},			   
		});
		
		//renting modal
		$elem.find('#rent-btn').api({
			action: 'view order',			
			onSuccess: function(response) {
			    
				if (response.success==="true") {
					var $rentingModal = $('#rentingModal');
					
					var listRentingBook = '';
					
					$.each(response.results, function(index, bookData){
						listRentingBook +='<div class="item" data-id="'+ bookData.id +'">'
										  + '<div class="right floated content">'
										  + '<div class="ui small button">Remove</div>'
										  + '</div>'
										  + '<img class="ui avatar image" src="' +defaultBookCoverUrl + '">'
										  + '<div class="content">'
										  + '<div class="header">'+bookData.title + '</div>'
										  + 'Renting cost: ' + bookData.rentPrice +'$'
										  + '</div>'
										  + '</div>';
					});
					
					$rentingModal.find('#list-rented-book').html(listRentingBook);
					
					$rentingModal.modal({
						
						onShow: function(){
							//clear form data
							$rentingModal.find('.ui.form').form('clear');
						},
						onVisible: function(){
							
							$('#borrowedDay').calendar({
								  type: 'date',
								  initialDate: null,
								  endCalendar: $('#returnDay')
								});
							$('#returnDay').calendar({
								  type: 'date',
								  startCalendar: $('#borrowedDay')
								});
																					
						}
						
					}).modal('show');

				}
				else{
					
					var $notifyModal = $('#notifyModal');
					$notifyModal.find('#msg-info').text("Error");
					$notifyModal.find('#msg-content').text("You must add book in order to start renting.");
					
					$notifyModal.modal('show');
				}
					
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
	
	//submit renting form
	$('#renting-btn').on('click',function(event){
		event.preventDefault();					
		
		var $rentingForm = $('#rentingModal .form'); 
		$rentingForm.form('validate form');
		
		if ($rentingForm.form('is valid')) {
			renting();
		}
				
	})
	
	function renting(){
		
		var renting = {};
		renting["readerName"] = $('#fullName').val();
		renting["phone"] = $('#phoneNumber').val();
		renting["address"] = $('#address').val();
		renting["note"] = $('#note').val();
		renting["borrowedDate"] = $('#borrowedDay').calendar('get date');
		renting["returnDate"] = $('#returnDay').calendar('get date');
		
		var listBook = [];
		$('#list-rented-book .item').each(function(){
			var bookId = $(this).attr('data-id');
			listBook.push(bookId);
		});
		
		renting["listRentingBook"] = listBook;
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : baseUrl + "book/renting/process",
			data : JSON.stringify(renting),
			dataType : 'json',
			// timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				
				if (data.success==="true") {
					var $notifyModal = $('#notifyModal');
					
					$notifyModal.find('#msg-info').text("Success");
					$notifyModal.find('#msg-content').text("Successfully add reader for book renting.");
					
					$notifyModal.modal('show');
					
					setTimeout(function(){
						
						$notifyModal.modal({
							onHidden: function(){
								$('#rentingModal').modal('hide');
								location.reload();
							}
						}).modal('hide');
						
						
					},2000)
				}
				
				//update loading status
				//$('#divider-result i').removeClass('spinner loading');
				//$('#divider-result i').addClass('search');
								
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}
	
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