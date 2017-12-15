// 클래스 문법의 용도 - 사용자 정의 데이터 타입 만들기
// => 
package bitcamp.java100.ch06.ex1;

// 인스턴스를 만들 때 생성자 호출하기 
public class Test4 {
    public static void main(String[] args) {
        // 학생의 성적 정보를 저장할 변수를 준비하라!
        Score3 score;
        
        // 인스턴스를 만들 때 생성자를 호출한다.
        score = new Score3();
        
        // 출력 결과를 보라!
        // => 생성자 호출을 증명하는 "Score3() 호출됨!" 문장이 출력될 것이다.
        // => 그리고 다음 명령은 생성자에서 초기화시킨 값을 출력할 것이다. 
        System.out.printf("이름=%s\n", score.name);
        System.out.printf("총점=%d\n", score.sum);
        System.out.printf("평균=%f\n", score.aver);
        
        // 인스턴스를 만들 때 생성자를 호출하지 않는다면?
        //score = new Score3; // 컴파일 오류!
        
        // 생성자를 호출할 때 반드시 그 생성자가 원하는 파라미터 값을 넘겨야 한다.
        //score = new Score3("홍길동"); // Score3에는 문자열을 받는 생성자가 없다. 
                                      // 컴파일 오류!
        
        // 생성자는 따로 호출할 수 없다.
        //score.Score3(); // 컴파일 오류!
    }
}







