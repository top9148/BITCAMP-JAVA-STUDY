// 컬렉션 API - HashSet III
package bitcamp.java100.ch09.ex7;

import java.util.HashSet;

public class Test6 {
    
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((email == null) ? 0 : email.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
            Contact other = (Contact) obj;
            if (email == null) {
                if (other.email != null)
                    return false;
            } else if (!email.equals(other.email))
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (tel == null) {
                if (other.tel != null)
                    return false;
            } else if (!tel.equals(other.tel))
                return false;
            return true;
        }
        
        
    }
    
    
    public static void main(String[] args) {
        
        HashSet<Contact> set = new HashSet<>();
        
        Contact c1 = new Contact("홍길동", "hong@test.com", "1111-1111");
        Contact c2 = new Contact("홍길동", "hong@test.com", "1111-1111");
        Contact c3 = new Contact("홍길동", "hong@test.com", "1111-1111");
        
        System.out.println(c1 == c2); // false
        System.out.println(c1 == c3); // false
        System.out.println(c2 == c3); // false
        
        // c1, c2, c3의 hashCode()의 리턴 값이 다르다.
        System.out.println(c1.hashCode()); 
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        
        // c1, c2, c3의 equals() 비교 값이 false이다.
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c2.equals(c3));
        
        // c1, c2, c3는 비록 같은 내용을 갖고 있지만,  
        // 다른 객체로 취급한다. 그래서 모두 저장 가능하다.
        set.add(c1);
        set.add(c2);
        set.add(c3);
        
        // 컬렉션에 저장된 객체(주소)들의 개수
        System.out.println(set.size());

        Contact[] arr = new Contact[set.size()];
        set.toArray(arr);
        
        for (Contact c : arr) {
            System.out.printf("%s, %s, %s\n", c.name, c.email, c.tel);
        }
        
        // HashSet이 중복 데이터임을 판단하는 기준 
        // => HashSet은 집합의 기능을 구현한 것이기 때문에 중복 데이터를 저장하지 않는다.
        // => 중복 데이터의 기준은? 
        //    hashCode() 리턴 값이 같다.
        //    equals()로 비교했을 때 리턴 값이 true이다.
        // => 그러나 Object로부터 그냥 상속 받은 hashCode()는 
        //    인스턴스가 다르면 무조건 다른 해시 값을 리턴한다.
        //    또한 Object로부터 그냥 상속 받은 equals()는
        //    인스턴스가 다르면 무조건 false를 리턴한다.
        // => 그래서,
        //    HashSet에 보관할 객체는 반드시 Object의 이들 메서드를 재정의 해야 한다.
        //    그래야만 같은 값을 갖는 객체를 중복 저장하지 않을 수 있다.
    }

}
















