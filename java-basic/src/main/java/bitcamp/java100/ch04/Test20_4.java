// ## 래퍼(wrapper) 클래스 사용법 - 메서드를 통해서 래퍼 객체 만들기
// - new 가 아닌 메서드를 통해서 래퍼 객체를 만들어보자!
//

package bitcamp.java100.ch04;

public class Test20_4 {
    
    public static void main(String[] args) {
        // 래퍼 클래스의 인스턴스를 만드는 기존 방식
        Integer i = new Integer(100);
        
        // 그러나 위와 생성자를 사용하여 Integer 객체를 생성하는 방식은 
        // 사용하지 말라고 권고하고 있다.
        // 대신 다음과 같이 래퍼 객체를 생성해주는 메서드를 사용하라!
        
        Integer i2 = Integer.valueOf(100);
        
        // valueOf() 처럼 객체를 생성해주는 메서드를 
        // 공장과 같다고 해서 "factory method"라 부른다.
    }
}











