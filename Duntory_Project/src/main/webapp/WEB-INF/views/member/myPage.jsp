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
<body>

<div class='container'>
		<h1>${sessionScope.loginUser.userId}님의 모험단</h1>
		<hr>
		
		<div id='adventure_team' class='row adventure_team'>
		<label>숙명의 의지 : ${fatality}개</label>
		<label>불멸의 의지 : ${Immortal}개</label>
		<c:forEach var="adv" items="${adventureTeam}">
			<hr>
			<img src='https://img-api.neople.co.kr/df/servers/${adv.server}/characters/${adv.characterId}?zoom=1'>
		</c:forEach>
		</div>
		
		<a href="http://developers.neople.co.kr" target="_blank">
		<img src="${contextPath}/resources/images/Neople_logo.png" alt="Neople 오픈 API"/> </a>
</div>


</body>
</html>