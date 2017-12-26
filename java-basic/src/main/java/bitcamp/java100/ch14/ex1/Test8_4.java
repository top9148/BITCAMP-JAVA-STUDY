// 재귀 호출 : 스택 오버 플로우 경험하기
package bitcamp.java100.ch14.ex1;

import java.util.Scanner;

public class Test8_4 {
    static Scanner keyScan = new Scanner(System.in);
    
    static int f(int n) {
        // 메서드를 호출할 때 마다 스택 메모리를 많이 사용하도록
        // 유도하기 위해서 일부로 메모리를 많이 사용하는 
        // 임의의 로컬 변수를 선언한다.
        // 목적? 스택 오버 플로우를 경험하자!
        long v0,v1,v2,v3,v4,v5,v6,v7;
        
        if (n == 0) {
            return 0;
        }
        return n + f(n - 1);
    }
    
    public static void main(String[] args) throws Exception {
        int sum = f(100000);
        System.out.println(sum);
    }
    
}






