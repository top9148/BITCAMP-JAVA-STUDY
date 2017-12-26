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
<h1>표현식(expression element) 테스트</h1>
10 + 20 = <%= 10 + 20 %> 입니다.
<%-- 
...
out.write("<h1>표현식(expression element) 테스트</h1>\n");
out.write("10 + 20 = ");
out.print( 10 + 20 );
out.print(" 입니다.\n"); 
...
--%>

</body>
</html>






