// 명시적으로 Exception 예외를 던지면 좋은 점! 
package bitcamp.java100.ch13.ex4;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {

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
    
    static void input() throws Exception {
        Score score = new Score();
        
        System.out.print("이름? ");
        score.name = keyScan.nextLine();
        try {
            System.out.print("국어? ");
            score.kor = Integer.parseInt(keyScan.nextLine());
            
            System.out.print("영어? ");
            score.eng = Integer.parseInt(keyScan.nextLine());
            
            System.out.print("수학? ");
            score.math = Integer.parseInt(keyScan.nextLine());
            
        } catch (RuntimeException e) {
            // 입력이 잘못되어 RuntimeException 예외가 발생하면 
            // 명시적으로 Exception 예외를 호출자에게 던져라!
            // 단 메서드 선언부에 어떤 예외를 던지는지 
            // 지정해야 한다.
            throw new Exception("입력이 잘못되었습니다.");
        }
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
            // input() 메서드에서 예외를 던질 수 있다고 명시했기 때문에
            // input()을 호출하는 쪽에서는 반드시 try...catch...로 
            // 처리해야 한다.
            try {
                input();
            } catch (Exception e) {
                // 예외 처리의 목적
                // => 실행 중 예외가 발생하더라도 적절히 조치를 취한 후 
                //    계속 프로그램을 실행시킨다.
                // 이것이 예외처리 문법을 사용하는 이유이다!
                System.out.println("입력 중 오류가 발생했습니다.");
            }
            
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
