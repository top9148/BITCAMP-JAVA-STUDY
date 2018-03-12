package bitcamp.java100.ch21.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Front {

    @Autowired X x;
    @Autowired Y y;
    @Autowired Z z;
    
    public void test() {
        System.out.println("Font.test() 호출시작-----");
        x.m1();
        y.m1();
        z.m2();
        System.out.println("Font.test() 호출 끝-----");
    }

}
