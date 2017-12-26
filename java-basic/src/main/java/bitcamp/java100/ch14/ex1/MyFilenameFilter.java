package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        // 이 메서드는 list() 또는 listFiles() 에서 호출한다.
        // 디렉토리에 들어있는 각 파일에 대해 이 메서드를 호출하여
        // 리턴 값에 포함시킬지 여부를 묻는 것이다.
        // true를 리턴하면 그 파일을 리턴 배열에 포함시키고,
        // false를 리턴하면 리턴 배열에 포함시키지 않는다.
        
        // 디렉토리 안에 포함된 파일 중에서 디렉토리만 
        // 리턴 배열에 포함시키자!
        
        // 파라미터로 넘어온 이름 만으로 디렉토리 여부를 확인할 수 없다.
        // 그래서 일단 File 객체를 만들어야 한다.
        File file = new File(dir, name);
        if (file.isDirectory())
            return true;
        else 
            return false;
    }

}




