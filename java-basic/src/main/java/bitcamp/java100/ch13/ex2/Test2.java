// 예외의 종류: 
// 1) try...catch... 사용을 강제하지 않는 예외
//    => Error와 RuntimeException 계열의 예외
//    => try...catch...로 예외를 처리하지 않더라도 컴파일 오류는 아니다!
// 
// 2) try...catch... 사용을 강제하는 예외
//    => Exception 계열의 예외 
//    => 즉 try...catch로 예외를 처리하지 않으면 컴파일 오류 발생!
// 
package bitcamp.java100.ch13.ex2;

public class Test2 {

    public static void main(String[] args) {
        
        // 1) try...catch...로 예외를 처리하지 않아도 되는 경우,
        // 물론 선택사항이긴 하지만, JVM으로 전달하기 싫으면
        // try...catch...를 사용해도 된다.
        try {
            System.out.printf("%d / %d = %d\n", 20, 0, 20 / 0);
            
        } catch (RuntimeException e) {
            System.out.println("나누기 실행 중 오류 발생!");
        }
    }

}







