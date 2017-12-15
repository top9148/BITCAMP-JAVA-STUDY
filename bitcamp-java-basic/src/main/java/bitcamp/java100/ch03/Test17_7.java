// ## 메서드 - 메서드 정의 문법 VI
// - 메서드 정의 기본 문법을 알아 보자!
//

package bitcamp.java100.ch03;

public class Test17_7 {

    // 6) 타입이 다른 여러 개의 값을 반환하는 방법 
    // - 컬렉션 객체(상자)에 담아서 반환한다.
    //
    
    static java.util.ArrayList m1() {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add("홍길동");
        list.add(20);
        list.add(false);
        list.add(4.12f);
        list.add('M');
        
        // 객체(상자)를 리턴하는 것이 아니라, 객체의 주소를 리턴한다. 
        return list;
    }
    
    public static void main(String[] args) {
        java.util.ArrayList a = m1();
        
        for (Object v : a) {
            System.out.println(v);
        }
    }
}














