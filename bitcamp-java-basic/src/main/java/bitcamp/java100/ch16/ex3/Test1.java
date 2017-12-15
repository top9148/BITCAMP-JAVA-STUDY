// 동기화가 처리된 경우 멀티 스레딩의 실행 결과 확인하기
package bitcamp.java100.ch16.ex3;

public class Test1 {

    public static void main(String[] args) {
        
        Account account = new Account();
        account.deposit(1000000);
        
        ATM t1 = new ATM("강남", account);
        ATM t2 = new ATM("종로", account);
        ATM t3 = new ATM("부산", account);
        ATM t4 = new ATM("광주", account);
        ATM t5 = new ATM("포항", account);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        // JVM은 모든 스레드가 모두 종료될 때까지 기다린다.
        System.out.println("인출 시작!");
    }
}

// 여러 스레드가 동시에 진입하는 코드 중에서 
// 크리티컬 섹션에 해당하는 메서드에 대해 
// 한 번에 한 스레드만이 접근할 수 있도록 조치를 취했다. 
// 어떻게?
// => 메서드나 특정 블록 앞에 synchronized를 붙이면 된다.











