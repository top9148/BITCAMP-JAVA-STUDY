//: ## ScoreDao ==> ArrayList
//: - Score 객체 뿐만아니라 다른 타입의 객체라도 보관할 수 있도록 변경한다.
//: - 이제 모든 타입의 객체 주소를 보관할 수 있기 때문에 
//:   클래스 이름을 "ArrayList"로 변경하라! 
//:
package java100.app;

public class ArrayList {
    //: > 배열 레퍼런스의 타입을 최상위 루트 클래스로 전환한다.
    Object[] list = new Object[10000];
    int cursor = 0;
    
    //: > 파라미터로 모든 타입의 객체 주소를 받을 수 있게 전환한다.
    void add(Object obj) {
        if (this.cursor == this.list.length) {
            System.err.println("최대 저장 개수를 초과하였습니다.");
            return;
        }
        this.list[this.cursor++] = obj;
    }
    
    int size() {
        return this.cursor;
    }
    
    Object get(int index) {
        if (index < 0 || index >= this.cursor) {
            return null;
        }
        return this.list[index];
    }
}
