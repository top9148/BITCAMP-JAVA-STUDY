package bitcamp.java100.ch20.ex10;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

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

    // required의 기본 값이 true이다.
    // 따라서 의존 객체가 없다면 셋터를 호출할 수 없기 때문에 
    // Car 객체 생성 오류가 발생한다.
    // 선택사항으로 바꾸고 싶다면,
    // false로 설정하라!
    @Autowired(required=false)
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
