// # 자바에서 값 표현(literal)하기 - 논리 값 표현
//
package bitcamp.java100.ch02;

public class Test11_11 {

    public static void main(String[] args) {
// 자바에서 논리 값은 true, false 라는 이름으로 표현한다.
// => 모두 소문자로 작성해야 한다.
        System.out.println(true);
        System.out.println(false);

// => 대문자로 작성하면 컴파일 오류이다.
        //System.out.println(True); 

// => 자바는 숫자를 논리값으로 사용하지 않는다.
// 0은 숫자, false는 논리값 비교 불가!
        //System.out.println(0 == false); 
    }
}

// 논리 값의 크기
// => 4바이트 int 메모리를 사용하여 저장한다.
// => 여러 개의 논리 값을 저장하기 위해 배열을 사용할 때는 1바이트 크기를 갖는 바이트 배열에 저장한다.