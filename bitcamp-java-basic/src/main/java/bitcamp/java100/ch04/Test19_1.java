// ## import - import를 사용하지 않을 때
// - import의 용도와 사용법을 알아보자!
//

package bitcamp.java100.ch04;

public class Test19_1 {
    public static void main(String[] args) {
        // 현재 클래스가 소속되어 있는 패키지가 아닌 
        // 다른 패키지에 소속되어 있는 클래스를 사용할 때는
        // 반드시 클래스 앞에 패키지를 적어야 한다.
        
        //ArrayList list = new ArrayList(); // 컴파일 오류!
        
        java.util.ArrayList<java.lang.String> list = 
                new java.util.ArrayList<>(); // OK!
        list.add("홍길동");
    }
}











