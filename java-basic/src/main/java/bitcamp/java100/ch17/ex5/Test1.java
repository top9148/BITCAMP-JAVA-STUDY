// 여러 SQL문의 실행을 한 묶음으로 다루기
// => 데이터 입출력 테스트를 위한 테이블 생성하라!
//    bitcamp-docs/jdbcexam.sql 을 실행하라!
// 
package bitcamp.java100.ch17.ex5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) throws Exception {
        
        Scanner keyboard = new Scanner(System.in);
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        // SQL 문 준비
        PreparedStatement pstmt = con.prepareStatement(
            "insert into jdbc_test(title,conts,regdt) values(?,?,now())");
        
        while (true) {
            // 사용자로부터 제목과 내용을 입력 받는다.
            System.out.print("제목? ");
            String title = keyboard.nextLine();
            
            // 제목을 입력할 때 200자를 초과하여 입력하면
            // 컬럼의 크기를 벗어나기 때문에 입력 오류가 발생한다!
            // => 입력 오류가 발생하기 전까지 입력한 것들은 그대로 잘 
            //    저장되어 있다. 
            // => 만약 정상적으로 종료되었을 경우에만 그 전까지 수행한 
            //    입력 내용을 저장하고, 중간에 오류가 발생하면
            //    그 전까지 수행한 입력 내용을 모두 취소하고 싶다면
            //    트랜잭션을 사용하여 한 개의 작업으로 묶어라!
            //
            // => Test2.java를 확인하라! 
            
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
        
        pstmt.close();
        con.close();
        keyboard.close();
    }

}









