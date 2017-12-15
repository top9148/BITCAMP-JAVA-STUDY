/* 클래스와 패키지
- 패키지를 사용하여 클래스를 분류하는 방법을 알아보자! 
- 패키지를 사용하는 이유?
*/

// 소스 파일에서 제일 처음에 패키지를 선언한다.
// 그러면 이후에 선언되는 모든 클래스들은 이 패키지에 소속된다.
package bitcamp.java100.ch01.a.b.c; // 하위 패키지는 점(.)으로 구분한다.

public class Test09_3 {
  public static void main(String[] ags) {
    System.out.println("Hello!"); 
  }
}

/*  [패키지 클래스를 실행하는 방법]
 *  > java -cp ./build/classes/java/main a.b.c.Test09_3
 *  
 */