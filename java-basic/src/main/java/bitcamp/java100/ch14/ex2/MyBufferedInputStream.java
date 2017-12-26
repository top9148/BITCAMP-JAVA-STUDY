package bitcamp.java100.ch14.ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyBufferedInputStream extends FileInputStream {

    byte[] buf = new byte[8192];
    int len; // 버퍼에 저장한 바이트 개수
    int cursor; // 버퍼에서 읽을 바이트 위치
    
    public MyBufferedInputStream(String name) throws FileNotFoundException {
        super(name);
    }
    
    @Override
    public int read() throws IOException {
        if (cursor >= len) { // 버퍼가 비었으면 다시 버퍼를 채운다.
            cursor = 0; // 커서는 다시 0으로 초기화시킨다.
            len = this.read(buf);
            if (len == -1) // 파일에서 읽을 데이터가 없다면 
                return -1;
        }
        
        return buf[cursor++] & 0x000000FF;
    }
    
    

    

}
