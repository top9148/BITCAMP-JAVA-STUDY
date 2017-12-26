// 자바에서 제공하는 BufferedOutputStream 사용
//

package bitcamp.java100.ch14.ex2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Test2_6 {
    public static void main(String[] args) throws Exception {
        
        // 데이터 준비 
        // => 랜덤 메서드를 사용하여 임의의 값을 400만개를 준비한다.
        int[] data = new int[4000000];
        
        for (int i = 0; i < data.length; i++) {
            data[i] = (int)(Math.random() * 100000);
        }
        
        // 파일에 출력할 객체 생성
        FileOutputStream out = new FileOutputStream("./test3.dat");
        
        // 중간에서 버퍼 기능을 제공할 객체 생성
        // 실제 출력하는 일은 위에서 생성한 FileOutputStream이 할 것이다.
        BufferedOutputStream out2 = new BufferedOutputStream(out);
        
        // 4백만개의 데이터를 출력해보고, 걸린 시간을 알아보자!
        
        long start = System.currentTimeMillis();
        
        for (int b : data) {
            out2.write(b);
        }
        
        // 버퍼에 남은 마지막 찌끄러기 출력하기
        out2.flush();
        
        long end = System.currentTimeMillis();
        System.out.printf("걸린시간 = %d\n", end - start);
        
        out.close();
        
    }
}

// BufferedOutputStream
// => 중간에서 출력할 데이터를 버퍼에 보관하고 있다가
//    버퍼가 차면 출력 객체를 통해 출력하는 일을 한다.
// => 이렇게 중간에서 가공하는 일을 하는 클래스를
//    "Data Processing Stream Class"라고 부른다.
// => 데코레이터 패턴에서 "데코레이터(Decorator)" 역할을 수행한다.
// 





