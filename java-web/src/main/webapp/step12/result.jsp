<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션테스트</title>
</head>
<body>
<h1>입력 확인</h1>
이름: ${sessionScope.name}<br>
나이: ${sessionScope.age}<br>
재직자: ${sessionScope.working}<br>

</body>
</html>