
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
							$.each(list, function(key, value){
								console.log(value);
								$('#result_box').append("<div class='col-md-3'>"+
									"<div class='img_box'>"+
										"<img src='https://img-api.neople.co.kr/df/servers/" + value.server +"/characters/" + value.characterId + "?zoom=1'>"+
									"</div>"+
									"<div class='info_box center-block'>"+
										"<p class='job_box'>" + value.jobGrowName + "</p>"+
										"<label class='server_box'>[" + serverCheck(value.server) + "]&nbsp;</label>"+
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

function serverCheck(server){
	switch(server){
	case 'diregie' : return '디레지에'
	case 'siroco' : return '시로코'
	case 'prey' : return '프레이'
	case 'hilder' : return '힐더'
	case 'bakal' : return '바칼'
	case 'anton' : return '안톤'
	case 'casillas' : return '카시야스'
	case 'cain' : return '카인'
	}
}