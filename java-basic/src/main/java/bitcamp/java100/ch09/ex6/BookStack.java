// 역할: BookStack을 사용하는 예
//   
package bitcamp.java100.ch09.ex6;


public class BookStack {
    
    // non-static nested class => inner class
    private class Box {
        Book value;
        Box next;
        
        public Box() {}
        
        public Box(Book value) {
            this.value = value;
        }
    }
    
    // 꼭대기 상자 주소를 보관
    Box top;
    
    // 전체 상자 개수
    int len;
    
    public void push(Book value) {
        
        // 새 상자를 만들어 값을 저장한다.
        Box box = new Box(value);

        // 새 상자가 이전의 꼭대기 상자를 가리키게 한다.
        box.next = top;

        // 꼭대기를 새 상자로 바꾼다.
        top = box;
        
        // 상자 개수를 증가시킨다.
        len++;
    }
    
    public int size() {
        return len;
    }
    
    public Book pop() {
        if (len == 0)
            return null;
        
        // 리턴할 값을 담은 Box의 주소를 보관한다.
        Box box = top;
        
        // 꼭대기 상자를 이전 상자로 바꾼다.
        top = top.next;
        
        // 상자의 개수를 줄인다.
        len--;
        
        return box.value;
    }
}










