<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP예제</title>
<link rel='stylesheet' href='../common.css'>
</head>
<body>
<h1>JSTL(JSP Standard Tag Library) 사용법</h1>
특정 자바 코드를 생성하는 태그이다.<br>

<h2>Core 라이브러리</h2>

<h3>c:out 태그</h3>
<p>자바의 출력문을 생성하는 태그이다.</p>

<c:out value="출력할 값"/><br>
<c:out value="${name}">없다면 이 값을 출력하라!</c:out><br>
<c:out value="${name}" default="없다면 이 값을 출력하라!"/><br>

<%
pageContext.setAttribute("name", "홍길동");
%>
<c:out value="${name}">없다면 이 값을 출력하라!</c:out><br>
<c:out value="${name}" default="없다면 이 값을 출력하라!"/><br>

</body>
</html>

















