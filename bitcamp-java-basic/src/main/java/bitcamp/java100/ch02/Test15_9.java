// ## 연산자 - 조건 연산자 ( 조건 ? 식1 : 식2 )
// - 조건 연산자의 사용법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test15_9 {

    public static void main(String[] args) {
        int age = 27;

// (조건) ? 식1 : 식2;
// => 조건이 참이면, 식1을 실행한 후 그 결과를 그 자리에 놓는다.
// => 조건이 거짓이면, 식2를 실행한 후 그 결과를 그 자리에 놓는다.
// 식(Expression) => 결과를 리턴하는 명령어
// 문장(Statement) => 결과를 반드시 리턴하지는 않는다. 세미콜론으로 끝나야 한다.
// 블록(Block) => 한 개 이상의 문장이나 하위 블록로 구성된 것.
// 메서드(Method) => 다시 사용할 수 있는 블록.
// 클래스(Class) => 여러 개의 변수 선언과 메서드들로 구성된 블록.
        String result = (age <= 19) ? "미성년" : "성년";
        
        System.out.println(result);

    }
}







