package bitcamp.java100.ch20.ex4;

public class Tire {
    String maker;
    String model;
    int width;
    int ratio;
    int inch;
    
    public Tire() {
        System.out.println("Tire()");
    }
    
    @Override
    public String toString() {
        return "Tire [maker=" + maker + ", model=" + model + ", width=" + width + ", ratio=" + ratio + ", inch=" + inch
                + "]";
    }
    
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getRatio() {
        return ratio;
    }
    public void setRatio(int ratio) {
        this.ratio = ratio;
    }
    public int getInch() {
        return inch;
    }
    public void setInch(int inch) {
        this.inch = inch;
    }
    
    
}
