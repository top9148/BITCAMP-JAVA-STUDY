// ## String 클래스 사용법 - 문자열 리터럴(literal)로 String 인스턴스 생성
// - literal을 사용하여 암시적으로 String 인스턴스를 생성하는 방법을 알아보자!
//

package bitcamp.java100.ch04;

public class Test18_2 {

    public static void main(String[] args) {
        // 문자열 리터럴로 String 인스턴스 생성하기
        String s1;
        
        s1 = "ABC가각간";
        // 문자열 리터럴을 String 레퍼런스에 대입하면,
        // 자바에서는 자동으로 new String() 명령으로 바꾼다.
        // s1은 레퍼런스이기 때문에 절대로 값이 직접 저장될 수 없다.
        // 단지 주소가 저장될 뿐이다.
        // 위의 s1에 저장된 것은 "ABC가각간" 문자열이 저장된 String 인스턴스의 주소이다.
        //
        //
        // 리터럴(literal)?
        // - 그냥 코드로 바로 적는 값 
        // - 예) 12, 12L, 3.14f, 3.14, true, false, '가'
        
        String s2 = "ABC가각간"; 
        
        if (s1 == s2) // 레퍼런스 s1에 저장된 주소와 s2에 저장된 주소가 같다.
            System.out.println("s1 == s2");
        
        // 이유?
        // - 리터럴을 이용하여 암시적으로 String 인스턴스를 만들 때는
        //   constants pool 이라는 별도의 영역에 인스턴스가 생성된다.
        // - constants pool에서는 중복된 내용의 인스턴스를 생성하지 않는다.
        // - 따라서 s2에 저장된 인스턴스 주소는 s1에서 생성된 
        //   기존의 String 인스턴스 주소이다.
        
    }
    
}











