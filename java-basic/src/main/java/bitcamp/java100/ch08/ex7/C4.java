package bitcamp.java100.ch08.ex7;

public class C4 extends C3 {
    @Override
    void m1() {
        System.out.println("C4.m1()");
    }
    
    @Override
    void m2() {
        System.out.println("C4.m2()");
    }
    
    void test1() {
        this.m1(); // 메서드 앞에 this를 주면 현재 클래스부터 메서드를 찾는다.
        super.m1(); // 메서드 앞에 super를 주면 수퍼 클래스부터 메서드를 찾는다.
        //super.super.m1(); // 컴파일 오류! 
                            // 현재 클래스 아니면 수퍼 클래스부터 찾는다.
                            // super 위를 지정할 수 없다.
        this.m2(); // C4.m2()
        super.m2(); // C2.m2()
        
        this.m3(); // C3.m3()
        super.m3(); // C3.m3()
        
        this.m4(); // C.m4()
        super.m4();  // C.m4()
    }
    
    public static void main(String[] args) {
        C4 obj = new C4();
        obj.test1();
    }
}
