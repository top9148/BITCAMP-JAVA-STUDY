package bitcamp.java100.ch16.ex3;

public class Account {
    long balance;
    
    // 입금 메서드도 여러 스레드가 동시에 진입했을 때 
    // 값이 일치하지 않는 문제가 발생하는 
    // 크리티컬 섹션에 해당된다. 이를 해결하기 위해 
    // 한 번에 한 스레드만이 진입할 수 있도록 
    // 동시화 표시를 한다.
    //
    synchronized public long deposit(long money) {
        long temp = this.balance;
        temp += money;
        this.balance = temp;
        return this.balance;
    }
    
    // 출금 메서드도 입금 메서드와 마찬가지이다.
    //
    synchronized public long withdraw(long money) {
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







