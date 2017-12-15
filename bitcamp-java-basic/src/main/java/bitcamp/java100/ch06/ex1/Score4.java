package bitcamp.java100.ch06.ex1;

// 파라미터가 있는 "생성자(constructor)" 
public class Score4 {
    // 필드 선언
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    // 생성자가 호출될 때 파라미터 값을 받을 수 있다.
    // => 값을 받을 파라미터를 선언해야 한다.
    Score4(String name, int kor, int eng, int math) {
        System.out.println("Score4() 호출됨!");
        
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









