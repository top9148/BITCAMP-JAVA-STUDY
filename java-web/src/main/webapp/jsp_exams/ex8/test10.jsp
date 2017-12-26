<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
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
<h1>EL(Expression Language) 사용법</h1>
OGNL 표기법을 이용하여 자바 객체의 프로퍼티 값을 꺼내는 문법이다.<br>
OGNL(Object Graph Navigation Language) 이란?<br>
점(.)이나 대괄호([]) 등을 이용하여 객체의 변수 값을 쉽게 꺼내게 해주는 문법이다.

<%
java.util.HashMap<String,Object> map = new java.util.HashMap<>();
map.put("name", "홍길동");
map.put("age", 20);
map.put("working", true);

pageContext.setAttribute("map", map);
%>

<h2>Map</h2>

name : ${pageScope.map["name"]}<br>
name : ${pageScope.map.name}<br>
name : ${map.name}<br>
age : ${map.age}<br>
working : ${map.working}<br>

</body>
</html>






