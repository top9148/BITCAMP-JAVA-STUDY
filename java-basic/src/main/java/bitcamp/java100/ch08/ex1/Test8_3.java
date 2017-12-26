// 캡슐화 활용 - 셋터의 등장
// 
package bitcamp.java100.ch08.ex1;

class Score3 {
    String name;
    private int kor;
    private int eng;
    private int math;
    private int sum;
    private float aver;
    
    
    public void setKor(int kor) {
        this.kor = kor;
        this.compute();
    }

    public int getKor() {
        return kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
        this.compute();
    }

    public int getEng() {
        return eng;
    }
    
    public void setMath(int math) {
        this.math = math;
        this.compute();
    }

    public int getMath() {
        return math;
    }

    public void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
    
    public int getSum() {
        return this.sum;
    }
    
    public float getAver() {
        return this.aver;
    }
}

public class Test8_3 {
    public static void main(String[] args) {
        Score3 s = new Score3();
        s.name = "홍길동";
        
        // 변수에 값을 직접 넣지 않고 메서드를 통해 넣는다면,
        // 그 메서드 내부에서 계산 작업을 수행할 수 있다.
        // 이것이 셋터를 만드는 이유이다!
        s.setKor(100);
        s.setEng(90);
        s.setMath(80);
        
        // 셋터를 통해 국,영,수 점수를 저장할 때마다 자동으로 계산되기 때문에
        // compute()을 따로 호출할 필요가 없다.
        //s.compute();
        
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                s.name, s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
        
        // 언제든지 한 과목의 점수를 바꾸더라도 자동으로 합계와 평균이 다시 계산된다.
        s.setEng(50);
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                s.name, s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
    }
}











