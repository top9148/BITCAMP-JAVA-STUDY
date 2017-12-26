package bitcamp.java100.ch08.ex3;

public class ArrayList {
    Object[] list = new Object[10000];
    int cursor = 0;
    
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
