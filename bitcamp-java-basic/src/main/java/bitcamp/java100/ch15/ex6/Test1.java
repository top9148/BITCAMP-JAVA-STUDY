// 프로그램 아규먼트와 VM 아규먼트
// 1) 프로그램 아규먼트
//    - 자바 프로그램을 실행할 때 main()에 넘겨주는 값
//    - String 배열로 생성되어 main()의 파라미터로 전달된다.
// 
// 2) VM 아규먼트 
//    - 자바 프로그램을 실행할 때 JVM에 넘겨주는 값
//    - VM 프로퍼티 객체에 보관된다. 
// 
// 3) 전달 방법
//    > java -cp bin -D변수명=값 -D변수명=값 ...Test1 값1 값2 값3
// => -D 옵션으로 넘겨주는 값을 "VM 아규먼트"라 부른다.
// => 클래스 이름 다음에 넘겨주는 값을 "프로그램 아규먼트"라 부른다.
//
package bitcamp.java100.ch15.ex6;

import java.util.Properties;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {
        // 실행 예)
        // java -cp bin -Daaa=111 -Dbbb=222 ...Test1 xxx yyy zzz
        // 
        // 프로그램 아규먼트 추출하기
        // - 프로그램 아규먼트 값이 없으면 빈 배열이 넘어온다. 
        //   null이 아니다!
        System.out.println("---------------------------");
        for (String value : args) {
            System.out.println(value);
        }
        
        // VM 아규먼트 추출하기
        System.out.println("---------------------------");
        System.out.println(System.getProperty("aaa"));
        System.out.println(System.getProperty("bbb"));

        // VM에 설정된 모든 프로퍼티 값 출력하기
        System.out.println("---------------------------");
        Properties props = System.getProperties();
        Set<Object> keySet = props.keySet();
        for (Object key : keySet) {
            System.out.printf("%s=%s\n", key, props.get(key));
        }
    }

}








