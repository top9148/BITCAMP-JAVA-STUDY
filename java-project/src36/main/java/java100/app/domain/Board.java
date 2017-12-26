package java100.app.domain;

import java.sql.Date;

import java100.app.control.CSVFormatException;

public class Board {
    protected int no;
    protected String title;
    protected String content;
    protected Date regDate;
    protected int viewCount;
    
    public Board() {}

    public Board(String csv) throws CSVFormatException {
        String[] rec = csv.split(",");
        if (rec.length != 5) 
            throw new CSVFormatException(
                    "CSV 데이터 항목의 개수가 올바르지 않습니다.");
        
        try {
            this.no = Integer.parseInt(rec[0]);
            this.title = rec[1]; 
            this.content = rec[2]; 
            this.regDate = Date.valueOf(rec[3]);
            this.viewCount = Integer.parseInt(rec[4]);;
            
        } catch (Exception e) {
            throw new CSVFormatException(
                    "CSV 데이터 항목의 형식이 올바르지 않습니다.");
        }
    }
    
    @Override
    public String toString() {
        return "Board [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", viewCount="
                + viewCount + "]";
    }

    public String toCSVString() {
        return String.format("%d,%s,%s,%s,%d", 
                this.getNo(), 
                this.getTitle(), 
                this.getContent(),
                this.getRegDate().toString(),
                this.getViewCount());
    }
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    
}










