// 다형성 - 오버라이딩할 때 접근 제어의 확장 및 축소 
package bitcamp.java100.ch08.ex7;

public class A3 extends A {
    
    // 접근 범위를 확장하기
    // default ==> protected
    protected void m2() {} // OK!
    
    // default ==> public 
    //public void m2() {} // OK!
    
    // protected ==> public 
    public void m3() {} // OK!
    
    // 접근 범위 축소
    // => 오버라이딩 할 때 상속 받은 메서드의 접근 범위를 확장할 순 있어도, 줄일 순 없다.
    // 
    // default ==> private 
    //private void m2() {} // 컴파일 오류!
    
    // protected ==> (default) 
    //void m3() {} // 컴파일 오류!
    
    // public ==> protected
    //protected void m4() {} // 컴파일 오류!
    
    // public ==> (default)
    //void m4() {} // 컴파일 오류!
}













