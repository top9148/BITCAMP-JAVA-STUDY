// # print()와 println() 

package bitcamp.java100.ch01;

public class Test10_3 {

    public static void main(String[] args) {
// print()
// => 출력한 이후에 줄바꿈 기호가 붙지 않는다.
        System.out.print("홍길동");
        System.out.print("임꺽정");
        System.out.println(); // 줄바꿈 코드 출력

// println()
// => 출력한 이후에 줄바꿈 기호가 붙는다.
        System.out.println("홍길동");
        System.out.println("임꺽정");
    }
}