// 애노테이션 사용하기
// 
package bitcamp.java100.ch19.ex1;

// 클래스 선언부에 붙일 수 있다.
@MyAnnotation
//@MyAnnotation // 오류! 중복해서 붙일 수는 없다.
public class MyClass {
    
    // 필드 선언부에 붙일 수 있다.
    @MyAnnotation
    public int a;
    
    // 메서드 선언부에 붙일 수 있다.
    @MyAnnotation
    public void m() {
        
        //@MyAnnotation // 오류! 일반 문장에는 붙일 수 없다.
        System.out.println("Hello!!!");
    }
    
    // 파라미터 선언부에도 붙일 수 있다.
    public void m2(@MyAnnotation int a, @MyAnnotation String b) {
        
        // 로컬 선언부에도 붙일 수 있다.
        // 즉 선언부에는 모두 붙일 수 있다.
        @MyAnnotation
        int x = 10;
    }
}








