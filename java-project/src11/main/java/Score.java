import java.util.Scanner;

//: ## 생성자와 인스턴스 메서드 도입
//: - init() 메서드 대신 생성자를 이용하여 인스턴스를 초기화시킨다.
//: - print() 메서드는 인스턴스 데이터를 다루기 때문에 스태틱 메서드 대신
//:   인스턴스 메서드로 전환한다. 
public class Score {
    
    String name;
    int[] subjects; 
    int sum;
    float aver;

    //: ### 생성자
    //: 객체를 생성할 때, 
    //: 인스턴스를 만든 후 나중에 값을 초기화시키는 경우가 있고,
    //: 인스턴스를 만들 때 초기화시키는 경우가 있다.
    //: 이런 다양한 경우를 대비하기 위해 보통 기본 생성자와 파라미터 값을 받는 생성자를
    //: 같이 만든다.
    
    //: > 빈 객체를 만드는 경우,
    Score() {
        //: > 생성자란? 인스턴스를 사용 가능하도록 유효한 상태로 만드는 것.
        //: 그래서 이 기본 생성자에서 할 일은 국,영,수 점수를 넣을 수 있도록 
        //: subjects에 배열을 만들어 저장하는 것이다.
        this.subjects = new int[3];
    }
    
    // > 객체를 만들 때 바로 초기화시키는 경우,
    Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.subjects = new int[]{kor, eng, math};
        
        this.compute();
    }
    
    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다.
    void compute() {
        for (int sub : this.subjects) {
            this.sum += sub;
        }
        this.aver = (float)this.sum / this.subjects.length;
    }
    
    void print() {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                this.name, 
                this.subjects[0], 
                this.subjects[1], 
                this.subjects[2], 
                this.sum, 
                this.aver);
    }
    
    void input() {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("이름? ");
        this.name = keyScan.nextLine();
        
        System.out.print("국어점수? ");
        this.subjects[0] = keyScan.nextInt();
        
        System.out.print("영어점수? ");
        this.subjects[1] = keyScan.nextInt();
        
        System.out.print("수학점수? ");
        this.subjects[2] = keyScan.nextInt();
        
        this.compute();
    }
}
