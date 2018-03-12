package bitcamp.java100.ch21.ex4;

public class MyAdvice {
    
    // 다음 메서드들은 대상 객체의 특정 메서드를 호출하기 
    // 전,후에 실행하는 메서드이다.
    // 이런 메서드의 역할은 충고를 하는 것이다.
    // 그래서 이런 메서드들을 "advice"라 부른다.
    //
    
    // 대상 메서드의 파라미터 값을 받고 싶으면 
    // advice에도 그 값을 받을 파라미터를 선언하라!
    public void doBefore(String name) {
        System.out.printf("MyAdvice.doBefore: %s\n", name);
    }
    
    public void doAfter() {
        System.out.println("MyAdvice.doAfter()");
    }
    
    // 리턴 값 받기 
    public void doAfterReturning(Object returnValue) {
        System.out.printf("MyAdvice.doAfterReturning(): %s\n", returnValue);
    }
    
    // 예외 객체 받기
    public void doAfterThrowing(Exception error) {
        System.out.printf("MyAdvice.doAfterThrowing(): %s\n", error.getMessage());
    }
    
    public void doAround() {
        System.out.println("MyAdvice.doAround()");
    }
}
