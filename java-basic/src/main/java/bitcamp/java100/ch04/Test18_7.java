// ## StringBuffer 클래스 사용법 - 원본 문자열 변경하기  
// - StringBuffer를 사용하여 원본 문자열을 변경하는 방법을 알아보자!
//

package bitcamp.java100.ch04;

public class Test18_7 {

    public static void main(String[] args) throws Exception {
        // Immutable 객체
        // > 한 번 값이 설정되면 메모리의 값을 바꿀 수 없는 객체
        String s1 = "Hello!";
        
        // > 값을 변경하기 위해 메서드를 호출하면 새로운 String 객체를 생성한다.
        String s2 = s1.replace("l", "x");
        
        System.out.println(s1);
        System.out.println(s2);
        
        // Mutable 객체
        // > 메모리의 값을 변경할 수 있는 객체
        StringBuffer sb1 = new StringBuffer("Hello!");
        
        // append(추가할 문자열)
        // > 원본 문자열 뒤에 문자열을 덧붙인다. 
        // > 값을 변경하면 진짜 원본 값이 변경된다.
        sb1.append(" World!");
        System.out.println(sb1);
        
        // replace(시작, 끝, "대체문자열")
        // > 원본 문자열에서 시작에서 끝 바로 전까지의 문자열을 다른 문자열로 대체한다.
        sb1.replace(2, 4, "xx");
        System.out.println(sb1);
        
        
    }
    
}











