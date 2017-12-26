//: ## 캡슐화 적용
//: - 모든 필드에 대해 외부 접근을 차단한다.
//:   단 자식 클래스에서는 직접 접근할 수 있게 허락한다.
//: 
package java100.app.domain;

import java100.app.control.CSVFormatException;

public class Score {  
    
    protected String name;
    protected int kor;
    protected int eng;
    protected int math;
    protected int sum;
    protected float aver;

    //: ### 생성자
    //: > 다른 패키지에서도 호출할 수 있도록 public으로 공개한다.
    public Score() {}
    
    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        
        this.compute();
    }
    
    public Score(String csv) throws CSVFormatException {
        String[] rec = csv.split(",");
        if (rec.length < 4) // 데이터의 개수가 올바르지 않다면,
            throw new CSVFormatException(
                    "CSV 데이터 항목의 개수가 올바르지 않습니다.");
        
        try {
            this.name = rec[0]; 
            this.kor = Integer.parseInt(rec[1]); 
            this.eng = Integer.parseInt(rec[2]); 
            this.math = Integer.parseInt(rec[3]);
            this.compute();
            
        } catch (Exception e) {
            throw new CSVFormatException(
                    "CSV 데이터 항목의 형식이 올바르지 않습니다.");
        }
    }
    
    @Override
    public String toString() {
        return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", aver="
                + aver + "]";
    }
    
    public String toCSVString() {
        return String.format("%s,%d,%d,%d,%d,%f", 
                this.getName(), 
                this.getKor(), 
                this.getEng(),
                this.getMath(),
                this.getSum(),
                this.getAver());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
        this.compute();
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
        this.compute();
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
        this.compute();
    }

    public int getSum() {
        return sum;
    }

    public float getAver() {
        return aver;
    }

    private void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
    
}
