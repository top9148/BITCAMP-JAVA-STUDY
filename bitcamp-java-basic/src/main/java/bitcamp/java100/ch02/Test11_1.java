// # 자바에서 값 표현(literal)하기
// 문자열, 정수, 부동소수점, 논리 값을 표현하는 방법
//
package bitcamp.java100.ch02;

public class Test11_1 {

    public static void main(String[] args) {
// 자바 코드로 문자열을 표현(=문자열 리터럴)하는 방법
// 
        System.out.println("문자열");

// 자바 코드로 정수를 표현(=정수 리터럴)하는 방법
//
        System.out.println(100);

// 자바 코드로 소수점이 있는 숫자를 표현(=부동소수점 리터럴)하는 방법
//
        System.out.println(3.14);
        
// 자바 코드로 논리 값을 표현(=불린 리터럴)하는 방법 
// 불린 = boolean
        System.out.println(true);
        System.out.println(false);

        // 대소문자를 구분하기 때문에 다음은 컴파일 오류!
        //System.out.println(True);
        //System.out.println(FALSE);
    }
}