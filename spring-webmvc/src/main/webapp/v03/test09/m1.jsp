<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>v03/test09</title>
</head>
<body>

<h1>ServletRequest 보관소</h1>
name: ${requestScope.name}<br>
age: ${requestScope.age}<br>
working: ${requestScope.working}<br>

<hr>

<h1>HttpSession 보관소</h1>
name: ${sessionScope.name}<br>
age: ${sessionScope.age}<br>
working: ${sessionScope.working}<br>


</body>
</html>





