package bitcamp.java100.ch14.ex4;

import java.io.Serializable;

// Score3의 인스턴스 값을 test2.dat 파일로 출력한 후 
// Score3에 음악 점수를 저장할 변수를 추가한다.
// 물론 compute()도 그에따라 변경한다.
// 그리고 다시 test2.dat 파일로 출력한다.
// 
public class Score3 implements Serializable {
    // serialVersionUID 변수의 용도
    // => java.io.Serializable 인터페이스를 구현한 클래스는 
    //    자동으로 생성되는 변수이다.
    // => 만약 개발자가 serialVersionUID를 지정하지 않는다면 
    //    컴파일할 때 컴파일러가 임의의 값으로 설정한다.
    // => serialize 데이터의 버전을 구분하기 위해 사용한다.
    // => 데이터를 읽는 쪽에서는 데이터에 기록된 클래스의 버전과 
    //    자신이 갖고 있는 클래스의 버전을 비교하여  
    //    다르다면 예외를 발생시킴으로써 
    //    데이터를 잘못 읽는 것을 방지한다.
    // 
    // => 클래스를 바꾼 후 serialize 한 데이터를 
    //    바꾸기 전 클래스로 읽을 수 있게 하려면,
    //    serialVersionUID 변수의 값을 일치시키면 된다.
    // 
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int music;// 이 필드를 추가한다.
    private int sum;
    private float aver;
    
    public Score3() {}
    
    public Score3(String name, int kor, int eng, 
            int math, /*파라미터 추가*/int music) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.music = music; // 여기 추가 
        this.compute();
    }
    
    private void compute() { // 변경 
        this.sum = this.kor + this.eng + this.math + this.music;
        this.aver = this.sum / 4f;
    }

    // toString() 코드 재생성
    @Override
    public String toString() {
        return "Score3 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", music=" + music
                + ", sum=" + sum + ", aver=" + aver + "]";
    }
    
    // music 겟터/셋터 추가 
    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
        this.compute();
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








