package bitcamp.java100.ch14.ex3;

import java.io.IOException;
import java.io.OutputStream;

public class MyDataOutputStream {
    
    OutputStream worker;
    
    public MyDataOutputStream(OutputStream worker) {
        this.worker = worker;
    }
    
    public void writeUTF(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");

        // 문자열의 바이트 개수는 2바이트로 표현하자.
        worker.write(bytes.length >> 8); // length = 0x -- 00 00 00 | 09
        worker.write(bytes.length);      // length = 0x 00 00 00 09 |
        worker.write(bytes); 
    }
    
    public void writeInt(int value) throws IOException {
        worker.write(value >> 24); // 0x -- -- -- 00 | 00 03 20
        worker.write(value >> 16); // 0x -- -- 00 00 | 03 20
        worker.write(value >> 8 ); // 0x -- 00 00 03 | 20
        worker.write(value);       // 0x 00 00 03 20 |
    }
}






