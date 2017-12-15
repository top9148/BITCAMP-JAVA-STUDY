package bitcamp.java100.ch14.ex3;

import java.io.IOException;
import java.io.InputStream;

public class MyDataInputStream {
    
    InputStream worker;
    
    public MyDataInputStream(InputStream worker) {
        this.worker = worker;
    }
    
    public String readUTF() throws IOException {
        
        // 2 byte => 문자열 바이트의 개수
        int len = worker.read() << 8 | worker.read() ;
        
        // len 개수의 바이트 배열 => UTF-8로 인코딩된 문자열의 바이트 배열.
        byte[] bytes = new byte[len];
        worker.read(bytes);
        
        return new String(bytes, "UTF-8");
    }
    
    public int readInt() throws IOException {
        return (worker.read() << 24) | 
                (worker.read() << 16) | 
                (worker.read() << 8) |
                worker.read();
    }
}










