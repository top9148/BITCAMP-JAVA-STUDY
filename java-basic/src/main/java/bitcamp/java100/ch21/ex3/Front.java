package bitcamp.java100.ch21.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Front {

    @Autowired X x;
    
    public void test(String name) {
        System.out.println("Font.test() 호출시작-----");
        try {
            String str = x.m1(name);
            System.out.println(str);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Font.test() 호출 끝-----");
    }

}
