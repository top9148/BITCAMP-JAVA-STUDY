// 중첩 클래스(nested class)
// => 특정 클래스에서만 사용되는 클래스라면 
//    굳이 공개할 필요가 없다.
// => 다른 개발자가 알 필요가 없는 것을 괜히 패키지 멤버 클래스로 공개하는 것은
//    유지보수에 도움이 안된다.
// => 가능한 쓸데없이 공개하지 말고 필요한 것만 공개하는 것이
//    소스 코드를 더 관리하기 쉽게 만든다.
// => 이런 것을 기준으로 
//    특정 클래스 안에서만 사용되는 클래스는 
//    오직 그 클래스만 사용하도록 제약을 가하는 게 유지보수에 좋다.
//
// => 이렇게 패키지가 아닌 클래스에 소속된 클래스를 "nested class"라 부른다.
// 
package bitcamp.java100.ch10.ex1;

public class Test2 {
    // static nested class
    // => 인스턴스 없이 바깥 클래스의 이름만으로 사용할 수 있는 중첩 클래스.
    static class A {}
    
    // non-static nested class = inner class
    // => 인스턴스가 있어야만 사용할 수 있는 nested class
    class B {}
    
    
    // 익명 클래스
    // => 클래스의 이름이 없어 클래스를 정의하는 동시에 
    //    인스턴스를 바로 생성하는 클래스를 말한다.
    Object obj = new Object() {
        String name;
        public void m1() {}
    };
    
    public static void main(String[] args) {
        
        // 로컬 클래스
        // => 특정 메서드에서만 사용하도록 메서드 안에 정의된 클래스.
        class C {}
        
        // 익명 클래스는 메서드 안에서도 정의할 수 있다.
        Object obj2 = new Object() {
            String name;
            public void m1() {}
        };
                
    }

}






