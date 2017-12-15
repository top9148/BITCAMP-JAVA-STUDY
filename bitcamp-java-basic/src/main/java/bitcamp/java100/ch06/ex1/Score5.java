package bitcamp.java100.ch06.ex1;

// 한 클래스에 여러 개의 "생성자(constructor)"를 정의할 수 있다.
// => 객체지향의 "다형성(polymorphism)" 규칙에는
//    파라미터의 타입과 개수, 순서만 다르다면
//    같은 이름의 메서드를 여러 개 생성할 수 있다.
//    이 규칙을 "오버로딩(overloading)"이라 부른다.
//
public class Score5 {
    // 필드 선언
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    // 파라미터 없는 생성자
    Score5() {
        System.out.println("Score5() 호출됨!");
        
        this.name = "홍길동";
        this.kor = 50;
        this.eng = 50;
        this.math = 50;
        
        this.compute();
    }
    
    // 파라미터 있는 생성자
    Score5(String name) {
        System.out.println("Score5(String) 호출됨!");
        this.name = name;
    }
    
    // 파라미터 있는 생성자
    Score5(String name, int kor, int eng, int math) {
        System.out.println("Score5(String,int,int,int) 호출됨!");
        
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        
        this.compute();
    }
    
    // 메서드 정의(= 연산자 정의)
    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
}









