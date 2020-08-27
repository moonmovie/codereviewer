<%@page import="org.springframework.util.ResizableByteArrayOutputStream"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta rel="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&family=Raleway:wght@300&display=swap" rel="stylesheet">
<script src="<c:url value="/resources/js/main.js" />"></script>
<script src="https://kit.fontawesome.com/a1e8010f17.js" crossorigin="anonymous"></script>
<title>nav bar</title>
</head>
<body>
	<nav class="navbar">
		<div class="navbar__logo">
			<i class="fas fa-code"></i>
			<a href="/">CodeReviewer</a>
		</div>
		
		<ui class="navbar__menu">
			<li><a href="/">Home</a></li>
			<li><a href="">CodeCamp</a></li>
			<li><a href="">Reviewer</a></li>
			<li><a href="">Community</a></li>
			<li><a href="">FAQ</a></li>
		</ui>
		<ui class="navbar__sign">
		<c:if test="${member==null}">
			<li><a href="/member/signin">sign in</a></li>
			|
			<li><a href="/member/signup">sign up</a></li>
		</c:if>
		<c:if test="${member!=null}">
			<c:choose>
				<c:when test="${member.verify==9}">
				<li>
					<i class="fas fa-user-cog"></i>
					<a href="/admin/index">관리자 화면</a>
				</li>
				</c:when>
				
				<c:otherwise>
				<li>
					<i class="fas fa-user"></i>
					<a href="/admin/index">${member.userName}</a>
				</li>
				</c:otherwise>
			</c:choose>
				|
				<li><a href="/member/signout">LogOut</a></li>
		</c:if>
		</ui>
		
		<a href="#" class="navbar__toogle">
			<i class="fas fa-bars"></i>
		</a>
	</nav>
</body>
<script type="text/javascript">

document.getElementsByClassName("navbar__toogle")[0].addEventListener('click', () => {

	const menu=document.getElementsByClassName("navbar__menu")[0];
	const sign=document.getElementsByClassName("navbar__sign")[0];
	
	menu.classList.toggle("active");
	sign.classList.toggle("active");
	
});
</script>
</html>