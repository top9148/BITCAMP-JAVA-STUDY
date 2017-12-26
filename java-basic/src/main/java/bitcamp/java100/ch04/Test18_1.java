// ## String 클래스 사용법 - String 인스턴스 생성
// - 개발자가 문자열을 쉽게 다룰 수 있도록 자바에게 기본으로 제공하는 부품이다.
// - 문자열을 저장하려면 char 배열이 필요한데,
//   개발자가 직접 char 배열을 다루는 것이 아니라
//   String 클래스에서 제공해주는 메서드를 사용하여 char 배열 메모리를 다룬다.
//

package bitcamp.java100.ch04;

public class Test18_1 {

    public static void main(String[] args) {
// String 클래스를 가지고 문자열 배열을 만들기
        // 1) String 메모리의 주소를 저장할 레퍼런스 선언
        String s1;
        
        // 2) 문자열을 저장할 메모리 준비
        s1 = new String("ABC가각간");
        
        // 내부적으로 'A', 'B', 'C', '가', '각', '간'의 문자 코드 값을 저장하는
        // 배열이 생성된다. 그리고 그 배열에 각 문자의 유니코드 값이 저장된다.
        // String 클래스의 소스 파일을 확인해보라!
        // - java1.8 이하 = char[] 배열에 문자열을 저장한다.
        // - java9 부터 = byte[] 배열에 문자열을 저장한다.
        //
        // new 연산자로 String 인스턴스를 만들 때는 Heap 메모리에 인스턴스가 생성된다.
        // 
        
        String s2 = new String("ABC가각간");
        
        if (s1 != s2) // 인스턴스가 다르기 때문에 주소도 다르다. 
            System.out.println("s1 != s2");
        
    }
    
}











