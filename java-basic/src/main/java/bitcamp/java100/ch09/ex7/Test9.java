// 컬렉션 API - HashMap III
package bitcamp.java100.ch09.ex7;

import java.util.HashMap;

public class Test9 {
    
    static class MyKey {
        String id;
        String pwd;
        
        public MyKey(String id, String pwd) {
            this.id = id;
            this.pwd = pwd;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MyKey other = (MyKey) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            if (pwd == null) {
                if (other.pwd != null)
                    return false;
            } else if (!pwd.equals(other.pwd))
                return false;
            return true;
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
        // => 이 예제의 MyKey는 내용물이 같을 때 같은 해시 값을 리턴하고,
        //    equals()의 리턴 값이 true가 되도록 오버라이딩 했기 때문에
        //    비록 MyKey 인스턴스가 다르더라도 값을 찾을 수 있을 것이다.
        MyKey k2 = new MyKey("aaaa", "1111");
        System.out.println(map.get(k2));
        
        // 결론!
        // - String 클래스와 Wrapper 클래스(Byte, Short, Integer, ...등)들은
        //   Object로부터 상속 받은 hashCode()와 equals()를 오버라이딩 했기 때문에
        //   HashMap이나 Hashtable의 key 클래스로 자주 사용한다.
        // 
    }

}
















