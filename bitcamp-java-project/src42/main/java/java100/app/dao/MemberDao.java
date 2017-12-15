package java100.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java100.app.beans.ApplicationContext;
import java100.app.domain.Member;
import java100.app.util.DataSource;

public class MemberDao {
    
    public List<Member> selectList() {
        DataSource ds = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            ds = (DataSource) ApplicationContext.getBean("mysqlDataSource"); 
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
        DataSource ds = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            ds = (DataSource) ApplicationContext.getBean("mysqlDataSource"); 
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
        DataSource ds = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            ds = (DataSource) ApplicationContext.getBean("mysqlDataSource"); 
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
        DataSource ds = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            ds = (DataSource) ApplicationContext.getBean("mysqlDataSource"); 
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
        DataSource ds = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            ds = (DataSource) ApplicationContext.getBean("mysqlDataSource"); 
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















