// 스레드 만들고 사용하기 I - Thread를 상속 받기
package bitcamp.java100.ch16.ex1;

public class Test2 {

    // 스레드 만들기
    static class MyThread extends Thread {
        // Thread를 상속 받은 후 run()을 오버라이딩 하여
        // main() 스레드와 별개로 독립적으로 실행할 코드를 둬라!
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println("MyThread => " + i);
            }
        }
    }
    
    public static void main(String[] args) {
        
        // 스레드 사용하기
        // => 객체 생성
        MyThread t = new MyThread();
        
        // => 스레드 가동
        t.start(); // run() 메서드를 "main" 스레드와 별개로 실행한다.
                   // 스레드를 분리하여 실행하는 즉시 리턴한다.
        
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        

    }

}
