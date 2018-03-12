package java100.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataSource {
    
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    
    // 여러 스레드가 사용할 커넥션을 담을 바구니 준비
    private ArrayList<Connection> list = new ArrayList<>();
    
    // 커넥션을 빌리거나 반납할 때 한 번에 한 스레드만이 호출할 수 있다.
    synchronized public Connection getConnection() 
            throws SQLException, ClassNotFoundException {
        
        // 기존에 존재하는 커넥션 객체가 있다면 그것을 빌려준다.
        if (list.size() > 0) {
            return list.remove(0);
        }
        
        Class.forName(this.driverClassName);
        // => com.mysql.jdbc.Driver 클래스를 로딩한다.
        //    단 한 번 로딩된 클래스는 다시 로딩하지 않는다.
        // => Driver 클래스 내부에 선언된 static {} 블록을 수행한다.
        //    => Driver 인스턴스를 생성한다.
        //    => DriverManager에 그 인스턴스를 등록한다.
        
        // 없다면 새로 만들어 빌려준다.
        return DriverManager.getConnection(
                this.url, this.username, this.password);
    }
    
    synchronized public void returnConnection(Connection con) {
        try {
            if (con == null) return;
            if (con.isClosed()) return;
            list.add(con);
            
        } catch (Exception e) {}
    }
    
    synchronized public void close() {
        for (Connection con : list) {
            try {con.close();} catch (Exception e) {}
        }
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}






