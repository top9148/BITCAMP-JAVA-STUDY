// 컬렉션 - LinkedList와 nested class
// => Box 라는 클래스는 LinkedList 클래스가 값을 보관하기 위해 사용하는 클래스이다.
//    다른 클래스가 사용할 일이 없다.
// => 이렇게 Box 클래스처럼 특정 클래스에서만 사용될 목적으로 만든 클래인 경우,
//    가능한 그 사용 범위를 제한하는 것이 유지보수에 좋다.
// => 즉 나중에 다른 목적으로 Box 클래스를 만들 때 
//    LinkedList에서 사용하기 위해 만든 Box 클래스와 혼동될 수 있기 때문이다.
// 
// => 이런 경우 "중첩 클래스" 문법을 이용하여 Box 클래스의 사용범위를
//    LinkedList로 좁히는 것이 유지보수에 좋다.
// 
package bitcamp.java100.ch09.ex3;



public class Test1 {

    static void printList(LinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s ", list.get(i));
        }
        System.out.println();
        System.out.println("--------------------------------");
    }
    
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        
        list.add("홍길동");
        list.add("임꺽정");
        list.add("유관순");
        list.add("안중근");
        list.add("윤봉길");
        
        printList(list);
        
        list.insert(2, "김구");
        
        printList(list);
        
        list.insert(0, "김원봉");
        
        printList(list);
        
        list.insert(6, "신채호");
        
        printList(list);
        
        // LinkedList의 특징 
        // => 초기 메모리의 크기가 크기 않다.
        // => 값을 저장할 때마다 메모리가 증가한다.
        // => 배열에 비해 저장 개수의 한계가 없다. 
        // => 값을 삽입하거나 제거할 때 
        //    배열과 달리 링크를 다뤄서 처리하기 때문에 속도가 빠르다.
        // => 그러나 값을 꺼낼 때는 링크를 따라가야 하기 때문에
        //    매우느리다. 
        // => 특히 뒤쪽의 값을 꺼낼 때 매우 느리다.
        //    즉 저장 개수가 늘어날 때 마다 조회시간을 비례하여 증가한다.
    }

}












