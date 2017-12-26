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

<h3>c:choose 태그</h3>
<p>
조건에 따라 여러 개로 분기할 때 사용하는 태그이다.<br>
<%--
<c:choose>

  <c:when test="EL로 표현된 논리 값"></c:when>
  <c:when test="EL로 표현된 논리 값"></c:when>
  <c:otherwise></c:otherwise>
  
</c:choose>
 --%>
</p>

<c:set var="level" value="2"/>

<c:choose>
  <c:when test="${level == 0}">손님입니다.</c:when>
  <c:when test="${level == 1}">회원입니다.</c:when>
  <c:when test="${level == 2}">관리자입니다.</c:when>
  <c:otherwise>권한이 없습니다!</c:otherwise>
</c:choose>


<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>

















