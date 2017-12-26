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
<h1>jsp:setProperty 테스트</h1>
겟터 호출하기.<br>
setProperty를 사용하는 경우 new 명령을 사용하여 객체를 만든 후<br>
그 객체를 PageContext에 담아 놓고 사용해도 문제가 없는데,<br>
getProperty를 사용하는 경우에는 useBean을 통해 객체를 생성해야만 사용할 수 있다.<br>
결론,<br> 
jsp:getProperty나 jsp:setProperty를 호출할 때는<br>
주로 jsp:useBean으로 만든 객체를 다룰 때이다.<br>
그러니 가능한 useBean으로 객체를 만든 후 이 태그를 사용하라!<br>

<jsp:useBean id="m" class="domain.Member">
    <jsp:setProperty name="m" property="name" value="홍길동"/>
    <jsp:setProperty name="m" property="age" value="20"/>
    <jsp:setProperty name="m" property="working" value="true"/>
</jsp:useBean>

<p>
이름: <jsp:getProperty name="m" property="name"/><br>
나이: <jsp:getProperty name="m" property="age"/><br>
재직자: <jsp:getProperty name="m" property="working"/><br>
</p>
</body>
</html>






