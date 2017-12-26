// 인터페이스를 정의하는 방법 II
// 
package bitcamp.java100.ch12.ex3;

// => 인터페이스도 필드를 가질 수 있다.
//
public interface Protocol2 {
    
    // => 단 규칙으로서 사용되기 때문에 
    //    모든 필드는 공개되어야 하고, 
    //    인터페이스로 직접 사용가능해야 하고,
    //    값을 변경할 수 없어야 한다.
    //    규칙은 변경되어서는 안되기 때문에 값은 무조건 상수이다.
    public static final float PI = 3.14159f;
    
    // => public 을 생략할 수 있다.
    static final int AA = 100;
    
    // => static 을 생략할 수 있다.
    final int BB = 200;
    
    // => final을 생략할 수 있다.
    int CC = 300;
    
    // => 생략하면 컴파일러가 자동으로 public static final을 붙인다.
    //    즉 위의 CC 필드는 다음과 같다.
    //
    //public static final int CC = 300;
    
    // => protected 또는 private? 
    //private int DD = 400; // 컴파일 오류! 왜? 규칙은 공개되야 하니까!
    
}







