// ## 연산자 - 비트 이동 연산자 (>>, >>>, <<)
// - 비트 이동 연산자의 사용법을 알아보자!
//

package bitcamp.java100.ch02;
 
public class Test15_12_1 {

    public static void main(String[] args) {
        int v = 87; //0000_0000_0000_0000_0000_0000_0101_0111
        
        // ### >>
        // - 오른쪽으로 비트를 이동 시킨다. 오른쪽 경계를 넘어간 비트는 짤린다.
        // - 왼쪽 빈 자리는 부호 비트로 채운다.
        // - 1비트 이동하는 것은 2로 나누는 것과 같은 효과가 있다.
        System.out.println(v >> 1); // v / 2**1 = x000_0000_0000_0000_0000_0000_0010_1011|1
        System.out.println(v >> 2); // v / 2**2 = xx00_0000_0000_0000_0000_0000_0001_0101|11
        System.out.println(v >> 3); // v / 2**3 = xxx0_0000_0000_0000_0000_0000_0000_1010|111
        System.out.println(v >> 4); // v / 2**4 = xxxx_0000_0000_0000_0000_0000_0000_0101|0111

        v = -87;
        System.out.println(v >> 1); // v / 2**1 
        System.out.println(v >> 2); // v / 2**2 
        System.out.println(v >> 3); // v / 2**3 
        System.out.println(v >> 4); // v / 2**4 
        
        // ### >>>
        // - 오른쪽으로 비트를 이동시킨다. 오른쪽 경계를 넘어간 비트는 짤린다.
        // - 왼쪽 빈 자리는 무조건 0으로 채운다.
        // - 음수의 경우 빈자리가 0으로 채워지기 때문에 양수로 바뀌는 현상이 발생한다.
        v = 87;
        System.out.println(v >>> 1); // v / 2**1 
        System.out.println(v >>> 2); // v / 2**2 
        System.out.println(v >>> 3); // v / 2**3 
        System.out.println(v >>> 4); // v / 2**4
        
        v = -87;
        System.out.println(v >>> 1); 
        System.out.println(v >>> 2);
        System.out.println(v >>> 3);  
        System.out.println(v >>> 4);
        
        // ### << 
        // - 왼쪽으로 비트를 이동시킨다. 왼쪽 경계를 넘어간 비트는 짤린다.
        // - 오른쪽 빈자리는 무조건 0으로 채운다.
        // - 값에 2를 곱한 효과가 있다.
        // - 음수의 경우 맨 왼쪽 비트가 0으로 바뀔 수 있다. 즉 이동하면서 양수가 될 수 있다. 
        //  
        v = 5; // 0000_0000_0000_0000_0000_0000_0000_0101
        System.out.println(v << 1); // v * 2**1 = 0000_0000_0000_0000_0000_0000_0000_1010
        System.out.println(v << 2); // v * 2**2 = 0000_0000_0000_0000_0000_0000_0001_0100
        System.out.println(v << 3); // v * 2**3 = 0000_0000_0000_0000_0000_0000_0010_1000
        System.out.println(v << 4); // v * 2**4 = 0000_0000_0000_0000_0000_0000_0101_0000
        
        v = -5;
        System.out.println(v << 1); // v * 2**1 
        System.out.println(v << 2); // v * 2**2 
        System.out.println(v << 3); // v * 2**3 
        System.out.println(v << 4); // v * 2**4
        
        for (int i = 0; i < 40; i++) {
            System.out.printf("%32s, %d\n", Integer.toBinaryString(v << i), v << i); 
        }        
    }
}




















