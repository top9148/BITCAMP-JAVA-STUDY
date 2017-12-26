// 여러 SQL문의 실행을 한 묶음으로 다루기
// => 데이터 입출력 테스트를 위한 테이블 생성하라!
//    bitcamp-docs/jdbcexam.sql 을 실행하라!
// 
package bitcamp.java100.ch17.ex5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) throws Exception {
        
        Scanner keyboard = new Scanner(System.in);
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        // SQL 문 준비
        PreparedStatement pstmt = con.prepareStatement(
            "insert into jdbc_test(title,conts,regdt) values(?,?,now())");
        
        // 트랜잭션?
        // - 여러 개의 데이터 변경 작업(insert,update,delete)을 
        //   한 개의 단위로 묶은 것을 말한다.
        // - 한 작업으로 묶어두면 작업 중 오류가 발생할 때
        //   그 전까지 실행한 작업을 모두 자동으로 쉽게 취소할 수 있다.
        // - 예) 다음 계좌이체 작업들을 트랜잭션(한 단위)로 묶었을 때,
        //   1) 내 계좌에 이체 정보 등록
        //   2) 내 계좌의 잔액 정보 변경 
        //   3) 상대편 계좌에 이체 정보 등록
        //   4) 상대편 계좌의 잔액 정보 변경
        //   => 4개의 작업중 한 개의 작업이라도 오류가 발생하면 
        //      이전에 수행한 작업들이 모두 자동 취소된다.
        //
        
        // 트랜잭션 묶기
        // => JDBC는 기본으로 auto commit(저지르다)이다. 
        // => 즉 SQL문을 서버에 보내서 실행하는 즉시 바로 테이블에 적용하도록 
        //    되어 있다. 
        // => 이것을 수동 커밋으로 설정해야 한다.
        
        con.setAutoCommit(false);
        // 수동 커밋 모드에서는 Connection 객체에 대해 
        // commit()을 호출해야만 테이블에 변경 내용을 적용한다.
        // 호출하지 않으면 아무리 insert, update, delete해도 
        // 작업이 끝난 후 버려진다.
        
        
        while (true) {
            // 사용자로부터 제목과 내용을 입력 받는다.
            System.out.print("제목? ");
            String title = keyboard.nextLine();
            
            System.out.print("내용? ");
            String contents = keyboard.nextLine();
            
            // 값 준비
            pstmt.setString(1, title);
            pstmt.setString(2, contents);
            
            // SQL 전송!
            pstmt.executeUpdate();
            System.out.println("입력 완료!");
            
            System.out.print("계속 입력하시겠습니까?(Y/n) ");
            String str = keyboard.nextLine().toLowerCase();
            if (!str.equals("y"))
                break;
        }
        
        // 정상적으로 끝났을 경우에만 
        // 테이블에 데이터 변경 사항(insert,update,delete)을 적용한다.
        con.commit();

        pstmt.close();
        con.close();
        keyboard.close();
    }

}

// 트랜잭션이 처리되는 원리
// => 클라이언트에서 DBMS에 SQL 명령을 보내면,
//    DBMS는 임시 테이블에 그 내용을 기록한다.
// => 클라이언트에서 commit()을 호출하여 지금까지 작업한 내용을
//    실제 테이블에 적용해달라고 요청해야만,
//    DBMS는 임시 테이블에 기록된 내용대로 실제 테이블에 적용한다.
// => commit()을 호출하여 DBMS에 요청하지 않으면,
//    임시 테이블에 기록된 작업 내용은 연결이 끊어질 때 버려진다.
//
// 트랜잭션 작업 명령
// 1) commit()
//    - 지금까지 작업한 것들을 실제 테이블에 적용하라!
// 2) rollback()
//    - 지금까지 작업한 것들을 버려라!
//







