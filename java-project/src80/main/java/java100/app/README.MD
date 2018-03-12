## ver 80
- 클라이언트가 보낸 파라미터 값을 요청 핸들러에서 객체로 받을 때 데이터 변환 오류를 검사하는 방법을 적용하라.
- 학습목표
  - BindingResult의 사용 방법을 이해한다.      

### 작업 목록

#### ScoreController.java 변경
- add() 요청 핸들러에 BindingResult 변수 추가

#### /WEB-INF/jsp/score/form.jsp 변경
- BindingResult 테스트를 위해 입력 폼에서 국,영,수 값을 검증하는 코드를 주석 처리함.






