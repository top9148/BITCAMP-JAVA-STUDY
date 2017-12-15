// File System 다루기 : 디렉토리 내용 알아내기 I
package bitcamp.java100.ch14.ex1;

import java.io.File;

public class Test3 {

    public static void main(String[] args) {
        
        File file = new File(".");

        // File 객체에서 지정한 경로가 디렉토리일 경우, 
        // 그 디렉토리 안에 있는 파일이나 디렉토리 이름을 이름을 리턴.
        // 만약 디렉토리가 아닐 경우, null을 리턴.
        String[] files = file.list();
        
        for (String name : files) {
            System.out.println(name);
        }
    }

}






