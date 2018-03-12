package bitcamp.java100.ch21.ex5.proxy2.server;

import bitcamp.java100.ch21.ex5.proxy2.Calculator;

public class CalculatorObject implements Calculator {

    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

}
