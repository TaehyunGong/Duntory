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
<style>

.char_detail_img{
	height: 100%;
    width: 100%;
    object-fit: contain;	
}

.anton_p{
	color: coral;
    font-size: 20px;
}

.luke_p{
	color: mediumpurple;
    font-size: 20px;
}

.fiend_p{
	color: deepskyblue;
    font-size: 20px;
}

.masu_p{
	color: darkcyan;
    font-size: 20px;
}

.raidname{
}

.raidCount{
	text-align: center;
	padding: 0px;
	height:100%
}

.raid_count{
    height: 25%;
}

.char_box{
}

.detail_view_btn{
	width:100%;
	margin-bottom:5px;
}

.raidPoint{
	font-size: 30px;
}
</style>

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
		<div>
			<label class='raidPoint'>
			숙명의 의지 :<font
			<c:if test="${fatality >= 2000}">
				style='background:red; color:white'
			</c:if>>
			${fatality}
			</font>
			개
			<br>
			불멸의 의지 :<font
			<c:if test="${Immortal >= 2000}">
				style='background:red; color:white'
			</c:if>>
			${Immortal}
			</font>
			개
			</label>
		</div>
		<hr>
		<div id='adventure_team' class='row adventure_team'>
		<c:forEach var="adv" items="${adventureTeam}">
			<div class='col-md-4 col-xs-12 char_box'>
				<div class='char_info col-md-6 col-xs-12'>
					<button onclick='deleteAdventure("${adv.characterId}")' class='btn btn-danger' style='position:absolute;'><i class="fas fa-times"></i></button>
					<img class='char_detail_img' src='https://img-api.neople.co.kr/df/servers/${adv.server}/characters/${adv.characterId}?zoom=1'>
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
					]</label><br>${adv.adventureName}</p>
					<p>Lv.${adv.level}&nbsp;${adv.characterName}</p>
				</div>
				<div class='raidCount col-md-6 col-xs-12'>
					<p class='anton_p raid_count'>
						<font
						<c:if test="${adv.singleAntonRaid+adv.antonRaid >= 2}">
							style='background-color:red; color:white;'
						</c:if>
						> 
						<label class='raidname'>안톤 :${adv.singleAntonRaid + adv.antonRaid}</label>
						</font>
					</p>
					<p class='luke_p raid_count'>
						<font
						<c:if test="${adv.singleLukeRaid + adv.lukeRaid + adv.hardLukeRaid >= 2}">
							style='background-color:red; color:white;'
						</c:if>
						> 
						<label>루크 : ${adv.singleLukeRaid + adv.lukeRaid + adv.hardLukeRaid}</label>
						</font>
					</p>
					<p class='fiend_p raid_count'>
						<font
						<c:if test="${adv.fiendWar >= 2}">
							style='background-color:red; color:white;'
						</c:if>
						> 
						<label>핀드워 : ${adv.fiendWar}</label>
						</font>
					</p>
					<p class='masu_p raid_count'>
						<font
						<c:if test="${adv.masuDungeon >= 2}">
							style='background-color:red; color:white;'
						</c:if>
						> 
						<label>마수던전 : ${adv.masuDungeon}</label>
						</font>
					</p>
					<button type='button' onclick='detailView("${adv.characterId}")' class='btn btn-primary detail_view_btn'>자세히 보기</button>
				</div>
			</div>
		</c:forEach>
		</div>
		
		<a href="http://developers.neople.co.kr" target="_blank">
		<img src="${contextPath}/resources/images/Neople_logo.png" alt="Neople 오픈 API"/> </a>
</div>

	<script>
		var result='${adventureTeam}';
		
		function detailView(id){
			console.log(id);
		}
		
		function deleteAdventure(id){
			$.ajax({
				url:'deleteAdventure.me',
				data:{
					id:id
				},
				success:function(data){
					if(data == '1'){
						alert('모험단에서 제외');
						location.reload();
					}else{
						alert('실패');
					}
				},
				error:function(err){
					alert(err);
				}
			});
		}
	</script>

</body>
</html>