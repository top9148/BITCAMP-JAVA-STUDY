// 예외처리 문법정리: 커스텀 예외 클래스를 이용하여 예외를 구분하기
package bitcamp.java100.ch13.ex9;

import java.util.ArrayList;
import java.util.Scanner;

// 예외를 구분할 때 문자열을 사용하는 것 보다 
// 클래스를 사용하는 것이 더 정확하다.
// 왜? 컴파일러가 클래스 타입을 정확하게 검사하기 때문이다.

public class Test3 {

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
    // => Test2와 달리 메시지가 아니라 예외 클래스를 구분하여 
    //    예외 상황을 전달한다.
    static void input() throws Exception {
        Score score = new Score();
        
        System.out.print("이름? ");
        score.name = keyScan.nextLine();
        
        if (score.name.length() == 0) {
            // 예전에는 기존에 있던 Exception을 사용하여 예외를 던졌지만,
            // 지금은 좀 더 정밀하게 정의한 예외 객체를 던진다.
            throw new EmptyStringException("이름이 빈 문자열입니다.");
        }
        
        System.out.print("국어? ");
        score.kor = Integer.parseInt(keyScan.nextLine());
        if (score.kor < 0 || score.kor > 100)
            throw new ScoreOutOfBoundsException();
            
        
        System.out.print("영어? ");
        score.eng = Integer.parseInt(keyScan.nextLine());
        if (score.eng < 0 || score.eng > 100)
            throw new ScoreOutOfBoundsException();
            
        
        System.out.print("수학? ");
        score.math = Integer.parseInt(keyScan.nextLine());
        if (score.math < 0 || score.math > 100)
            throw new ScoreOutOfBoundsException();
        
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
            // input()에서 예외 클래스를 이용하여 
            // 예외 상황을 전달하기 때문에 
            // input()을 호출하는 쪽에서는 
            // catch 블록으로 예외를 쉽게 구분할 수 있다.
            try {
                input();
                // 다음과 같이 예외가 발생할 때 
                // 클래스 타입으로 구분하기 때문에
                // 코드를 해석하기 쉽다. 
                // 즉 유지보수가 쉽다.
            } catch (EmptyStringException e) {
                System.out.println("입력 문자열이 비어 있습니다.");
                
            } catch (ScoreOutOfBoundsException e) {
                System.out.println("점수의 범위를 벗어났습니다.");
                
            } catch (NumberFormatException e) {
                System.out.println("숫자 형식이 아닙니다.");
                
            } catch (Exception e) {
                // 기타 예외는 어떤 상황인지 유추하기 힘들다.
                // 이런 경우 어디에서 예외가 발생했는지 
                // 상세하게 조사할 필요가 있다.
                // 이때 사용하는게 호출 단계를 출력해 보는 것이다.
                e.printStackTrace();
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
