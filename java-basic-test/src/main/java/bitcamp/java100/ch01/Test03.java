package bitcamp.java100.ch01;
//.class 파일 분리하기
//.class 파일을 관리하기 쉽도록 별도의 폴더로 분리하는 방법을 알아보자!
//왜 .class 파일을 소스 파일로부터 분리하는가?
        
public class Test03 {

    public static void main(String[] args) {
System.out.println("안녕하세요!");  
    }
}

//분리하는 이유?
//        소스 파일과 클래스 파일을 분리함으로서
//        소스파일을 관리하기 쉽고,
//        배포를 위해 클래스 파일을 추출하기도 쉽다.
//        
//다른 폴더에 있는 클래스 실행하기
//운영체제에 .class 파일이 있는 폴더를 등록해두면
//.class 파일을 실행할 때 마다 매번 -cp 또는 -classpath를
//사용하여 .class 파일이 있는 경로를 지정할 필요가 없다.

