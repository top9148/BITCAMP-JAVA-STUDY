// ## 문장(Statement) - 반복문 for (:)
// - for (:) 문 사용법을 알아보자!
//

package bitcamp.java100.ch02;

public class Test16_7 {

    public static void main(String[] args) {
        // => for (:) 문의 용도 및 기본 문법
        // - 배열이나 콜렉션 객체의 값을 꺼낼 때 적합하다.
        // - for(레퍼런스 선언 : 배열 또는 콜렉션 객체) 명령문;
        
        String[] names = {"홍길동", "임꺽정", "유관순", "안중근", "윤봉길"};
        
        for (String n : names) 
            System.out.println(n);
        
        System.out.println("------------------");
        
        int[] kor = {100, 90, 80, 90, 50, 80};
        
        for (int score : kor) {
            System.out.println(score);
        }
        
        // => for 블록 밖에 변수를 선언해 놓고 사용할 수 없다.
        int s = 0;
        /* 컴파일 오류!
        for (s : kor) {
            System.out.println(s);
        }
        */
        
        System.out.println("------------------");
        
        // => List 컬렉션 객체에서 값을 꺼내기
        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        list.add("홍길동");
        list.add("임꺽정");
        list.add("유관순");
        list.add("안중근");
        list.add("윤봉길");
        list.add("홍길동");
        list.add("임꺽정");
        
        for (String n : list) {
            System.out.println(n);
        }
        
        System.out.println("------------------");
        
        // => Set 컬렉션 객체에서 값을 꺼내기
        java.util.HashSet<String> set = new java.util.HashSet<>();
        set.add("홍길동");
        set.add("임꺽정");
        set.add("유관순");
        set.add("안중근");
        set.add("윤봉길");
        set.add("홍길동");
        set.add("임꺽정");
        
        for (String n : set) {
            System.out.println(n);
        }
        
        
    }
}














