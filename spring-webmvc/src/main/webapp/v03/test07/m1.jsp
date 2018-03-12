<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>v03/test07</title>
</head>
<body>
<h1>Model 값이 어느 보관소에 저장되었는지 확인</h1>

<h2>ServletRequest 보관소</h2>
name: ${requestScope.name}<br>
age: ${requestScope.age}<br>
working: ${requestScope.working}<br>

<hr>

<h2>HttpSession 보관소</h2>
name: ${sessionScope.name}<br>
age: ${sessionScope.age}<br>
working: ${sessionScope.working}<br>


</body>
</html>





