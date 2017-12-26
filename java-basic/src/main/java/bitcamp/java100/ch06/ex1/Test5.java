// 클래스 문법의 용도 - 사용자 정의 데이터 타입 만들기
// => 
package bitcamp.java100.ch06.ex1;

// 파라미터 값을 주는 생성자 호출하기 
public class Test5 {
    public static void main(String[] args) {
        // 학생의 성적 정보를 저장할 변수를 준비하라!
        Score4 score;
        
        // 인스턴스를 만들 때 생성자를 호출한다.
        
        //score = new Score4(); // 컴파일 오류!
        // Score4의 생성자는 파라미터 값을 받는 생성자이다.  
        // 파라미터 값을 넘기지 않고 호출할 수 없다.
                              
        
        //score = new Score4("홍길동"); // 컴파일 오류! 
        // 생성자를 호출할 때, 
        //반드시 생성자에 정의된 파라미터의 타입과 개수, 순서가 일치해야 한다.
        
        score = new Score4("임꺽정", 100, 80, 70); // OK!
        
        System.out.printf("이름=%s\n", score.name);
        System.out.printf("총점=%d\n", score.sum);
        System.out.printf("평균=%f\n", score.aver);
    }
}







