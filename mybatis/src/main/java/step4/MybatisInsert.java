package step4;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisInsert {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = 
                Resources.getResourceAsStream("step4/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // insert를 실행할 때 넘겨줄 값을 준비한다.
        Map<String,Object> data = new HashMap<>();
        
        // 값을 저장할 때 사용한 key는 
        // SQL Mapper 파일에서 그 값을 꺼낼 때 사용할 것이다.
        //
        data.put("title", "오호라~ 제목이래요!");
        data.put("contents", "내용이더래요~~~");
        
        // insert(SQL문을 찾을 때 이름, 데이터가 저장된 객체)
        int count = sqlSession.insert("JdbcTestMapper.insert", data);
        
        // Mybatis는 기본으로 수동 commit이다.
        // 즉 개발자가 명시적으로 commit() 호출해야 한다.
        sqlSession.commit();
        
        System.out.printf("%d 개가 입력되었습니다.", count);
        
        sqlSession.close();
    }
}
