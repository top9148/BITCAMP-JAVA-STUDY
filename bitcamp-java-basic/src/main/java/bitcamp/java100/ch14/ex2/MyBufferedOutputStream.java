package bitcamp.java100.ch14.ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 상속을 이용한 기능 확장
public class MyBufferedOutputStream extends FileOutputStream {
    
    // 출력할 데이터를 모아두는 버퍼
    byte[] buf = new byte[8192];
    int len; // 버퍼에 저장한 개수
    int cursor; // 저장할 위치
    
    public MyBufferedOutputStream(String path) throws FileNotFoundException {
        super(path);
    }
    
    @Override
    public void write(int b) throws IOException {
        if (cursor == buf.length) { // 버퍼가 꽉 찼다면
            this.write(buf); // 버퍼의 내용을 파일로 출력한다.
            cursor = 0;
        }
        
        buf[cursor++] = (byte)b;
    }
    
    @Override
    public void flush() throws IOException {
        // 버퍼에 남아있는 데이터를 마저 출력한다.
        this.write(buf, 0, cursor);
        cursor = 0;
    }
}









