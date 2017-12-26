// 스레드 만들고 사용하기 II - Runnable 인터페이스 구현하기
package bitcamp.java100.ch16.ex1;

public class Test3 {

    // 스레드가 실행시킬 Runnable 구현하기
    static class MyRunnable implements Runnable {
        // Runnable 인터페이스에 선언된 run() 메서드를 구현한다.
        // 이 메서드는 Thread가 호출할 것이다.
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println("MyThread => " + i);
            }
        }
    }
    
    public static void main(String[] args) {
        
        // 스레드 사용하기
        // => 객체 생성할 때 Thread가 실행할 코드가 들어있는
        //    Runnable 구현체를 생성자의 파라미터로 넘겨야 한다.
        Thread t = new Thread(new MyRunnable());
        
        // => 스레드 가동
        t.start(); // 생성자 파라미터로 받은 MyRunnable 객체의 
                   // run() 메서드를 독립적으로 실행한다.
                   // 그리로 즉시 리턴!
        
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        
        // 스레드를 만들 때 Runnable 인터페이스를 구현하는 방법을 
        // 더 많이 사용한다.
        // 이유?
        // 다른 클래스를 상속 받고 있을 때는 Thread를 상속 받을 수 없다.
        // 그러나 인터페이스인 Runnable은 구현할 수 있다.

    }

}










