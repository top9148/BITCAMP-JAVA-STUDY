// File System 다루기 : 필터 사용
package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Test5_4 {

    public static void main(String[] args) {
        // .으로 시작하는 파일이나 디렉토리만 결과에 포함시킨다.
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.startsWith("."))
                    return true;
                else 
                    return false;
            }
        };
        
        File file = new File(".");

        // 디렉토리에 들어 있는 파일이나 디렉토리 이름을 알아낼 때 
        // 특정 조건에 부합하는 이름만 꺼내고 싶을 때가 있다.
        // 그럴 때 list()의 파라미터로 필터 기능을 수행하는 객체를 
        // 전달하라! 이름을 꺼낼 때 그 필터를 사용하여
        // 리턴하는 배열에 포함할지 여부를 결정한다.
        //
        // ver 4: list()에서 사용할 필터 클래스를 익명 클래스로 만든다.
        // => 오직 한 개의 객체만 생성할 클래스라면 익명 클래스로 
        //    만들어도 된다.
        String[] filenames = file.list(filter);
        
        for (String name : filenames) {
            System.out.println(name);
        }
    }

}






