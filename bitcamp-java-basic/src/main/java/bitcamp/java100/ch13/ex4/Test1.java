// 예외 상황이 발생했을 때 문제점
package bitcamp.java100.ch13.ex4;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {

    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
    }
    
    static ArrayList<Score> list = new ArrayList<>();
    static Scanner keyScan = new Scanner(System.in);
    
    static void input() {
        Score score = new Score();
        
        System.out.print("이름? ");
        score.name = keyScan.nextLine();
        
        System.out.print("국어? ");
        score.kor = Integer.parseInt(keyScan.nextLine());
        
        System.out.print("영어? ");
        score.eng = Integer.parseInt(keyScan.nextLine());
        
        System.out.print("수학? ");
        score.math = Integer.parseInt(keyScan.nextLine());
        
        score.sum = score.kor + score.eng + score.math;
        score.aver = score.sum / 3f;
        
        list.add(score);
    }
    
    static void print() {
        for (Score s : list) {
            System.out.printf("%s,%d,%d,%d,%d,%f\n", 
                    s.name, s.kor, s.eng, s.math, s.sum, s.aver);
        }
    }
    
    public static void main(String[] args) {
        
        while (true) {
            // input()을 실행하다가 점수를 잘못입력하여
            // 숫자로 바꾸지 못할 경우, input() 메서드에서는
            // RuntimeException 계열의 예외를 발생시킨다.
            // 그 예외를 input()을 호출하는 main()에서 받는 것이다.
            // main()에서 처리하지 않으면,
            // 다시 main()을 호출한 JVM으로 전달된다.
            // 결국 JVM은 프로그램 실행을 멈추고 오류 내용을 간단히 출력한다.
            // 
            // 왜 이런 문제가 발생했을까?
            // => input()을 호출하는 개발자 쪽에서는 
            //    설마 input()이 실행중에 예외를 발생시킬 줄은 몰랐다.
            // => 그래서 input()을 호출할 때 try...catch...로 
            //    예외를 처리하지 않았다.
            // => 만약 input() 메서드를 만드는 개발자가 
            //    잘못된 입력이 들어올 경우 Exception 계열의 예외를
            //    던졌더라면,
            //    input()을 호출하는 개발자가 input() 메서드에서 
            //    예외가 발생된다는 것을 빠르게 눈치챘을 것이다.
            // => 왜? Exception 계열의 예외는 try...catch...로 
            //    처리하지 않으면 컴파일 오류가 발생하기 때문에
            //    모를 수가 없다.
            //
            input();
            
            System.out.print("계속 하시겠습니까? (Y/n)");
            String str = keyScan.nextLine().toLowerCase();
            if (str.equals("") || str.equals("y") || str.equals("yes")) {
                continue;
            }
            break;
        }
        
        System.out.println("--------------------------");
        
        print();

    }

}
