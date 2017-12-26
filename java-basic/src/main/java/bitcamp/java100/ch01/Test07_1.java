package bitcamp.java100.ch01;
/* .java vs class {} vs .class
- .java 파일과 class {}과 .class 파일의 관계를 알아보자!
- .java 파일에 class 블록을 한 개만 두는 이유는?
 */
class Test07_A {}
class Test07_B {}
class Test07_C {}

/*  [.java 소스 파일의 컴파일 결과]
    - 각각의 class 블록 별로 .class 파일이 생성된다.
    - .java 파일 당 한 개의 .class 파일이 생성되는 것이 아니다!
    - .class 파일의 이름은 class {} 블록 이름과 같다.
 */