<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Duntory</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/menubar.jsp"/>
<h1>
	여기는 던토리 메인 페이지입니다.
</h1>
<form action='join.me' method='post'>
	<input name='userId'>
	<input name='userPwd'>
	<button>제출</button>
</form>
<div id='result'>
</div>

<a href="http://developers.neople.co.kr" target="_blank">
<img src="${contextPath}/resources/images/Neople_logo.png" alt="Neople 오픈 API"/> </a>

<script>
	$(function(){
		var value = ${server};
		$('#result').append("<img src='https://img-api.neople.co.kr/df/servers/bakal/characters/" + value.rows[0].characterId +"?zoom=1'>")
	})
</script>

</body>
</html>