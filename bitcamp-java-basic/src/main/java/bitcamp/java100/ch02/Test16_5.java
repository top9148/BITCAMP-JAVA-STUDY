// ## 문장(Statement) - 반복문 do ~ while
// - do ~ while 문 사용법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test16_5 {

    public static void main(String[] args) {
        // => do ~ while 문법
        // - do 명령문 while (expression);
        // - expression의 실행 결과가 true이면 계속 명령문을 반복해서 실행한다.
        int i = 0;
        do 
            System.out.println(i++);
        while (i < 5);
        
        System.out.println("----------------------------");
        
        // => 여러 개의 문장을 반복하기 
        // - 블록을 사용하여 실행할 문장을 묶는다.
        i = 0;
        do {
            System.out.print("=> ");
            System.out.println(i);
            i++;
        } while (i < 5);
        
        System.out.println("----------------------------");
        
       
    }
}

// while vs do ~ while
// - while 문은 0 번 이상 반복할 때 사용한다.
// - do ~ while 문은 1 번 이상 반복할 때 사용한다.













