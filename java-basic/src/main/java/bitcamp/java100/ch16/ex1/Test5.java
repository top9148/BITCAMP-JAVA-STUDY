// wait() 와 notify() 
//
package bitcamp.java100.ch16.ex1;

public class Test5 {
    
    static class Result {
        int sum;
    }
    
    static Result result = new Result();
    
    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }
        
        @Override
        public void run() {
            // result 객체를 사용하는 경우 
            // 한 번에 한 스레드만이 접근하도록 제한 한다.
            synchronized(result) {
                for (int i = 1; i <= 10; i++) {
                    System.out.printf("%s(%d)\n", this.getName(), i);
                    result.sum += i;
                    try {
                        Thread.sleep(1000); 
                    } catch (Exception e) {}
                }
                
                // 작업이 완료되면 result 객체를 사용하기 위해
                // 기다리고 있는 스레드에게
                // 이제 사용해도 된다고 알린다.
                result.notify();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        MyThread t = new MyThread("꽃님이");
        t.start();
        
        // result 객체는 한 번에 한 스레드만 사용하겠다고 선언한다.
        synchronized(result) {
            // result 객체를 사용하기 전에 다른 스레드가 
            // 사용하라고 알려줄 때까지 기다린다.
            // 다른 스레드가 notify() 또는 notifyAll()을 호출하여
            // 사용하라고 알려주면 그 때서야 
            // 다른 라인을 실행한다.
            result.wait();
            
            System.out.println("합계=" + result.sum);
        }
    }
    
}




