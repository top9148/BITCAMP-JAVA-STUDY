// 클래스 멤버와 인스턴스 멤버의 활용 2
package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

// 2단계: 메서드 분리 및 static 변수 사용
public class Test2 {

    // 사용자가 입력한 데이터를 저장할 변수 준비
    // 여러 메서드가 공유하는 변수는 static으로 선언한다.
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
        
        keyScan.close(); // Scanner는 사용 후 닫아야 한다.
                         // 즉 Scanner가 사용한 공용 자원(키보드)을 해제해야 한다.
    }
    
    static void computeScore() {
        sum = kor + eng + math;
        aver = sum / 3f;
    }
    
    static void printScore() {
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                name, kor, eng, math, sum, aver);
    }
    
    public static void main(String[] args) {
        
        inputScore();
        computeScore();
        printScore();

    }

}






