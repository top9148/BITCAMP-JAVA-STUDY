package bitcamp.java100.ch18;

public class X {
    String name;
    int age;
    
    @Override
    public String toString() {
        return "X [name=" + name + ", age=" + age + "]";
    }

    public X() {
        System.out.println("X() 호출됨!");
    }
    
    public X(int age) {
        System.out.println("X(int) 호출됨!");
        this.age = age;
    }
    
    public X(String name) {
        System.out.println("X(String) 호출됨!");
        this.name = name;
    }
    
    public X(String name, int age) {
        System.out.println("X(String,int) 호출됨!");
        this.name = name;
        this.age = age;
    }
    
    public void m() {
        System.out.println("m() 호출됨");
    }
    
    public void m(int a) {
        System.out.println("m(int) 호출됨");
    }
    
    public void m(int a, String b) {
        System.out.println("m(int,String) 호출됨");
    }
    
    public static void m2() {
        System.out.println("X.m2() 호출됨");
    }
    
    public static void m2(int a) {
        System.out.println("X.m2(int) 호출됨");
    }
}












