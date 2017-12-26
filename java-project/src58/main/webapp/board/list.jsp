<%@page import="java100.app.domain.Board"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="/header.jsp"/>

<h1>게시물 목록</h1>

<p><a href='form' class='btn btn-primary btn-sm'>추가</a></p>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>제목</th><th>등록일</th><th>조회수</th>
</tr>
</thead>
<tbody>
<jsp:useBean id="list" type="java.util.List<java100.app.domain.Board>" scope="request"></jsp:useBean>

<%
try {
    for (Board board : list) {
        pageContext.setAttribute("board", board);
    %>
        <tr>
        <td>${board.no}</td>
        <td><a href='view?no=${board.no}'>${board.title}</a></td>
        <td>${board.regDate}</td>
        <td>${board.viewCount}</td>
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
    