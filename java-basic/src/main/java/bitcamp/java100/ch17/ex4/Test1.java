// insert 문 실행 후 auto_increment 컬럼 값 조회하기
// => 데이터 입출력 테스트를 위한 테이블 생성하라!
//    bitcamp-docs/jdbcexam.sql 을 실행하라!
// 
package bitcamp.java100.ch17.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test1 {

    public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        // SQL 문 준비
        PreparedStatement pstmt = con.prepareStatement(
            "insert into jdbc_test(title,conts,regdt) values(?,?,now())");
        
        // 값 준비
        pstmt.setString(1, "제목이래요");
        pstmt.setString(2, "내용이래요...");
        
        // SQL 전송!
        pstmt.executeUpdate();
        
        // insert를 실행한 후 방금 입력한 게시물의 번호가 무엇인지 
        // 알아내는 방법은? Test2.java를 보라!
        
        System.out.println("입력 완료!");
        
        pstmt.close();
        con.close();
    }

}









