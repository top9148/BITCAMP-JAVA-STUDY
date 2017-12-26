// 다형성 - 오버라이딩 사용 전
package bitcamp.java100.ch08.ex3;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        ArrayList list = new ArrayList();
        
        while (true) {
            Score s = new Score();
            
            s.setNo(Prompts.inputInt("번호? "));
            s.setName(Prompts.inputString("이름? "));
            s.setKor(Prompts.inputInt("국어? "));
            s.setEng(Prompts.inputInt("영어? "));
            s.setMath(Prompts.inputInt("수학? "));
            
            list.add(s);
            
            // Score에 toString()은 없다.
            // Score의 수퍼클래스인 Object의 toString()을 호출하는 것이다.
            // Object의 toString()은 "클래스명@해시값"을 리턴한다.
            System.out.println(s.toString());
            
            if (!Prompts.confirm("계속하시겠습니까? "))
                break;
            
        }
    }
}




