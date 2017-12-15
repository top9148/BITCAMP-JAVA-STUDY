// ## 메서드 - 인스턴스(클래스 설계도에 따라 만든 메모리)를 다루는 메서드 VI
// - 메서드를 이용하여 인스턴스를 다루는 방법을 알아보자!
//

package bitcamp.java100.ch03.Test17_17.step6;

// 6단계: 인스턴스의 값을 다루는 메서드는 해당 인스턴스의 전용 메서드로 만든다. 
public class Test {

    
    
    public static void main(String[] args) {
        // 면적을 구하는 예제
        Rect r;
        r = new Rect();

        r.width = 390;
        r.height = 420;
        
        // 인스턴스 전용 메서드를 호출할 때,
        // - 파라미터가 아닌 메서드 앞에 인스턴스 주소를 지정해야 한다.
        // - 예) 인스턴스주소.메서드명();
        
        // 메서드 앞에 준 인스턴스 주소는 해당 메서드의 내장 변수 this에 보관된다. 
        System.out.println(r.area());
        System.out.println(r.pyeong());
        
    }
}













