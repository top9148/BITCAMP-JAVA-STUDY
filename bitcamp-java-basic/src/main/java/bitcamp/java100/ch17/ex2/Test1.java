// DBMS 서버에게 SQL문을 보내기 - insert
// => 데이터 입출력 테스트를 위한 테이블 생성하라!
//    bitcamp-docs/jdbcexam.sql 을 실행하라!
// 
package bitcamp.java100.ch17.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test1 {

    public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        System.out.println("연결되었음!");
        
        // SQL문을 보내는 일을 할 객체를 Connection 객체로부터 얻는다.
        // => 빈 SQL 문 객체를 만든다.
        Statement stmt = con.createStatement();
        
        // Statement 객체의 메서드를 통해 SQL문을 서버에 보낸다.
        stmt.executeUpdate(
            "insert into jdbc_test(title,conts,regdt)"
            + " values('aaa','aaaa',now())");
        
        System.out.println("입력 완료!");
        
        //Statement도 사용한 후 닫아야 한다.
        stmt.close();
        
        //Statement를 먼저 닫고 그 다음에 Connection을 닫아야 한다.
        //왜? Connection 객체로부터 Statement를 만들었기 때문이다.
        con.close();
    }

}









