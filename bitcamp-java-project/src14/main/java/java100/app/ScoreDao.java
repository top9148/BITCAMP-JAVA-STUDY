//: ## ScoreDao
//: - 스태틱 변수는 클래스가 로딩될 때 단 한 번만 생성된다.
//: - 만약 데이터를 개별적으로 다루고 싶다면 인스턴스 변수로 전환해야 한다.
//: - ScoreDao는 Score 객체들의 주소를 보관하는 일을 한다.
//: - 배열 변수가 스태틱이기 때문에 보관소는 한 개만 존재한다.
//: - 앞으로 그룹에 따라 학생들의 성적을 별도의 보관소에 저장할 일이 있을 것 같다.
//: - 이런 경우를 대비하기 위해 보관소를 여러 개 만들 수 있도록 
//:   인스턴스 변수로 전환하는 것이다.
//:
package java100.app;

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
