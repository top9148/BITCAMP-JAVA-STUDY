package java100.app.control;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScoreController implements Controller {
    
    @Override
    public void destroy() {}
    
    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // => com.mysql.jdbc.Driver 클래스를 로딩한다.
            // => static {} 블록을 수행한다.
            //    => Driver 인스턴스를 생성한다.
            //    => DriverManager에 그 인스턴스를 등록한다.
            
        } catch (ClassNotFoundException ex) {
            // 이 예외가 발생하면 init()를 호출한 쪽에 예외를 던진다.
            // 단 RuntimeException 예외인 경우 스텔스 방식으로 전달되기 때문에,
            // 굳이 메서드 선언부에 어떤 예외를 던지는지 적시할 필요는 없다.
            throw new RuntimeException(
                    "JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }
    
    @Override
    public void execute(Request request, Response response) {

        switch (request.getMenuPath()) {
        case "/score/add": this.doAdd(request, response); break;
        case "/score/list": this.doList(request, response); break;
        case "/score/view": this.doView(request, response); break;
        case "/score/update": this.doUpdate(request, response); break;
        case "/score/delete": this.doDelete(request, response); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doDelete(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        out.println("[성적 삭제]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "delete from ex_score where no=?");
             ){
            
            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
            
            if (pstmt.executeUpdate() > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", 
                        request.getParameter("no"));
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doUpdate(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[성적 변경]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "update ex_score set name=?,kor=?,eng=?,math=? where no=?");
             ){
            
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setInt(2, Integer.parseInt(request.getParameter("kor")));
            pstmt.setInt(3, Integer.parseInt(request.getParameter("eng")));
            pstmt.setInt(4, Integer.parseInt(request.getParameter("math")));
            pstmt.setInt(5, Integer.parseInt(request.getParameter("no")));
            
            // executeUpdate()의 리턴 값은 변경된 레코드들의 개수이다.
            // 만약 해당 번호와 일치하는 데이터를 찾지 못해 
            // 변경한게 없다면 0을 리턴한다.
            
            if(pstmt.executeUpdate() > 0) {
                out.println("변경하였습니다.");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", 
                        request.getParameter("no"));
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doView(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        out.println("[성적 상세 정보]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "select no,name,kor,eng,math from ex_score where no=?");
             ){
            
            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int sum = rs.getInt("kor") + rs.getInt("eng") + rs.getInt("math");
                float aver = sum / 3f;
                out.printf("번호: %d\n", rs.getInt("no"));
                out.printf("이름: %s\n", rs.getString("name"));
                out.printf("국어: %d\n", rs.getInt("kor"));
                out.printf("영어: %d\n", rs.getInt("eng"));
                out.printf("수학: %d\n", rs.getInt("math"));
                out.printf("합계: %d\n", sum);
                out.printf("평균: %.1f\n", aver);
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", 
                        request.getParameter("no"));
            }
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doList(Request request, Response response) {
        PrintWriter out = response.getWriter();
        out.println("[성적 목록]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "select no,name,kor,eng,math from ex_score");
             ResultSet rs = pstmt.executeQuery();){
            
            while (rs.next()) {
                int sum = rs.getInt("kor") + rs.getInt("eng") + rs.getInt("math");
                float aver = sum / 3f;
                out.printf("%4d, %-4s, %4d, %6.1f\n",
                        rs.getInt("no"),
                        rs.getString("name"), 
                        sum, aver);
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }

    private void doAdd(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        out.println("[성적 등록]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "insert into ex_score(name,kor,eng,math) values(?,?,?,?)");
             ){
            
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setInt(2, Integer.parseInt(request.getParameter("kor")));
            pstmt.setInt(3, Integer.parseInt(request.getParameter("eng")));
            pstmt.setInt(4, Integer.parseInt(request.getParameter("math")));
            
            pstmt.executeUpdate();
            out.println("저장하였습니다.");
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
}













