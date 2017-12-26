<%@page import="java100.app.listener.ContextLoaderListener"%>
<%@page import="java100.app.dao.MemberDao"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
MemberDao memberDao = ContextLoaderListener.iocContainer.getBean(
        MemberDao.class);
%>
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

<h1>회원 삭제 결과</h1>
<%
try {
    int no = Integer.parseInt(request.getParameter("no"));
    
    if (memberDao.delete(no) > 0) {%>
        <p>삭제했습니다.</p>
<%        
    } else {%>
        <p>'<%=no %>'번의 회원 정보가 없습니다.</p>
<%         
    }
    
} catch (Exception e) {
    e.printStackTrace(); // for developer%>
    <%=e.getMessage() %>
<%    
} %>
<p><a href='list.jsp' class='btn btn-primary btn-sm'>목록</a></p>

<jsp:include page="/footer.jsp"/>

</div>

<%@ include file="../jslib.txt"%>

</body>
</html>
    