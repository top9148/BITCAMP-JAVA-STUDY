// 멀티태스킹 
// - 한 번에 여러 개의 프로그램을 동시에 실행하는 것
// - 실제는 cpu가 여러 개의 프로그램을 돌아가면서 
//   일정 시간 분량으로 명령어를 처리한다.
// - CPU의 처리속도가 빠르기 때문에 잠깐씩 돌아가면서 
//   각각의 프로그램 명령을 처리해도 
//   사용자에게는 동시에 실행되는 것 처럼 보인다.
// - 멀티태스킹을 수행하려면 실행할 프로세스의 순서를 관리해야 한다.
//   프로세스의 실행 순서를 관리하는 것을 "process scheduling"한다.
//
// 프로세스 스케줄링 기법
// 1) round-robin 방식
//    - 일정한 시간(예: 10ms)으로 쪼개서 프로세스를 돌아가면서 실행.
//    - Windows OS에서 사용하는 방식
// 
// 2) priority 방식
//    - 우선 순위가 높은 프로세스를 먼저 실행한다.
//    - 우선 순위가 낮아 실행 순서가 밀린 프로세스는 
//      한 번 밀릴 때 마다 나이를 먹게 하여 
//      결국에는 실행할 수 있도록 한다. => "Aging" 기법
//    - 리눅스 유닉스에서 사용하는 방식
// 
// 멀티태스킹을 이용해서 한 프로세스에서 여러 작업을 동시에 실행시키는 방법
// 1) 멀티 프로세싱
//    - 실행 중인 프로세스를 복제해서 작업을 동시에 실행하는 방법
//    - 특징 
//      => fork 를 이용하여 간단히 프로세스를 복제할 수 있다.
//         프로그래밍이 쉽다.
//      => 프로세스가 사용한 메모리 전체를 그대로 복제한다.
//         메모리 낭비가 심하다.
//      => 복제된 프로세스가 모두 종료되어야만 프로그램이 완전히 종료된다. 
// 
// 2) 멀티 스레딩
//    - 프로세스 복제 방식의 문제점을 해결하기 위해 나온 방식
//    - 특징
//      => 프로세스의 Heap 메모리를 공유한다. => 메모리 절약.
//      => 동시에 실행해야 할 코드만 별도로 분리한다.
//         별도의 코딩이 필요하다.
//      => 스레드를 소유한 프로세스를 종료하면 
//         프로그램을 바로 종료할 수 있다.
//    
//
package bitcamp.java100.ch16.ex1;

public class Test1 {

    public static void main(String[] args) {
        // 이순간 이 코드를 실행하는 스레드 알아내기
        Thread t1 = Thread.currentThread();
        System.out.println(t1.getName());
        // => main()을 호출하는 스레드는 "main"이라는 이름을 가진 스레드 이다.
        
        // 스레드가 소속된 스레드 그룹 알아내기
        ThreadGroup g1 = t1.getThreadGroup();
        System.out.println(g1.getName());
        // => 스레드 "main"이 소속된 그룹 이름은 "main"이다.
        
        // 스레드 그룹 "main"이 소속된 부모 스레드그룹 알아내기
        ThreadGroup g2 = g1.getParent();
        System.out.println(g2.getName());
        // => 스레드 그룹 "main"이 소속된 그룹 이름은 "system"이다.
        
        // 스레드 그룹 "system"이 소속된 부모 스레드 그룹 알아내기
        ThreadGroup g3 = g2.getParent();
        System.out.println(g3);
        // => 스레드 그룹 "system"의 부모 그룹은 없다.
        
        // 현재 상황
        // "system" 스레드 그룹(g2)
        //   => "main" 스레드 그룹(g1)
        //      => "main" 스레드(t1)
        
        System.out.println("-------------------------------");
        
        // 스레드 그룹 "system"에는 다른 하위 스레드 그룹이 없는가?
        ThreadGroup[] groups = new ThreadGroup[10];
        int len = g2.enumerate(groups, false);
        for (int i = 0; i < len; i++) {
            System.out.println(groups[i].getName());
        }
        
        // 현재 상황
        // "system" 스레드 그룹(g2)
        //   => "main" 스레드 그룹(g1)
        //
        
        System.out.println("-------------------------------");
        
        // 스레드 그룹 "main"에는 다른 하위 스레드 그룹이 없는가?
        len = g1.enumerate(groups, false);
        for (int i = 0; i < len; i++) {
            System.out.println(groups[i].getName());
        }

        // 현재 상황
        // "system" 스레드 그룹(g2)
        //   => "main" 스레드 그룹(g1)
        //
        
        System.out.println("-------------------------------");
        
        // 스레드 그룹 "system"에는 다른 스레드는 없는가?
        Thread[] threads = new Thread[10];
        len = g2.enumerate(threads, false);
        for (int i = 0; i < len; i++) {
            System.out.println(threads[i].getName());
        }
        
        // 현재 상황
        // "system" 스레드 그룹(g2)
        //   => "main" 스레드 그룹(g1)
        //   => "Reference Handler" 스레드 
        //   => "Finalizer" 스레드 
        //   => "Signal Dispatcher" 스레드 
        // 
        
        System.out.println("-------------------------------");
        
        // 스레드 그룹 "main"에는 다른 스레드는 없는가?
        len = g1.enumerate(threads, false);
        for (int i = 0; i < len; i++) {
            System.out.println(threads[i].getName());
        }
        
        // 최종 상황
        // "system" 스레드 그룹(g2)
        //   => "main" 스레드 그룹(g1)
        //      => "main" 스레드 
        //   => "Reference Handler" 스레드 
        //   => "Finalizer" 스레드 
        //   => "Signal Dispatcher" 스레드 
        // 

    }

}















