// 다형성 - 오버라이딩 사용 후 
// => Score2 클래스는 수퍼 클래스 Object로부터 상속 받은 toString() 메서드를 재정의하였다.
// => 이렇게 상속 받은 메서드를 서버 클래스의 역할에 맞춰 재정의 하는 것을 
//    "오버라이딩"이라 부른다.
//    
package bitcamp.java100.ch08.ex3;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        ArrayList list = new ArrayList();
        
        while (true) {
            Score2 s = new Score2();
            
            s.setNo(Prompts.inputInt("번호? "));
            s.setName(Prompts.inputString("이름? "));
            s.setKor(Prompts.inputInt("국어? "));
            s.setEng(Prompts.inputInt("영어? "));
            s.setMath(Prompts.inputInt("수학? "));
            
            list.add(s);
            
            // Score2는 Object의 toString()을 재정의 하였기 때문에 
            // 다음 코드에서 호출되는 것은 재정의된 toString()이다.
            System.out.println(s.toString());
            
            if (!Prompts.confirm("계속하시겠습니까? "))
                break;
            
        }
    }
}




