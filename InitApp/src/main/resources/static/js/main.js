/**
 * 
 */

$.urlParam = function(){
	var url_param       = $(location).attr('href').split("?type=");
	var param           = (url_param[1]);
	return param;
}

function checkDataFields(){
	var empty = false;
	var naziv = $('.myForm #naziv').val();
	var kategorija = $('.myForm #kategorija').val();
	var podkategorija = $('.myForm #podkategorija').val();
	
	if(naziv==''){
		$('.myForm #naziv').css('background-color', '#ff0000');
		$('.myForm #naziv').css('opacity', '0.5');
		empty = true;
	}
	
	if(kategorija==''){
		$('.myForm #kategorija').css('background-color', '#ff0000');
		$('.myForm #kategorija').css('opacity', '0.5');
		empty = true;
	}
	
	if(podkategorija==''){
		$('.myForm #podkategorija').css('background-color', '#ff0000');
		$('.myForm #podkategorija').css('opacity', '0.5');
		empty = true;
	}
	
	
	return empty;
}

$(document).ready(function(){
	if($.urlParam() === "undefined")
		console.log($.urlParam());
	else{
		switch($.urlParam()){
		case "edit" : 
			$('#infoModal .modal-title').text("Obavijest!");
			$('#infoModal .modal-body p').text("Aktivnost uspješno promijenjena!");
			$('#infoModal #okBtn').attr('href', '/');
			$('#infoModal').css("position", "fixed");
			$('#infoModal').css("top", "0%");
			$('#infoModal').css("left", "35%");
			$('#infoModal').css("outline", "none");
			$('#infoModal').modal();
			break;
		case "new":
			$('#infoModal .modal-title').text("Obavijest!");
			$('#infoModal .modal-body p').text("Nova aktivnost uspješno dodana!");
			$('#infoModal #okBtn').attr('href', '/');
			$('#infoModal').css("position", "fixed");
			$('#infoModal').css("top", "0%");
			$('#infoModal').css("left", "35%");
			$('#infoModal').css("outline", "none");
			$('#infoModal').modal();
			break;
		case "delete":
			$('#infoModal .modal-title').text("Obavijest!");
			$('#infoModal .modal-body p').text("Aktivnost uspješno obrisana!");
			$('#infoModal #okBtn').attr('href', '/');
			$('#infoModal').css("position", "fixed");
			$('#infoModal').css("top", "0%");
			$('#infoModal').css("left", "35%");
			$('#infoModal').css("outline", "none");
			$('#infoModal').modal();
			break;
		}
	}
		
	/*$('#infoModal').on('show.bs.modal', function () {
		

	});*/
		
	
	$('.nBtn, .table .eBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text =='New'){
			$('.myForm #id').val('');
			$('.myForm #naziv').val('');
			$('.myForm #kategorija').val('');
			$('.myForm #podkategorija').val('');
		}
		else{
			$.get(href, function(activity, status){
				$('.myForm #id').val(activity.id);
				$('.myForm #naziv').val(activity.naziv);
				$('.myForm #kategorija').val(activity.kategorija);
				$('.myForm #podkategorija').val(activity.podkategorija);
				
			});
		}
		$('.myForm #editModal #sBtn').attr('href', href);
		
		$('.myForm #editModal').modal();
	});
	
	
	
	$('.table .dBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmationModal #delRef').attr('href', href);
		$('#confirmationModal').modal();	
		
		
	});
	
	$('.myForm #editModal #sBtn').on('click', function(event){
		event.preventDefault();
		if(checkDataFields()==false)
			$("#myForm").submit();
	});
	
	$('.myForm #editModal #cBtn').on('click', function(event){
		event.preventDefault();
		location.reload();
	});
});