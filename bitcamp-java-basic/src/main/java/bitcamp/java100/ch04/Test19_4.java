// ## import - import와 wildcard 
// - import의 용도와 사용법을 알아보자!
//

package bitcamp.java100.ch04;

// import를 선언할 때 와일드카드(*)로 선언하면
// 클래스 이름까지 자세하게 적을 필요가 없어 편리하다.
import java.util.*;
import java.io.*;
import java.net.*;

// 단 클래스가 어떤 패키지에 소속되어 있는지 널리 알려진 경우에는 괜찮지만,
// 잘 알려진 클래스가 아닌 경우에는 오히려 그 클래스가 어떤 패키지인지 
// 확인할 수 없어서 코드를 해석하기 어렵게 만든다.
//
// 그래서 실무에서는 가능한 와일드카드 사용을 자제한다.


public class Test19_4 {
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











