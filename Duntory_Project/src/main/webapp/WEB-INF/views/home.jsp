<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
	<title>Start</title>
</head>
<body>
<c:set var = "contextPath" value = "${ pageContext.servletContext.contextPath }" scope = "application" />
<jsp:forward page = "main/main.jsp"/>

</body>
</html>
