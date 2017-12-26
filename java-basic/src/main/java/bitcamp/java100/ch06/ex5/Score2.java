package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

public class Score2 {
    
    // 여러 사람의 성적을 개별적으로 관리하고 싶다면
    // 성적 데이터를 저장할 변수를 인스턴스 변수로 만들라!
    // => static 제거
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
    // 인스턴스 변수를 사용하려면 인스턴스 메서드로 만들라!
    // => static 제거
    // => 인스턴스 변수를 사용하기 위해 메서드에 내장되어 있는 this를 활용하라!
    // => this는 메서드를 호출할 때 넘겨준 인스턴스 주소를 보관하는 변수이다.
    // 
    void input() {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("이름? ");
        this.name = keyScan.nextLine();
        
        System.out.print("국어점수? ");
        this.kor = keyScan.nextInt();
        
        System.out.print("영어점수? ");
        this.eng = keyScan.nextInt();
        
        System.out.print("수학점수? ");
        this.math = keyScan.nextInt();
        
        this.compute();
        
        //keyScan.close(); // Scanner는 사용 후 닫아야 한다.
                         // 즉 Scanner가 사용한 공용 자원(키보드)을 해제해야 한다.
                         // 만약 계속 사용할 것이라면 닫으면 안된다.
    }
    
    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
    
    void print() {
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                this.name, this.kor, this.eng, this.math, this.sum, this.aver);
    }
}
