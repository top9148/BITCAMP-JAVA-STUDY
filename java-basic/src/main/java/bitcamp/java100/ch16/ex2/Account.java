package bitcamp.java100.ch16.ex2;

public class Account {
    long balance;
    
    public long deposit(long money) {
        long temp = this.balance;
        temp += money;
        this.balance = temp;
        return this.balance;
    }
    
    public long withdraw(long money) {
        long temp = this.balance;
        delay();
        
        if ((temp - money) < 0)
            return 0;
        delay();
        
        temp -= money;
        delay();
        
        this.balance = temp;
        delay();
        
        return money;
    }
    
    // 이 메서드를 호출하여 밍기적 거리는 동안 다른 스레드에게
    // CPU 사용권을 뺏기도록 한다.
    private void delay() {
        double value = 1;
        for (int i = 0; i < 10; i++) {
            value *= Math.random();
        }
    }
}







