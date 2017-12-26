<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP예제</title>
</head>
<body>
<h1>JSP 구동 원리</h1>
<pre>
1) 클라이언트가 test02.jsp를 요청한다.
2) 서블릿 컨테이너는 test02.jsp에 대한 서블릿 클래스가 있는 지 조사한다.

   => JSP 파일이 변경되었거나 서블릿 클래스가 없다면,
      - test02.jsp에 작성된 명령에 따라 서블릿 클래스를 만든다.
        - 어디에? tmpX/work/...../test02_jsp.java(톰캣서버의 경우)
      - 서블릿 소스를 컴파일한다.
        - 어디에? tmpX/work/...../test02_jsp.class(톰캣서버의 경우)
         
   => 해당 서블릿을 실행한다.
      
</pre>

</body>
</html>






