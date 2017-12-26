// 캡슐화 활용 - 접근 제한하기
// 
package bitcamp.java100.ch08.ex1;

class Score2 {
    String name;
    int kor;
    int eng;
    int math;
    
    // sum과 aver는 kor, eng, math를 계산한 결과를 저장하는 변수이다.
    // 외부에 공개해서는 안된다.
    private int sum;
    private float aver;
    
    // 대신 sum과 aver의 값을 설정한 메서드를 만든다.
    // 이 메서드를 공개해야 한다.
    public void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
    
    // 또한 sum과 aver의 값을 꺼낼 수 있도록 공개 메서드를 추가한다.
    // => 특히 sum과 aver는 셋터는 없고 겟터만 있다.
    // => 이런 경우 "read only property"라고 부른다.
    public int getSum() {
        return this.sum;
    }
    
    public float getAver() {
        return this.aver;
    }
}

public class Test8_2 {
    public static void main(String[] args) {
        Score2 s = new Score2();
        s.name = "홍길동";
        s.kor = 100;
        s.eng = 90;
        s.math = 80;
        
        // sum과 aver는 private 으로 접근이 제한되었기 때문에 
        // 직접 값을 넣을 수 없다.
//        s.sum = 280;
//        s.aver = s.sum / 3f;
        
        // 대신 sum과 aver의 값을 계산해주는 공개 메서드를 사용하라!
        s.compute();
        
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                s.name, s.kor, s.eng, s.math, s.getSum(), s.getAver());
        
        // 만약 국,영,수의 점수를 바꾼다면?
        s.eng = 50;
        
        // 다시 계산해야 한다.
        s.compute();
        
        // 값을 바꿀 때 자동으로 계산하게 하는 방법은 없을까?
        // => 현재의 코드 상황으로는 없다!
        // => 혹시나 이런 경우를 대비해서 우리는 셋터를 만드는 것이다.
    }
}











