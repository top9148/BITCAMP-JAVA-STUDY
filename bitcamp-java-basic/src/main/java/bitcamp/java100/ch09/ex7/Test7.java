// 컬렉션 API - HashMap
package bitcamp.java100.ch09.ex7;

import java.util.HashMap;

public class Test7 {
    
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
        
        // key-value 한 쌍으로 이루어진 값을 보관할 때 사용한다.
        // => key는 값을 저장하고 찾을 때 사용한다.
        // => value는 보관하고자 하는 값을 말한다.
        // HashMap 객체를 생성할 때 key의 타입과 value의 타입 이름을 넘겨야 한다. 
        HashMap<String,Contact> map = new HashMap<>();
        
        Contact c1 = new Contact("홍길동", "hong@test.com", "1111-1111");
        Contact c2 = new Contact("홍길동2", "hong2@test.com", "1111-1112");
        Contact c3 = new Contact("홍길동3", "hong3@test.com", "1111-1113");
        
        // 값을 저장할 때는 key를 사용하여 저장한다.
        map.put("aaa", c1);
        map.put("bbb", c2);
        map.put("ccc", c3);
        
        
        // 값을 꺼낼 때는 key를 사용하여 꺼낸다.
        System.out.println(map.get("aaa"));
        System.out.println(map.get("bbb"));
        System.out.println(map.get("ccc"));
        
        // key의 인스턴스가 다르더라도 
        // hashCode()의 리턴 값이 같고, equals()의 리턴 값이 true라면 
        // 같은 key로 간주한다.
        String key = new String("aaa");
        
        // String 클래스는 같은 내용일 때 같은 해시값과 equals()가 true를 리턴하도록
        // 메서드를 재정의하였다.
        System.out.println("aaa" == key);
        System.out.println("aaa".hashCode());
        System.out.println(key.hashCode());
        System.out.println("aaa".equals(key));
     
        // "aaa" 리터럴로 만든 String 인스턴스와 key 가 가리키는 인스턴스가 비록 다르더라도
        // hashCode()의 리턴 값이 같고, equals()의 리턴 값이 true이기 때문에
        // HashMap에서는 같은 key로 본다.
        // 따라서 다음과 같이 key를 사용하여 "aaa"로 저장한 값을 꺼낼 수 있다.
        System.out.println(map.get(key));
    }

}
















