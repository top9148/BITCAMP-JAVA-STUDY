// 컬렉션 API - Iterator III
// => 컬렉션에서 값을 꺼내주는 역할을 하는 객체 
//
package bitcamp.java100.ch09.ex7;

import java.util.HashMap;
import java.util.Iterator;

public class Test15 {
    
    static class Contact {
        String name;
        String email;
        String tel;
        
        public Contact(String name, String email, String tel) {
            this.name = name;
            this.email = email;
            this.tel = tel;
        }

        @Override
        public String toString() {
            return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + "]";
        }
    }
    
    
    public static void main(String[] args) {
        
        HashMap<String,Contact> map = new HashMap<>();
        
        Contact c1 = new Contact("홍길동", "hong@test.com", "1111-1111");
        Contact c2 = new Contact("홍길동2", "hong2@test.com", "1111-1112");
        Contact c3 = new Contact("홍길동3", "hong3@test.com", "1111-1113");
        
        map.put("aaa", c1);
        map.put("bbb", c2);
        map.put("ccc", c3);
        
        // 값이 저장된 목록에서 "데이터를 꺼내주는 일을 할 객체"를 얻는다.
        // "데이터를 꺼내주는 일을 하는 객체"를 사용하여 값을 꺼낸다.
        Iterator<Contact> iterator = map.values().iterator();
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        // Iterator?
        // => 데이터를 저장한 방식(스택, 큐, List, Set, Map 등)에 상관없이
        //    일관된 방식(hasNext(), next())으로 값을 꺼내게 해주는
        //    설계 패턴이다.
        
    }

}
















