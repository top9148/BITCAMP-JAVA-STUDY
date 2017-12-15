// ## 연산자 - char 데이터와 명시적 형변환
// - 정수 값을 유니코드로 다루는 사용법을 알아보자!
//

package bitcamp.java100.ch02;
 
public class Test15_14 {

    public static void main(String[] args) {
        // ### 문자 다루기
        // - 문자는 항상 유니코드로 다룬다.
        // - 유니코드를 전문적으로 저장할 때 사용하면 메모리 타입이 char이다.
        // - char는 2바이트 크기를 가지며, 0 ~ 65535까지의 값을 저장할 수 있다.
        
        char v1 = 44032;
        System.out.println(v1);
        // => println() 메서드는 넘어온 값의 메모리 타입에 따라 출력을 조정한다.
        //    넘어온 값이 char 메모리 값이라면 숫자를 출력하는 대신 그 유니코드의 해당하는
        //    문자를 출력한다.

        // => 그러나 다음과 같이 println()에 넘어온 값이 int 메모리 타입이라면
        //    그냥 숫자를 출력한다.
        int v2 = 44032;
        System.out.println(v2);
        
        // ### int 메모리에 들어 있는 값을 문자로 출력하기
        // => 명시적 형변환 명령을 이용하여 char 값으로 변환해라!
        System.out.println((char)v2);
        
        

    }
}


















