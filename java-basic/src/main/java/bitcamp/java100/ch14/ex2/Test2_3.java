// FileOutputStream 사용법 - 버퍼 사용 후
//

package bitcamp.java100.ch14.ex2;

import java.io.FileOutputStream;

public class Test2_3 {
    public static void main(String[] args) throws Exception {
        
        // 데이터 준비 
        // => 랜덤 메서드를 사용하여 임의의 값을 400만개를 준비한다.
        byte[] data = new byte[4000000];
        
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte)(Math.random() * 255);
        }
        
        FileOutputStream out = new FileOutputStream("./test3.dat");
        
        // 4백만개의 데이터를 출력해보고, 걸린 시간을 알아보자!
        
        long start = System.currentTimeMillis();

        for (int i = 0; i < data.length; i += 8192) {
            out.write(data, i, 
                    (data.length - i) > 8192 ? 8192 : data.length - i);
        }
        
        long end = System.currentTimeMillis();
        System.out.printf("걸린시간 = %d\n", end - start);
        
        out.close();
        
    }
}







