// 클래스 멤버와 인스턴스 멤버의 활용 2
package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

// 1단계: 로컬 변수 사용
public class Test1 {

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        
        // 사용자가 입력한 데이터를 저장할 변수 준비
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        
        System.out.print("이름? ");
        name = keyScan.nextLine();
        
        System.out.print("국어점수? ");
        kor = keyScan.nextInt();
        
        System.out.print("영어점수? ");
        eng = keyScan.nextInt();
        
        System.out.print("수학점수? ");
        math = keyScan.nextInt();
        
        sum = kor + eng + math;
        aver = sum / 3f;
        
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                name, kor, eng, math, sum, aver);

    }

}






