$(document).ready(function() {
	if ($("#date").val() != ""){
		
		$("#return").remove();
	}
	$.fn.api.settings.api = {
			  'return books' : baseUrl + '/book/return/{id}',
	};	
	$("#back").click(function() {
		window.history.back();
	});
	$('#return').api({
		action: 'return books',
		urlData: {
		      id: $("#thongtinid").val()
		},
		onSuccess: function(response) {
			var $notifyModal = $("#notifyModal");
			console.log(response.header)
			if(response.success === "true"){
				$notifyModal.find("#msg-info").text(response.header);
				$notifyModal.find("#msg-content").text(response.content);
			}
			$notifyModal.modal("show");
			setTimeout(function(){
				$notifyModal.modal({
					onHidden: function(){
						location.reload();
					}
				}).modal('hide');
			},1000)
		}
	});
});