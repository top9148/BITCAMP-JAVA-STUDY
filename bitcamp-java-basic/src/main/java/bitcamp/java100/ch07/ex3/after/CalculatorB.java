package bitcamp.java100.ch07.ex3.after;

public class CalculatorB extends Calculator {
    
    CalculatorB(int value) {
        this.result = value;
    }
    
    void remainder(int value) {
        this.result %= value;
    }
}
