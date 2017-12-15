package java100.app.control;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberController implements Controller {
    
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
        case "/member/list": this.doList(request, response); break;
        case "/member/add": this.doAdd(request, response); break;
        case "/member/view": this.doView(request, response); break;
        case "/member/update": this.doUpdate(request, response); break;
        case "/member/delete": this.doDelete(request, response); break;
        default: 
            response.getWriter().println("해당 명령이 없습니다.");
        }
    }
    
    private void doList(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 목록]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "select no,name,email,regdt from ex_memb");
             ResultSet rs = pstmt.executeQuery();){
            
            while (rs.next()) {
                out.printf("%d, %s, %s, %s\n",
                        rs.getInt("no"),
                        rs.getString("name"), 
                        rs.getString("email"),
                        rs.getDate("regdt"));
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
    private void doAdd(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 등록]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "insert into ex_memb(name,email,pwd,regdt)"
                + " values(?,?,password(?),now())");
             ){
            
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setString(2, request.getParameter("email"));
            pstmt.setString(3, request.getParameter("password"));
            
            pstmt.executeUpdate();
            out.println("저장하였습니다.");
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    } 
    
    private void doView(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 상세 정보]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "select no,name,email,regdt from ex_memb where no=?");
             ){
            
            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                out.printf("번호: %d\n", rs.getInt("no"));
                out.printf("이름: %s\n", rs.getString("name"));
                out.printf("이메일: %s\n", rs.getString("email"));
                out.printf("등록일: %s\n", rs.getDate("regdt"));
            } else {
                out.printf("'%s'번의 회원 정보가 없습니다.\n", 
                        request.getParameter("no"));
            }
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    } 
    
    private void doUpdate(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 변경]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "update ex_memb set name=?,email=?,pwd=password(?) where no=?");
             ){
            
            pstmt.setString(1, request.getParameter("name"));
            pstmt.setString(2, request.getParameter("email"));
            pstmt.setString(3, request.getParameter("password"));
            pstmt.setInt(4, Integer.parseInt(request.getParameter("no")));
            
            if (pstmt.executeUpdate() > 0) {
                out.println("변경하였습니다.");
            } else {
                out.printf("'%s'번 회원의 정보가 없습니다.\n", 
                        request.getParameter("no"));
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
    
    private void doDelete(Request request, Response response) {

        PrintWriter out = response.getWriter();
        out.println("[회원 삭제]");
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studydb", "study", "1111");
             PreparedStatement pstmt = con.prepareStatement(
                "delete from ex_memb where no=?");
             ){
            
            pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
            
            if (pstmt.executeUpdate() > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%s'번의 회원 정보가 없습니다.\n", 
                        request.getParameter("no"));
            }
            
        } catch (Exception e) {
            e.printStackTrace(); // for developer
            out.println(e.getMessage()); // for user
        }
    }
}










