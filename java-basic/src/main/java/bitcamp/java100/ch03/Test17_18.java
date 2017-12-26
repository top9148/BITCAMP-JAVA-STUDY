// ## 메서드 - 클래스 메서드와 인스턴스 메서드
// - 클래스 메서드와 인스턴스 메서드를 정의하고 사용하는 방법을 알아보자!

package bitcamp.java100.ch03;

public class Test17_18 {
    
    static class My {
        int value;
        
        // 클래스 메서드 
        // - 클래스에 소속된 메서드 
        // - static 이 붙은 메서드이다. 그래서 "static 메서드"라고도 부른다. 
        // - 인스턴스의 값을 사용하려면 반드시 파라미터로 받아야 한다.
        // 
        static void print(My ref) {
            System.out.println(ref.value);
            
            //System.out.println(this.value); // 컴파일 오류!
            // 클래스 메서드는 this라는 내장 변수가 없다.
        }
    }
    
    public static void main(String[] args) {
        My r1 = new My();
        My r2 = new My();
        My r3 = new My();
        
        r1.value = 100;
        r2.value = 200;
        r3.value = 300;
        
        // 클래스 메서드를 통해 인스턴스 값을 다루려면,
        // 호출할 때 파라미터로 인스턴스 주소를 넘겨야 한다.
        My.print(r1);
        My.print(r2);
        My.print(r3);
                
        // 클래스 메서드를 호출할 때 클래스 이름 대신 레퍼런스로 호출할 수 있다.
        r1.print(r1);
        // 클래스 메서드는 this라는 내장 변수가 없기 때문에 
        // 메서드 앞에 지정한 인스턴스 주소는 그냥 버려진다.
        // 즉 아무런 영향을 끼치지 않는다.
        //
        // 결론!
        // 클래스 메서드는 클래스 이름으로 호출하라!
        // 레퍼런스로 호출할 수 있더라도 클래스 이름으로 호출하여
        // 해당 메서드가 클래스 메서드임을 명확히 하는 게 소스 코드를 해석하기 쉽게한다.
        // 이클립스에서도 클래스 메서드를 레퍼런스 변수로 호출하면 
        // 위오 같이 경고이 메시지를 띄운다.
    }
    
}











