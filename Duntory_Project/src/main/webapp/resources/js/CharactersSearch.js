
$(document).ready(function(){
    $("#searchBox").keyup(function (e) {
		if(!($('#searchBox').val().length <= 0 && e.keyCode == 8)){
			
			var search = $('#searchBox').val();
			if(search != ''){
				var server = '';
				$("input[name='server']:checked").each(function(i){
					server += $(this).val() + ',';
				});
				
				$.ajax({
					url:'searchChar.search',
					data:{
						search:search,
						server:server
					},
					success:function(data){
						var list = JSON.parse(data);
						$('#result_box div').remove();
						if(list.rows == ''){
							console.log('--');
						}else{
							//console.log(list.rows[0].characterName);\
							$.each(list.rows, function(key, value){
								console.log(value);
								$('#result_box').append("<div class='col-md-3'>"+
									"<div class='img_box'>"+
										"<img src='https://img-api.neople.co.kr/df/servers/bakal/characters/" + value.characterId + "?zoom=1'>"+
									"</div>"+
									"<div class='info_box center-block'>"+
										"<p class='job_box'>" + value.jobGrowName + "</p>"+
										"<label class='server_box'>[바칼]</label>"+
										"<label class='nick_box'>"+ value.characterName + "</label>"+
									"</div>"+
								"</div>");
							});
						}
						
					},
					error:function(err){
						console.log(err);
					}
				});
			}
			
		}
		
		if (window.event.keyCode == 13){
		}

    });
	
});