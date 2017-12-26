// 동기화가 처리되지 않은 경우 멀티 스레딩의 문제점 확인하기
package bitcamp.java100.ch16.ex2;

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

// 실행 결과
// - 계좌에 입금된 것은 1000000원인데, 출금은 그 이상을 하였다.
// - 이유?
//   여러 스레드가 동시에 withdraw()를 호출하여 같은 변수의 값을
//   동시에 변경함으로써 계산 값이 일치하지 않는 문제가 발생한 것이다.
// - 즉 같은 변수를 여러 스레드가 동시에 접근하여 사용하게 되면
//   이런 문제가 흔하게 발생한다.
// - 이렇게 여러 스레드가 동시에 실행하면 문제가 되는 코드를 갖고 있는 경우,
//   "Thread Safe"하지 않은 코드라고 말한다.
//
// "Thread Safe 하다"
// - 여러 스레드가 동시에 실행해도 문제가 없는 코드를 말한다.
// - 여러 스레드가 같은 변수를 접근하더라도 조회만 하는 경우에는
//   "스레드 안전"하다 할 수 있다.
//
// Critical Section(Critical Region)
// - 여러 스레드가 동시에 같은 변수를 접근하여 값을 변경하는 
//   작업을 실행할 때 문제가 되는 코드들을 말한다.
// - 예) Account 클래스에서 deposit()과 withdraw() 메서드가 이에 해당한다.
// 
// 크리티컬 섹션이 있는 경우, 스레드 안전하게 만드려면?
// - 크리티컬 섹션에 오직 한 번에 한 개의 스레드만이 진입하도록 
//   제한을 가해야 한다.
// - 이런 기술에는 "Mutex"와 "Semaphore"가 있다.
//
// 세마포어
// - 한 번에 크리티컬 섹션에 진입할 수 있는 스레드의 개수를 제한하는 기술이다.
// - Semaphore(n) 은 한 번에 n 개의 스레드가 진입할 수 있다는 의미다.
// - 예) Semaphore(1)은 한 번에 한 개의 스레드만이 크리티컬 섹션에 
//       진입할 수 있다는 의미다.
//
// 뮤텍스(MUTEX)
// - MUTual EXclusion의 약자로 "상호배제"를 뜻한다.
// - 즉 한 번에 한 개의 스레드 만이 크리티컬 섹션에 진입하는 기술이다.
// - Semaphore(1)과 같다.
//












