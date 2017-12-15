# ver 51 작업 목록

## 각각의 기능별로 패키지를 준비한다.
- java100.app.servlet 패키지 생성
- servlet 패키지의 하위 패키지로 board, member, room, score 패키지를 만든다.
- 각 컨트롤러 클래스에 들어 있는 메서드를 XxxxListServlet, XxxxAddServlet 등의 
  서블릿 클래스로 추출한다.
  예) /board/list 요청을 처리할 서블릿은 BoardListServlet 클래스이다.
   
