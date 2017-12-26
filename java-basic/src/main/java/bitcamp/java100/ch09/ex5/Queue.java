// 역할: Queue 방식으로 데이터 목록 관리
// => 먼저 저장한 데이터를 먼저 꺼내는 방식(First In First Out; FIFO)
//   
package bitcamp.java100.ch09.ex5;


public class Queue {
    
    // non-static nested class => inner class
    private class Box {
        Object value;
        Box next;
        
        public Box() {}
        
        public Box(Object value) {
            this.value = value;
        }
    }
    
    // 시작과 끝 위치의 상자 주소 보관
    Box head;
    Box tail;
    
    // 전체 상자 개수
    int len;
    
    public void add(Object value) {
        
        // 새 상자를 만들어 값을 저장한다.
        Box box = new Box(value);

        // 기존의 상자가 새 상자를 가리키게 한다.
        if (tail != null)
            tail.next = box;
        
        // 새 상자가 꼬리가 되게 한다.
        tail = box;
        
        // 상자 개수를 증가시킨다.
        len++;

        // 처음 추가한 상자라면 head가 되게 한다.
        if (head == null) 
            head = box;
    }
    
    public int size() {
        return len;
    }
    
    public Object poll() {
        if (len == 0)
            return null;
        
        // 리턴할 값을 담은 Box의 주소를 보관한다.
        Box box = head;
        
        // head를 다음 상자로 이동한다.
        head = head.next;
        
        // 상자의 개수를 줄인다.
        len--;
        
        return box.value;
    }
}










