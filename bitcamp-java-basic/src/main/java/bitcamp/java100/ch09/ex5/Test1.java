// 컬렉션 - Queue 활용
// => Queue는 먼저 저장된 값이 먼저 나오는 방식으로 데이터를 관리한다.
package bitcamp.java100.ch09.ex5;

public class Test1 {

    public static void main(String[] args) {
        
        Queue queue = new Queue();
        
        queue.add("홍길동");
        queue.add("임꺽정");
        queue.add("유관순");
        queue.add("안중근");
        queue.add("윤봉길");
        
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        
        queue.add("홍길동");
        queue.add("임꺽정");
        
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        
    }

}












