// 인터페이스의 구현체를 사용하는 개발자 입장!
package bitcamp.java100.ch12.ex2;

import java.util.ArrayList;
import java.util.Iterator;

public class Caller2 {

    public static void main(String[] args) {
        
        // 이번에는 자바에서 제공하는 클래스가 아닌 
        // 우리가 만든 Array 클래스를 사용해보자!
        Array list = new Array();
        list.add("홍길동");
        list.add("임꺽정");
        list.add("유관순");
        
        
        // caller 쪽 클래스를 만드는 입장에서 코딩해보자!
        
        Iterator iterator = list.iterator();
        
        // Iterator 인터페이스에 정의된 대로 
        // 그 규칙에 따라 메서드를 호출한다.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
    }

}






