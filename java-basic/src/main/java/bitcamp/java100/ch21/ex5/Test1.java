// AOP의 구동 원리 
// 
package bitcamp.java100.ch21.ex5;

public class Test1 {

    public static void main(String[] args) {
        
        XProxy xproxy = new XProxy();
        
        Front obj = new Front();
        obj.x = xproxy;
        
        obj.test("홍길동");
        
        System.out.println("------------------------------------------");
        
        obj.test(null); // 예외가 발생하는 경우!
        
    }
}








