package bitcamp.java100.ch07.ex2;

public class Calculator {
    int result;
     
    void multiple(int value) {
        this.result *= value;
    }
    
//    void divide(int value) {
//        this.result /= value;
//    }
    
    // 여기에서 코드를 변경하면, 그 서브 클래스에 변경된 내용이 그대로 반영된다.
    // 왜? 서브 클래스에서 divide()를 사용할 때 마다 이 클래스를 방문할 것이기 때문이다.
    // 
    void divide(int value) {
        if (value == 0) {
            System.err.println("0으로 나눌 수 없습니다.");
            return;
        }
        this.result /= value;
    }
    
}
