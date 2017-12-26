// 컬렉션 API - HashSet II
package bitcamp.java100.ch09.ex7;

import java.util.HashSet;

public class Test4 {
    
    public static void main(String[] args) {
        
        HashSet<String> set = new HashSet<>();
        
        // 강조!
        // => HashSet은 
        //    - 해시값(hashCode()의 리턴 값)이 같고, 
        //    - equals()의 리턴 값이 true인 객체를 중복저장하지 않는다.
        //
        String s1 = "홍길동";
        String s2 = "임꺽정";
        String s3 = "유관순";
        
        set.add(s1);
        set.add(s2);
        set.add(s3);
        
        String s4 = new String("홍길동");
        String s5 = new String("홍길동");
        
        // s1과 s4, s5는 모두 다른 인스턴스이다.
        System.out.println(s1 == s4); // false
        System.out.println(s1 == s5); // false
        System.out.println(s4 == s5); // false
        
        // s1, s4, s5의 해시값은 같다.
        System.out.println(s1.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s5.hashCode());
        
        // 또한 equals()의 리턴 값도 같다.
        System.out.println(s1.equals(s4)); // true
        System.out.println(s1.equals(s5)); // true
        System.out.println(s4.equals(s5)); // true
        
        
        set.add(s4); // s1과 같은 객체로 판단한다. 따라서 저장 안함.
        set.add(s5); // s1과 같은 객체로 판단한다. 따라서 저장 안함.
        
        System.out.println(set.size());
        
        String[] arr = new String[set.size()];
        set.toArray(arr);
        
        for (String s : arr) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }

}







