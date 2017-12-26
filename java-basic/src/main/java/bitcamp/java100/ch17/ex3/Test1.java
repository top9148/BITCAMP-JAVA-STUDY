// Statement의 문제점
// => 데이터 입출력 테스트를 위한 테이블 생성하라!
//    bitcamp-docs/jdbcexam.sql 을 실행하라!
// 
package bitcamp.java100.ch17.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test1 {

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
        
        Statement stmt = con.createStatement();
        
        // 사용자가 입력한 값을 가지고 SQL문을 만들 때 문제점?
        // => 사용자가 SQL문을 조작할 수 있다.
        // => 그래서 실무(특히 국가 공공 프로젝트)에서는 절대로 
        //    사용자가 입력한 값을 가지고 SQL 문장을 생성하지 않도록 요구한다.
        //  
        stmt.executeUpdate(
                "update jdbc_test set title='" + title
                + "', conts='" + contents
                + "' where no=" + no);
        
        // 해킹 예)
        // => 사용자가 번호 값을 입력할 때 "5 or 1=1"로 입력한다면 
        //    다음과 같은 update 문이 만들어질 것이다.
        // update jdbc_test set title='xxx', conts='hahaha' where no=5 or 1=1
        // 
        // 결국, 모든 데이터에 대해 변경하게 된다.
        // 이런 이유로 사용자가 입력한 값을 가지고 SQL문을 만들지 말도록
        // 권유하고 있다. 공공 프로젝트에서는 강제 사항이다.
        //
        // 행안부의 자바 시큐어코딩 가이드 문서를 참고하라!
        
        System.out.println("변경 완료!");
        
        stmt.close();
        con.close();
    }

}









