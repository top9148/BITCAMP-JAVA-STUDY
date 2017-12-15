package bitcamp.java100.ch06.ex2;

import java.io.Console;

public class MessageBox {
    static boolean confirm(String message) {
        Console console = System.console(); // 현재 JVM의 콘솔 객체를 리턴한다.
        
        String response = console.readLine(message).toLowerCase();
        if (response.equals("y") || response.equals("yes")) {
            return true;
        }
        return false;
    }
}
