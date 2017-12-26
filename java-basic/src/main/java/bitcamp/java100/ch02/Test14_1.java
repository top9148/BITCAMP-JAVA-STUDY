// ## 사용자 정의 데이터 타입 만들기
// - 여러 종류의 메모리를 묶어 새로운 타입을 만드는 방법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test14_1 {

    public static void main(String[] args) {
// 1) 사용자 데이터 타입 정의하기
// - 학생의 성적 데이터를 저장할 수 있는 새로운 메모리 구조를 정의한다.

        // 새 데이터 타입을 선언한다. 
        class Score {
                //2) 메모리 구조를 정의한다.
                String name;
                int kor;
                int eng;
                int math;
                int sum;
                float aver;
        }

// 2) 새 데이터 타입에 따라 만든 메모리의 주소를 저장할 변수 선언
//    => 메모리설계도명_즉_클래스명 레퍼런스명;
        Score r1; // Score 설계도에 따라 준비한 메모리의 주소를 저장.
        
// 3) 사용자가 새로 정의한 데이터 타입에 따라 메모리를 준비하기
//    => new 메모리설계도명_즉_클래스명();
        r1 = new Score(); // 설계도에 따라 만든 메모리를 "인스턴스"라 한다.

// 4) 레퍼런스를 사용하여 새 메모리에 값 넣기
//    => 레퍼런스명.내부메모리명 = 값;
        r1.name = "홍길동";
        r1.kor = 100;
        r1.eng = 98;
        r1.math = 95;
        r1.sum = r1.kor + r1.eng + r1.math;
        r1.aver = r1.sum / 3.0f;
        
        System.out.printf("%s %d %d %d %d %f\n", 
                r1.name, r1.kor, r1.eng, r1.math, r1.sum, r1.aver);
    }
}

// ### 사용자 정의 데이터 타입
// - 여러 종류의 메모리를 묶어서 만든 새로운 데이터 타입.
// - 이를 위해 자바에서는 "class"라는 문법을 제공하고 있다.
// - 문법
//   class 데이터타입명 {
//       메모리 구조
//   }
//
// - 메모리 구조 문법
//   변수 선언
//   예) String name;
//       int age;
//       boolean working;