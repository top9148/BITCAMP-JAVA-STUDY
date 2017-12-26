// ## 문장(Statement) - 블록과 변수의 범위
// - 블록이란? 여러 명령어를 묶는 문법이다.
// - 블록의 종류? 일반 블록, 메서드, 클래스, 인스턴스 블록, 스태틱 블록
// - 블록을 만드는 방법과 변수의 사용범위를 알아보자!
//

package bitcamp.java100.ch02;

public class Test16_1 {

    public static void main(String[] args) {
        int a = 100;
        
        // => 블록을 만드는 방법
        {
            // => 바깥 블록에 선언된 변수와 같은 이름으로 또 다시 변수를 만들 수 없다.
            //int a = 200; // 컴파일 오류!
            
            // => 바깥 블록에 선언된 변수를 사용할 수 있다.
            System.out.println(a);
            
            // => 블록 안에 새 변수를 만들 수 있다.
            int b = 200; 
            System.out.println(b);
            {
                System.out.println(b);
                int c = 300;
                System.out.println(c);
            }
            
            // => 블록을 벗어난 변수는 사용할 수 없다. 왜? 제거되었기 때문이다.
            //System.out.println(c); // 컴파일 오류!
        }
        
        System.out.println(a);
        
        // => 블록을 벗어난 변수는 사용할 수 없다.
        // - 변수는 블록을 벗어나는 순간 제거된다.
        //System.out.println(b); // 컴파일 오류!
        
        // => 변수는 사용 전에 선언되어 있어야 한다.
        //System.out.println(c); // 컴파일 오류!
        
        // => c 변수는 위의 안쪽 블록에서 한 때!!! 있었다. 지금은 없는 상태이다.
        //    그래서 같은 이름을 변수를 선언할 수 있다.
        int c = 300;
        
        // => 강조! a 변수는 현재 블록에 존재하는 상태이다. 
        //    같은 이름으로 변수를 만들 수 없다. 
        //int a = 400; // 컴파일 오류!
    }
}













