package bitcamp.java100.ch20.ex11;

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
