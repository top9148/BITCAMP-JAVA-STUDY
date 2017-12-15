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
<h1>jsp:useBean</h1>
JSP 페이지에 이 태그를 넣으면,<br>
자바 객체를 생성하는 코드를 삽입한다.<br>

<h2>주요 속성</h2>
<h3>id 속성</h3>
<p>
객체를 생성한 후 저장할 때 사용할 이름<br>
동시에 변수명으로도 사용함.
</p>

<h3>class 속성</h3>
<p>
객체를 생성하기 위한 클래스명.<br>
반드시 Fully-Qualified Class Name을 줘야 한다.<br>
즉 패키지명을 포함한 클래스 이름이어야 한다.<br> 
객체를 생성할 때 사용할 이름이기 때문에 반드시 클래스이름어야 한다.<br>
인터페이스와 추상 클래스는 인스턴스를 생성할 수 없기 때문에 사용할 수 없다.<br>
</p>

<h3>type 속성</h3>
<p>
변수를 선언할 때 사용할 타입명.<br>
인스턴스를 만드는 용도가 아니기 때문에 인터페이스나 추상클래스도 가능하다.<br>
물론 이 이름도 반드시 Fully-Qualified Name 이어야 한다.<br>
만약 이 속성이 생략되면 class 속성 값을 변수선언하는데 사용한다.<br>
</p>

<h3>score 속성</h3>
<p>
객체를 생성한 후 저장할 보관소를 지정한다.<br>
이 속성을 생략하면 기본적으로 PageContext 보관소에 저장된다.<br>
서블릿은 총 4개의 보관소를 제공한다.<br>
보관소에 대한 내용을 따로 설명한다.<br>
</p>
</body>
</html>






