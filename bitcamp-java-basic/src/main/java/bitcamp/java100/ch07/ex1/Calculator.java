package bitcamp.java100.ch07.ex1;

public class Calculator {
    int result;
    
    void multiple(int value) {
        this.result *= value;
    }
    
    // Test4.java에서 0으로 나눌 때 실행 오류가 발생하였다.
    // 그래서 기존 코드를 변경하였다.
// 변경 전 코드
//    void divide(int value) {
//        this.result /= value;
//    }
    
    void divide(int value) {
        if (value == 0) {
            System.err.println("0으로 나누면 안됩니다!");
            return;
        }
        this.result /= value;
    }
}
