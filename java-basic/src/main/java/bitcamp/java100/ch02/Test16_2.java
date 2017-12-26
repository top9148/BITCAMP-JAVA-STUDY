// ## 문장(Statement) - 분기문 if
// - 분기문의 용도와 if 문 사용법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test16_2 {

    public static void main(String[] args) {
        // 조건문은 조건에 따라 실행을 분기시킬 때 사용하는 문법이다.
        // 
        // > if (조건) 명령문1; else 명령문2;
        // 조건이 참이면 명령문1을 실행하고 거짓이면 명령문2를 실행한다.
        // 
        // 예) 나이 조건에 따라 성인과 미성년 구분하기
        //
        int age = 27;
        
        if (age <= 19) System.out.println("미성년"); else System.out.println("성년");
        
        // > 줄바꿈과 들여쓰기 
        // 소스 코드의 가독성을 높이기 위해 적절하게 줄바꿈과 들여쓰기를 하는 것이 좋다.
        age = 17;
        if (age <= 19) 
            System.out.println("미성년"); 
        else 
            System.out.println("성년");
        
        // > else 문은 선택사항이다.
        age = 57;
        if (age >= 65) 
            System.out.println("경로우대 대상자입니다.");
        
        System.out.println("------------------------------");
        
        // > else 문만 단독으로 사용할 수는 없다.
        age = 57;
        /* 컴파일 오류!
        else 
            System.out.println("경로우대 대상자가 아닙니다.");
        */
        
        System.out.println("------------------------------");
        
        // > if 문에 여러 개의 문장을 넣기 
        age = 27;
        if (age <= 19)
            System.out.println("미성년입니다.");
            System.out.println("청소년 할인을 받을 수 있습니다.");
            
        // 블록으로 묶지 않으면 위의 경우처럼 if 문 다음의 한 문장만 if에 소속된다.
        
        System.out.println("------------------------------");
            
        // > if 문 안에 여러 문장을 넣으려면 블록으로 묶어야 한다.
        if (age <= 19) {
            System.out.println("미성년입니다.");
            System.out.println("청소년 할인을 받을 수 있습니다.");
        }
        
        System.out.println("------------------------------");
        
        // > 복잡한 분기 표현 - if 문 안에 if 문 넣기
        age = 13;
        
        if (age <= 19) // 미성년을 청소년과 어린이로 나누기
            if (age > 13)
                System.out.println("청소년");
        // => if 문은 한 문장이기 때문에 중괄호를 치지 않아도 된다.
        
        System.out.println("------------------------------");
        
        // > 복잡한 분기 표현 - if 문 안에 if ~ else 문
        age = 27;
        if (age <= 19)
            if (age > 13)
                System.out.println("청소년");
        else
            System.out.println("성년");
        // => 항상 else는 가까운 if에 묶인다.
        
        System.out.println("------------------------------");

        // > 만약 위의 코드에서 else를 if (age <= 19)에 묶고 싶다면, 블록을 사용하라!
        age = 27;
        if (age <= 19) {
            if (age > 13)
                System.out.println("청소년");
        } // 이렇게 블록을 사용하여 if (age > 13) 문을 아래의 else와 분리해야 한다.
        else
            System.out.println("성년");
        
        System.out.println("------------------------------");
        
        // > if ~ else 는 한 문장이기 때문에 블록으로 묶지 않아도 된다.
        age = 13;
        if (age <= 19)
            if (age > 13)
                System.out.println("청소년");
            else
                System.out.println("어린이 또는 유아");
        // => else 문은 if문 없이 사용할 수 없기 때문에 if ~ else는 한 문장으로 취급한다.
        //    따라서 블록을 사용해 묶지 않아도 된다.
        
        System.out.println("------------------------------");
        
        // > else 문의 소속
        age = 23;
        if (age <= 19)
            if (age > 13)
                System.out.println("청소년");
            else
                System.out.println("어린이 또는 유아");
            else // 이렇게 들어쓰기를 해도 이 else문은 첫 번째 if 문과 연결된다.
                System.out.println("성년입니다.");
        
        System.out.println("------------------------------");
        
        // > else 안에 if 두기
        age = 72;
        if (age <= 19)
            if (age > 13)
                System.out.println("청소년");
            else
                System.out.println("어린이 또는 유아");
        else 
            if (age < 65)
                System.out.println("성년입니다.");
            else 
                System.out.println("노인입니다.");
        
        System.out.println("------------------------------");
        
        // > 코드의 가독성을 높이기 위해 블록 활용
        // 위의 코드는 옳다. 그러나 들여쓰기를 실수하게 되면 코드를 오독할 가능성이 높다.
        // 그래서 대부분의 전문가들은 한 개의 문장을 실행하더라도 블록을 사용하라고 권장한다.
        age = 72;
        if (age <= 19) {
            if (age > 13)
                System.out.println("청소년");
            else
                System.out.println("어린이 또는 유아");
        } 
        else {
            if (age < 65)
                System.out.println("성년입니다.");
            else 
                System.out.println("노인입니다.");
        }
        
        System.out.println("------------------------------");
        
        // > else 문 안에 if ~ else 넣기
        age = 72;
        
        if (age < 8) 
            System.out.println("유아");
        else
            if (age < 14)
                System.out.println("어린이");
            else 
                if (age < 20)
                    System.out.println("청소년");
                else
                    if (age < 65)
                        System.out.println("성년");
                    else
                        System.out.println("노인");
        
        System.out.println("------------------------------");
        
        // > else 안에 if ~ else가 있을 경우, 가독성을 높이기 위해 다음과 같이 정렬한다.
        age = 72;
        
        if (age < 8) 
            System.out.println("유아");
        else if (age < 14)
            System.out.println("어린이");
        else if (age < 20)
            System.out.println("청소년");
        else if (age < 65)
            System.out.println("성년");
        else
            System.out.println("노인");
        
        // 위 코드를 보고 오해하지 말아야 한다. 뭘? if ~ else if ~ else 라는 문법은 없다.
        // 오직 if ~ else 문법만 있다. 
        
        // > 가독성을 좋게 하기 위해서는 가능한 블록을 사용하라!
        age = 72;
        
        if (age < 8) { 
            System.out.println("유아");
        } else if (age < 14) {
            System.out.println("어린이");
        } else if (age < 20) {
            System.out.println("청소년");
        } else if (age < 65) {
            System.out.println("성년");
        } else {
            System.out.println("노인");
        }
        
    }
}













