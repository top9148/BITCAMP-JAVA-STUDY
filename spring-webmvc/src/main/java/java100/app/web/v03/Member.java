package java100.app.web.v03;

public class Member {
    String name;
    int age;
    boolean working;
    
    public Member(String name, int age, boolean working) {
        this.name = name;
        this.age = age;
        this.working = working;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isWorking() {
        return working;
    }
    public void setWorking(boolean working) {
        this.working = working;
    }
}
