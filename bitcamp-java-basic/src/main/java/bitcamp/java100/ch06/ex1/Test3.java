// 클래스 문법의 용도 - 사용자 정의 데이터 타입 만들기
// => 
package bitcamp.java100.ch06.ex1;

// 메서드 문법을 이용하여 클래스에 연산자 추가 
public class Test3 {
    public static void main(String[] args) {
        // 학생의 성적 정보를 저장할 변수를 준비하라!
        Score2 score;
        score = new Score2();
        
        // 학생의 성적 정보를 저장하라!
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 100;
        score.math = 100;

        // 학생의 성적 데이터를 계산할 때 새 데이터를 위해 만든 연산자를 사용하라!
        score.compute();
    }
}







