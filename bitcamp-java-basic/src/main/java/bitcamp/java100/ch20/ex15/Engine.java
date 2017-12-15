package bitcamp.java100.ch20.ex15;

import org.springframework.stereotype.Component;

@Component("bitengine") // 스프링 IoC 컨테이너에게 이 클래스의 객체를 만들어 달라고 요청!
public class Engine {
    private String name;
    private int valve;
    private int cc;
    
    public Engine() {
        System.out.println("Engine()");
    }
    
    @Override
    public String toString() {
        return "Engine [name=" + name + ", valve=" + valve + ", cc=" + cc + "]";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getValve() {
        return valve;
    }
    public void setValve(int valve) {
        this.valve = valve;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }
    
    
}
