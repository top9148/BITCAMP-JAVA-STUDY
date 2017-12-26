package bitcamp.java100.ch11.ex6;

public abstract class C {
    int v1;
    
    public void m1() {
        System.out.println("C.m1()");
    }
    
    // 서브 클래스가 반드시 오버라이딩(구현) 하도록 강제하고 싶다면
    // 추상 메서드로 선언하라!
    
    // => 추상 메서드는 구현하면 안된다.
    //public abstract void m2() {}
    
    // => 추상 메서드는 추상 클래스만이 가질 수 있다.
    public abstract void m2();
}








