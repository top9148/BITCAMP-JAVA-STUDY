// 캡슐화 활용 - 더미 셋터/겟터
// 
package bitcamp.java100.ch08.ex1;

class Score5 {
    // 캡슐화를 통해 외부 접근을 막지 않아도 되는 필드에 대해서도
    // "객체 사용의 일관성을 위해 셋터와 겟터를 만드는 것"이 좋다.
    // 다음 name 필드가 대표적인 예이다.
    private String name;
    
    private int kor;
    private int eng;
    private int math;
    private int sum;
    private float aver;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    private void compute() {
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

public class Test8_5 {
    public static void main(String[] args) {
        Score5 s = new Score5();
        s.setName("홍길동");
        s.setKor(100);
        s.setEng(90);
        s.setMath(80);
        
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
        
        s.setEng(50);
        System.out.printf("%s, %d, %d, %d, %d, %f\n", 
                s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
    }
}











