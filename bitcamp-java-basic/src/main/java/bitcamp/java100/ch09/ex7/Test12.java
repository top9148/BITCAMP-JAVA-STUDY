// 컬렉션 API - HashMap의 값 꺼내기 III
package bitcamp.java100.ch09.ex7;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Test12 {
    
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
        
        map.put("c01", new Contact("홍길동1", "hong@test.com", "1111-1111"));
        map.put("c02", new Contact("홍길동2", "hong@test.com", "1111-1111"));
        map.put("c03", new Contact("홍길동3", "hong@test.com", "1111-1111"));
        map.put("c04", new Contact("홍길동4", "hong@test.com", "1111-1111"));
        map.put("c05", new Contact("홍길동4", "hong@test.com", "1111-1111"));

        // key-value를 한쌍으로 묶은 목록 얻기
        Set<Entry<String,Contact>> entrySet = map.entrySet();
        
        for (Entry<String,Contact> entry : entrySet) {
            String key = entry.getKey();
            Contact contact = entry.getValue();
            System.out.printf("%s=%s\n", key, contact.name);
        }
        
        
    }

}
















