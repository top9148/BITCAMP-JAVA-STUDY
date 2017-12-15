// ## 메서드 - 메서드를 분류하기
// - 메서드를 관리하기 쉽도록 서로 연관된 것끼리 묶어 분류하는 방법을 알아보자!
//

package bitcamp.java100.ch03.Test17_16;


public class Test17_16 {

    public static void main(String[] args) {
        // 별도의 클래스로 분류된 메서드 사용하기
        // 문법: 클래스명.메서드명()
        
        Test17_16_A.m1();
        Test17_16_B.m1();
        Test17_16_A.m2();
        Test17_16_B.m2();
        Test17_16_A.m3();
        Test17_16_B.m3();
        Test17_16_B.m4();
        

        // 다른 패키지에 있는 클래스를 사용할 때는
        // 반드시 전체 패키지명까지 지정해야 한다.
        
        //Test17_16_C.m1(); // 컴파일 오류!
        
        bitcamp.java100.ch03.Test17_16.other.Test17_16_C.m1();
        bitcamp.java100.ch03.Test17_16.other.Test17_16_C.m2();
        bitcamp.java100.ch03.Test17_16.other.Test17_16_C.m3();
        bitcamp.java100.ch03.Test17_16.other.Test17_16_C.m4();
        
        
    }
}

// ### 클래스 문법의 용도
// 1) 사용자 정의 데이터 타입을 만들 때
// 2) 메서드를 관리하기 쉽게 분류할 때












