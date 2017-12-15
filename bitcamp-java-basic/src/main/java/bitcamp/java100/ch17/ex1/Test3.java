// DBMS에 연결하기 II - DriverManager를 이용하여 DBMS와 연결하기
// => java.sql.Driver 객체를 직접 사용하는 대신에
//    DriverManager를 통해 DBMS에 연결할 수 있다.
//    실무에서는 이 방법을 더 많이 사용한다.
//
package bitcamp.java100.ch17.ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test3 {

    public static void main(String[] args) throws Exception {
        
        
        java.sql.Driver driver = new com.mysql.jdbc.Driver();
        
        // java.sql.Driver 구현체를 JDBC Driver 관리자에 등록한다.
        DriverManager.registerDriver(driver);
        
        // => DBMS에 연결하기 방법1:
        /*
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        */
        
        // => DBMS에 연결하기 방법1:
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        System.out.println("연결되었음!");
        
        // 사용 후 DBMS와의 연결을 끊어야 한다.
        con.close();
    }

}









