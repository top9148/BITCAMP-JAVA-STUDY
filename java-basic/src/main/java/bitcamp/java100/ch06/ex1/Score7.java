package bitcamp.java100.ch06.ex1;

// 생성자에서 다른 생성자 호출하기
public class Score7 {
    // 필드 선언
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    // 기본 생성자를 호출하면 다음과 같이 인스턴스 메모리를 기본 값으로 채운다.
    Score7() {
        this("홍길동");
        /*
        this.name = "홍길동";
        this.kor = 50;
        this.eng = 50;
        this.math = 50;
        
        this.compute();
        */
    }
    
    Score7(String name) {
        // 다음과 같이 인스턴스 변수를 초기화시키는 코드가 다른 생성자와 중복되는 경우,
        // 다른 생성자를 호출하는 것으로 대체할 수 있는 편리한 방법이 있다.
        //     this(파라미터, ....);
        // 단 다음과 같이 다른 생성자를 호출하는 명령어 앞에 다른 명령어가 와서는 안된다.
        // 물론 주석은 상관없다.
        
        //System.out.println("Score7(String)"); // 컴파일 오류! 
        this(name, 50, 50, 50);
        
        /*
        this.name = name;
        this.kor = 50;
        this.eng = 50;
        this.math = 50;
        
        this.compute();
        */
    }
    
    Score7(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        
        this.compute();
    }
    
    // 메서드 정의(= 연산자 정의)
    void compute() {
        // 일반 인스턴스 메서드에서 생성자를 호출할 수 없다.
        // => 오직 new 명령으로 인스턴스를 생성할 때만 호출할 수 있다.
        //this(); // 컴파일 오류!

        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
        
    }
}









