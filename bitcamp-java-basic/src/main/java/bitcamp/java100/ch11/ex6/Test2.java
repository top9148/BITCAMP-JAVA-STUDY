// 추상 클래스 II
package bitcamp.java100.ch11.ex6;

public class Test2 {
    public static void main(String[] args) {
        // 추상 클래스의 서브 클래스를 사용한다.
        B obj = new B();
        obj.m1();
        obj.m2();
        
        System.out.println("----------------------------");
        
        // 물론 레퍼런스를 만들 때는 추상 클래스도 사용할 수 있다.
        A obj2 = new B();
        
        // 다만 obj2로 사용할 수 있는 메서드는
        // obj2 타입에 제한된다.
        obj2.m1();
        //obj2.m2(); // 컴파일 오류!
        
        // obj2에는 실제 B 객체(의 주소)가 저장되어 있다.
        // B의 원래 기능을 쓰고 싶다면, 형변환하라!
        ((B)obj2).m2();
        
        B obj3 = (B)obj2;
        obj3.m2();
    }
}












