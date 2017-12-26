// DBMS에 연결하기
// => java.sql.Driver 구현체를 통해 DBMS와 연결할 수 있다.
//
package bitcamp.java100.ch17.ex1;

import java.sql.Connection;

public class Test2 {

    public static void main(String[] args) throws Exception {
        
        
        java.sql.Driver driver = new com.mysql.jdbc.Driver();
        
        // java.sql.Driver 구현체를 통해 DBMS에 접속한다.
        // connect()의 리턴 값? 
        // => MySQL 서버와 연결된 정보를 갖고 있는 객체를 리턴한다.
        // => 그 객체는 java.sql.Connection 구현체이다.
        Connection con = driver.connect(
            "jdbc:mysql://localhost:3306/studydb?user=study&password=1111", 
            null);
        System.out.println("연결되었음!");
        
        // 사용 후 DBMS와의 연결을 끊어야 한다.
        con.close();
    }

}









