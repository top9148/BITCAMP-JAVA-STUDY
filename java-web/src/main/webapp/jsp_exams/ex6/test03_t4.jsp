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
<h1>jsp:useBean 테스트 IV</h1>
type과 class 구분하기.

<jsp:useBean id="list" type="java.util.List" class="java.util.ArrayList"/>

<%--
// PageContext 보관소에서 객체를 찾는다. 
java.util.List list = pageContext.getAttribute("list");

// 없으면 생성한다.
if (list == null) {
    list = new java.util.ArrayList();
    // 생성한 객체는 PageContext 보관소에 저장한다.
    pageContext.setAttribute("list", list);
}
--%>
<p>
리스트 크기: <%=list.size()%>
</p>

</body>
</html>






