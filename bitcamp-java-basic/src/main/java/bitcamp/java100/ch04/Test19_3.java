// ## import - import를 여러 개 사용하기
// - import의 용도와 사용법을 알아보자!
//

package bitcamp.java100.ch04;

// 패키지 정보를 알려야 하는 클래스는 무조건 import를 선언하면 된다.
import java.util.ArrayList; 
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.net.Socket;
import java.net.ServerSocket;
import java.net.URL;

// 클래스를 사용하기 위해 import를 추가한다고 해서
// 컴파일된 .class 파일이 커지지 않는다.

public class Test19_3 {
    public static void main(String[] args) {
        ArrayList<String> list;
        HashSet<String> set;
        HashMap<String,Object> map;
        
        File f;
        FileInputStream in;
        FileOutputStream out;
        
        Socket s;
        ServerSocket ss;
        URL url;
    }
}











