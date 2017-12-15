// ## 메서드 - 용도의 사용 예
// - 메서드의 용도와 간단한 사용 예를 알아보자!
//

package bitcamp.java100.ch03;

public class Test17_1 {

    //: 성적 정보를 담을 메모리 설계
    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
    }
    
    
    public static void main(String[] args) {
        
        //: 메모리 준비
        Score s1 = new Score();
        
        //: 메모리에 데이터 넣기
        s1.name = "홍길동";
        s1.kor = 90;
        s1.eng = 100;
        s1.math = 100;
        s1.sum = s1.kor + s1.eng + s1.math;
        s1.aver = s1.sum / 3f;
        
        //: 메모리 준비
        Score s2 = new Score();
        
        //: 메모리에 데이터 넣기
        s2.name = "임꺽정";
        s2.kor = 100;
        s2.eng = 70;
        s2.math = 50;
        s2.sum = s2.kor + s2.eng + s2.math;
        s2.aver = s2.sum / 3f;
       
        //: 위와 같이 메모리를 만들고 그 메모리에 값을 넣는 코드가 반복될 경우,
        //: 그 코드를 별도의 블록으로 묶어 놓은 다음에 필요할 때마다 사용한다면
        //: 훨씬 더 간결하게 코딩을 할 수 있을 것이다.
        //: 이를 위해 사용하는 문법이 "메서드(method) 또는 함수(function)"이다.
        //: 자바에서는 "메서드" 용어를 주로 사용한다.
        
        //: 메서드를 사용하면 아래와 같이 성적 데이터를 저장할 때 마다 긴 코드를 
        //: 작성할 필요가 없다.
        Score s3 = createScore("유관순", 100, 100, 100);
        Score s4 = createScore("안중근", 90, 90, 90);
        Score s5 = createScore("윤봉길", 80, 80, 80);
        
    }
    
    //: 성적 데이터를 저장할 메모리를 만들고 그 메모리에 값을 저장하는 기능을 수행한다.
    //: 그리고 데이터가 저장된 메모리의 주소를 호출한 쪽에 리턴한다.
    static Score createScore(String name, int kor, int eng, int math) {
        //: 메모리 준비
        Score s = new Score();
        
        //: 메모리에 데이터 넣기
        s.name = name;
        s.kor = kor;
        s.eng = eng;
        s.math = math;
        s.sum = kor + eng + math;
        s.aver = s.sum / 3f;
        
        //: 메모리 주소 리턴하기
        return s;
    }
}

//: 메서드를 사용하는 이유?
//: > 반복 작성하는 코드를 별도의 블록으로 분리해 놓으면, 
//: > 필요할 때 마다 반복 작성할 필요가 없어 매우 편리하다. 













