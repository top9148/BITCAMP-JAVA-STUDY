// ## 논리 값을 저장할 변수 
// - 논리 값을 저장할 변수를 만들고 사용하는 방법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test12_8 {

    public static void main(String[] args) {
// 논리 값 저장할 메모리 준비
        boolean b1;
        
// 저장할 수 있는 값은 자바 언어에 미리 정의된 true, false만 가능하다.
        b1 = true;
        System.out.println(b1);

        b1 = false;
        System.out.println(b1);

// JVM에서 내부적으로 true, false를 다룰 때 1, 0으로 다루지만, 개발자가 직접 이 메모리에 1 또는 0을 넣을 수는 없다.
        //b1 = 1; // 컴파일 오류!
        //b1 = 0; // 컴파일 오류!

// boolean 타입의 값에 대해서는 +, -, *, / 등의 연산자가 정의되어 있지 않다. 즉 사용할 수 없다.
        //b1 = true - false; // 컴파일 오류!
    }
}
