package bitcamp.java100.Src15;

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
