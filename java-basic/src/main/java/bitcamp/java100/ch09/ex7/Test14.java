// 컬렉션 API - Iterator II 
// => 컬렉션에서 값을 꺼내주는 역할을 하는 객체 
//
package bitcamp.java100.ch09.ex7;

import java.util.HashSet;
import java.util.Iterator;

public class Test14 {

    public static void main(String[] args) {
        
        HashSet<String> set = new HashSet<>();
        
        set.add("홍길동");
        set.add("임꺽정");
        set.add("유관순");
        
        // HashSet에서 "데이터를 꺼내주는 객체"를 얻는다.
        Iterator<String> iterator = set.iterator();
        
        // "데이터를 꺼내주는 객체"를 통해 값을 꺼낸다.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
            
        
        
    }

}







