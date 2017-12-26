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

<h2>연산자</h2>

<h3>산술 연산자</h3>
10 + 20 = ${10 + 20}<br>
10 - 20 = ${10 - 20}<br>
10 * 20 = ${10 * 20}<br>
10 / 20 = ${10 / 20}<br>
10 % 20 = ${10 % 20}<br>
10 div 20 = ${10 div 20}<br>
10 mod 20 = ${10 mod 20}<br>

<h3>논리 연산자</h3>

true &amp;&amp; true = ${true && true}<br>
true &amp;&amp; false = ${true && false}<br>
true and false = ${true and false}<br>

true || true = ${true || true}<br>
true || false = ${true || false}<br>
true or false = ${true or false}<br>

!true = ${!true}<br>
not true = ${not true}<br>

<h3>관계 연산자</h3>
3 == 5 = ${3 == 5}<br>
3 eq 5 = ${3 eq 5}<br>

3 != 5 = ${3 != 5}<br>
3 ne 5 = ${3 ne 5}<br>

3 > 5 = ${3 > 5}<br>
3 gt 5 = ${3 gt 5}<br>

3 >= 5 = ${3 >= 5}<br>
3 ge 5 = ${3 ge 5}<br>

3 < 5 = ${3 < 5}<br>
3 lt 5 = ${3 lt 5}<br>

3 <= 5 = ${3 <= 5}<br>
3 le 5 = ${3 le 5}<br>

<h3>empty</h3>
<%
pageContext.setAttribute("money", 10000);
%>
empty name = ${empty pageScope.name}<br>
empty money = ${empty pageScope.money}<br>

<h3>조건식</h3>
<%
pageContext.setAttribute("age", 15);
%>
age > 18 ? "성인" : "미성년" = ${age > 18 ? "성인": "미성년"}<br>




<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>
















