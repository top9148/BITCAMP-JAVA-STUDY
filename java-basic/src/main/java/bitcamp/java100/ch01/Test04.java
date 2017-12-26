package bitcamp.java100.ch01;
/* 소스 파일 분리하기
- 소스 파일을 관리하기 쉽도록 별도의 폴더로 분리하는 방법을 알아보자!
- 왜 소스 파일을 별도의 폴더로 분리하는가?
 */
class Test04 {
  public static void main(String[] args) {
    System.out.println("안녕하세요!");
  }
}

/* 분리 
   > javac -d [.class 파일을 저장할 폴더] [폴더명/.../소스파일명]
   예)
   $프로젝트> md src
   $프로젝트> javac -d bin src/Test04.java

   이유?
   - 소스 파일을 보다 쉽게 관리하기 위함.
*/