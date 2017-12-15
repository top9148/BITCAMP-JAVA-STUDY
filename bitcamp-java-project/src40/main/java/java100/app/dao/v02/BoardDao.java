package java100.app.dao.v02;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java100.app.App;
import java100.app.domain.Board;

public class BoardDao {
    
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
    
    public List<Board> selectList() {
        try (PreparedStatement pstmt = App.con.prepareStatement(
                "select no,title,regdt,vwcnt from ex_board");
             ResultSet rs = pstmt.executeQuery();){
            
            ArrayList<Board> list = new ArrayList<>();
            
            while (rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("no"));
                board.setTitle(rs.getString("title"));
                board.setRegDate(rs.getDate("regdt"));
                board.setViewCount(rs.getInt("vwcnt"));
                
                list.add(board);
            }
            
            return list;
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public int insert(Board board) {
        try (PreparedStatement pstmt = App.con.prepareStatement(
                "insert into ex_board(title,conts,regdt)"
                + " values(?,?,now())");
             ){
            
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            
            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public int update(Board board) {
        try (PreparedStatement pstmt = App.con.prepareStatement(
                "update ex_board set title=?, conts=? where no=?");){
            
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getNo());
            
            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public int delete(int no) {
        try (PreparedStatement pstmt = App.con.prepareStatement(
                "delete from ex_board where no=?");
             ){
            
            pstmt.setInt(1, no);
            
            return pstmt.executeUpdate();
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public Board selectOne(int no) {
        try {
            
            try (PreparedStatement pstmt = App.con.prepareStatement(
                    "update ex_board set vwcnt = vwcnt + 1 where no=?")) {
                pstmt.setInt(1, no);
                pstmt.executeUpdate();
            } catch (Exception e) {throw e;}
            
            try (PreparedStatement pstmt = App.con.prepareStatement(
                    "select no,title,conts,regdt,vwcnt from ex_board where no=?")) {
                pstmt.setInt(1, no);
                
                ResultSet rs = pstmt.executeQuery();
                
                Board board = null;
                
                if (rs.next()) {
                    board = new Board();
                    board.setNo(no);
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("conts"));
                    board.setRegDate(rs.getDate("regdt"));
                    board.setViewCount(rs.getInt("vwcnt"));
                    
                } 
                
                rs.close();
                return board;
            } catch (Exception e) {throw e;}
            
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}















