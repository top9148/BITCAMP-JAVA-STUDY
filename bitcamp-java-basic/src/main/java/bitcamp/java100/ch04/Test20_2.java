// ## 래퍼(wrapper) 클래스 사용법 - 오토박싱 & 언박싱
// - 오토 박싱/ 오토 언박싱의 개념과 사용법을 알아보자!
//

package bitcamp.java100.ch04;

public class Test20_2 {
    public static void main(String[] args) {
        int i = 100;
        
        // 오토 박싱(auto-boxing)
        // - primitive 값을 레퍼런스 변수에 저장하려 할 때 
        //   자동으로 래퍼 클래스의 인스턴스를 생성한 후 그 주소를 리턴한다.
        // - 이렇게 값이 객체에 넣어져서 리턴된다고 해서 "상자에 담는다(boxing)"라는
        //   표현을 사용한다.
        // 
        Integer r1 = 100; // OK! => new Integer(100)
        
        Integer r2 = new Integer(300);
        
        // 오토 언박싱(auto-unboxing)
        // - 랩퍼 객체를 primitive 타입의 변수에 저장하려 할 때 
        //   자동으로 래퍼 객체의 값을 꺼내는 것을 말한다.
        // - 즉 객체에 들어 있는 값을 꺼낸다고 해서 "상자에서 꺼낸다(unboxing)"라고 
        //   부른다.
        // 
        int i2 = r2; // OK! => r2.intValue()
        
    }
}











