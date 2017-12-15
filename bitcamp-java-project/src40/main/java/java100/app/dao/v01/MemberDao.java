package java100.app.dao.v01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java100.app.domain.Member;

public class MemberDao {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // => com.mysql.jdbc.Driver 클래스를 로딩한다.
            //    단 한 번 로딩된 클래스는 다시 로딩하지 않는다.
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
    
    Connection con;
    
    public MemberDao() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studydb", "study", "1111");
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public List<Member> selectList() {
        try (PreparedStatement pstmt = con.prepareStatement(
                "select no,name,email,regdt from ex_memb");
             ResultSet rs = pstmt.executeQuery();){
            
            ArrayList<Member> list = new ArrayList<>();
            
            while (rs.next()) {
                Member member = new Member();
                member.setNo(rs.getInt("no"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setCreatedDate(rs.getDate("regdt"));
                
                list.add(member);
            }
            
            return list;
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public int insert(Member member) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into ex_memb(name,email,pwd,regdt)"
                + " values(?,?,password(?),now())");
             ){
            
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPassword());
            
            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public int update(Member member) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "update ex_memb set name=?,email=?,pwd=password(?) where no=?");
             ){
            
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPassword());
            pstmt.setInt(4, member.getNo());
            
            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public int delete(int no) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "delete from ex_memb where no=?");
             ){
            
            pstmt.setInt(1, no);
            
            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public Member selectOne(int no) {
        try (PreparedStatement pstmt = con.prepareStatement(
                "select no,name,email,regdt from ex_memb where no=?");
             ){
            
            pstmt.setInt(1, no);
            
            ResultSet rs = pstmt.executeQuery();
            
            Member member = null;
            
            if (rs.next()) {
                member = new Member();
                member.setNo(no);
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setCreatedDate(rs.getDate("regdt"));
                
            } 
            
            rs.close();
            return member;
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}















