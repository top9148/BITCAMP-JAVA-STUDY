// 컬렉션 API - Iterator 
// => 컬렉션에서 값을 꺼내주는 역할을 하는 객체 
//
package bitcamp.java100.ch09.ex7;

import java.util.ArrayList;
import java.util.Iterator;

public class Test13 {

    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>();
        
        list.add("홍길동");
        list.add("임꺽정");
        list.add("유관순");
        
        // ArrayList에서 "데이터를 꺼내주는 객체"를 얻는다.
        Iterator<String> iterator = list.iterator();
        
        // "데이터를 꺼내주는 객체"를 통해 ArrayList에서 값을 꺼낸다.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
    }

}
