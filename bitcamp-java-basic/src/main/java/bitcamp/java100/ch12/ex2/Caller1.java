// 인터페이스의 구현체를 사용하는 개발자 입장!
package bitcamp.java100.ch12.ex2;

import java.util.ArrayList;
import java.util.Iterator;

public class Caller1 {

    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("임꺽정");
        list.add("유관순");
        
        
        // caller 쪽 클래스를 만드는 입장에서 코딩해보자!
        
        // ArrayList 객체에게 값을 꺼내주는 일을 할 객체를 요구한다.
        // 그 객체는 Iterator 규칙에 따라 만든 객체이다.
        // Iterator는 
        // 값을 꺼내려는 쪽(caller)과 
        // 값을 꺼내주는 쪽(callee)의 호출 규칙을 정의한 것이다.
        //
        // 다음 iterator() 메서드의 의미?
        // => iterator()는 Iterator 인터페이스를 구현한  
        //    어떤 클래스의 인스턴스를 만들어 리턴한다.
        // => iterator()는 Iterator 인터페이스를 구현한 
        //    어떤 클래스의 객체를 리턴한다.
        // => iterator()는 Iterator 인퍼페이스를 구현한 객체를 리턴한다.
        // => iterator()는 Iterator 구현체를 리턴한다.
        // => iterator()는 Iterator 객체를 리턴한다.
        Iterator<String> iterator = list.iterator();
        
        // Iterator 인터페이스에 정의된 대로 
        // 그 규칙에 따라 메서드를 호출한다.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        

    }

}






