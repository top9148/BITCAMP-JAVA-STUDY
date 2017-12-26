package java100.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataSource {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // => com.mysql.jdbc.Driver 클래스를 로딩한다.
            //    단 한 번 로딩된 클래스는 다시 로딩하지 않는다.
            // => static {} 블록을 수행한다.
            //    => Driver 인스턴스를 생성한다.
            //    => DriverManager에 그 인스턴스를 등록한다.
            
        } catch (ClassNotFoundException ex) {
            // 이 예외가 발생하면 init()를 호출한 쪽에 예외를 던진다.
            // 단 RuntimeException 예외인 경우 스텔스 방식으로 전달되기 때문에,
            // 굳이 메서드 선언부에 어떤 예외를 던지는지 적시할 필요는 없다.
            throw new RuntimeException(
                    "JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }
    
    // 여러 스레드가 사용할 커넥션을 담을 바구니 준비
    static ArrayList<Connection> list = new ArrayList<>();
    
    // 커넥션을 빌리거나 반납할 때 한 번에 한 스레드만이 호출할 수 있다.
    synchronized public static Connection getConnection() throws SQLException {
        
        // 기존에 존재하는 커넥션 객체가 있다면 그것을 빌려준다.
        if (list.size() > 0) {
            return list.remove(0);
        }
        
        // 없다면 새로 만들어 빌려준다.
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
    }
    
    synchronized public static void returnConnection(Connection con) {
        try {
            if (con == null) return;
            if (con.isClosed()) return;
            list.add(con);
            
        } catch (Exception e) {}
    }
}






