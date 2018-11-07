<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Duntory</title>

<jsp:include page="/WEB-INF/views/common/menubar.jsp"/>

<link href="${contextPath}/resources/css/myPage.css" rel="stylesheet">
<script src="${contextPath}/resources/js/myPage.js"></script>

</head>
<body>

<div class='container'>
	<c:set var='startD'>${fn: replace(startDate,'T','')}00</c:set>
	<c:set var='endD'>${fn: replace(endDate,'T','')}00</c:set>
	<fmt:parseDate value="${a}" var="dateFmt" pattern="yyyyMMddHHmmss"/>
      <fmt:formatDate value="${dateFmt}"  pattern="yyyy-MM-dd HH:mm"/> 
		<h1>${sessionScope.loginUser.userId}님의 모험단 <br>
		<fmt:parseDate var="startDateFormat" value="${startD}" pattern="yyyyMMddHHmmss" />
		<fmt:parseDate var="endDateFormat" value="${endD}" pattern="yyyyMMddHHmmss" />
			<hr>
			<fmt:formatDate value="${startDateFormat}"  pattern="yyyy-MM-dd HH:mm"/>
			 ~ 
			<fmt:formatDate value="${endDateFormat}"  pattern="yyyy-MM-dd HH:mm"/>
		</h1>
		
		<hr>
		<label>숙명의 의지 : ${fatality}개</label>
		<label>불멸의 의지 : ${Immortal}개</label>
		
		<div id='adventure_team' class='row adventure_team'>
		<c:forEach var="adv" items="${adventureTeam}">
			<div class='col-md-3 char_box'>
				<div class='char_img'>
					<img src='https://img-api.neople.co.kr/df/servers/${adv.server}/characters/${adv.characterId}?zoom=1'>
				</div>
				<div class='char_info'>
					<p><label class='server'>[
				<c:choose>
		         <c:when test = "${adv.server eq 'bakal'}">바칼</c:when>
		         <c:when test = "${adv.server eq 'anton'}">안톤</c:when>
				 <c:when test = "${adv.server eq 'cain'}">카인</c:when>
		         <c:when test = "${adv.server eq 'casillas'}">카시야스</c:when>
		         <c:when test = "${adv.server eq 'diregie'}">디레지에</c:when>
		         <c:when test = "${adv.server eq 'hilder'}">힐더</c:when>
		         <c:when test = "${adv.server eq 'prey'}">프레이</c:when>
		         <c:when test = "${adv.server eq 'siroco'}">시로코</c:when>
		   	   </c:choose>
					]</label>&nbsp;${adv.adventureName}</p>
					<p>Lv.${adv.level}&nbsp;${adv.characterName}</p>
					<div class='raidCount'>
						<p>
							<label>싱글 안톤 : ${adv.singleAntonRaid}</label>
							<br>
							<label>안톤 : ${adv.antonRaid}</label>
						</p>
						<p>
							<label>싱글 루크 : ${adv.singleLukeRaid}</label>
							<br>
							<label>루크 : ${adv.lukeRaid}</label>
							<br>
							<label>하드 루크 : ${adv.hardLukeRaid}</label>
						</p>
						<p>
							<label>마수던전 : ${adv.masuDungeon}</label>
							<br>
							<label>핀드워 : ${adv.fiendWar}</label>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		
		<a href="http://developers.neople.co.kr" target="_blank">
		<img src="${contextPath}/resources/images/Neople_logo.png" alt="Neople 오픈 API"/> </a>
</div>


</body>
</html>