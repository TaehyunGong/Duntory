<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Duntory</title>
	<link href="${contextPath}/resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet"> 
	 
	<script src="${contextPath}/resources/js/jquery-3.3.1.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
</head>
  <style>
  .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  </style>
<body>
	<nav class="navbar navbar-light">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Duntory</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="#">캐릭터 검색</a></li>
	      <li><a href="#">서버 검색</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li>
		      <a data-toggle="modal" href="#myModal">로그인</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	
</body>

<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4>로그인</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form action='login.me' method='post' role="form">
            <div class="form-group">
              <label for="usrname">아이디</label>
              <input type="text" name='userId' class="form-control" id="usrname" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="psw">비밀번호</label>
              <input type="text" name='userPwd' class="form-control" id="psw" placeholder="Enter password">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" name='saveId' value="Y" checked>세션 저장</label>
            </div>
              <button type="submit" class="btn btn-success btn-block">Login</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">닫기</button>
          <p><a href="#" class='btn btn-primary'>무료 회원가입</a></p>
        </div>
      </div>
      
    </div>
  </div> 

</html>

