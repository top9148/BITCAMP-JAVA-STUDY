// ## 메서드 - 로컬 변수와 스택 메모리
// - 로컬 변수와 스택 메모리의 관계를 알아보자!
//

package bitcamp.java100.ch03;

public class Test17_12 {

    static void m1(int value) {
        value += 50;
        System.out.printf("m1(): %d\n", value);
    }
    
    public static void main(String[] args) {
        int value = 100;
        m1(value);
        System.out.printf("main(): %d\n", value);
    }
}

// ### 로컬 변수(local variables)
// - 메서드에 선언된 변수를 말한다.
// - 메서드가 호출될 때 스택(stack) 메모리에 만들어진다.
// - 메서드 호출이 끝나면 제거된다.
// - 파라미터도 로컬 변수이기 때문에 동일하다.
// 
// ### 스택 메모리(stack)
// - 메서드가 호출될 때 로컬 변수들이 존재하는 메모리 영역이다.
// - 메서드가 호출되면 그 순서대로 생성되고 호출이 끝나면 그 순서대로 제거되기 때문에
//   접시를 쌓고 꺼내는 과정과 비슷하다고 해서 스택 메모리라 부른다.
//
// ### 메서드 호출
// main()
// - args = 빈배열
// - value = 100
// main() --> m1(100)
// - value = 100 + 50















