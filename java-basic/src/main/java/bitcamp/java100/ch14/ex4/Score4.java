package bitcamp.java100.ch14.ex4;

import java.io.Serializable;

// 인스턴스 변수 중에는 serialize 대상이 되는 필드가 있고,
// 굳이 serialize 할 필요가 없는 필드가 있다.
// 예) 
// music 필드를 추가한 후 Score3의 값을 파일로 출력하였다.
// 데이터를 읽는 쪽에서는 Score3 클래스에 아직 music 필드가 
// 추가되지 않은 상태였다.
// 그러나 데이터를 읽어 출력해보면 합계와 평균은 
// music 데이터 값을 포함한 계산 값이었다. 
// 왜 이런 문제가 발생하였는가?
// 국,영,수,음 외에 합계와 평균도 출력했기 때문에
// 사실 합계와 평균은 과목 점수를 계산하여 나온 값이다.
// 이런 값을 출력하게 되면 
// 읽는 쪽에서 잘못된 결과를 사용할 수 있다.
// 이를 방지하기 위해서 자바에서는 
// serialize 대상에서 필드를 제외시키는 문법을 제공한다.
// => transient modifier 이다. 
// => transient의 사전적 의미를 보면 "일시적인", "잠깐 머무르는"의 
//    뜻을 갖고 있다.
// => 직렬화 대상에서 제외하고 싶은 필드가 있다면 
//    transient를 붙여라!
//    그러면 직렬화할 때 그 값은 제외된다.
//    특히 sum이나 aver 필드처럼 다른 필드의 값을 가지고 
//    도출하는 값인 경우 transient를 붙이도록 하라!
//  
public class Score4 implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int music;// 이 필드를 추가한다.
    
    // transient가 붙은 필드의 값을 serialize 되지 않는다.
    transient private int sum;
    private transient float aver;
    
    public Score4() {}
    
    public Score4(String name, int kor, int eng, 
            int math, /*파라미터 추가*/int music) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.music = music; // 여기 추가 
        this.compute();
    }
    
    // 직렬화를 통해 읽어 들인 점수를 가지고 다시 합계와 평균을 
    // 계산할 수 있도록 다음 메서드를 공개해야 한다.
    // => 이렇게 필요한 상황에서 공개를 하면된다.
    //    무조건 모든 메서드를 공개 상태로 만들지 말라!
    public void compute() { // 변경 
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








