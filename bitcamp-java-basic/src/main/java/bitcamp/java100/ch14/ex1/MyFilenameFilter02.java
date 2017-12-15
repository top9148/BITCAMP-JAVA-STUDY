package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter02 implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        // 이 메서드는 list() 또는 listFiles() 에서 호출한다.
        // 디렉토리에 들어있는 각 파일에 대해 이 메서드를 호출하여
        // 리턴 값에 포함시킬지 여부를 묻는 것이다.
        // true를 리턴하면 그 파일을 리턴 배열에 포함시키고,
        // false를 리턴하면 리턴 배열에 포함시키지 않는다.
        
        // 모든 파일이나 디렉토리에 대해 리턴 배열에 포함시킨다.
        // => 파라미터에 넘어오는 값이 뭔지 알아보자!
        try {
            System.out.print(dir.getCanonicalPath() + ",");
            System.out.println(name);
        } catch (Exception e) {}
        
        return true;
    }

}




