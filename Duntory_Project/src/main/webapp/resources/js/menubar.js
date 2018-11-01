function logout(){
	location.href='logout.me';
}

function login(){
	$.ajax({
		url:'login.me',
		data:{
			userId:$('#loginId').val(),
			userPwd:$('#loginPwd').val()
		},
		success:function(data){
			if(data == 'true'){
				location.href="/duntory/";
			}else{
				alert('잘못된 정보입니다.');
			}
		},
		error:function(err){
			console.log(err);
		}
	});
}

var idCheck=false;
var pwdCheck=false;
var re = /^[A-Za-z0-9]{4,10}$/;
var repw = /^[A-Za-z0-9]{2,10}$/;
$(function(){
	$('#joinusrname').keyup(function(){
		
		if(re.test($('#joinusrname').val())){
			$.ajax({
				url:'joinCheckId.me',
				data:{
					userId:$('#joinusrname').val()
				},
				success:function(data){
					if(data == 0){
						$('#idJoinLabel').text('사용가능합니다.').css('color','green');
						idCheck=true;
					}else{
						$('#idJoinLabel').text('중복된 아이디입니다.').css('color','red');
						idCheck=false;
					}
				},
				error:function(err){
					console.log(err);
				}
			});
		}else{
			$('#idJoinLabel').text('4~10자리 영문 숫자만').css('color','red');
			idCheck=false;
		}
		
		if(idCheck && pwdCheck){
			$('#joinbtn').prop("disabled", false);
		}else{
			$('#joinbtn').prop("disabled", true);
		}
	});
	
	$('#joinpsw').keyup(function(){
		
		if(repw.test($('#joinpsw').val())){
			$('#pwdJoinLabel').text('사용가능합니다.').css('color','green');
			pwdCheck=true;
		}else{
			$('#pwdJoinLabel').text('2~10자리 영문 숫자만').css('color','red');
			pwdCheck=false;
		}
		
		if(idCheck && pwdCheck){
			$('#joinbtn').prop("disabled", false);
		}else{
			$('#joinbtn').prop("disabled", true);
		}
	});
	
});