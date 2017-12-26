package bitcamp.java100.ch20.ex2;

public class MyClass {
    public MyClass() {
        System.out.println("=> MyClass()");
    }

    public MyClass(int p1) {
        System.out.println("=> MyClass(int)");
    }
    
    public MyClass(String p1) {
        System.out.println("=> MyClass(String)");
    }
    
    public MyClass(int p1, String p2) {
        System.out.println("=> MyClass(int,String)");
    }
    
    public MyClass(String p1, int p2) {
        System.out.println("=> MyClass(String,int)");
    }
    
}
