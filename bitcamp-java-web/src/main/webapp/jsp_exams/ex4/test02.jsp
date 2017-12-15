<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<%!
  public int a;
%>
<meta charset="UTF-8">
<title>JSP예제</title>
<link rel='stylesheet' href='../common.css'>
</head>
<%!
  {
    this.a = 100;
    this.b = 200;
  }
%>
<body>
<h1>선언부(declaration element) 테스트</h1>
JSP declaration element는 JSP 페이지의 어느 위치에 와도 상관없다.<br>
어차피 서블릿 클래스 선언부에 그대로 복사될 것이다.<br>
그렇다고 이 소스처럼 아무데나 퍼트려 배치한다면, 유지보수하기 어려울 것이다.<br>
이 예제 코드는 위치에 상관없다는 것을 강조하기 위한 것이다.<br>
실무에서 사용할 때는 맨 앞 또는 맨 뒤에 놓도록 하라!<br>
<br>
a + b = <%=m()%>
</body>
<%!
  private int m() {
    return a + b;
  }
%>
</html>
<%!
  public int b;
%>






