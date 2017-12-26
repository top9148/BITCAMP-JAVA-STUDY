<%@page import="java100.app.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="/header.jsp"/>

<h1>회원 목록</h1>

<p><a href='form' class='btn btn-primary btn-sm'>추가</a></p>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>이름</th><th>이메일</th><th>가입일</th>
</tr>
</thead>
<tbody>
<jsp:useBean id="list" type="java.util.List<java100.app.domain.Member>" scope="request"></jsp:useBean>
<%
try {
    for (Member member : list) {
        pageContext.setAttribute("member", member);
    %>
        <tr>
        <td>${member.no}</td>
        <td><a href='view?no=${member.no}'>${member.name}</a></td>
        <td>${member.email}</td>
        <td>${member.createdDate}</td>
        </tr>
<%
    }
} catch (Exception e) {
    e.printStackTrace(); // for developer%>
    <%=e.getMessage() %>
<%    
}%>
</tbody>
</table>

<jsp:include page="/footer.jsp"/>

</div>

<%@ include file="../jslib.txt"%>

</body>
</html>
    