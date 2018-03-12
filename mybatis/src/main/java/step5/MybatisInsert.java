package step5;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisInsert {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = 
                Resources.getResourceAsStream("step5/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // insert를 실행할 때 Board 객체를 넘겨줄 것이다.
        Board board = new Board();
        board.setTitle("오호라~ 제목이래요2!");
        board.setContents("내용이더래요~~~2");
        
        int count = sqlSession.insert("JdbcTestMapper.insert", board);
        
        sqlSession.commit();
        
        System.out.printf("%d 개가 입력되었습니다.", count);
        
        sqlSession.close();
    }
}
