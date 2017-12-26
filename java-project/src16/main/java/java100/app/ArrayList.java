//: ## 제네릭 적용
//: - ArrayList에 저장할 데이터의 타입 이름을 파라미터화 시켜서 다룬다. 
//:
package java100.app;

public class ArrayList<T> {
    //: > 배열 레퍼런스의 타입을 최상위 루트 클래스로 전환한다.
    private Object[] list = new Object[10000];
    private int cursor = 0;
    
    
    //: > 파라미터로 모든 타입의 객체 주소를 받을 수 있게 전환한다.
    void add(T obj) {
        if (this.cursor == this.list.length) {
            System.err.println("최대 저장 개수를 초과하였습니다.");
            return;
        }
        this.list[this.cursor++] = obj;
    }
    
    int size() {
        return this.cursor;
    }
    
    @SuppressWarnings("unchecked")
    T get(int index) {
        if (index < 0 || index >= this.cursor) {
            return null;
        }
        return (T)this.list[index];
    }
}







