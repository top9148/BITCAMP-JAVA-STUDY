package bitcamp.java100.ch06.ex1;

// 인스턴스 초기화 블록
public class Score9 {
    // 필드 선언
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    // 인스턴스 초기화 블록 정의
    // => 생성자가 호출되기 전에 먼저 실행된다.
    // => 생성자를 만들 수 없는 익명 클래스를 정의할 때 사용할 수 있다.
    {
        System.out.println("인스턴스 초기화 블록 실행111!");
    }
    
    Score9() {
        System.out.println("Score9() 호출됨!");
    }
    
    Score9(String name) {
        System.out.println("Score9(String) 호출됨!");
    }
    
    // 인스턴스 블록의 위치는 상관없다. 
    { 
        System.out.println("인스턴스 초기화 블록 실행2222!");
    }
    
    // 메서드 정의(= 연산자 정의)
    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
        
    }
    
    // 모든 인스턴스 블록이 실행된 다음에 생성자가 호출된다.
    // => 가능한 인스턴스 블록을 한 개만 만들라!
    // => 지금처럼 여러 개 두는 것은 유지보수에 좋지 않다.
    // => 또한 위치도 위 또는 아래로 고정하라!
    // => 이 예제처럼 위, 중간, 아래에 여러 개를 배치하는 것은 최악이다!
    {
        System.out.println("인스턴스 초기화 블록 실행333!");
    }
    
    
    // 인스턴스 블록을 소개하는 이유?
    // => 사용법과 용도를 알려주는 목적 보다는 잘못 이해하는 것을 방지하기 위함이다.
    
    // => 클래스 블록 안에는 변수 선언을 제외한 코드를 넣을 수 없다.
    int i = 10; // <== 이것은 일반 변수가 아니다. 인스턴스 변수이다.
    int j; // <== 이것도 일반 변수가 아니다. 인스턴스 변수이다.
    { // <== 오해하지 말라! 일반 블럭이 아니라 인스턴스 초기화 블록이다.
      // 즉 new 명령으로 인스턴스를 만들 때 생성자가 호출되기 전에 실행되는
      // 아주 특별한 블록이다.
        j = 20;
        if (i < 10) 
            System.out.println("Hello");
    }
}









