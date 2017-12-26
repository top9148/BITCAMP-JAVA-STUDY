// 스레드 생명주기(lifecycle) - sleep() 사용법
//
// new Thread() --start()--> Runnable 상태 --sleep()/wait()--> Not Runnable
//                                       <-- time out/notify()
//                                |
//                              run() 실행 종료
//                                |
//                                V
//                               Dead
//
// Runnable 상태?
// - CPU 사용권을 얻어 실행하는 상태가 아니라,
//   CPU 사용권을 얻을 수 있는 상태이다.
// 
// Not Runnable 상태?
// - 실행하지 않는 상태가 아니라,
//   CPU를 얻지 않겠다고 선언한 상태.
// 
// Dead 상태?
// - run() 실행을 완료한 상태.
// - 종료된 스레드는 다시 실행할 수 없다.
// - 만약 종료된 스레드에 대해 start() 호출하면 예외가 발생한다.
// - 스레드를 다시 실행하고 싶다면 새로 객체를 만들어 start()를 호출하라!
// 
package bitcamp.java100.ch16.ex1;

public class Test4 {
    
    static class MyThread extends Thread {
        
        public MyThread(String name) {
            super(name);
        }
        
        @Override
        public void run() {
            int count = 0;
            while (true) {
                System.out.printf("\n%s(%d)\n", this.getName(), ++count);
                
                if (count == 500) {
                    count = 0;
                    try {
                        // 5초 동안 Not Runnable 상태로 만든다.
                        Thread.sleep(5000); 
                    } catch (Exception e) {}
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        new MyThread("꽃님이").start();
        
        while (true) {
            System.out.println("...");
            
            double v1 = 3.141592;
            double v2 = 0.1234543;
            for (int i = 0; i < 1000000; i++) {
                v1 = Math.random() * v1;
                v2 = Math.random() / v2;
            }
        }
        
    }
}
















