package bitcamp.java100.ch21.ex5.proxy1;

public class CalculatorProxy implements Calculator {

    Calculator realWorker = new CalculatorImpl();
    
    @Override
    public int plus(int a, int b) {
        return realWorker.plus(a, b);
    }

    @Override
    public int minus(int a, int b) {
        return realWorker.minus(a, b);
    }

}
