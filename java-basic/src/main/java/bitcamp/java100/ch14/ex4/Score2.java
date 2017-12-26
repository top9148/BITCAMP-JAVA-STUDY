package bitcamp.java100.ch14.ex4;

import java.io.Serializable;

// 스트림 클래스가 인스턴스 변수의 값을 serialize 할 수 있도록 허락한다.
// => java.io.Serializable 인터페이스를 구현하면 된다.
// => Serializable 인터페이스에는 아무런 메서드가 없다.
//    이 인터페이스의 목적은 단지 어떤 클래스에 대해 
//    직렬화를 허용할 것인지 여부를 지정하기 위해 
//    표시하는 용도로 사용한다.
// 
public class Score2 implements Serializable {
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int sum;
    private float aver;
    
    public Score2() {}
    
    public Score2(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.compute();
    }
    
    private void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }

    @Override
    public String toString() {
        return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", aver="
                + aver + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
        this.compute();
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
        this.compute();
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
        this.compute();
    }

    public int getSum() {
        return sum;
    }

    public float getAver() {
        return aver;
    }
    
    
}








