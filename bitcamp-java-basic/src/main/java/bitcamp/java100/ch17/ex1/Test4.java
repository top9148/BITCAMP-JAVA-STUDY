// DBMS에 연결하기 III - Class.forName() 사용하기
// => java.sql.Driver 객체를 직접 생성하는 대신 클래스를 로딩만 한다.
//
package bitcamp.java100.ch17.ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test4 {

    public static void main(String[] args) throws Exception {
        
        // java.sql.Driver를 구현한 클래스를 단지 로딩만 한다.
        // => java.lang.Class.forName() 메서드는 파라미터에 주어진 
        //    클래스를 찾아서 로딩하는 일을 한다.
        // => 이때 com.mysql.jdbc.Driver 클래스의 static 블록에는
        //    자신의 객체를 생성해서 DriverManager에게 등록하는 코드가 들어있다.
        // => 그래서 클래스를 로딩하는 것 만으로 Driver 객체가 자동 등록된다.
        // => 즉 Test2, Test3 처럼 개발자가 직접 Driver 객체를 생성하고
        //    DriverManager에게 등록할 필요가 없다.
        //
        // => 특히 이 방법을 실무에서 많이 사용하는 이유는,
        //    클래스 이름을 문자열로 받기 때문에 
        //    언제든지 다른 JDBC Driver로 교체하기가 쉽다.
        //    이전의 Test2나 Test3에서는 소스 코드에서 직접 클래스를 
        //    지정했기 때문에 다른 JDBC Driver 클래스로 교체하려면
        //    소스 코드를 변경해야 하는 번거로움이 있다.
        Class.forName("com.mysql.jdbc.Driver");
        
        
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb",
                "study", "1111");
        
        System.out.println("연결되었음!");
        
        // 사용 후 DBMS와의 연결을 끊어야 한다.
        con.close();
    }

}









