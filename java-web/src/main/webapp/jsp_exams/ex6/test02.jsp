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
<h1>jsp:include</h1>
JSP 페이지에 이 태그를 넣으면,<br>
서블릿 클래스를 만들 때,<br>
RequestDispatcher의 include()를 실행하는 코드가 삽입된다.<br>

<%-- page 속성에 지정한 JSP를 실행한 후 다시 돌아온다. --%>
<jsp:include page="test02_p1.jsp"/>

<hr>

<%-- 해당 JSP 파일의 내용을 이 JSP에 포함시키는 것이 아니라
     page 속성에 지정한 JSP를 실행한 후 다시 돌아온다. --%>
<jsp:include page="test02_p2.jsp"/>

</body>
</html>






