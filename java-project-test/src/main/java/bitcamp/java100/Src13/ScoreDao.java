package bitcamp.java100.Src13;

public class ScoreDao {
  //: 인스턴스 변수로 정의한다.
    //: > 인스턴스 변수는 new 연산자를 사용하여 인스턴스를 만들 때 생성된다.
    Score[] scores = new Score[10000];
    int cursor = 0;
    
    //: 인스턴스 변수를 다루는 메서드는 인스턴스 메서드로 전환하는 것이 사용하기 편하다.
    void add(Score score) {
        if (this.cursor == this.scores.length) {
            System.err.println("최대 저장 개수를 초과하였습니다.");
            return;
        }
        this.scores[this.cursor++] = score;
    }
    
    int size() {
        return this.cursor;
    }
    
    Score get(int index) {
        if (index < 0 || index >= this.cursor) {
            return null;
        }
        return this.scores[index];
    }
}
