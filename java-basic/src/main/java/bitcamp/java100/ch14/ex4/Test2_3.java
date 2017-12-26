// 데이터 프로세싱 스트림 클래스 사용법 - ObjectInputStream 사용하기
// 
package bitcamp.java100.ch14.ex4;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test2_3 {
    public static void main(String[] args) throws Exception {
        
        ObjectInputStream in = new ObjectInputStream(
                                    new FileInputStream("test3.dat"));
        
        Score4 s = (Score4)in.readObject(); 
        in.close();

        // serialize 데이터를 읽으면 sum과 aver 필드의 값은 비어 있다.
        System.out.println(s);
        
        // 인스턴스를 사용하기 전에 sum과 aver 필드의 값을 
        // 계산해야 한다.
        // 이렇게 기존 필드의 값을 가지고 계산하는 필드는
        // 데이터를 읽은 다음에 명시적으로 계산하는 것이
        // 데이터의 오류를 줄이는 방법이다.
        // 즉 국,영,수 점수는 그대로 둔 채로 
        // 합계와 평균을 조작하는 것을 막을 수 있다.
        // 
        s.compute();
        System.out.println(s);
    }
}











