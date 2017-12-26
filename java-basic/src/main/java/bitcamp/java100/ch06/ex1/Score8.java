package bitcamp.java100.ch06.ex1;

// this의 생략
public class Score8 {
    // 필드 선언
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
    Score8(String name) {
        // 변수 앞에 this가 없으면 로컬 변수인지 찾아본다.
        this.name = name;
        
        // 로컬 변수에 그런 이름을 가진 변수가 없다면 
        // 인스턴스 변수인지 찾아본다. 
        // => 인스턴스 변수라면 컴파일러는 그 변수 앞에 this를 자동으로 붙인다.
        // => 인스턴스 변수가 아니라면, 당연히 컴파일 오류이다!
        kor = 50;
        eng = 50;
        math = 50;
        
        compute();
    }
    
    // 메서드 정의(= 연산자 정의)
    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
        
    }
}









