// ## String 클래스 사용법 - String 인스턴스의 암시적 생성과 명시적 생성 
// - String 인스턴스를 암시적으로 만드는 것과 명시적으로 만드는 것의 차이점을 이해하자!
//

package bitcamp.java100.ch04;

public class Test18_3 {

    public static void main(String[] args) {
        // 문자열 리터럴로 String 인스턴스를 암시적으로 생성하기
        // => contants pool 에 생성된다.
        String s1 = "ABC가각간";
        String s2 = "ABC가각간";
        String s3 = "ABC가각간";
        
        // String 인스턴스를 명시적으로 생성하기
        // => heap에 생성된다.
        String s4 = new String("ABC가각간");
        String s5 = new String("ABC가각간");
        String s6 = new String("ABC가각간");
        
        // 인스턴스의 주소를 확인해보자!
        if (s1 == s2) System.out.println("s1 == s2");
        if (s1 == s3) System.out.println("s1 == s3");
        
        if (s1 != s4) System.out.println("s1 != s4");
        if (s1 != s5) System.out.println("s1 != s5");
        if (s1 != s6) System.out.println("s1 != s6");
        
        if (s4 != s5) System.out.println("s4 != s5");
        if (s4 != s6) System.out.println("s4 != s6");
        if (s5 != s6) System.out.println("s5 != s6");
        
        if (s1 == "ABC가각간") System.out.println("s1 == ABC가각간");
        if (s4 != "ABC가각간") System.out.println("s4 != ABC가각간");
    }
    
}











