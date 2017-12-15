// DBMS 서버에게 SQL문을 보내기 - select
// => 데이터 입출력 테스트를 위한 테이블 생성하라!
//    bitcamp-docs/jdbcexam.sql 을 실행하라!
// 
package bitcamp.java100.ch17.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test4 {

    public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        System.out.println("연결되었음!");
        
        Statement stmt = con.createStatement();
        
        // Statement 객체의 메서드를 통해 SQL문을 서버에 보낸다.
        // => 결과를 조회할 수 있는 select를 실행할 때는 
        //    executeQuery() 메서드를 사용해야 한다.
        // => executeQuery()는 서버에 결과를 받을 때 사용하는 도구를 리턴한다.
        // => 주의!
        //    executeQuery()를 실행하면 서버가 결과를 리턴하는 것이 아니다.
        //    select 결과는 서버의 임시 메모리에 보관되고,
        //    그 보관된 결과를 가져오는 도구를 리턴하는 것이다.
        // 
        ResultSet rs = stmt.executeQuery(
            "select * from jdbc_test");
        
        // ResultSet 도구를 사용하여 서버에 준비된 select 데이터를 한 개씩 가져오기
        // => next()를 호출하면 서버에서 데이터를 한 개(레코드라 부른다) 가져온다.
        //    가져왔으면 true, 더이상 가져올 레코드가 없으면 false를 리턴한다.
        //
        while (rs.next()) {
            // 가져온 레코드(record)는 ResultSet 객체에 보관되어 있다.
            // 레코드에서 컬럼의 값을 꺼낸다.
            // 컬럼의 값이 문자열이면 getString(),
            // 컬럼의 값이 숫자이면 getInt(),
            // 컬럼의 값이 날짜이면 getDate() 등 
            // 컬럼의 타입에 맞춰 getXxx() 메서드를 호출한다.
            // 
            System.out.printf("%d, %s, %s, %s, %d\n",
                rs.getInt("no"), // 레코드에서 값을 꺼낼 때 컬럼 이름을 지정한다.
                rs.getString(2), // select할 때 지정한 컬럼 번호를 사용할 수 있다.
                rs.getString("conts"), // 그러나 가능한 컬럼명을 사용하라!
                rs.getDate("regdt")/*.toString()*/,
                rs.getInt("vwcnt")
                );
        }
        
        // Statement 와 마찬가지로 ResultSet 객체는 Statement로부터 
        // 얻었기 때문에 닫을 때도 ResultSet을 먼저 닫는다.
        rs.close();
        stmt.close();
        con.close();
    }

}









