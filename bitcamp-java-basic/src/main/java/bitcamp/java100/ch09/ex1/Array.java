package bitcamp.java100.ch09.ex1;

public class Array {
    // 고민!
    // 다음 변수를 인스턴스 변수로 만들 것인지 스태틱 변수로 만들 것인지 결정해야 한다.
    // => 배열을 한 개만 만들어서 순차적으로 사용할 것 같으면 스태틱으로 만들면된다.
    // => 배열을 여러 개 만들어야 한다면 인스턴스 변수로 지정하라!
    private Object[] arr = new Object[10000];
    private int cursor = 0;
    
    // Array 클래스도 따지고 보면 사용자 정의 데이터 타입이다.
    // 즉 자바에서 기본으로 제공하지 않는 메모리 타입이다.
    // 개발자가 여러 개의 주소를 다루기 위해 특별히 고안한 메모리 구조이다.
    // 새로운 타입을 정의하면 그 타입의 데이터를 다루는 연산자가 필요하다.
    // 다음은 이 타입의 메모리를 다루는 연산자를 정의한 것이다.
    //
    public void add(Object obj) {
        if (cursor == arr.length)
            return;
        arr[cursor++] = obj;
    }
    
    public int size() {
        return cursor;
    }
    
    public Object get(int index) {
        if (index < 0 || index >= cursor)
            return null;
        return arr[index];
    }
    
    public Object remove(int index) {
        if (index < 0 || index >= cursor)
            return null;
        
        // 삭제할 값을 임시 변수에 저장 
        Object removedValue = arr[index];
        
        // 앞쪽의 값을 당겨서 현재 위치에 덮어쓴다.
        for (int i = index; i < cursor - 1; i++) {
            arr[i] = arr[i + 1];
        }
        
        // cursor의 위치를 한칸 당긴다.
        cursor--;
        
        // 삭제한 항목의 값은 리턴한다.
        return removedValue;
    }
    
    public void insert(int index, Object value) {
        if (cursor == arr.length)
            return;
        
        if (index < 0 || index >= cursor)
            return;
        
        // 현재 i가 가리키는 방의 값을 앞쪽 방으로 옮긴다.
        for (int i = cursor - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        
        // 지정된 위치에 값을 넣는다.
        arr[index] = value;
        
        // cursor의 위치를 증가시킨다.
        cursor++;
    }
    
}










