package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

public class Score1 {
    
    static String name;
    static int kor;
    static int eng;
    static int math;
    static int sum;
    static float aver;
    
    static void inputScore() {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("이름? ");
        name = keyScan.nextLine();
        
        System.out.print("국어점수? ");
        kor = keyScan.nextInt();
        
        System.out.print("영어점수? ");
        eng = keyScan.nextInt();
        
        System.out.print("수학점수? ");
        math = keyScan.nextInt();
        
        //keyScan.close(); // Scanner는 사용 후 닫아야 한다.
                         // 즉 Scanner가 사용한 공용 자원(키보드)을 해제해야 한다.
                         // 만약 계속 사용할 것이라면 닫으면 안된다.
    }
    
    static void computeScore() {
        sum = kor + eng + math;
        aver = sum / 3f;
    }
    
    static void printScore() {
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                name, kor, eng, math, sum, aver);
    }
}
