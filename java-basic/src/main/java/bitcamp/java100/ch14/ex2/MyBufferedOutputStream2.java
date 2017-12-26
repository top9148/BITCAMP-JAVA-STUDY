package bitcamp.java100.ch14.ex2;

import java.io.IOException;
import java.io.OutputStream;

// 상속이 아닌 위임을 이용한 기능 확장
public class MyBufferedOutputStream2 {
    
    // 실제 출력하는 일을 할 객체 보관
    OutputStream worker;
    
    // 출력할 데이터를 모아두는 버퍼
    byte[] buf = new byte[8192];
    int len; // 버퍼에 저장한 개수
    int cursor; // 저장할 위치
    
    public MyBufferedOutputStream2(OutputStream worker) {
        this.worker = worker;
    }
    
    public void write(int b) throws IOException {
        if (cursor == buf.length) { // 버퍼가 꽉 찼다면
            worker.write(buf); // 버퍼의 내용을 파일로 출력한다.
            cursor = 0;
        }
        
        buf[cursor++] = (byte)b;
    }
    
    public void flush() throws IOException {
        // 버퍼에 남아있는 데이터를 마저 출력한다.
        worker.write(buf, 0, cursor);
        cursor = 0;
    }
}









