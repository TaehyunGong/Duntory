<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Duntory</title>

<jsp:include page="/WEB-INF/views/common/menubar.jsp"/>

</head>

<style>
	.result_box{
		background-color: whitesmoke;
	}
	
	.char_box{
		width:80%;
		text-align: center;
	}
	
	.char_box:hover{
		background:gray;
		cursor:pointer;
	}
	
	.Adventure_btn{
		width:100%;
	}
	
	.nickBox{
		font-size:20px;
	}
</style>

<body>

<div class='container'>
		<h1 id='test'>캐릭터 검색</h1>
		
		<div class='form-inline box'>
			<div class=''>
				<input type='search' id='searchBox' class='form-control' name='char_search' placeholder='Please.. Enter'>
				<button type='button' onclick='charSearch();' class='btn btn-default'>검색</button>
			</div>
		</div>
		<div class='levelFilter_box'>
			<label><input type="radio" name="levelFilter" value="0" checked>모든 레벨</label>
			<label><input type="radio" name="levelFilter" value="95">95 레벨만</label>
		</div>
		<div id='serverCheckBoxBox' class='server_box box'>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="cain" checked> 카인
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="diregie" > 디레지에
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="siroco" > 시로코
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="prey" > 프레이
			</label>
			<br>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="casillas" > 카시야스
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="hilder" > 힐더
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="anton" > 안톤
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="bakal" > 바칼
			</label>
		</div>
		<h3>검색 결과 : <label id='searchCount'>0</label>건</h3>
		<hr>
		
		<div id='result_box' class='row result_box'>
		</div>
		
		<a href="http://developers.neople.co.kr" target="_blank">
		<img src="${contextPath}/resources/images/Neople_logo.png" alt="Neople 오픈 API"/> </a>
</div>

  <!-- 캐릭 정보 -->
  <div class="modal fade" id="char_detail_modal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 id='name' class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>

<script>

	//캐릭 클릭시
	function charDetail(id,server){
		alert('캐릭터 상세보기 준비중');
		/* $.ajax({
			url:'charDetail.search',
			data:{
				id:id,
				server:server
			},
			success:function(data){
				alert(data)
			},
			error:function(err){
				alert('다시 시도해주세요');
			}
		});
		
		$('#name').text(id);
		$("#char_detail_modal").modal('show'); */
	}

	var sessionMid = -1;
	<c:if test='${!empty sessionScope.loginUser}'>
		sessionMid = ${sessionScope.loginUser.mid};
	</c:if>
	
	$(document).ready(function(){
		
		$("#searchBox").keyup(function (e) {
			if (window.event.keyCode == 13){
				if(!($('#searchBox').val().length <= 0 && e.keyCode == 8)){
					charSearch();
				}
			}
		});
		
	    $("input:checkbox").on('click', function() {
	    	if(!($('#searchBox').val().length <= 0)){
	    		charSearch();
	    	}
	    });
	});

	var searchCount = 0;
	function charSearch(){
		var search = $('#searchBox').val();
		var level = $("input[name='levelFilter']:checked").val();
		var server = '';
		$("input[name='server']:checked").each(function(i){
			server += $(this).val() + ',';
		});
		if(search != '' && server != ''){
			$('#result_box div').remove();
			$('#result_box').append("<div><img src='resources/images/loading.gif'/></div>");
			searchCount = 0;
			$.ajax({
				url:'searchChar.search',
				data:{
					search:search,
					server:server,
					level:level
				},
				success:function(data){
					var list = JSON.parse(data);
					$('#result_box div').remove();
					if(list == ''){
						$('#result_box').append("<div class='col-md-12'>"+
								"<div class='empty_box'>"+
									"<label>검색 결과가 없습니다.</label>"+
								"</div>"+
							"</div>");
					}else{
						$.each(list, function(key, value){
							searchCount += 1;
							$('#result_box').append("<div class='col-md-3' onClick='charDetail(\""+ value.characterId +"\",\""+ value.server + "\");'>"+
								"<div class='char_box'>"+
									"<div class='img_box'>"+
										"<img src='https://img-api.neople.co.kr/df/servers/" + value.server +"/characters/" + value.characterId + "?zoom=1'>"+
									"</div>"+
									"<div class='info_box center-block'>"+
										"<p class='job_box'>" +
											"<label class='server_box'>[" + serverCheck(value.server) + "]&nbsp;</label>" +
											"<label class='server_box'>&nbsp;" + value.jobGrowName + "&nbsp;</label>"+
										"</p>"+
										"<p class='nickBox'>"+
											"<label class='server_box'>Lv.&nbsp;" + value.level + "&nbsp;</label>"+
											"<label class='nick_box'>"+ value.characterName + "</label>"+
										"</p>"+
									"</div>"+
									"<button onclick='adventrue_enroll(this, event, \"" + value.characterId + "\", \"" + value.server + "\")'" + wishListCheck(value.wishList) +
								"</div>"+
							"</div>");
						});
					}
					$('#searchCount').text(searchCount);
					
				},
				error:function(err){
					alert('다시 시도해주세요');
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
</script>

</body>
</html>