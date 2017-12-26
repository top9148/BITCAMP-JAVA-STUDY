// Stack 클래스에 generic 문법 적용 
//   
package bitcamp.java100.ch09.ex6;


// => Stack이 어떤 데이터 타입을 다룰 것인지 
//    그 타입의 이름을 받을 변수를 선언한다.
// => Type의 이름을 받는다하여 보통 Type의 약자인 T를 사용한다.
//    물론 변수명이기 때문에 개발자가 마음대로 해도 된다.
//
// => T 외에선 많이 사용하는 변수는,
//    
public class Stack2<T> {
    
    // 그리고 사용자가 전달한 타입의 이름을 코드 곳곳에 지정하면 된다.
    private class Box {
        T value;
        Box next;
        
        public Box() {}
        
        public Box(T value) {
            this.value = value;
        }
    }
    
    // 꼭대기 상자 주소를 보관
    Box top;
    
    // 전체 상자 개수
    int len;
    
    public void push(T value) {
        
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
    
    public T pop() {
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










