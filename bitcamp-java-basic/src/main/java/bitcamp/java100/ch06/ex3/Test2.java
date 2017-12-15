// 스태틱 멤버 - 인스턴스 변수가 생성될 때
package bitcamp.java100.ch06.ex3;

// 실행 과정과 클래스 변수 및 인스턴스 변수 생성 순서
// 1) JVM은 Test2 클래스를 로딩한다.
public class Test2 {
    
    // 2) JVM은 Test2의 main()을 호출한다.
    // 3) main()의 로컬 변수(args, obj1, obj2)가 "스택(stack) 영역"에 생성된다.
    public static void main(String[] args) {

        // 4) MyClass 가 로딩된다.
        // 5) MyClass의 스태틱 변수 v1이 "메서드 영역(Method Aread)"에 생성된다.
        // 6) MyClass의 설계도에 따라 "힙 영역(heap)"에 인스턴스 변수 v2가 생성된다.
        // 7) 힙 영역에 생성된 인스턴스 메모리의 주소가 obj1에 보관된다.
        MyClass obj1 = new MyClass();
        
        // 8) MyClass의 설계도에 따라 "힙 영역(heap)"에 인스턴스 변수 v2가 생성된다.
        //    => 이때 MyClass는 이전에 이미 Method Area 영역에 로딩되었기 때문에 
        //       다시 로딩되지 않는다.
        // 9) 힙 영역에 생성된 인스턴스 메모리의 주소가 obj2에 보관된다.
        MyClass obj2 = new MyClass();
        
        
    }
}








