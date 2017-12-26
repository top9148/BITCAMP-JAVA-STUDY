// 데이터 프로세싱 스트림 클래스 사용법 - ObjectOutputStream 사용하기
// 
package bitcamp.java100.ch14.ex4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_1 {
    public static void main(String[] args) throws Exception {
        
        Score2 s = new Score2("홍길동", 800, 900, 1000);
        
        // ObjectOutputStream 클래스를 사용하여 인스턴스 변수의 값을 
        // 출력해보자!
        ObjectOutputStream out = new ObjectOutputStream(
                                    new FileOutputStream("test1.dat"));
        
        // Score2 클래스는 Serializable 인터페이스를 구현하였다.
        // => 인스턴스 변수의 값을 바이트 배열로 만들로 출력하도록 
        //    허락한 클래스이다.
        // 그래서 다음 메서드를 사용하여 인스턴스 값을 출력할 수 있다.
        // 
        // 출력할 때 인스턴스 변수의 값만 출력하는 것이 아니라,
        // 출력 데이터가 어떤 클래스의 인스턴스 값인지 그 정보도 
        // 함께 출력한다.
        // 
        // 출력데이터 = 클래스 정보 + 인스턴스 변수의 값
        // 
        out.writeObject(s); // 출력 OK!
        
        out.close();
        
        System.out.println("출력을 완료했습니다.");
    }
}











