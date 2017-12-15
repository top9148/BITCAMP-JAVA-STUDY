<%@page import="java100.app.listener.ContextLoaderListener"%>
<%@page import="java100.app.dao.ScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
    ScoreDao scoreDao = ContextLoaderListener.iocContainer.getBean(ScoreDao.class);
%>
<!DOCTYPE html>
<html>
<head>
<title>성적관리</title>
<link rel='stylesheet'
	href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
	<div class='container'>
		<jsp:include page="/header.jsp"></jsp:include>
		<h1>성적 삭제</h1>
		<%
		    try {
		        int no = Integer.parseInt(request.getParameter("no"));

		        if (scoreDao.delete(no) > 0) {
		%>
		<p>삭제했습니다.</p>
		<%
		    } else {
		%>
		<p>
			'<%=no%>'의 성적 정보가 없습니다.
		</p>
		<%
		    }

		    } catch (Exception e) {
		        e.printStackTrace(); // for developer
		%>
		<%=e.getMessage()%>
		<%
		    }
		%>

		<p>
			<a href='list.jsp' class='btn btn-primary btn-sm'>목록</a>
		</p>

		<jsp:include page="/header.jsp"></jsp:include>
	</div>

	<script src='../node_modules/jquery/dist/jquery.slim.min.js'></script>
	<script src='../node_modules/popper.js/dist/umd/popper.min.js'></script>
	<script src='../node_modules/bootstrap/dist/js/bootstrap.min.js'></script>

</body>
</html>

