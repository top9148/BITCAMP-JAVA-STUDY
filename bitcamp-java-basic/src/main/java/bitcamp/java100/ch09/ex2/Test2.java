// 컬렉션 - LinkedList
// => remove() 테스트
package bitcamp.java100.ch09.ex2;

public class Test2 {

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
        
        System.out.println(list.remove(4));
        
        printList(list);
        
        System.out.println(list.remove(2));
        
        printList(list);
        
        System.out.println(list.remove(0));
        
        printList(list);
        
        System.out.println(list.remove(0));
        
        printList(list);
        
        System.out.println(list.remove(0));
        
        printList(list);
        
        list.add("홍길동");
        list.add("임꺽정");
        printList(list);
    }

}
