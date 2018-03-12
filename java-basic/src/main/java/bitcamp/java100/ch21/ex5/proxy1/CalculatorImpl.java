package bitcamp.java100.ch21.ex5.proxy1;

// 인터페이스 구현체로서 실제 작업을 수행하는 객체
public class CalculatorImpl implements Calculator {

    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

}
