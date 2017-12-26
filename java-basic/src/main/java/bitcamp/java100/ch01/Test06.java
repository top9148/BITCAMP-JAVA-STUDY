package bitcamp.java100.ch01;
/* 다른 소스 파일의 코드를 참조할 때 컴파일 하는 방법
- 다른 소스 파일의 코드를 참조할 때, 컴파일 하는 방법을 알아보자!
- 다른 소스 파일의 코드를 참조하는 이유는?
 */
class Test06 {
  public static void main(String[] args) {
    Test06_other.printHello();   
  }
}

/*  [일반적인 컴파일 방법]
    $프로젝트폴더> javac -d bin -encoding utf8 src/main/java/Test06.java 
    => Test06 블록에서는 Test06_other라는 블록의 코드를 사용한다.
    => 그러나 컴파일러가 Test06_other라는 블록을 못찾기 때문에 오류가 발생한다.
    
    [다른 소스 파일을 참조하는 경우 컴파일 하는 방법]
    -sourcepath [참조하는 소스 파일이 들어 있는 폴더]
    $프로젝트폴더> javac ... -sourcepath src/main/java src/main/java/Test06.java 
    
 */