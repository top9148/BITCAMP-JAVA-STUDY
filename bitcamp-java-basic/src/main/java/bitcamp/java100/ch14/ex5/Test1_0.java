// FileInputStream과 FileReader의 차이점
package bitcamp.java100.ch14.ex5;

import java.io.FileInputStream;

public class Test1_0 {

    public static void main(String[] args) throws Exception {
        // FileInputStream 
        // => 바이너리 데이터를 읽을 때 사용한다.
        // => read()를 호출하면 1바이트를 읽어 리턴한다.
        
        FileInputStream in = new FileInputStream("test.txt");

        int b;
        
        while ((b = in.read()) != -1) {
            System.out.println(Integer.toHexString(b));
        }
        
        in.close();
    }

}







