// 다형성 - hashCode() 오버라이딩 전
// hashCode()의 리턴 값은 
// HashSet이나 HashMap에서 객체를 저장할 때 사용한다.
// equals() 외에 이 메서드의 리턴값을 비교하여 같은 객체인지 검사한다.
// equals()의 리턴 값이 같더라도 hashCode()의 리턴 값이 다르면 다른 객체로 취급한다.
// 
package bitcamp.java100.ch08.ex6;

import java.util.ArrayList;
import java.util.HashSet;

public class Test1 {
    public static void main(String[] args) {
        
        Score s1 = new Score(1, "홍길동", 100, 100, 100);
        Score s2 = new Score(1, "홍길동", 100, 100, 100);

        ArrayList list = new ArrayList();
        // ArrayList는 객체들의 주소를 보관한다.
        // 같은 객체를 중복해서 보관할 수 있다.
        
        list.add(s1);
        list.add(s1);
        
        System.out.println(list.size());
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());
        
        System.out.println("-------------------------------------------------");
        
        HashSet set = new HashSet();
        // HashSet은 ArrayList처럼 객체들의 주소를 보관하는
        // 용도로 사용하는 클래스이다.
        // 단 ArrayList와 다른 점은 같은 객체를 중복해 저장하지 않는다.
        //
        // 같은 객체로 보는 기준은 무엇인가?
        // => 인스턴스 주소가 같을 경우. 
        // => equals()로 비교했을 때 리턴 값이 true이이고,
        //    hashCode() 값이 같을 경우.
        
        set.add(s1);
        set.add(s1);
        
        System.out.println(set.size());
        // HashSet에 저장된 개수를 출력해 보면 1이 나온다.
        // 왜? s1 객체가 중복 저장되지 않기 때문이다.
        
        System.out.println("----------------------------------------");
        
        // 그러면 인스턴스는 다르지만 같은 값을 갖는 객체인경우?
        set.add(s2);
        System.out.println(set.size());
        // 같은 값을 갖고 있다고 해서 같은 객체가 아니다.
        // HashSet이 같은 객체라고 판단하는 기준은 위와 같이,
        // 정말 같은 인스턴스 이거나 즉 주소가 같거나,
        // equals()의 리턴 값이 true이고 hashCode()의 리턴 값이 같을 경우에 
        // 같은 객체로 판단한다.
        //
        // Score 클래스는 equals()를 오버라이딩 하여 
        // name과 kor, eng, math의 값이 같을 경우 true를 리턴하게 했다.
        // 하지만, hashCode()의 리턴 값은 여전히 다르다.
        
        System.out.println("-------------------------");
        System.out.printf("s1.equals(s2) = %b\n", s1.equals(s2));
        System.out.printf("s1.hashCode() = %d\n", s1.hashCode());
        System.out.printf("s2.hashCode() = %d\n", s2.hashCode());
        
        
        
    }
}











