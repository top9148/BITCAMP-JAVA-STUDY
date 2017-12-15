// 컬렉션 API - ArrayList
package bitcamp.java100.ch09.ex7;

import java.util.ArrayList;

public class Test1 {

    public static void main(String[] args) {
        
        // 여러 개의 객체(주소)를 저장할 컬렉션을 준비한다. 
        ArrayList<String> list = new ArrayList<>();
        
        // 컬렉션에 객체(주소)를 담는다.
        list.add(new String("홍길동"));
        list.add(new String("임꺽정"));
        list.add(new String("유관순"));
        
        // 컬렉션에 저장된 객체(주소)들의 개수
        System.out.println(list.size());
        
        // 컬렉션에서 객체 꺼내기
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s ", list.get(i));
        }
        System.out.println();
        
        // 컬렉션에서 값을 꺼낼 때 다음 형식의 for문을 사용할 수 있다.
        for (String s : list) {
            System.out.printf("%s ", s);
        }
        System.out.println();
        
        

    }

}
