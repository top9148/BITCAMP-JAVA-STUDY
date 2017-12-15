// File System 다루기 : 디렉토리 내용 알아내기 II
package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.sql.Date;

public class Test4 {

    public static void main(String[] args) {
        
        File file = new File(".");

        // list()는 단순히 파일이나 디렉토리 이름을 리턴한다.
        // 좀 더 자세한 정보를 리턴 받고 싶다면 다음 메서드를 호출하라!
        // 리턴하는 것은 파일 정보를 담은 File들의 배열이다.
        //
        File[] files = file.listFiles();
        
        for (File f : files) {
            System.out.printf("%s %10d %s %s\n",
                f.isDirectory() ? "d" : "-",
                f.length(),
                new Date(f.lastModified()).toString(),
                f.getName());
        }
    }

}






