package bitcamp.java100.ch12.ex4;

public class Test1 {

    public static void main(String[] args) {
        
        // Protocol 규칙에 따라 만든 클래스의 객체 주소를 담을 변수를 준비.
        Protocol obj;
        
        // obj에 Protocol 구현체를 만들어 저장한다.
        obj = new A();
        
        // A의 서브클래스도 저장할 수 있다.
        // 왜?
        // => A의 모든 기능을 상속 받았기 때문이다.
        obj = new B();
        
        // instanceof 연산자로 다시 한 번 확인해보자!
        if (new A() instanceof Protocol) {
            System.out.println("A의 객체는 Protocol 구현체이다.");
        }
        
        if (new B() instanceof Protocol) {
            System.out.println("B의 객체는 Protocol 구현체이다.");
        }
        

    }

}





