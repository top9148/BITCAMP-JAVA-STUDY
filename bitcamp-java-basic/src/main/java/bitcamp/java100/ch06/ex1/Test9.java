// 클래스 문법의 용도 - 사용자 정의 데이터 타입 만들기
// => 
package bitcamp.java100.ch06.ex1;

// 인스턴스 변수나 메서드를 사용할 때 this를 생략하기 
public class Test9 {
    public static void main(String[] args) {
        // 학생의 성적 정보를 저장할 변수를 준비하라!
        Score8 score;
        
        // 파라미터 값을 주지 않으면 기본 생성자를 찾아 호출한다.
        score = new Score8("홍길동");
        
        System.out.printf("이름=%s\n", score.name);
        System.out.printf("총점=%d\n", score.sum);
        System.out.printf("평균=%f\n", score.aver);
    }
}







