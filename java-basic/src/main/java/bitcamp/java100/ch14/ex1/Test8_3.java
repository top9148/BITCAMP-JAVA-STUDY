// 재귀 호출 : 수학 함수를 표현하는 것이 쉽다.
package bitcamp.java100.ch14.ex1;

public class Test8_3 {
    
    static int f(int n) {
        if (n == 0)
            return 0;
        return n + f(n - 1);
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(f(10));
        
        // 재귀호출의 단점
        // => 종료 조건이 될 때까지 계속 호출 스택을 내려가기 때문에
        //    스택 메모리의 크기를 초과하는 
        //    스택오버 플로우 예외가 발생하기 쉽다.
        
    }
    
}






