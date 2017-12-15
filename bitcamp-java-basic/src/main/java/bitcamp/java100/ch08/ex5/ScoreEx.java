// 다형성 - 오버라이딩 
// compute() 메서드는 국,영,수 과목의 합계와 평균을 계산한다.
// ScoreEx 클래스에서는 새로 추가한 과학, 사회 과목을 포함해서 계산해야 하기 때문에
// 이 클래스에 맞게끔 상속 받은 compute()를 재정의할 필요가 있다.
// 이런 경우가 바로 오버라이딩을 적용해야 하는 예다.
// 
// 일단 이 클래스는 compute()를 오버라이딩 하지 않는다.
// 오버라이딩 하지 않아서 발생하는 문제를 확인하자!
//
package bitcamp.java100.ch08.ex5;

public class ScoreEx extends Score {
    int sci;
    int soc;
    
    public ScoreEx() {}
    
    public ScoreEx(int no, String name, int kor, int eng, int math, int sci, int soc) {
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
    
}










