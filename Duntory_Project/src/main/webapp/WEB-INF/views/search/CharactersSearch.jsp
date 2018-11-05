<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Duntory</title>

<jsp:include page="/WEB-INF/views/common/menubar.jsp"/>

<link href="${contextPath}/resources/css/defaultBox.css" rel="stylesheet">
<script src="${contextPath}/resources/js/CharactersSearch.js"></script>

</head>
<body>

<div class='container'>
		<h1>캐릭터 검색</h1>
		
		<div class='form-inline box'>
			<div class='search_box form-group'>
				<input type='search' id='searchBox' class='form-control' name='char_search'>
				<button type='button' class='btn btn-default'>검색</button>
			</div>
		</div>
		
		<div id='serverCheckBoxBox' class='server_box box'>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="cain" checked> 카인
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="diregie" checked> 디레지에
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="siroco" checked> 시로코
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="prey" checked> 프레이
			</label>
			<br>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="casillas" checked> 카시야스
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="hilder" checked> 힐더
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="anton" checked> 안톤
			</label>
			<label class="checkbox-inline">
			  <input type="checkbox" id="server" name='server' value="bakal" checked> 바칼
			</label>
		</div>
		
		<hr>
		
		<div id='result_box' class='row result_box'>
		</div>
		
		<a href="http://developers.neople.co.kr" target="_blank">
		<img src="${contextPath}/resources/images/Neople_logo.png" alt="Neople 오픈 API"/> </a>
</div>

<script>
	var sessionMid = -1;
	<c:if test='${!empty sessionScope.loginUser}'>
		sessionMid = ${sessionScope.loginUser.mid};
	</c:if>
</script>

</body>
</html>