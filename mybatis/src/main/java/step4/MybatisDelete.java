package step4;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisDelete {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = 
                Resources.getResourceAsStream("step4/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // delete(SQL문을 찾을 때 이름, 데이터가 저장된 객체)
        // => 원시 타입의 값을 넘기면 auto-boxing 된다.
        int count = sqlSession.delete("JdbcTestMapper.delete", 30);
        
        sqlSession.commit();
        
        System.out.printf("%d 개가 삭제되었습니다.", count);
        
        sqlSession.close();
    }
}
