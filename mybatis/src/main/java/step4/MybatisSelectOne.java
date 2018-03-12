package step4;

import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSelectOne {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = 
                Resources.getResourceAsStream("step4/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // selectOne(SQL문을 찾을 때 이름, 데이터)
        Map<String,Object> record = sqlSession.selectOne("JdbcTestMapper.findByNo", 27);
        
        System.out.printf("번호: %d\n", record.get("no"));
        System.out.printf("제목: %s\n", record.get("title"));
        System.out.printf("내용: %s\n", record.get("conts"));
        System.out.printf("날짜: %s\n", record.get("regdt"));
        System.out.printf("조회수: %d\n", record.get("vwcnt"));
        
        sqlSession.close();
    }
}
