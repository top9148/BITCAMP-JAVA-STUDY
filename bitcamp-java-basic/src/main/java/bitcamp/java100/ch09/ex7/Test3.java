// 컬렉션 API - HashSet
package bitcamp.java100.ch09.ex7;

import java.util.HashSet;

public class Test3 {

    public static void main(String[] args) {
        
        HashSet<String> set = new HashSet<>();
        
        String s1 = "홍길동";
        String s2 = "임꺽정";
        String s3 = "유관순";
        
        set.add(s1);
        set.add(s2);
        set.add(s3);
        
        // => 집합의 특징을 구현했기 때문에, 같은 인스턴스를 중복 저장할 수 없다.
        set.add(s1);
        set.add(s2);
        set.add(s3);
        
        // => null 값도 저장할 수 있다.
        set.add(null);
        set.add(null); // null 또한 중복 저장할 수 없다.
        
        // 컬렉션에 저장된 객체(주소)들의 개수
        System.out.println(set.size());
        
        
        // 값을 배열로 꺼내고 싶다면, 값을 모두 담을 수 있는 배열을 만든 다음에,
        // toArray()의 파라미터로 배열 주소를 넘겨라!
        // 그러면 배열에 객체들의 주소를 담아줄 것이다.
        // 만약 파라미터로 제공된 배열을 크기가 HashSet에 보관된 객체들의 수 보다 작다면,
        // 따로 배열을 새로 만든 다음에 그 배열의 주소를 리턴할 것이다.
        String[] arr = new String[set.size()];
        String[] arr2 = set.toArray(arr);
        
        if (arr == arr2)
            System.out.println("arr == arr2");
        else 
            System.out.println("arr != arr2");
        
        
        // => 컬렉션에서 객체를 꺼낼 때 저장 순서대로 꺼낼 수 없다.
        for (String s : arr) {
            System.out.printf("%s ", s);
        }
        System.out.println();

        // 왜 저장된 순서로 꺼낼 수 없는가?
        // => 객체(주소)를 저장할 때 ArrayList처럼 
        //    0번부터 순서대로 번호를 붙이는 것이 아니라
        //    그 객체의 해시값(hashCode()의 리턴 값)을 토대로 
        //    객체를 저장할 위치를 계산하여 보관한다.
        // => 그래서 add()를 호출한 순서가 아니라 
        //    그 객체의 hash 값에 따라 순서가 결정되기 때문에
        //    입력 순서를 보장하지 않는다.
        //
        // 왜 이렇게 해시값을 이용하여 위치를 계산하는가?
        // => 같은 값의 중복 저장을 피하기 위해
        //    기본적으로 인스턴스가 다르더라도 같은 내용을 가지고 있다면,
        //    보통 같은 값으로 다루기 위해 개발자들은 hashCode()를 재정의한다.
        //    즉 해시 값이 같은 인스턴스는 같은 값을 갖고 있다고 판단할 수 있으며,
        //    이에 따라 중복 값을 저장하는 것을 피할 수 있다.
        // => 해시 값으로 저장 위치를 계산하기 때문에
        //    찾을 때 빨리 찾을 수 있다.
        //    예) 도서관에서 책장에 책을 보관할 때 각 책의 키워드나 고유번호를 부여하여
        //        분류별로 저장하는 방식과 같다.
        //        이렇게 저장하는 것의 이점은 책 고유번호를 보고 빠르게 
        //        책장에서 책을 찾을 수 있기 때문이다.
        
    }

}







