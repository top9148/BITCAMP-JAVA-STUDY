package java100.app;

import java.util.Scanner;

public class Prompts {
    static Scanner keyScan = new Scanner(System.in);
    
    // 이들 메서드는 별도의 인스턴스 변수를 사용하지 않기 때문에
    // 클래스 메서드(스태틱 메서드)로 둔다.
    // 외부에서 사용할 메서드이기 때문에 완전 공개한다.
    public static String input(String message) {
        System.out.print(message);
        return keyScan.nextLine();
    }
    
    public static boolean confirm(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();
        
        if (response.equals("y") || 
                response.equals("yes") || 
                response.equals("")) {
            return true;
        }
        return false;
    }
    
    public static boolean confirm2(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();
        
        if (response.equals("n") || 
                response.equals("no") || 
                response.equals("")) {
            return false;
        }
        return true;
    }
}
