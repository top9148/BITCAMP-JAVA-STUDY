// 파일 읽기: FileInputStream 사용법

package bitcamp.java100.ch14.ex2;

import java.io.FileInputStream;

public class Test1_1 {
    public static void main(String[] args) throws Exception {
        // => 문자열로 파일 경로를 생성자에 바로 넘길 수 있다.
        FileInputStream in = new FileInputStream("sample/a.jpg");
        
        int b; 
        
        int count = 0;
        while ((b = in.read()) != -1) {
            count++;
        }
        System.out.println(count);
        
        in.close();
    }
}





