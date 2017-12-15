package bitcamp.java100.ch06.ex1;

// 기본 생성자(default constructor)
// => 클래스를 정의할 때 생성자를 만들지 않으면, 
//    컴파일러가 파라미터가 없는 public 생성자를 자동으로 만든다. 
public class Score6 {
    // 필드 선언
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    // 파라미터 없는 생성자 = default constructor
    // => 생성자가 한 개도 없으면 컴파일러가 다음과 같이 기본 생성자를 추가한다.
    // => 그래서 자바의 모든 클래스는 무조건 생성자가 존재한다.
    //public Score6() {}
    
    /*
    Score6() {
        System.out.println("기본 생성자 호출됨!"); 
    }
    */
    
    // 메서드 정의(= 연산자 정의)
    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
}









