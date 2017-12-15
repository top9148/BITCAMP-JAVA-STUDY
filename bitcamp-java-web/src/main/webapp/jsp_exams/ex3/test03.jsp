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
<h1>표현식(expression element) 테스트 II</h1>
<%int age = 18;%>
나이 <%=age%>는 <%=(age < 19) ? "미성년" : "성년" %> 입니다.
<%-- 
...
out.write("<h1>표현식(expression element) 테스트 II</h1>\n");
int age = 18;
out.write("\n");
out.write("나이 ");
out.print(age);
out.write("는 ");
out.print((age < 19) ? "미성년" : "성년" );
out.write(" 입니다.\n");
...
--%>

</body>
</html>






