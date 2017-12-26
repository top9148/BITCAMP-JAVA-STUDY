package java100.app;

import java.util.Scanner;

public class Prompts {
    static Scanner keyScan = new Scanner(System.in);
    
    public static int inputInt(String message, Object...values) {
        System.out.printf(message, values);
        return Integer.parseInt(keyScan.nextLine());
    }
    
    public static String inputString(String message, Object...values) {
        System.out.printf(message, values);
        return keyScan.nextLine();
    }
    
    // 이전에는 숫자를 입력받을 경우를 고려하지 않았기 때문에
    // 문자열을 입력 받는 메서드의 이름을 input()이라 하였다.
    // 그러나 위의 inputInt()와 inputString()처럼 문자열이나 숫자를 
    // 입력받는 메서드를 만들고 보니 다음 input() 메서드가 필요없게 되었다.
    // 하지만 기존 코드에서 이 클래스를 가지고 작업하였기 때문에
    // 지울 수는 없다. 또한 이름을 바꿔서도 안된다.
    // 다만 앞으로 다른 개발자들이 이 메서드를 사용하지 않도록
    // 경고를 해야 한다. 
    // 어떻게? @Deprecated 애노테이션을 붙여라!
    // 그러면 이 메서드를 사용할 때 컴파일러가 경로를 띄울 것이다.
    @Deprecated
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
