// ## 배열 
// - 배열의 이점과 사용법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test13_1 {

    public static void main(String[] args) {
// 국어, 영어, 수학, 사회, 과학, 도덕, 중국어 점수를 저장할 변수를 만들라!
// => 배열 사용 전:
        int kor, eng, math, soc, sci, eth, chi;
        kor = 100;
        eng = 100;
        math = 100;
        soc = 100;
        sci = 100;
        eth = 100;
        chi = 100;
        
        System.out.println(kor);
        System.out.println(eng);
        System.out.println(math);
        System.out.println(soc);
        System.out.println(sci);
        System.out.println(eth);
        System.out.println(chi);

// => 배열 사용 후:
        int[] scores = new int[7];
        scores[0] = 100;
        scores[1] = 100;
        scores[2] = 100;
        scores[3] = 100;
        scores[4] = 100;
        scores[5] = 100;
        scores[6] = 100;
        // 이렇게 배열을 사용하면 같은 종류의 메모리를 여러 개 손쉽게 만들 수 있다. 
        // 여기에 for() 반복문을 결합하면 변수의 값을 다루기 더욱 쉬워진다.

        for (int i = 0; i < 7; i++) {
            System.out.println(scores[i]);
        }
    }
}
