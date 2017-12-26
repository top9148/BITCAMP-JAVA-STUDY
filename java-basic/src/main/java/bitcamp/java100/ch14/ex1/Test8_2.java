// 재귀 호출
package bitcamp.java100.ch14.ex1;

public class Test8_2 {
    
    static void printStar(int n) {
        if (n == 0)
            return;
        
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
        
        printStar(n - 1);
    }
    
    public static void main(String[] args) throws Exception {
        printStar(5);
    }
    
}






