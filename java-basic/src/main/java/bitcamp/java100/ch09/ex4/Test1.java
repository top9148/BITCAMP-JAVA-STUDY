// 컬렉션 - Stack 활용
// => Stack은 먼저 저장된 값이 나중에 나오는 방식(First In Last Out; FILO)으로 
//    데이터를 관리한다.
//    즉 나중에 들어간 값이 먼저 나온다. (Last In First Out; LIFO)
package bitcamp.java100.ch09.ex4;



public class Test1 {

    public static void main(String[] args) {
        
        Stack stack = new Stack();
        
        stack.push("홍길동");
        stack.push("임꺽정");
        stack.push("유관순");
        stack.push("안중근");
        stack.push("윤봉길");
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
        stack.push("홍길동");
        stack.push("임꺽정");
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
    }

}












