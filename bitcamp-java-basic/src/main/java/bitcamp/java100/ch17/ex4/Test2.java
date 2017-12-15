// insert 문 실행 후 auto_increment 컬럼 값 조회하기
// => 데이터 입출력 테스트를 위한 테이블 생성하라!
//    bitcamp-docs/jdbcexam.sql 을 실행하라!
// 
package bitcamp.java100.ch17.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {

    public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        // SQL 문 준비
        // => auto_increment pk 컬럼의 값을 조회하려면 
        //    PreparedStatement 객체를 생성할 때 미리 설정해야 한다.
        // => prepareStatement()의 두 번째 파라미터에 
        //    auto_increment 컬럼의 값을 받겠다고 상수 값을 지정해야 한다.
        PreparedStatement pstmt = con.prepareStatement(
            "insert into jdbc_test(title,conts,regdt) values(?,?,now())",
            Statement.RETURN_GENERATED_KEYS);
        
        // 값 준비
        pstmt.setString(1, "제목이래요");
        pstmt.setString(2, "내용이래요...");
        
        // SQL 전송!
        pstmt.executeUpdate();
        System.out.println("입력 완료!");
        
        // insert SQL문을 실행한 후 새로 추가된 데이터의 
        // auto_increment 컬럼(no 컬럼) 값을 가져올 도구를 리턴 받는다. 
        ResultSet autokeyRS = pstmt.getGeneratedKeys();
        
        // => 서버에서 auto_increment 컬럼의 값을 가져온다.
        autokeyRS.next();
        
        // => ResultSet 객체에서 가져온 값을 꺼낸다.
        //    이때 컬럼명이 아닌 번호로 꺼내면 된다.
        System.out.println(autokeyRS.getInt(1));
        autokeyRS.close();
        
        
        pstmt.close();
        con.close();
    }

}









