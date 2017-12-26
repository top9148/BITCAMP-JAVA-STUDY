package java100.app.domain;

import java100.app.control.CSVFormatException;

public class Member {
    
    protected String name;
    protected String email;
    protected String password;
    
    public Member() {}
    
    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Member(String csv) throws CSVFormatException {
        String[] rec = csv.split(",");
        if (rec.length != 3) // 데이터의 개수가 올바르지 않다면,
            throw new CSVFormatException(
                    "CSV 데이터 항목의 개수가 올바르지 않습니다.");
        
        this.name = rec[0]; 
        this.email = rec[1]; 
        this.password = rec[2]; 
    }
    
    @Override
    public String toString() {
        return "Member [name=" + name + ", email=" + email + ", password=" + password + "]";
    }

    public String toCSVString() {
        return String.format("%s,%s,%s", 
                this.getName(), 
                this.getEmail(), 
                this.getPassword());
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}









