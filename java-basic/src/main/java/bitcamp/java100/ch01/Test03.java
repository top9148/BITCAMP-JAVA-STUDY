package bitcamp.java100.ch01;
/* .class 파일 분리하기
- .class 파일을 관리하기 쉽도록 별도의 폴더로 분리하는 방법을 알아보자!
- 왜 .class 파일을 소스 파일로부터 분리하는가?
 */
class Test03 {
  public static void main(String[] args) {
    System.out.println("안녕하세요!");
  }
}

/* 분리 
   > javac -d [.class 파일을 저장할 폴더] [소스파일명]
   예)
   > md bin
   > javac -d bin Test03.java

   이유?
   - 소스 파일과 클래스 파일을 분리함으로써
     소스 파일을 관리하기 쉽고,
     배포를 위해 클래스 파일을 추출하기도 쉽다.

  다른 폴더에 있는 클래스 실행하기
  > java -classpath [.class 파일이 있는 폴더] 클래스명
  > java -cp [.class 파일이 있는 폴더] 클래스명
  예)
  > java -classpath bin Test03
  > java -cp bin Test03

  운영체제에 .class 파일이 있는 폴더를 등록해두면 
  .class 파일을 실행할 때 마다 매번 -cp 또는 -classpath를
  사용하여 .class 파일이 있는 경로를 지정할 필요가 없다.
  > set CLASSPATH=[클래스파일이 있는 폴더1;폴더2;폴더3]
  예)
  > set CLASSPATH=c:\workspace\java-basic\bin
  > java Test03
*/