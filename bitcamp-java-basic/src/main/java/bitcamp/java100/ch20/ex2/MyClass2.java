package bitcamp.java100.ch20.ex2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class MyClass2 {
    public MyClass2() {
        System.out.println("=> MyClass2()");
    }

    public MyClass2(int age) {
        System.out.println("=> MyClass2(int)");
    }
    
    public MyClass2(String name) {
        System.out.println("=> MyClass2(String)");
    }
    
    public MyClass2(int age, String name) {
        System.out.println("=> MyClass2(int,String)");
    }
    
    public MyClass2(String name, int age) {
        System.out.println("=> MyClass2(String,int)");
    }
    
    public MyClass2(String name, int age, boolean working) {
        System.out.println("=> MyClass2(String,int,boolean)");
    }
    
    public static void main(String[] args) throws Exception {
        Constructor<?> c = 
                MyClass2.class.getConstructor(int.class, String.class);
        System.out.println(c.getName());
        
        Parameter[] params = c.getParameters();
        for (Parameter p : params) {
            System.out.println(p.getName());
        }
    }
    
}









