// 다형성 - 오버라이딩
// compute() 메서드는 국,영,수 과목의 합계와 평균을 계산한다.
// ScoreEx 클래스에서는 새로 추가한 과학, 사회 과목을 포함해서 계산해야 하기 때문에
// 이 클래스에 맞게끔 상속 받은 compute()를 재정의할 필요가 있다.
// 이런 경우가 바로 오버라이딩을 적용해야 하는 예다.
// 
package bitcamp.java100.ch08.ex5;

public class ScoreEx2 extends Score {
    int sci;
    int soc;
    
    public ScoreEx2() {}
    
    public ScoreEx2(int no, String name, int kor, int eng, int math, int sci, int soc) {
        super(no, name, kor, eng, math);
        
        this.sci = sci;
        this.soc = soc;
        
        this.compute();
    }

    public int getSci() {
        return sci;
    }

    public void setSci(int sci) {
        this.sci = sci;
        
        this.compute();
    }

    public int getSoc() {
        return soc;
    }

    public void setSoc(int soc) {
        this.soc = soc;
        
        this.compute();
    }
    
    @Override
    protected void compute() {
        // 오버라이딩 할 때 완전히 모든 코드를 재작성하는 경우가 있고,
        // 현재의 경우처럼 기존의 코드를 사용하는 경우가 있다.
        
        // => 기존의 compute()를 호출하여 국,영,수 합계를 일단 구한다.
        super.compute();
        // 의미? 
        // => 현재 클래스가 아니라 수퍼 클래스부터 compute()를 찾아 올라가라.
        // => 있으면 호출하라!
        // => 없다면 컴파일 오류!
        
        this.sum += this.sci + this.soc;
        this.aver = this.sum / 5f;
    }
    
}










