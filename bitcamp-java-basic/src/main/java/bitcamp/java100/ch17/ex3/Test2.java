// PreparedStatement 사용
// => 데이터 입출력 테스트를 위한 테이블 생성하라!
//    bitcamp-docs/jdbcexam.sql 을 실행하라!
// 
package bitcamp.java100.ch17.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) throws Exception {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("변경할 게시물 번호? ");
        String no = keyboard.nextLine();
        
        System.out.print("제목? ");
        String title = keyboard.nextLine();
        
        System.out.print("내용? ");
        String contents = keyboard.nextLine();
        keyboard.close();
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        // 입력값을 넣을 자리를 비워두고 SQL 문을 먼저 준비한다.
        // => 값을 들어갈 자리에 ?를 넣는다.
        // => ?를 "in-parameter"라고 부른다.
        // => prepareStatement()의 리턴 값은 준비된 SQL 문장이다.
        //    꼭 미리 이력서가 그려진 폼과 같다.
        PreparedStatement pstmt = con.prepareStatement(
            "update jdbc_test set title=?, conts=? where no=?");
        
        // 사용자가 입력한 값을 따로 설정한다.
        // => 컬럼의 값이 int이면 setInt()
        // => 컬럼의 값이 문자열이면 setString()
        // => 즉 컬럼의 값 타입에 따라 setXxx()를 호출하여 값을 넣는다.
        // => 값을 넣을 때 in-parameter의 번호를 지정한다.
        //    주의! 번호는 배열과 달리 0부터가 아니라 1부터 지정한다.
        //
        // => 값에 작은 따옴표(')를 포함하고 있더라도 그냥 문자로 취급한다.
        //    그래서 해커가 작은 따옴표를 이용한 SQL 문 조작을 할 수 없다.
        //
        // => 번호를 이용하여 값을 들어갈 자리를 지정할 수 있다.
        //    그래서 값을 넣는 순서를 마음대로 할 수 있다.
        //    하지만,
        pstmt.setString(1, title);
        pstmt.setString(2, contents);
        pstmt.setString(3, no);
        
        
        // 값이 설정된 SQL 문을 서버에 보낸다.
        // => PreparedStatement 객체를 생성할 때 이미 SQL문을 지정했기 때문에
        //    executeUpdate() 메서드는 파라미터가 없는 메서드를 호출해야 한다.
        pstmt.executeUpdate();
        
        System.out.println("변경 완료!");

        pstmt.close();
        con.close();
    }

}

// Statement vs PreparedStatement
// 1) Statement
//    - 문자열을 결합하여 SQL문을 만든다.
//    - 보안에 취약한다.
//    - 문자열을 결합하는 방식으로 SQL문을 만들기 때문에
//      SQL문이 긴 경우에 코드를 읽기 어렵다.
//    - SQL문에 값을 붙일 때 문자열로 만들기 때문에
//      바이너리 값을 지정할 수 없다.
//    - executeUpdate()를 호출하여 SQL문을 실행할 때마다
//      매번 SQL문을 번역한다.
//      (DBMS에 SQL문을 보낼 때 문자열 그대로 보내는 것이 아니라,
//       DBMS가 원하는 형식으로 변환하여 보내기 때문에
//       SQL문과 값을 인코딩 해야 한다.)
//    - 정리:
//      읽기 복잡하다, 바이너리 값 넣을 수 없다, 반복 실행 시 속도 느리다,
//      해커에 의해 SQL문이 조작될 수 있다.
//
// 2) PreparedStatement
//    - SQL문을 미리 준비한 후 메서드를 이용하여 값을 넣는다.
//    - 보안에 강하다.
//    - SQL문에서 값이 들어갈 자리에 ?를 붙이기 때문에
//      SQL문을 읽기가 쉽고, 값을 넣기도 쉽다.
//    - setBinaryStream(), setBlob() 등을 이용하여 바이너리 데이터를 넣을 수 있다.
//    - prepareStatement()를 호출할 때 딱 한 번 SQL문을 번역한다.
//      그런 후 값만 따라 인코딩 하여 전송하기 때문에 
//      반복하여 SQL문을 보내는 경우, Statement 보다 실행 속도가 빠르다.
//      Statement는 executeUpdate(sql) 호출할 때 매번 파라미터의 
//      SQL문을 DBMS가 원하는 형식으로 인코딩한다.
//      PreparedStatement는 executeUpdate() 호출할 때 SQL문을 파라미터로 
//      받지 않는다. 이미 준비되어 있기 때문이다.
//    - 정리:
//      읽기 쉽다, 바이너리 데이터 입력 가능, 반복 실행 시 속도 빠른다,
//      해커가 SQL문을 조작할 수 없다.







