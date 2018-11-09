
$(document).ready(function(){
    $("#searchBox").keyup(function (e) {
		if(!($('#searchBox').val().length <= 0 && e.keyCode == 8)){
			charSearch();
		}
		if (window.event.keyCode == 13){
		}
    });
	
    $("input:checkbox").on('click', function() {
    	if(!($('#searchBox').val().length <= 0)){
    		charSearch();
    	}
    });
});

function charSearch(){
	var search = $('#searchBox').val();
	
	var server = '';
	$("input[name='server']:checked").each(function(i){
		server += $(this).val() + ',';
	});
	if(search != '' && server != ''){
		$.ajax({
			url:'searchChar.search',
			data:{
				search:search,
				server:server
			},
			success:function(data){
				var list = JSON.parse(data);
				$('#result_box div').remove();
				if(list == ''){
					console.log('empty');
					$('#result_box').append("<div class='col-md-12'>"+
							"<div class='empty_box'>"+
								"<label>검색 결과가 없습니다.</label>"+
							"</div>"+
						"</div>");
				}else{
					$.each(list, function(key, value){
						$('#result_box').append("<div class='col-md-3' onClick='charDetail(\""+ value.characterId +"\");'>"+
							"<div class='char_box'>"+
								"<div class='img_box'>"+
									"<img src='https://img-api.neople.co.kr/df/servers/" + value.server +"/characters/" + value.characterId + "?zoom=1'>"+
								"</div>"+
								"<div class='info_box center-block'>"+
									"<p class='job_box'>" +
										"<label class='server_box'>[" + serverCheck(value.server) + "]&nbsp;</label>" +
										"<label class='server_box'>&nbsp;" + value.jobGrowName + "&nbsp;</label>"+
									"</p>"+
									"<label class='server_box'>Lv.&nbsp;" + value.level + "&nbsp;</label>"+
									"<label class='nick_box'>"+ value.characterName + "</label>"+
								"</div>"+
								"<button onclick='adventrue_enroll(this, event, \"" + value.characterId + "\", \"" + value.server + "\")'" + wishListCheck(value.wishList) +
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

function wishListCheck(check){
	if(check === 'Y'){
		return "class='Adventure_btn btn btn-info'>모험단 등록됨</button>";
	}else{
		return "class='Adventure_btn btn btn-default'>모험단 등록</button>";
	}
}

//캐릭 클릭시
function charDetail(id){
	console.log(id);
}

function adventrue_enroll(btn, event, id, server){
	event.stopPropagation();
	if(sessionMid === -1){
		alert('로그인 해야지만 등록할수 있습니다.');
		return;
	}
	
	$.ajax({
		url:'adventrueEnroll.me',
		data:{
			id:id,
			server:server
		},
		success:function(data){
			console.log(data);
			switch(data){
				case '0' : 
					alert('모험단 등록 실패');
					break;
				case '1' : 
					$(btn).removeClass('btn-default');
					$(btn).addClass('btn-info');
					$(btn).html('모험단 등록 완료');
					break;
				case '2' : 
					$(btn).removeClass('btn-info');
					$(btn).addClass('btn-default');
					$(btn).html('모험단 등록 취소');
					break;
			}
		},
		error:function(err){
			console.log(err);
			console.log('모험단 등록 에러');
		}
	});
	
}

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