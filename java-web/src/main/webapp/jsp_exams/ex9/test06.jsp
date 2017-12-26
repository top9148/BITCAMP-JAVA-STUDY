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

<h3>c:if 태그</h3>
<p>
조건에 따라 실행을 여부를 결정하는 태그이다.<br>
&lt;c:if test="EL로 작성된 조건" 
         var="조건 검사 결과(true/false)를 저장할 변수"
         scope="page|request|session|application"/><br>
</p>

<c:set var="name" value="홍길동" scope="page"/> 

<c:if test="${name == '홍길동'}" var="result">
  오호라, 당신이 홍길동이군요!<br>
</c:if>

result: ${result}

<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>

















