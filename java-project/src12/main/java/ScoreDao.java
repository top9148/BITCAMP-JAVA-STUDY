//: ## ScoreDao
//: 여러 개의 Score 인스턴스 주소를 보관하는 역할을 수행한다.
//:
public class ScoreDao {
    static Score[] scores = new Score[10000];
    static int cursor = 0;
     
    static void add(Score score) {
        if (cursor == scores.length) {
            System.err.println("최대 저장 개수를 초과하였습니다.");
            return;
        }
        scores[cursor++] = score;
    }
    
    static int size() {
        return cursor;
    }
    
    static Score get(int index) {
        if (index < 0 || index >= cursor) {
            return null;
        }
        return scores[index];
    }
}
