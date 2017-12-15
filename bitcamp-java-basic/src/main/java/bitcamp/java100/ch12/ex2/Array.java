// 인터페이스의 구현체를 만드는 개발자 입장!
// 
package bitcamp.java100.ch12.ex2;

import java.util.Iterator;

public class Array {
    private Object[] arr = new Object[10000];
    private int cursor = 0;
    
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
        
        Object removedValue = arr[index];
        
        for (int i = index; i < cursor - 1; i++) {
            arr[i] = arr[i + 1];
        }
        
        cursor--;
        
        return removedValue;
    }
    
    public void insert(int index, Object value) {
        if (cursor == arr.length)
            return;
        
        if (index < 0 || index >= cursor)
            return;
        
        for (int i = cursor - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        
        arr[index] = value;
        
        cursor++;
    }
    
    // Iterator 규칙에 따라 만든 클래스의 객체를 리턴한다.
    public Iterator iterator() {
        return new MyIterator();
    }
    
    // 인터페이스 규칙에 따라 사용될 클래스를 정의하는 개발자 입장에서  
    // 클래스를 정의해보자!
    class MyIterator implements Iterator<Object> {
        int index;
        
        @Override
        public boolean hasNext() {
            // Array의 cursor 변수는 값을 입력할 방의 위치를 가리킨다.
            // 그래서 MyIterator의 index가 그 위치보다 적은 
            // 위치를 가리킨다면 꺼낼 데이터가 있다는 것이다.
            if (index < cursor)
                return true; // 꺼낼 데이터가 있다면 true를 리턴한다.
            return false;
        }

        @Override
        public Object next() {
            // Array의 배열 저장소에서 index가 가리키는 위치의 
            // 값을 꺼낸 다음에 index는 다음 위치를 가리키도록 증가시킨다.
            return arr[index++];
        }
        
    }
    
}










