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

<h3>c:remove 태그</h3>
<p>
보관소에 저장된 값을 제거하는 태그이다.<br>
&lt;c:remove var="변수명" 
             scope="page|request|session|application"/><br>
</p>

<c:set var="name" value="홍길동" scope="page"/> 
<c:set var="name" value="임꺽정" scope="request"/>
<c:set var="name" value="유관순" scope="session"/>
<c:set var="name" value="김구" scope="application"/>

${pageScope.name}<br>
${requestScope.name}<br>
${sessionScope.name}<br>
${applicationScope.name}<br>
<hr>

<c:remove var="name" scope="session"/>
<c:remove var="name" scope="request"/>
<c:remove var="name" scope="application"/>
<c:remove var="name" scope="page"/>

${pageScope.name}<br>
${requestScope.name}<br>
${sessionScope.name}<br>
${applicationScope.name}<br>
<hr>

<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>

















