package java100.app.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java100.app.dao.DaoException;
import java100.app.dao.MemberDao;
import java100.app.domain.Member;
import java100.app.util.DataSource;

//기존에 있던 MemberDao 클래스에서 컨트롤러가 호출하는 기본 메서드 
//호출 규칙을 별도의 인터페이스로 분리하고,
//이 클래스는 그 인터페이스를 구현한 클래스로 전환한다.
//
public class MemberDaoImpl implements MemberDao {
    
    // 주입 받은 DataSource 객체를 저장할 인스턴스 변수를 준비한다.
    DataSource ds;
    
    // 외부에서 DataSource 객체를 주입할 수 있도록 셋터를 준비한다.
    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }
    
    // DataSource를 주입 받았다 가정하고 다음 아래의 메서드들을 변경한다.
    // => 이렇게하면 DataSource를 얻기 위해 ApplicationContext를 사용한
    //    코드를 제거해도 된다. 
    // => 즉 더이상 ApplicationContext에 종속되지 않는다.
    //
    public List<Member> selectList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "select no,name,email,regdt from ex_memb");
            rs = pstmt.executeQuery();
            
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
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {pstmt.close();} catch (Exception e) {}
            ds.returnConnection(con);
        }
    }
    
    public int insert(Member member) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "insert into ex_memb(name,email,pwd,regdt)"
                            + " values(?,?,password(?),now())");
            
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPassword());
            
            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {pstmt.close();} catch (Exception e) {}
            ds.returnConnection(con);
        }
    }
    
    public int update(Member member) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "update ex_memb set name=?,email=?,pwd=password(?) where no=?");
            
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPassword());
            pstmt.setInt(4, member.getNo());
            
            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {pstmt.close();} catch (Exception e) {}
            ds.returnConnection(con);
        }
    }
    
    public int delete(int no) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "delete from ex_memb where no=?");
            
            pstmt.setInt(1, no);
            
            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {pstmt.close();} catch (Exception e) {}
            ds.returnConnection(con);
        }
    }
    
    public Member selectOne(int no) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "select no,name,email,regdt from ex_memb where no=?");
            
            pstmt.setInt(1, no);
            
            rs = pstmt.executeQuery();
            
            Member member = null;
            
            if (rs.next()) {
                member = new Member();
                member.setNo(no);
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setCreatedDate(rs.getDate("regdt"));
                
            } 
            
            return member;
            
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {pstmt.close();} catch (Exception e) {}
            ds.returnConnection(con);
        }
    }
}















