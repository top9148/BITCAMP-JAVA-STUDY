// 파일 읽기: FileInputStream 사용법 - 버퍼 사용 전

package bitcamp.java100.ch14.ex2;

import java.io.FileInputStream;

public class Test1_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("sample/jls9.pdf");
        
        int count = 0;
        int b = 0;
        
        // 읽는데 걸린 시간을 측정하기 위해, 
        // 읽기 시작 시간을 저장한다.
        long start = System.currentTimeMillis();
        
        while ((b = in.read()) != -1) {
            count++;
        }
        
        // 읽은 후 시간을 저장한다.
        long end = System.currentTimeMillis();
        
        // 총 읽은 바이트수를 출력한다.
        System.out.printf("읽은 바이트 수 = %d\n", count);
        System.out.printf("걸린시간 = %d\n", end - start);
        
        in.close();
    }
}





