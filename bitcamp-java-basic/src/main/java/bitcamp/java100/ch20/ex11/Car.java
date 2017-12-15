package bitcamp.java100.ch20.ex11;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
    private String model;
    private String color;
    private int capacity;
    private Engine engine;
    private Map<String,String> options;
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", color=" + color + ", capacity=" + capacity + ", engine=" + engine
                + ", options=" + options + "]";
    }

    public Car() {
        System.out.println("Car()");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
        System.out.println("setModel()");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("setColor()");
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        System.out.println("setCapacity()");
    }

    public Engine getEngine() {
        return engine;
    }

    @Autowired
    // 여러 엔진 중에서 어떤 엔진을 꼽을 지 결정해야 한다.
    @Qualifier("e2")
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("setEngine()");
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
        System.out.println("setOptions()");
    }
}
