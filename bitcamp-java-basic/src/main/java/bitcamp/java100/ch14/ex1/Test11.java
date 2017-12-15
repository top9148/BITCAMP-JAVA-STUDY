// 현재 폴더 및 하위 폴더를 모두 포함하여
// .class 파일을 찾아 파일명을 출력하라!
package bitcamp.java100.ch14.ex1;

import java.io.File;

public class Test11 {
 
    public static void main(String[] args) throws Exception {
        File file = new File(".");

        printFiles(file);
    }
    
    static void printFiles(File dir) throws Exception {
        File[] files = dir.listFiles();
        
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                System.out.println(f.getName());
            }
            if (f.isDirectory()) {
                printFiles(f);
            }
        }
    }

}



