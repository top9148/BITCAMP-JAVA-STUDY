// 컬렉션 API - HashMap II
package bitcamp.java100.ch09.ex7;

import java.util.HashMap;

public class Test8 {
    
    static class MyKey {
        String id;
        String pwd;
        
        public MyKey(String id, String pwd) {
            this.id = id;
            this.pwd = pwd;
        }
    }
    
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
        
        HashMap<MyKey,Contact> map = new HashMap<>();
        
        Contact c1 = new Contact("홍길동", "hong@test.com", "1111-1111");
        MyKey k1 = new MyKey("aaaa", "1111");
        
        // 값을 저장할 때 MyKey를 사용하여 저장하고,
        map.put(k1, c1);
        
        // 저장할 때 사용한 같은 MyKey 객체를 사용하여 값을 꺼낸다.
        System.out.println(map.get(k1));
        
        // 내용이 같은 다른 MyKey 객체를 사용한다면?
        MyKey k2 = new MyKey("aaaa", "1111");
        System.out.println(map.get(k2));
        
        // get() 메서드가 MyKey 객체를 가지고 값을 찾을 때 
        // hashCode()의 리턴 값이 같고,
        // equals()의 리턴 값이 true인 
        // 그 key로 저장된 값을 찾아 리턴한다.
        // 
        // 그런데 MyKey 클래스는 hashCode()와 equals()를 오버라이딩 하지 않았다.
        // 즉 Object의 메서드를 호출하는 것이다.
        // Object에 정의된 hashCode()는 내용물에 상관없이 인스턴스가 다르면 
        // 다른 해시값을 리턴하게 만들어져있다.
        // 또한 equals()도 내용물에 상관없이 인스턴스가 다르면 false를 리턴하게
        // 프로그램되어 있다. 
        //
        // 해결책?
        // - 그래서 HashMap이나 Hashtable에서 key로 사용할 클래스는 
        //   반드시 내용물이 같을 경우 같은 hashCode()를 리턴하고,
        //   equals()의 리턴 값이 true가 되도록 오버라이딩해야 한다.
        // 예제 Test9.java를 보라!
    }

}
















