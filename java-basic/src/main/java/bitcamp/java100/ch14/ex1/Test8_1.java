// 재귀 호출
package bitcamp.java100.ch14.ex1;

public class Test8_1 {
    
    static void printStar(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws Exception {
        printStar(5);
        printStar(4);
        printStar(3);
        printStar(2);
        printStar(1);
    }
    
}






