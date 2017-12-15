<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP예제</title>
<link rel='stylesheet' href='../common.css'>
</head>
<body>
<h1>JSP 코드 - taglib 테스트</h1>
JSTL 태그 라이브러리를 가져와서 사용해보자!
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forTokens var="name" items="홍길동,임꺽정,유관순,안중근,윤봉길" delims=",">
    <p>${name}</p>
</c:forTokens>

</body>
</html>






