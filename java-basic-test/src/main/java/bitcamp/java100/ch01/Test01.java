package bitcamp.java100.ch01;
//자바 프로그램 실행하기

//1. 컴파일
//개발자가 작성한 .java 파일을
//플레이어가 실행할 수 있는 포맷으로 변환한다.
//변환하면 .class 파일이 생성된다.
//컴파일을 실행하려면 컴파일을 해주는 프로그램을 사용해야 한다.
//
//2. 실행
//컴파일 된 .class 파일을 실행하려면 프로그램이 있어야 한다.
//그 프로그래밍을 인터프리터 또는 JVM이라 부른다.
//
//3. javac.exe와 java.exe을 실행하기 위해 긴 디렉터리 경로까지 적어야 한다.
//이를 피하는 방법은?
//        운영체제의 PATH라는 환경변수에 javac.exe, java.exe가 들어 있는 
//        디텍토리 경로를 미리 등록하라!

public class Test01 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
