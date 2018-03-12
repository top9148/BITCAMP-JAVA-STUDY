package step7;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUpdate {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = 
                Resources.getResourceAsStream("step7/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // update를 실행할 때 넘겨줄 Board 객체를 준비한다.
        Board board = new Board();
        
        board.setNo(28);
        board.setTitle("제목 변경!");
        board.setContents("내용 변경!");
        
        int count = sqlSession.update("JdbcTestMapper.update", board);
        
        sqlSession.commit();
        
        System.out.printf("%d 개가 변경되었습니다.", count);
        
        sqlSession.close();
    }
}
