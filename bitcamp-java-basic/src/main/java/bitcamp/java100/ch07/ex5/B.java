package bitcamp.java100.ch07.ex5;

public class B extends A {

    // 수퍼 클래스의 생성자가 호출되는 검증하자!
    B() {
        //super(); // 생략하면 자동으로 붙는다고 했으니, 확인해보자!
        System.out.println("B() 생성자 실행!");
    }
}
