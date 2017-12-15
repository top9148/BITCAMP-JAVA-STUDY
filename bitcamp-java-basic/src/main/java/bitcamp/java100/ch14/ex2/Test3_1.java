// Byte 스트림 응용 => 파일 복사하기 - 버퍼 적용 전
//

package bitcamp.java100.ch14.ex2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test3_1 {
    public static void main(String[] args) throws Exception {
        
        // 1) 바이트 단위로 데이터를 읽어주는 객체 준비
        FileInputStream in = new FileInputStream(
                                    new File("sample/jls9.pdf"));
        
        // 2) 바이트 단위로 데이터를 출력할 객체 준비
        FileOutputStream out = new FileOutputStream(
                                    new File("sample/jls9-2.pdf"));
                
        
        // 3) 바이트를 읽어서 그대로 출력한다.
        int b; 
        
        long start = System.currentTimeMillis();
        
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        
        long end = System.currentTimeMillis();
        System.out.printf("걸린시간 = %d\n", end - start);
        
        // 4) 항상 사용을 마친 자원은 해제시킨다.
        in.close();
        out.close();
        
        System.out.println("파일 복사 완료했음!");
    }
}






