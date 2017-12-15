// # 콘솔창으로 출력하기 

package bitcamp.java100.ch01;

public class Test10_2 {

    public static void main(String[] args) {

// 자바에서 프로그래밍 할 때 도구를 사용하는 방법
// 1) 도구함.기능명
// 2) 도구함.객체명.기능명
// 3) 객체명.기능명
        
// System => 도구함. 클래스라고 부른다.
// out => 객체(object) = 실체(instance)
// println => 기능
// "Hello" => 매개변수(parameter). 기능을 수행하기 위해 전달하는 조건.
        System.out.println("Hello!");

// 도구함에 있는 기능을 바로 사용하는 경우
// - 어떤 기능은 인스턴스가 있어야만 사용 가능하다.
// - 어떤 기능은 클래스만 있으면 사용 가능하다.
        long currMillis = System.currentTimeMillis();
        System.out.println(currMillis);
    }
}