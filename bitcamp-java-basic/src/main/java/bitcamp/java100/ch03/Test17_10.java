// ## 메서드 - 메서드 호출
// - 메서드가 호출되고 리턴되는 과정을 살펴보자!
//

package bitcamp.java100.ch03;

public class Test17_10 {

    static void m1() {
        System.out.println("m1() --->");
        m2();
        System.out.println("m1() <---");
        
    }
    
    static void m2() {
        System.out.println("    m2() --->");
        m3();
        System.out.println("    m2() <---");
        
    }
    
    static void m3() {
        System.out.println("        m3() --->");
        m4();
        System.out.println("        m3() <---");
        
    }
    
    static void m4() {
        System.out.println("            m4()...");
    }
    
    
    // Eclipse IDE에 있는 디버그 기능을 이용하여 메서드가 호출되는 과정을 추적해보자!
    public static void main(String[] args) {
        System.out.println("main()===> ");
        m1();
        System.out.println("main()<===");
    }
}














