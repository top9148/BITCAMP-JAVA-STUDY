// ## 문장(Statement) - 반복문 while
// - while 문 사용법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test16_4 {

    public static void main(String[] args) {
        // => while 문법
        // - while (expression) 명령문
        // - expression의 실행 결과가 true이면 계속 명령문을 반복해서 실행한다.
        int i = 0;
        while (i < 5)
            System.out.println(i++);
        
        System.out.println("----------------------------");
        
        // => 여러 개의 문장을 반복하기 
        // - 블록을 사용하여 실행할 문장을 묶는다.
        i = 0;
        while (i < 5) {
            System.out.print("=> ");
            System.out.println(i);
            i++;
        }
        
        System.out.println("----------------------------");
        
        // => while문의 중첩
        i = 1;
        while (i <= 5) {
            int count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i++;
        }
        
        System.out.println("----------------------------");
        
        // => while 문의 중법 연습
        // - 위의 결과처럼 *을 출력하되 다음과 같이 출력하라!
        //      *
        //     **
        //    ***
        //   ****
        //  *****
        i = 1;
        while (i <= 5) {
            int count = 5 - i;
            while (count > 0) {
                System.out.print(" ");
                count--;
            }
            count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i++;
        }
        
        System.out.println("----------------------------");
        
        // => while 문의 중법 연습 II
        // - 위의 결과를 다음과 같이 출력하라!
        //    *
        //   ***
        //  *****
        i = 1;
        while (i <= 5) {
            int count = (5 - i) / 2;
            while (count > 0) {
                System.out.print(" ");
                count--;
            }
            count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i += 2;
        }
        
        System.out.println("----------------------------");
        
        // => while 문의 중법 연습 III
        // - 위의 결과를 다음과 같이 출력하라!
        //  *****
        //   ***
        //    *
        i = 5;
        while (i > 0) {
            int count = (5 - i) / 2;
            while (count > 0) {
                System.out.print(" ");
                count--;
            }
            count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i -= 2;
        }
        
        System.out.println("----------------------------");
        
        // => break
        // - 반복문을 멈추고 나가는 명령
        i = 0;
        while (i < 5) {
            if (i == 3) {
                break; // 현재 실행 중인 반복문 블록을 나간다.
            }
            System.out.println(i);
            i++;
        }
        
        System.out.println("----------------------------");
        
        // => continue
        // - 반복문 안에서 다음 줄로 넘어가지 않고 바로 조건 검사로 이동시키는 명령.
        i = 0;
        while (i < 5) {
            if (i == 3) {
                i++;
                continue; // 바로 조건 검사로 이동한다.
            }
            System.out.println(i);
            i++;
        }
        
        System.out.println("----------------------------");
        
        // => 중첩 반복문 전체를 빠져 나가기 
        i = 1;
        label1: {
            while (i <= 10) {
                int count  = 1;
                while (count <= i) {
                    System.out.print("*");
                    if (count == 5) {
                        //break; // 현재 반복문을 탈출한다.
                        break label1; // label1 블록을 탈출한다.
                    }
                    count++;
                }
                System.out.println();
                i++;
            }
        }
        System.out.println();
        System.out.println("----------------------------");
        
        // => 중첩 반복문 전체를 빠져 나가기 II
        // - 라벨에 한 문장만 있을 경우 블록을 치지 않아도 된다.
        i = 1;
        label1: 
        while (i <= 10) {
            int count  = 1;
            while (count <= i) {
                System.out.print("*");
                if (count == 5) {
                    //break; // 현재 반복문을 탈출한다.
                    break label1; // label1 블록을 탈출한다.
                }
                count++;
            }
            System.out.println();
            i++;
        }
        
        System.out.println();
        System.out.println("----------------------------");
        
        // => 2단에서 9단까지 구구단을 출력하라!
        // - 출력 예)
        //   2 * 1 = 2
        //   2 * 2 = 4
        //   2 * 3 = 6
        //   2 * 9 = 18
        //   3 * 1 = 3
        //   ...
        //   9 * 9 = 81
        i = 2;
        while (i <= 9) {
            int j = 1;
            while (j <= 9) {
                System.out.printf("%d * %d = %d\n", i, j, (i * j));
                j++;
            }
            i++;
        }
        
        System.out.println("----------------------------");
        
        // => 주어진 숫자를 뒤에서부터 한 개씩 출력하라
        // 주어지는 값 => 987654321
        // 출력 => 1 2 3 4 5 6 7 8 9
        i = 4884325;
        while (i > 0) {
            System.out.printf("%d ", i % 10);
            i /= 10;
        }
        
        System.out.println("----------------------------");
        
        // => 주어진 숫자에서 1에서 9까지 등장하는 숫자의 개수를 세어라!
        // 주어지는 값 => 4885323
        // 출력
        // 0 = 0
        // 1 = 0
        // 2 = 1
        // 3 = 2
        // 4 = 1
        // 5 = 1
        // 6 = 0
        // 7 = 0
        // 8 = 2
        // 9 = 0
        i = 4885323;
        
        int[] cnt = new int[10];
        
        while (i > 0) {
            cnt[i % 10]++;
            i /= 10;
        }
        
        int x = 0;
        while (x < cnt.length) {
            System.out.printf("%d = %d\n", x, cnt[x]);
            x++;
        }
        
        
    }
}













