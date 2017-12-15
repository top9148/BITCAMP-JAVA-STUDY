// 데이터 프로세싱 스트림 클래스 사용법 - ObjectOutputStream 사용하기
// 
package bitcamp.java100.ch14.ex4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_0 {
    public static void main(String[] args) throws Exception {
        
        Score s = new Score("홍길동", 800, 900, 1000);
        
        // ObjectOutputStream 클래스를 사용하여 인스턴스 변수의 값을 
        // 출력해보자!
        ObjectOutputStream out = new ObjectOutputStream(
                                    new FileOutputStream("test0.dat"));
        
        // ObjectOutputStream은 인스턴스 변수의 값을 
        // 바이트 배열로 만들어 출력한다.
        // => "직렬화(serialization)"이라 부른다.
        // 
        // 조건
        // => serialization을 허락해야만 직렬화를 수행할 수 있다.
        //
        // 허락하는 방법?
        // => 클래스 선언부에 java.io.Serializable 규칙을 따른다고 선언!
        //
        out.writeObject(s); // Score 클래스는 직렬화를 허락하지 않았기 
                            // 때문에 실행 오류가 발생한다!
        
        out.close();
        
        System.out.println("출력을 완료했습니다.");
    }
}











