<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP예제</title>
<link rel='stylesheet' href='../common.css'>
</head>
<body>
<h1>page - import 속성 테스트 III</h1>
이 JSP를 실행한 후 생성된 서블릿 소스 파일을 확인하라!
<pre class="jsp">
&lt;%@ page import="java.util.Date,java.net.*,java.sql.*"%>
&lt;%@ page import="java.net.*"%>
&lt;%@ page import="java.sql.*"%>
</pre>
</body>
</html>





