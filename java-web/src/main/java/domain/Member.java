package domain;

public class Member {
    String name;
    int age;
    boolean working;
    
    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + ", working=" + working + "]";
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
