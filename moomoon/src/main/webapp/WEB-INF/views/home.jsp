<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
	<title>Home</title>
</head>
<body>
<jsp:include page="include/nav.jsp" />

<img src="<c:url value="/resources/img/main4.png" />" max-width="100%">
<div class="main_banner">
	<div class="cover"></div>
</div>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime} >. </P>
    <c:forEach items="${b_reviewer}" var="b_reviewer">
    <div>
    	${b_reviewer.member.userName}	
    </div>
    <ul>
    	<li>${b_reviewer.member.userId}</li>
    	<li>${b_reviewer.reviewer.lang}</li>
    	<li>${b_reviewer.reviewer.star}</li>
    </ul>
	</c:forEach>
	
	<section class="bestReviewer">
		<div class="bReviewer">dfgfdfdf</div>
	</section>
</body>
</html>
