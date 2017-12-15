// ## 메모리에 값 저장
// 메모리에 값을 저장하는 방법을 대해 자세히 알아보자!
//

package bitcamp.java100.ch02;

public class Test12_2 {

    public static void main(String[] args) {
// 메모리 준비하기
        int i;
        int j;

// 메모리에 값 저장하기
// '=' 연산자를 사용한다. 
// => '=' 연산자 왼편을 'l-value' 라 부른다. 반드시 메모리여야 한다.
// => '=' 연산자 오른편을 'r-value' 라 부른다. 메모리나 값이 될 수 있다. 
        i = 100; // r-value가 값인 경우
        j = i; // r-value가 변수인 경우
        System.out.println(i);
        System.out.println(j);

// => l-value에는 값이 올 수 없다.
        //100 = 200; // 컴파일 오류!

// => 메모리를 준비할 때 선언한 종류가 아닌 다른 종류의 값을 저장할 수 없다.
        //i = 3.14; // 컴파일 오류! 자바는 정적 타입 바인딩이다.

// => 메모리를 준비하지도 않고 사용할 수 없다.
        //x = 100; // "cannot find symbol" 컴파일 오류 발생!
    }
}
