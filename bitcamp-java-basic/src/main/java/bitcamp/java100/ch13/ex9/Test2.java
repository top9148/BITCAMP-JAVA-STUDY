// 예외처리 문법정리: 메시지를 이용하여 예외를 구분하기
package bitcamp.java100.ch13.ex9;

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
    
    // 성적 정보를 입력 받을 때 유효하지 않은 값을 입력하면 
    // 예외를 사용하여 호출자에게 전달해보자!
    static void input() throws Exception {
        Score score = new Score();
        
        System.out.print("이름? ");
        score.name = keyScan.nextLine();
        
        if (score.name.length() == 0) {
            throw new Exception("EmptyString");
        }
        
        System.out.print("국어? ");
        try {
            score.kor = Integer.parseInt(keyScan.nextLine());
            if (score.kor < 0 || score.kor > 100)
                throw new Exception("ScoreOutOfBounds");
            
        } catch (NumberFormatException e) {
            throw new Exception("NumberFormatError");
        }
        
        System.out.print("영어? ");
        try {
            score.eng = Integer.parseInt(keyScan.nextLine());
            if (score.eng < 0 || score.eng > 100)
                throw new Exception("ScoreOutOfBounds");
            
        } catch (NumberFormatException e) {
            throw new Exception("NumberFormatError");
        }
        
        System.out.print("수학? ");
        try {
            score.math = Integer.parseInt(keyScan.nextLine());
            if (score.math < 0 || score.math > 100)
                throw new Exception("ScoreOutOfBounds");
            
        } catch (NumberFormatException e) {
            throw new Exception("NumberFormatError");
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
            // input()에서 예외가 발생하면 Exception 객체를 던지는데 
            // 이때 Exception 객체 안에는 예외의 상황을 알리는 
            // 간단한 문자열이 보관되어 있다.
            // 이것을 이용하여 예외를 분류해보자!
            try {
                input();
            } catch (Exception e) {
                // 이렇게 Exception 객체에 보관된 메시지를 꺼내 
                String message = e.getMessage();
                
                // 어떤 상황에서 발생된 예외인지 구분하여 처리할 수 있다.
                if (message.equals("EmptyString")) {
                    System.out.println("입력 문자열이 비어 있습니다.");
                } else if (message.equals("ScoreOutOfBounds")) {
                    System.out.println("점수의 범위를 벗어났습니다.");
                } else if (message.equals("NumberFormatError")) {
                    System.out.println("숫자 형식이 아닙니다.");
                }
                
                // 하지만, 문자열을 이용하여 예외를 구분하는 것은
                // 매우 번거롭고 불안한 방법이다.
                // 문자열을 비교하다가 알파벳 대소문자를 잘못 기입해
                // 분류를 제대로 못하는 상황도 발생할 것이기 때문이다.
                // 해결책?
                // => Test3 을 참고하라!
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
